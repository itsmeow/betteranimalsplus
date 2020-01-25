package its_meow.betteranimalsplus.common.entity;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.util.EntityTypeContainer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TargetGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.nbt.StringNBT;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

public class EntityGoose extends EntityAnimalWithTypes {

    public int attacksLeft = 0;
    public int lastAttackTime = 0;
    protected final Set<UUID> dislikedPlayers = new HashSet<UUID>();
    private Set<Goal> aggroGoals;
    private Set<Goal> aggroTargetGoals;

    public EntityGoose(World world) {
        super(ModEntities.GOOSE.entityType, world);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(2, new PanicGoal(this, 1.4D) {
            @Override
            public boolean shouldExecute() {
                return this.creature.getAttackTarget() == null && super.shouldExecute();
            }
        });
        this.goalSelector.addGoal(3, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new TemptGoal(this, 1.0D, Ingredient.fromItems(Items.PUMPKIN_SEEDS, Items.WHEAT_SEEDS, Items.BEETROOT_SEEDS, Items.MELON_SEEDS, Items.BREAD), false));
        this.goalSelector.addGoal(5, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.addAggroGoals();
    }
    
    public void addAggroGoals() {
        MeleeAttackGoal melee = new MeleeAttackGoal(this, 1.1D, false) {
            @Override
            public void startExecuting() {
                attacksLeft = this.attacker.getRNG().nextInt(2) + 1;
                super.startExecuting();
            }

            @Override
            public boolean shouldExecute() {
                return super.shouldExecute() && this.attacker.ticksExisted - lastAttackTime > 300;
            }

            @Override
            public boolean shouldContinueExecuting() {
                return attacksLeft > 0 && super.shouldContinueExecuting();
            }

            @Override
            protected void checkAndPerformAttack(LivingEntity p_190102_1_, double p_190102_2_) {
                if(attacksLeft > 0) {
                    super.checkAndPerformAttack(p_190102_1_, p_190102_2_);
                } else {
                    this.resetTask();
                }
            }

            @Override
            public void resetTask() {
                super.resetTask();
                if(attacksLeft <= 0) {
                    this.attacker.setAttackTarget(null);
                }
            }
        };
        this.goalSelector.addGoal(1, melee);
        HurtByTargetGoal target1 = new HurtByTargetGoal(this, new Class[0]);
        this.targetSelector.addGoal(0, target1);
        DislikeTargetGoal target2 = new DislikeTargetGoal(this);
        this.targetSelector.addGoal(1, target2);
        aggroGoals = new HashSet<Goal>();
        aggroTargetGoals = new HashSet<Goal>();
        aggroGoals.add(melee);
        aggroTargetGoals.add(target1);
        aggroTargetGoals.add(target2);
    }
    
    public void removeAggroGoals() {
        for(Goal goal : aggroGoals) {
            this.goalSelector.removeGoal(goal);
        }
        for(Goal goal : aggroTargetGoals) {
            this.targetSelector.removeGoal(goal);
        }
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(12D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
        this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1D);
    }

    @Override
    public void setAttackTarget(LivingEntity entity) {
        super.setAttackTarget(entity);
        if(entity instanceof PlayerEntity) {
            UUID uuid = ((PlayerEntity) entity).getGameProfile().getId();
            if(!dislikedPlayers.contains(uuid)) {
                dislikedPlayers.add(uuid);
            }
        }
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        if(attacksLeft > 0) {
            attacksLeft--;
        }
        this.lastAttackTime = this.ticksExisted;
        return super.attackEntityAsMob(entityIn);
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        ListNBT list = new ListNBT();
        for(UUID uuid : dislikedPlayers) {
            list.add(new StringNBT(uuid.toString()));
        }
        compound.put("disliked_players", list);
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        compound.getList("disliked_players", Constants.NBT.TAG_STRING).forEach(nbt -> dislikedPlayers.add(UUID.fromString(nbt.getString())));
    }
    
    @Override
    public ILivingEntityData onInitialSpawn(IWorld world, DifficultyInstance difficulty, SpawnReason reason, ILivingEntityData livingdata, CompoundNBT compound) {
        int[] types;
        switch (reason) {
            case NATURAL:
                types = new int[] {2,3};
                break;
            case CHUNK_GENERATION:
                types = new int[] {2,3};
                break;
            case STRUCTURE:
                types = new int[] {2,3};
                break;
            case BREEDING:
                types = new int[] {1};
                break;
            default:
                types = new int[] {1,2,3};
                break;
        }
        return this.initData(super.onInitialSpawn(world, difficulty, reason, livingdata, compound), types[rand.nextInt(types.length)]);
    }

    @Override
    public int getVariantMax() {
        return 3;
    }

    @Override
    protected IVariantTypes getBaseChild() {
        return new EntityGoose(world);
    }

    @Override
    protected EntityTypeContainer<? extends EntityAnimalWithTypes> getContainer() {
        return ModEntities.GOOSE;
    }
    
    public class DislikeTargetGoal extends TargetGoal {
        
        protected EntityGoose goose;

        public DislikeTargetGoal(EntityGoose goose) {
            super(goose, true);
            this.goose = goose;
        }

        @Override
        public boolean shouldExecute() {
            return goose.dislikedPlayers.size() > 0 && goose.getAttackTarget() == null && this.goose.ticksExisted - goose.lastAttackTime > 300;
        }

        @Override
        protected boolean isSuitableTarget(LivingEntity potentialTarget, EntityPredicate targetPredicate) {
            return potentialTarget instanceof PlayerEntity && super.isSuitableTarget(potentialTarget, targetPredicate) && dislikedPlayers.contains(((PlayerEntity)potentialTarget).getGameProfile().getId());
        }
        
    }

}
