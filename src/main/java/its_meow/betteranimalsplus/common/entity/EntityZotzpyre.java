package its_meow.betteranimalsplus.common.entity;

import java.util.Random;

import its_meow.betteranimalsplus.common.entity.util.EntityTypeContainer;
import its_meow.betteranimalsplus.common.entity.util.abstracts.EntityMonsterWithTypes;
import its_meow.betteranimalsplus.init.ModEntities;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.AmbientEntity;
import net.minecraft.entity.passive.IFlyingAnimal;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.play.server.SSetPassengersPacket;
import net.minecraft.pathfinding.ClimberPathNavigator;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.common.BiomeDictionary;

public class EntityZotzpyre extends EntityMonsterWithTypes {

    private static final DataParameter<Byte> CLIMBING = EntityDataManager.<Byte>createKey(EntityZotzpyre.class, DataSerializers.BYTE);
    protected int lastAttack = 0;
    private boolean isFromZotz = false;

    public EntityZotzpyre(World world) {
        super(ModEntities.ZOTZPYRE.entityType, world);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new LeapAtTargetGoal(this, 0.5F));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomWalkingGoal(this, 0.6D));
        this.goalSelector.addGoal(3, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.targetSelector.addGoal(0, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<PlayerEntity>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<MobEntity>(this, MobEntity.class, 0, true, true, entity -> !(entity instanceof EntityZotzpyre) && !(entity instanceof AbstractHorseEntity) && !(entity instanceof AmbientEntity) && !(entity instanceof IMob) && entity.getCreatureAttribute() != CreatureAttribute.UNDEAD));
    }

    protected PathNavigator createNavigator(World worldIn) {
        return new ClimberPathNavigator(this, worldIn);
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(CLIMBING, (byte) 0);
    }

    @Override
    public boolean canBePushed() {
        return false;
    }

    @Override
    protected void collideWithEntity(Entity entityIn) {}

    @Override
    protected void collideWithNearbyEntities() {}

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
    }

    @Override
    public void tick() {
        super.tick();
        if(!this.world.isRemote && !this.isAlive() && this.getRidingEntity() != null || (!this.world.isRemote && this.getRidingEntity() != null && !this.getRidingEntity().isAlive())) {
            this.dismountZotz();
        }
        if(!this.world.isRemote) {
            this.setBesideClimbableBlock(this.collidedHorizontally);
        }
    }

    /* prevent slowdown in air */
    @Override
    public void travel(Vec3d vec) {
        double d0 = 0.08D;
        IAttributeInstance gravity = this.getAttribute(ENTITY_GRAVITY);
        boolean flag = this.getMotion().y <= 0.0D;
        d0 = gravity.getValue();
        double d1 = this.posY;
        float f = this.isSprinting() ? 0.9F : this.getWaterSlowDown();
        float f1 = 0.02F;
        float f2 = (float)EnchantmentHelper.getDepthStriderModifier(this);
        if (f2 > 3.0F) {
            f2 = 3.0F;
        }

        /*if (!this.onGround) {
                f2 *= 0.5F;
            }*/

        if (f2 > 0.0F) {
            f += (0.54600006F - f) * f2 / 3.0F;
            f1 += (this.getAIMoveSpeed() - f1) * f2 / 3.0F;
        }

        if (this.isPotionActive(Effects.DOLPHINS_GRACE)) {
            f = 0.96F;
        }

        f1 *= (float)this.getAttribute(SWIM_SPEED).getValue();
        this.moveRelative(f1, vec);
        this.move(MoverType.SELF, this.getMotion());
        Vec3d vec3d1 = this.getMotion();
        if (this.collidedHorizontally && this.isOnLadder()) {
            vec3d1 = new Vec3d(vec3d1.x, 0.2D, vec3d1.z);
        }

        this.setMotion(vec3d1.mul((double)f, (double)0.8F, (double)f));
        if (!this.hasNoGravity() && !this.isSprinting()) {
            Vec3d vec3d2 = this.getMotion();
            double d2;
            if (flag && Math.abs(vec3d2.y - 0.005D) >= 0.003D && Math.abs(vec3d2.y - d0 / 16.0D) < 0.003D) {
                d2 = -0.003D;
            } else {
                d2 = vec3d2.y - d0 / 16.0D;
            }

            this.setMotion(vec3d2.x, d2, vec3d2.z);
        }

        Vec3d vec3d6 = this.getMotion();
        if (this.collidedHorizontally && this.isOffsetPositionInLiquid(vec3d6.x, vec3d6.y + (double)0.6F - this.posY + d1, vec3d6.z)) {
            this.setMotion(vec3d6.x, (double)0.3F, vec3d6.z);
        }


        this.prevLimbSwingAmount = this.limbSwingAmount;
        double d5 = this.posX - this.prevPosX;
        double d6 = this.posZ - this.prevPosZ;
        double d8 = this instanceof IFlyingAnimal ? this.posY - this.prevPosY : 0.0D;
        float f8 = MathHelper.sqrt(d5 * d5 + d8 * d8 + d6 * d6) * 4.0F;
        if (f8 > 1.0F) {
            f8 = 1.0F;
        }

        this.limbSwingAmount += (f8 - this.limbSwingAmount) * 0.4F;
        this.limbSwing += this.limbSwingAmount;
    }

    @Override
    public boolean isOnLadder() {
        return this.isBesideClimbableBlock();
    }

    public boolean isBesideClimbableBlock() {
        return (this.dataManager.get(CLIMBING) & 1) != 0;
    }

    public void setBesideClimbableBlock(boolean climbing) {
        byte b0 = ((Byte) this.dataManager.get(CLIMBING)).byteValue();
        this.dataManager.set(CLIMBING, climbing ? (byte) (b0 | 1) : (byte) (b0 & -2));
    }

    @Override
    protected float getSoundVolume() {
        return 0.5F;
    }

    @Override
    protected float getSoundPitch() {
        return super.getSoundPitch() * 0.05F;
    }

    @Override
    public SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_BAT_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_BAT_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_BAT_DEATH;
    }

    @Override
    public void livingTick() {
        super.livingTick();
        if(!this.world.isRemote && this.getAttackTarget() != null && this.getAttackTarget().isAlive()) {
            if(this.getRidingEntity() != null && this.getRidingEntity() == this.getAttackTarget()) {
                float time = 20F; 
                if(!this.inWater) {
                    time *= 2F * (Math.random() + 1F);
                } else {
                    time += Math.random() * Math.random() * 2 * ((Math.random() < 0.5) ? -1 : 1);
                }
                if(this.lastAttack + time < this.ticksExisted) {
                    this.attackEntityAsMob(this.getAttackTarget());
                }
            } else if(this.getDistanceSq(this.getAttackTarget()) < 3) {
                this.grabTarget(this.getAttackTarget());
            }
        }
    }

    @Override
    public boolean canBeRiddenInWater(Entity rider) {
        return true;
    }

    public void grabTarget(Entity entity) {
        if(!world.isRemote) {
            if(this.getRidingEntity() == null) {
                this.startRiding(entity, true);
                for(ServerPlayerEntity player : this.world.getServer().getPlayerList().getPlayers()) {
                    if(player.world == this.world && player.getDistance(this) <= 128) {
                        player.connection.sendPacket(new SSetPassengersPacket(entity));
                    }
                }
            }
        }
    }

    public void dismountZotz() {
        Entity mount = this.getRidingEntity();
        this.dismountEntity(mount);
        this.isFromZotz = true;
        this.stopRiding();
        this.isFromZotz  = false;
        if(!world.isRemote) {
            for(ServerPlayerEntity player : this.world.getServer().getPlayerList().getPlayers()) {
                if(player.world == this.world && player.getDistance(this) <= 128) {
                    player.connection.sendPacket(new SSetPassengersPacket(mount));
                }
            }
        }
    }

    @Override
    public void stopRiding() {
        if(this.getRidingEntity() != null && !this.getRidingEntity().canBeRiddenInWater(this)) {
            super.stopRiding();
        } else if(this.getAttackTarget() == null || isFromZotz) {
            super.stopRiding();
        }
    }

    @Override
    public boolean canRiderInteract() {
        return true;
    }

    @Override
    public boolean shouldRiderSit() {
        return false;
    }

    @Override
    public double getYOffset() {
        if(getRidingEntity() != null && getRidingEntity() instanceof PlayerEntity) {
            return getRidingEntity().getHeight() - 2.25F;
        } else if(getRidingEntity() != null) {
            return (getRidingEntity().getEyeHeight() / 2) - this.getHeight();
        } else {
            return super.getYOffset();
        }
    }

    public static boolean canSpawn(EntityType<EntityZotzpyre> type, IWorld world, SpawnReason reason, BlockPos pos, Random rand) {
        if (pos.getY() >= world.getSeaLevel() && !BiomeDictionary.getTypes(world.getBiome(pos)).contains(BiomeDictionary.Type.JUNGLE)) {
            return false;
        } else {
            return func_223324_d(type, world, reason, pos, rand);
        }
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) {
            return false;
        } else {
            if(amount > 3 && this.getRidingEntity() != null && !this.world.isRemote) {
                this.dismountZotz();
            }

            return super.attackEntityFrom(source, amount);
        }
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        float f = (float) this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue();
        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), f);
        if(flag) {
            this.lastAttack = this.ticksExisted;
            if(entityIn instanceof PlayerEntity) {
                PlayerEntity entityplayer = (PlayerEntity) entityIn;
                int slowTicks = 0;
                if(this.world.getDifficulty() == Difficulty.EASY) {
                    slowTicks = 200; // 10s
                } else if(this.world.getDifficulty() == Difficulty.NORMAL) {
                    slowTicks = 300; // 15s
                } else if(this.world.getDifficulty() == Difficulty.HARD) {
                    slowTicks = 600; // 30s
                }
                entityplayer.addPotionEffect(new EffectInstance(Effects.SLOWNESS, slowTicks, 1, false, false));
            }
        }
        if(!this.world.isRemote && !entityIn.isAlive() && entityIn == this.getRidingEntity()) {
            this.dismountZotz();
        }
        return flag;
    }

    @Override
    public void fall(float distance, float damageMultiplier) {
    }

    @Override
    public EntityTypeContainer<EntityZotzpyre> getContainer() {
        return ModEntities.ZOTZPYRE;
    }

}
