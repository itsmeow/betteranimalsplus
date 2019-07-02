package its_meow.betteranimalsplus.common.entity;

import java.util.Set;

import javax.annotation.Nullable;

import net.minecraft.entity.IEntityLivingData;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraftforge.common.BiomeDictionary;

public abstract class EntityTameableWithSelectiveTypes extends EntityTameableWithTypes {
    
    public EntityTameableWithSelectiveTypes(World world) {
        super(world);
    }
    
    @Override
    @Nullable
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
        int validTypes[] = this.getTypesFor(BiomeDictionary.getTypes(world.getBiome(this.getPosition())));
        int type = validTypes[this.getRNG().nextInt(validTypes.length)];
        return this.initData(super.onInitialSpawn(difficulty, livingdata), type);
    }

    protected abstract int[] getTypesFor(Set<BiomeDictionary.Type> types);

}
