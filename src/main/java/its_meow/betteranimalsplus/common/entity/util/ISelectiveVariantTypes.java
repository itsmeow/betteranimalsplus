package its_meow.betteranimalsplus.common.entity.util;

import java.util.Set;

import javax.annotation.Nullable;

import its_meow.betteranimalsplus.config.BetterAnimalsPlusConfig;
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
            if(!this.getImplementation().isChild()) {
                Biome biome = world.getBiome(this.getImplementation().getPosition());
                String[] validTypes = this.getTypesFor(biome, BiomeDictionary.getTypes(biome));
                String variant = validTypes[this.getImplementation().getRNG().nextInt(validTypes.length)];
                livingdata = new TypeData(variant);
                this.setType(variant);
            }
        } else {
            if(!this.getImplementation().isChild()) {
                String variant = this.getRandomType().getName();
                if(livingdata instanceof TypeData) {
                    variant = ((TypeData) livingdata).typeData;
                } else {
                    livingdata = new TypeData(variant);
                }
                this.setType(variant);
            }
        }
        return livingdata;
    }

    String[] getTypesFor(Biome biome, Set<BiomeDictionary.Type> types);

}
