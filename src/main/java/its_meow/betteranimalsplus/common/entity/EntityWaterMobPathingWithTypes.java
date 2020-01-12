package its_meow.betteranimalsplus.common.entity;

import java.util.Random;

import javax.annotation.Nullable;

import its_meow.betteranimalsplus.util.EntityTypeContainer;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public abstract class EntityWaterMobPathingWithTypes extends EntityWaterMobPathing implements IVariantTypes {

    protected static final DataParameter<Integer> TYPE_NUMBER = EntityDataManager.<Integer>createKey(EntityWaterMobPathingWithTypes.class, DataSerializers.VARINT);

    public EntityWaterMobPathingWithTypes(EntityType<? extends EntityWaterMobPathingWithTypes> entityType, World worldIn) {
        super(entityType, worldIn);
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
    
    protected abstract EntityTypeContainer<? extends EntityWaterMobPathingWithTypes> getContainer();

    @Override
    public boolean canDespawn(double range) {
        return getContainer().despawn && !this.hasCustomName();
    }
}
