package its_meow.betteranimalsplus.common.entity.util;

import java.util.Set;

import javax.annotation.Nullable;

import its_meow.betteranimalsplus.config.BetterAnimalsPlusConfig;
import net.minecraft.entity.AgeableEntity.AgeableData;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

public interface ISelectiveVariantTypes<T extends MobEntity> extends IVariantTypes<T> {

    @Nullable
    @Override
    default ILivingEntityData initData(IWorld world, SpawnReason reason, ILivingEntityData livingdata) {
        if(BetterAnimalsPlusConfig.biomeBasedVariants && (reason == SpawnReason.CHUNK_GENERATION || reason == SpawnReason.NATURAL)) {
            Biome biome = world.getBiome(this.getImplementation().getPosition());
            String[] validTypes = this.getTypesFor(biome, BiomeDictionary.getTypes(biome));
            String variant = validTypes[this.getImplementation().getRNG().nextInt(validTypes.length)];
            if(livingdata instanceof TypeData) {
                variant = ((TypeData) livingdata).typeData;
            } else {
                livingdata = new TypeData(variant);
            }
            this.setType(variant);
        } else {
            String variant = this.getRandomType().getName();
            if(livingdata instanceof TypeData) {
                variant = ((TypeData) livingdata).typeData;
            } else {
                livingdata = new TypeData(variant);
            }
            this.setType(variant);
        }
        return livingdata;
    }

    @Nullable
    @Override
    default ILivingEntityData initAgeableData(IWorld world, SpawnReason reason, ILivingEntityData livingdata) {
        if(BetterAnimalsPlusConfig.biomeBasedVariants && (reason == SpawnReason.CHUNK_GENERATION || reason == SpawnReason.NATURAL)) {
            Biome biome = world.getBiome(this.getImplementation().getPosition());
            String[] validTypes = this.getTypesFor(biome, BiomeDictionary.getTypes(biome));
            String variant = validTypes[this.getImplementation().getRNG().nextInt(validTypes.length)];
            if(livingdata instanceof AgeableTypeData) {
                variant = ((AgeableTypeData) livingdata).typeData;
            } else if(livingdata instanceof AgeableData) {
                livingdata = new AgeableTypeData((AgeableData) livingdata, variant);
            } else {
                livingdata = new AgeableTypeData(variant);
            }
            this.setType(variant);
        } else {
            String variant = this.getRandomType().getName();
            if(livingdata instanceof AgeableTypeData) {
                variant = ((AgeableTypeData) livingdata).typeData;
            } else if(livingdata instanceof AgeableData) {
                livingdata = new AgeableTypeData((AgeableData) livingdata, variant);
            } else {
                livingdata = new AgeableTypeData(variant);
            }
            this.setType(variant);
        }
        return livingdata;
    }

    String[] getTypesFor(Biome biome, Set<BiomeDictionary.Type> types);

}
