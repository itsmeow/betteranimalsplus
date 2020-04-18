package its_meow.betteranimalsplus.common.entity.util.abstracts;

import javax.annotation.Nullable;

import its_meow.betteranimalsplus.common.entity.util.IVariantTypes;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public abstract class EntityTameableWithTypes extends EntityTameableBetterAnimalsPlus implements IVariantTypes<EntityTameableBetterAnimalsPlus> {

    public EntityTameableWithTypes(EntityType<? extends EntityTameableWithTypes> entityType, World worldIn) {
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

    protected abstract EntityTameableWithTypes getBaseChild();

}
