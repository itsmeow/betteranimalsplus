package its_meow.betteranimalsplus.common.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Nullable;

import dev.itsmeow.imdlib.entity.util.IVariant;
import dev.itsmeow.imdlib.entity.util.IVariantTypes;
import its_meow.betteranimalsplus.common.entity.util.EntityTypeContainerBAP;
import its_meow.betteranimalsplus.common.entity.util.abstracts.EntitySharkBase;
import its_meow.betteranimalsplus.common.entity.util.abstracts.EntityWaterMobPathing;
import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.init.ModLootTables;
import its_meow.betteranimalsplus.util.OceanBiomeHelper;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

public class EntityShark extends EntitySharkBase {

    private float lastAttack = 0;
    private float lastGrab = 0;
    private float lastTickHealth = 0;
    public float lastBodyRotation = 0;

    public EntityShark(World world) {
        super(ModEntities.SHARK.entityType, world);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new MoveTowardsTargetGoal(this, 1D, 40F));
        this.goalSelector.addGoal(1, new LookAtGoal(this, LivingEntity.class, 15F));
        this.goalSelector.addGoal(1, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(2, new RandomSwimmingGoal(this, 1D, 1));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<LivingEntity>(this, LivingEntity.class, 5, false, false, e -> {
            if(e instanceof EntitySharkBase || e instanceof EntityBobbitWorm) return false;
            if(e instanceof PlayerEntity) return shouldAttackForHealth(e.getHealth());
            return true;
        }) {
            @Override
            public boolean shouldExecute() {
                return super.shouldExecute() && !EntityShark.this.isPeaceful();
            }
        });
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if(super.attackEntityFrom(source, amount)) {
            if(source.getImmediateSource() instanceof PlayerEntity && !this.isPeaceful()) {
                PlayerEntity player = (PlayerEntity) source.getImmediateSource();
                if(!player.isCreative() && !player.isInvisible()) {
                    this.setAttackTarget(player);
                }
            }
            return true;
        }
        return false;
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(1.5D);
        this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6D);
    }

    @Override
    public IVariantTypes<EntityWaterMobPathing> setType(IVariant variant) {
        super.setType(variant);
        updateAttributes(this.getVariantNameOrEmpty());
        return this;
    }

    @Override
    public IVariantTypes<EntityWaterMobPathing> setType(String variantKey) {
        super.setType(variantKey);
        updateAttributes(this.getVariantNameOrEmpty());
        return this;
    }

    private void updateAttributes(String name) {
        if("hammerhead".equals(name)) {
            this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(45D);
            this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(9D);
        } else if("mako".equals(name)) {
            this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(3D);
        } else if("great_white".equals(name)) {
            this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(60D);
            this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(12D);
        } else {
            this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30D);
            this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6D);
            this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(1.5D);
        }
        this.setHealth(this.getMaxHealth());
    }

    public boolean shouldAttackForHealth(float health) {
        switch(this.getVariantNameOrEmpty()) {
        case "blue": return health <= 8F;
        case "bull": return health <= 13F;
        case "tiger": return health <= 10F;
        case "whitetip": return health <= 16F;
        case "greenland": return health <= 8F;
        case "hammerhead": return health <= 8F;
        case "goblin": return health <= 8F;
        case "mako": return health <= 13F;
        case "great_white": return health <= 13F;
        default: return false;
        }
    }

    @Override
    public void livingTick() {
        super.livingTick();
        if(this.getAttackTarget() != null && !this.getAttackTarget().isAlive()) {
            this.setAttackTarget(null);
        }
        if(!this.world.isRemote && this.getAttackTarget() != null && this.getAttackTarget().isAlive() && this.isAlive() && !this.isPeaceful()) {
            boolean isBoat = this.getAttackTarget() instanceof PlayerEntity && this.getAttackTarget().getRidingEntity() != null && this.getAttackTarget().getRidingEntity() instanceof BoatEntity;
            float grabDelay = isBoat ? 20F : 60F;
            if(this.getPassengers().contains(this.getAttackTarget())) {
                float time = 30F;
                time *= (Math.random() + 1F);
                if(this.lastAttack + time < this.ticksExisted) {
                    this.attackEntityAsMob(this.getAttackTarget());
                }
            } else if(lastGrab + grabDelay < this.ticksExisted && this.getDistanceSq(this.getAttackTarget()) < 5) {
                if(isBoat) {
                    BoatEntity boat = (BoatEntity) this.getAttackTarget().getRidingEntity();
                    boat.attackEntityFrom(DamageSource.causeMobDamage(this), 3F);
                } else if(!this.getAttackTarget().isInvulnerable() && this.getAttackTarget().getWidth() < 2.5 && this.getAttackTarget().getHeight() < 2.5) {
                    if (this.getAttackTarget() instanceof MobEntity) {
                        MobEntity el = (MobEntity) this.getAttackTarget();
                        el.setAttackTarget(null);
                        el.setRevengeTarget(null);
                        el.getNavigator().clearPath(); 
                        el.setNoAI(true);
                    }
                    this.getAttackTarget().startRiding(this, false);
                } else if(!this.getAttackTarget().isInvulnerable()) {
                    this.attackEntityAsMob(this.getAttackTarget());
                }
                lastGrab = this.ticksExisted;
            }
            if(lastTickHealth - 4F > this.getHealth()) {
                this.getAttackTarget().dismountEntity(this);
                if (this.getAttackTarget() instanceof MobEntity) {
                    MobEntity el = (MobEntity) this.getAttackTarget();
                    el.setNoAI(false);
                }
            }
        }
        this.lastTickHealth = this.getHealth();
    }

    @Override
    protected ResourceLocation getLootTable() {
        return ModLootTables.SHARK;
    }

    @Override
    public EntityTypeContainerBAP<EntityShark> getContainer() {
        return ModEntities.SHARK;
    }

    @Override
    public String[] getTypesFor(Biome biome, Set<Type> types) {
        // types always contains OCEAN
        List<String> list = new ArrayList<String>();
        OceanBiomeHelper.Wrapper b = new OceanBiomeHelper.Wrapper(biome);
        if(b.isColdOrFrozen()) {
            list.add("greenland");
        } else {
            list.add("bull");
            list.add("blue");
            list.add("whitetip");
            list.add("tiger");
        }
        if(!b.isFrozen()) {
            list.add("great_white");
        }
        if(b.isDeep()) {
            list.add("goblin");
            if(!b.isFrozen()) {
                list.add("mako");
            }
        }
        if(b.isWarm()) {
            list.add("mako");
        }
        return list.toArray(new String[0]);
    }

    @Override
    @Nullable
    public ILivingEntityData onInitialSpawn(IWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData livingdata, CompoundNBT compound) {
        if(this.getContainer().biomeVariants && (reason == SpawnReason.CHUNK_GENERATION || reason == SpawnReason.NATURAL)) {
            if(!this.getImplementation().isChild()) {
                Biome biome = world.getBiome(this.getImplementation().getPosition());
                String[] validTypes = this.getTypesFor(biome, BiomeDictionary.getTypes(biome));
                String varStr = validTypes[this.getImplementation().getRNG().nextInt(validTypes.length)];
                for(int i = 0; i < 2; i++) {
                    if("great_white".equals(varStr) || "goblin".equals(varStr)) {
                        varStr = validTypes[this.getImplementation().getRNG().nextInt(validTypes.length)];
                    }
                }
                if(world instanceof World && ((World) world).isDaytime()) {
                    if(validTypes.length > 1 && "goblin".equals(varStr)) {
                        for(int i = 0; i < validTypes.length && "goblin".equals(varStr); i++) {
                            varStr = validTypes[i];
                        }
                    }
                }
                IVariant variant = this.getContainer().getVariantForName(varStr);
                if(variant == null || !varStr.equals(variant.getName())) {
                    throw new RuntimeException("Received invalid variant string from selective type: " + varStr + " on entity " + this.getContainer().entityName);
                }
                if(livingdata instanceof TypeData) {
                    variant = ((TypeData) livingdata).typeData;
                } else {
                    livingdata = new TypeData(variant);
                }
                this.setType(variant);
            }
        } else {
            return super.onInitialSpawn(world, difficulty, reason, livingdata, compound);
        }
        return livingdata;
    }

}
