package its_meow.betteranimalsplus.common.entity;

import java.util.Set;

import javax.annotation.Nullable;

import its_meow.betteranimalsplus.config.BetterAnimalsPlusConfig;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraftforge.common.BiomeDictionary;

public abstract class EntityWaterMobPathingWithSelectiveTypes extends EntityWaterMobPathingWithTypes {

    public EntityWaterMobPathingWithSelectiveTypes(World world) {
        super(world);
    }

    @Override
    @Nullable
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
        int validTypes[] = this.getTypesFor(BiomeDictionary.getTypes(world.getBiome(this.getPosition())));
        return BetterAnimalsPlusConfig.biomeBasedVariants ? this.initData(super.onInitialSpawn(difficulty, livingdata), validTypes[this.getRNG().nextInt(validTypes.length)]) : this.initData(super.onInitialSpawn(difficulty, livingdata));
    }

    protected abstract int[] getTypesFor(Set<BiomeDictionary.Type> biome);

}
