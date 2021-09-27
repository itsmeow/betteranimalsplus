package dev.itsmeow.betteranimalsplus.common.entity.util.abstracts;

import dev.itsmeow.imdlib.entity.interfaces.IVariantTypes;
import net.minecraft.world.entity.AgableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;

import javax.annotation.Nullable;

public abstract class EntityAnimalWithTypes extends Animal implements IVariantTypes<EntityAnimalWithTypes> {

    public EntityAnimalWithTypes(EntityType<? extends Animal> entityType, Level worldIn) {
        super(entityType, worldIn);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.registerTypeKey();
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        this.writeType(compound);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.readType(compound);
    }

    @Override
    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, CompoundTag compound) {
        return this.initAgeableData(world, reason, super.finalizeSpawn(world, difficulty, reason, livingdata, compound));
    }

    @Override
    public AgableMob getBreedOffspring(ServerLevel world, AgableMob ageable) {
        if (!(ageable instanceof IVariantTypes))
            return null;
        IVariantTypes<?> child = getBaseChild();
        if (child == null)
            return null;
        return (AgableMob) child.setType(this.getOffspringType(this, (IVariantTypes<?>) ageable));
    }

    protected abstract EntityAnimalWithTypes getBaseChild();

    @Override
    public boolean removeWhenFarAway(double range) {
        return despawn(range);
    }

    @Override
    public EntityAnimalWithTypes getImplementation() {
        return this;
    }

}