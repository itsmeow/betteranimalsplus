package its_meow.betteranimalsplus.common.entity;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public abstract class EntityWaterMobWithTypes extends EntityWaterMob implements IVariantTypes {

    protected static final DataParameter<Integer> TYPE_NUMBER = EntityDataManager.<Integer>createKey(EntityWaterMobWithTypes.class, DataSerializers.VARINT);

    public EntityWaterMobWithTypes(EntityType<? extends Entity> entityType, World worldIn) {
        super(entityType, worldIn);
    }
    
    @Override
    protected void registerData() {
        super.registerData();
        this.registerTypeKey();
    }
    
    @Override
    public boolean writeUnlessRemoved(NBTTagCompound compound) {
        this.writeType(compound);
        return super.writeUnlessRemoved(compound);
    }

    @Override
    public void read(NBTTagCompound compound) {
        super.read(compound);
        this.readType(compound);
    }

    @Override
    @Nullable
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata, NBTTagCompound compound) {
        return this.initData(super.onInitialSpawn(difficulty, livingdata, compound));
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
}
