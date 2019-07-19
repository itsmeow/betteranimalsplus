package its_meow.betteranimalsplus.common.entity;

import java.util.Random;

import javax.annotation.Nullable;

import its_meow.betteranimalsplus.common.entity.ai.EntityAIWanderWaterEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFindEntityNearest;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityShark extends EntitySharkBase implements IVariantTypes {

    protected static final DataParameter<Integer> TYPE_NUMBER = EntityDataManager.<Integer>createKey(EntityShark.class, DataSerializers.VARINT);
    private float lastAttack = 0;
    private float lastGrab = 0;

    public EntityShark(World world) {
        super(world);
        this.setSize(2.5F, 1.2F);
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityLiving.class, 15F));
        this.tasks.addTask(2, new EntityAIWanderWaterEntity(this, 0.55D));
        this.targetTasks.addTask(1, new EntityAIFindEntityNearest(this, EntityLiving.class));
        this.targetTasks.addTask(1, new EntityAIFindEntityNearest(this, EntityPlayer.class));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.75D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8D);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if(!this.world.isRemote && this.getAttackTarget() != null && !this.getAttackTarget().isDead) {
            if(this.getPassengers().contains(this.getAttackTarget())) {
                float time = 60F; 
                time *= 5F * (Math.random() + 1F);
                if(this.lastAttack + time < this.ticksExisted) {
                    this.attackEntityAsMob(this.getAttackTarget());
                }
            } else if(lastGrab  + 60F < this.ticksExisted && this.getDistanceSq(this.getAttackTarget()) < 10) {
                this.getAttackTarget().startRiding(this, true);
                lastGrab = this.ticksExisted;
            } else {
                this.getMoveHelper().setMoveTo(this.getAttackTarget().posX, this.getAttackTarget().posY, this.getAttackTarget().posZ, 0.1D);
            }
        }
    }

    @Override
    public void updatePassenger(Entity passenger) {
        if(this.isPassenger(passenger)) {
            BlockPos pos = this.getPosition().offset(this.getHorizontalFacing()).subtract(this.getPosition());
            pos = pos.add(pos.getX(), 0, pos.getZ());
            passenger.setPosition(this.posX + this.motionX + pos.getX(), this.posY - (this.height / 2) + this.motionY, this.posZ + this.motionZ + pos.getZ());
            this.motionY += Math.abs(passenger.motionY);
            if (passenger instanceof EntityLivingBase && (this.getAttackTarget() == null || this.getAttackTarget() != passenger)) {
                this.setAttackTarget((EntityLivingBase) passenger);
            }
            if (this.world.isRemote) {
                this.applyOrientationToEntity(passenger);
            }
        }
    }

    public BlockPos getOffset(float l, float w, float a1) {
        double y = (w * l) / (l * Math.tan(a1)) + w;
        double x = y / Math.tan(a1);
        return new BlockPos(x, 0, y);
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
    public boolean shouldDismountInWater(Entity entity) {
        return false;
    }

    protected void entityInit() {
        super.entityInit();
        this.registerTypeKey();
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        this.writeType(compound);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        this.readType(compound);
    }

    @Override
    @Nullable
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
        return this.initData(super.onInitialSpawn(difficulty, livingdata));
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
