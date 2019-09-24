package its_meow.betteranimalsplus.common.entity;

import javax.annotation.Nullable;

import its_meow.betteranimalsplus.init.ModEntities;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class EntityMoose extends EntityAnimalWithTypes {

    public EntityMoose(World worldIn) {
        super(ModEntities.getEntityType("moose"), worldIn);
    }

    @Override
    public int getVariantMax() {
        return 4;
    }

    @Override
    protected IVariantTypes getBaseChild() {
        return null;
    }

    @Override
    protected String getContainerName() {
        return "moose";
    }
    
    @Override
    @Nullable
    public ILivingEntityData onInitialSpawn(IWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData livingdata, CompoundNBT compound) {
        int validTypes[] = {1, 2, 3, 4};
        return this.initData(super.onInitialSpawn(world, difficulty, reason, livingdata, compound), getBiasedRandomType(validTypes));
    }

    private int getBiasedRandomType(int[] validTypes) {
        int r = validTypes[this.getRNG().nextInt(validTypes.length)];
        if(r > 2) {
            r = validTypes[this.getRNG().nextInt(validTypes.length)];
        }
        if(r > 2) {
            r = validTypes[this.getRNG().nextInt(validTypes.length)];
        }
        return r;
    }

}
