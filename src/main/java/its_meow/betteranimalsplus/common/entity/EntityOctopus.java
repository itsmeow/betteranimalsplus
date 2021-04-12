package its_meow.betteranimalsplus.common.entity;

import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.interfaces.IVariantTypes;
import its_meow.betteranimalsplus.common.entity.ai.HungerNearestAttackableTargetGoal;
import its_meow.betteranimalsplus.common.entity.ai.HybridMoveController;
import its_meow.betteranimalsplus.common.entity.ai.HybridPathNavigator;
import its_meow.betteranimalsplus.common.entity.ai.PeacefulNearestAttackableTargetGoal;
import its_meow.betteranimalsplus.common.entity.util.IHaveHunger;
import its_meow.betteranimalsplus.common.entity.util.abstracts.EntityBAPCephalopod;
import its_meow.betteranimalsplus.common.entity.util.abstracts.EntityWaterMobPathing;
import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.init.ModLootTables;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.WaterMobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.UUID;

public class EntityOctopus extends EntityBAPCephalopod implements IVariantTypes<EntityWaterMobPathing>, IHaveHunger<EntityWaterMobPathing> {

    public UUID friend = null;
    private int hunger = 0;

    public EntityOctopus(EntityType<? extends EntityOctopus> entityType, World world) {
        super(entityType, world);
        this.setPathPriority(PathNodeType.WALKABLE, 1.5F);
        this.setPathPriority(PathNodeType.WATER, 1.5F);
        this.setPathPriority(PathNodeType.WATER_BORDER, 1F);
        this.moveController = new HybridMoveController(this);
        this.stepHeight = 1F;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new GoToWaterGoal(this, 2D));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 0.8D, true));
        this.goalSelector.addGoal(2, new LookAtGoal(this, WaterMobEntity.class, 10.0F));
        this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(3, new MoveRandomGoal(this));
        this.targetSelector.addGoal(0, new HurtByTargetGoal(this) {
            @Override
            public boolean shouldExecute() {
                return EntityOctopus.this.world.getDifficulty() != Difficulty.PEACEFUL && "blue_ringed".equals(EntityOctopus.this.getVariantNameOrEmpty()) && super.shouldExecute();
            }

            @Override
            public void startExecuting() {
                super.startExecuting();
                if(this.goalOwner.getRevengeTarget() instanceof PlayerEntity && ((PlayerEntity) this.goalOwner.getRevengeTarget()).getGameProfile().getId() == friend) {
                    EntityOctopus.this.friend = null;
                }
            }
        });
        this.targetSelector.addGoal(1, new OctopusAIAttackForFriend(this));
        this.targetSelector.addGoal(2, new PeacefulNearestAttackableTargetGoal<>(this, PlayerEntity.class, 0, true, true, e -> (friend == null || ((PlayerEntity) e).getGameProfile().getId() != friend) && e.getDistance(EntityOctopus.this) < 4D && "blue_ringed".equals(EntityOctopus.this.getVariantNameOrEmpty())));
        this.targetSelector.addGoal(3, new HungerNearestAttackableTargetGoal<>(this, WaterMobEntity.class, 0, true, true, e -> !(e instanceof IMob) && e.getSize(Pose.STANDING).width < this.getSize(Pose.STANDING).width));
    }

    @Override
    protected PathNavigator createNavigator(World worldIn) {
        return new HybridPathNavigator<>(this, worldIn, e -> e.getAttackTarget() == null || (e.getAttackTarget().isInWater() && this.isInWater()) || (!e.getAttackTarget().isInWater() && this.isInWater()));
    }

    @Override
    protected void updateAir(int air) {
        if(this.isAlive() && !this.isInWaterOrBubbleColumn()) {
            this.setAir(air - 1);
            if(this.getAir() == -20) {
                this.setAir(0);
                this.attackEntityFrom(DamageSource.DROWN, 2.0F);
            }
        } else {
            this.setAir(1600);
        }
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(18D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(1D);
        this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3D);
    }

    @Override
    public int getHunger() {
        return hunger;
    }

    @Override
    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.ticksExisted % 20 == 0) {
            this.incrementHunger();
        }
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        boolean b = super.attackEntityAsMob(entityIn);
        if(b && entityIn instanceof LivingEntity && "blue_ringed".equals(this.getVariantNameOrEmpty())) {
            ((LivingEntity)entityIn).addPotionEffect(new EffectInstance(Effects.POISON, 200, 1, false, false));
        }
        return b;
    }

    @Override
    public boolean processInteract(PlayerEntity player, Hand hand) {
        if(!"blue_ringed".equals(this.getVariantNameOrEmpty()) && ItemTags.FISHES.contains(player.getHeldItem(hand).getItem()) && !this.isChild()) {
            this.friend = player.getGameProfile().getId();
            if(!player.isCreative()) {
                player.getHeldItem(hand).shrink(1);
            }
            if(this.getEntityWorld() instanceof ServerWorld) {
                ServerWorld s = (ServerWorld) this.getEntityWorld();
                s.spawnParticle(ParticleTypes.HEART, this.getPositionVector().getX(), this.getPositionVector().getY(), this.getPositionVector().getZ(), 20, 0.5, 0.5, 0.5, 0.3D);
            }
        }
        return super.processInteract(player, hand);
    }

    public boolean isAboveBlock() {
        return world.isBlockPresent(this.getPosition().down()) && world.getBlockState(this.getPosition().down()).isSolid() && this.getPosY() - (double) ((int) this.getPosY()) <= 0.25D;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return ModLootTables.OCTOPUS;
    }

    @Override
    public EntityTypeContainer<? extends EntityOctopus> getContainer() {
        return ModEntities.OCTOPUS;
    }

    public static class OctopusAIAttackForFriend extends Goal {

        EntityOctopus octo;

        public OctopusAIAttackForFriend(EntityOctopus entity) {
            this.octo = entity;
        }

        @Override
        public boolean shouldExecute() {
            if(this.octo.friend == null) {
                return false;
            }
            PlayerEntity p = octo.world.getPlayerByUuid(octo.friend);
            return p != null && p.getAttackingEntity() != null;
        }

        @Override
        public void startExecuting() {
            PlayerEntity p = octo.world.getPlayerByUuid(octo.friend);
            this.octo.setAttackTarget(p.getAttackingEntity());
        }

        @Override
        public boolean shouldContinueExecuting() {
            return false;
        }

    }

    public static class GoToWaterGoal extends MoveToBlockGoal {
        private final EntityOctopus octo;

        public GoToWaterGoal(EntityOctopus octo, double speed) {
            super(octo, speed, 24);
            this.octo = octo;
            this.field_203112_e = -1;
        }

        @Override
        public boolean shouldContinueExecuting() {
            return !this.octo.isInWater() && this.timeoutCounter <= 1200 && this.shouldMoveTo(this.octo.world, this.destinationBlock);
        }

        @Override
        public boolean shouldExecute() {
            return !this.octo.isInWater() && this.octo.getAttackTarget() == null && super.shouldExecute();
        }

        @Override
        public boolean shouldMove() {
            return this.timeoutCounter % 160 == 0;
        }

        @Override
        protected boolean shouldMoveTo(IWorldReader worldIn, BlockPos pos) {
            Block block = worldIn.getBlockState(pos).getBlock();
            return block == Blocks.WATER;
        }
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.registerTypeKey();
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        this.writeType(compound);
        this.writeHunger(compound);
        if(friend != null) {
            compound.putUniqueId("Friend", this.friend);
        }
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.readType(compound);
        this.readHunger(compound);
        this.friend = compound.getUniqueId("Friend");
    }

    @Override
    @Nullable
    public ILivingEntityData onInitialSpawn(IWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData livingdata, CompoundNBT compound) {
        this.setInitialHunger();
        return this.initData(world, reason, super.onInitialSpawn(world, difficulty, reason, livingdata, compound));
    }

    @Override
    public EntityOctopus getImplementation() {
        return this;
    }

    @Override
    public boolean canDespawn(double range) {
        return super.canDespawn(range) && this.friend == null;
    }
}
