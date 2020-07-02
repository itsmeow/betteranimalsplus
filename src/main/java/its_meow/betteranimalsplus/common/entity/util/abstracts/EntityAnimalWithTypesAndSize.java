package its_meow.betteranimalsplus.common.entity.util.abstracts;

import javax.annotation.Nullable;

import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SpawnReason;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public abstract class EntityAnimalWithTypesAndSize extends EntityAnimalWithTypes {

    protected static final DataParameter<Float> SIZE = EntityDataManager.<Float>createKey(EntityAnimalWithTypesAndSize.class, DataSerializers.FLOAT);

    public EntityAnimalWithTypesAndSize(EntityType<? extends EntityAnimalWithTypes> entityType, World worldIn) {
        super(entityType, worldIn);
        this.setSize(0.35F);
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(SIZE, 1F);
    }

    @Override
    public EntitySize getSize(Pose pose) {
        float size = this.dataManager.get(SIZE).floatValue();
        return EntitySize.flexible(size, size).scale(this.getRenderScale());
    }

    public void setSize(float size) {
        this.dataManager.set(SIZE, size);
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putFloat("Size", this.getSize(Pose.STANDING).width);
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        float size = compound.getFloat("Size");
        this.setSize(size);
    }

    @Override
    @Nullable
    public ILivingEntityData onInitialSpawn(IWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData livingdata, CompoundNBT compound) {
        livingdata = super.onInitialSpawn(world, difficulty, reason, livingdata, compound);
        if(!this.isChild()) {
            String i = this.getRandomType().getName();
            float rand = this.getRandomizedSize();

            if(livingdata instanceof SizeTypeData) {
                i = ((SizeTypeData) livingdata).typeData;
                rand = ((SizeTypeData) livingdata).size;
            } else {
                livingdata = new SizeTypeData(i, rand);
            }

            this.setType(i);
            this.setSize(rand);
        }
        return livingdata;
    }

    protected abstract float getRandomizedSize();

    public static class SizeTypeData implements ILivingEntityData {

        public String typeData;
        public float size;

        public SizeTypeData(String type, float size) {
            this.typeData = type;
            this.size = size;
        }
    }

}
