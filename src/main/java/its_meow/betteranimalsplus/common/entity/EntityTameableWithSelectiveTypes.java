package its_meow.betteranimalsplus.common.entity;

import java.util.Set;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.common.BiomeDictionary;

public abstract class EntityTameableWithSelectiveTypes extends EntityTameableWithTypes {
    
    public EntityTameableWithSelectiveTypes(EntityType<? extends EntityTameableWithSelectiveTypes> type, World world) {
        super(type, world);
    }
    
    @Override
    public ILivingEntityData onInitialSpawn(IWorld world, DifficultyInstance difficulty, SpawnReason reason, ILivingEntityData livingdata, CompoundNBT compound) {
        int validTypes[] = this.getTypesFor(BiomeDictionary.getTypes(world.getBiome(this.getPosition())));
        int type = validTypes[this.getRNG().nextInt(validTypes.length)];
        return this.initData(super.onInitialSpawn(world, difficulty, reason, livingdata, compound), type);
    }

    protected abstract int[] getTypesFor(Set<BiomeDictionary.Type> types);

}
