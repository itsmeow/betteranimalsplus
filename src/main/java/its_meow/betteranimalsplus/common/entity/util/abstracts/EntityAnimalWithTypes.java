package its_meow.betteranimalsplus.common.entity.util.abstracts;

import javax.annotation.Nullable;

import dev.itsmeow.imdlib.entity.util.IVariantTypes;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public abstract class EntityAnimalWithTypes extends AnimalEntity implements IVariantTypes<EntityAnimalWithTypes> {

    public EntityAnimalWithTypes(EntityType<? extends AnimalEntity> entityType, World worldIn) {
        super(entityType, worldIn);
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
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.readType(compound);
    }

    @Override
    @Nullable
    public ILivingEntityData onInitialSpawn(IWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData livingdata, CompoundNBT compound) {
        return this.initAgeableData(world, reason, super.onInitialSpawn(world, difficulty, reason, livingdata, compound));
    }

    @Override
    public AgeableEntity createChild(AgeableEntity ageable) {
        if(!(ageable instanceof IVariantTypes))
            return null;
        IVariantTypes<?> child = getBaseChild();
        if(child == null)
            return null;
        return (AgeableEntity) child.setType(this.getOffspringType(this, (IVariantTypes<?>) ageable));
    }

    protected abstract EntityAnimalWithTypes getBaseChild();

    @Override
    public boolean canDespawn(double range) {
        return despawn(range);
    }

    @Override
    public EntityAnimalWithTypes getImplementation() {
        return this;
    }

}