package its_meow.betteranimalsplus.common.entity;

import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.base.Predicates;

import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.util.PolarVector3D;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class EntityShark extends EntitySharkBase implements IVariantTypes {

    protected static final DataParameter<Integer> TYPE_NUMBER = EntityDataManager.<Integer>createKey(EntityShark.class, DataSerializers.VARINT);
    private float lastAttack = 0;
    private float lastGrab = 0;

    public EntityShark(World world) {
        super(ModEntities.getEntityType("sharK"), world);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new MoveTowardsTargetGoal(this, 0.8D, 40F));
        this.goalSelector.addGoal(1, new LookAtGoal(this, LivingEntity.class, 15F));
        this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 0.55D));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<LivingEntity>(this, LivingEntity.class, 90, false, false, Predicates.alwaysTrue()));
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.75D);
        this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8D);
    }

    @Override
    public void livingTick() {
        super.livingTick();
        if(!this.world.isRemote && this.getAttackTarget() != null && this.getAttackTarget().isAlive()) {
            if(this.getPassengers().contains(this.getAttackTarget())) {
                float time = 20F; 
                time *= 5F * (Math.random() + 1F);
                if(this.lastAttack + time < this.ticksExisted) {
                    //this.attackEntityAsMob(this.getAttackTarget());
                }
            } else if(lastGrab  + 60F < this.ticksExisted && this.getDistanceSq(this.getAttackTarget()) < 10) {
                this.getAttackTarget().startRiding(this, true);
                lastGrab = this.ticksExisted;
            }
        }
    }

    @Override
    public void updatePassenger(Entity passenger) {
        if(this.isPassenger(passenger)) {
            BlockPos pos = this.fromPolarCoordinates(new PolarVector3D(this.rotationYaw, 0F, 2F));
            passenger.setPosition(this.posX + this.getMotion().getX() + pos.getX(), this.posY - (this.getHeight() / 2) + this.getMotion().getY(), this.posZ + this.getMotion().getZ() + pos.getZ());
            this.addVelocity(0, Math.abs(passenger.getMotion().getY()), 0);
            if (passenger instanceof LivingEntity && (this.getAttackTarget() == null || this.getAttackTarget() != passenger)) {
                this.setAttackTarget((LivingEntity) passenger);
            }
            if (this.world.isRemote) {
                this.applyOrientationToEntity(passenger);
            }
        }
    }

    public BlockPos fromPolarCoordinates(PolarVector3D polar) {
        double r = polar.getR();
        double lat = polar.getThetaY() / 360;
        double lon = polar.getThetaX() / 360;
        double x = r * Math.sin(lat) * Math.cos(lon);
        double y = r * Math.sin(lat) * Math.sin(lon);
        double z = r * Math.cos(lat);
        return new BlockPos(x, y, z);
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
    public boolean canBeRiddenInWater(Entity rider) {
        return true;
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.registerTypeKey();
    }

    @Override
    public boolean writeUnlessRemoved(CompoundNBT compound) {
        this.writeType(compound);
        return super.writeUnlessRemoved(compound);
    }

    @Override
    public void read(CompoundNBT compound) {
        super.read(compound);
        this.readType(compound);
    }

    @Override
    @Nullable
    public ILivingEntityData onInitialSpawn(IWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData livingdata, CompoundNBT compound) {
        return this.initData(super.onInitialSpawn(world, difficulty, reason, livingdata, compound));
    }

    public boolean isChildI() {
        return this.isChild();
    }

    @Override
    public Random getRNGI() {
        return this.getRNG();
    }

    @Override
    public EntityDataManager getDataManagerI() {
        return this.getDataManager();
    }

    @Override
    public DataParameter<Integer> getDataKey() {
        return TYPE_NUMBER;
    }

    @Override
    public int getVariantMax() {
        return 3;
    }

}
