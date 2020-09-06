package its_meow.betteranimalsplus.util;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

public class OceanBiomeHelper {

    public static class Wrapper {
        private final boolean coldOrFrozen;
        private final boolean deep;
        private final boolean frozen;
        private final boolean warm;
        private final boolean lukewarm;

        public Wrapper(Biome biome) {
            this.coldOrFrozen = OceanBiomeHelper.isColdOrFrozenOcean(biome);
            this.deep = OceanBiomeHelper.isDeepOcean(biome);
            this.frozen = OceanBiomeHelper.isFrozenOcean(biome);
            this.warm = OceanBiomeHelper.isWarmOcean(biome);
            this.lukewarm = OceanBiomeHelper.isLukewarmOcean(biome);
        }

        public boolean isLukewarm() {
            return lukewarm;
        }

        public boolean isWarm() {
            return warm;
        }

        public boolean isFrozen() {
            return frozen;
        }

        public boolean isDeep() {
            return deep;
        }

        public boolean isColdOrFrozen() {
            return coldOrFrozen;
        }
    }

    public static boolean isColdOrFrozenOcean(Biome biome) {
        Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(biome);
        return types.contains(Type.OCEAN) && (biome == Biomes.COLD_OCEAN || biome == Biomes.DEEP_COLD_OCEAN || biome == Biomes.DEEP_FROZEN_OCEAN || biome == Biomes.FROZEN_OCEAN || (types.contains(Type.COLD) && types.contains(Type.OCEAN)));
    }

    public static boolean isDeepOcean(Biome biome) {
        Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(biome);
        return types.contains(Type.OCEAN) && (biome == Biomes.DEEP_FROZEN_OCEAN || biome == Biomes.DEEP_COLD_OCEAN || biome == Biomes.DEEP_LUKEWARM_OCEAN || biome == Biomes.DEEP_OCEAN || biome == Biomes.DEEP_WARM_OCEAN || biome.getRegistryName().getPath().contains("deep"));
    }

    public static boolean isFrozenOcean(Biome biome) {
        Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(biome);
        return types.contains(Type.OCEAN) && (biome == Biomes.DEEP_FROZEN_OCEAN || biome == Biomes.FROZEN_OCEAN || biome.getRegistryName().getPath().contains("frozen"));
    }

    public static boolean isWarmOcean(Biome biome) {
        Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(biome);
        return types.contains(Type.OCEAN) && (biome == Biomes.DEEP_WARM_OCEAN || biome == Biomes.WARM_OCEAN || (biome.getRegistryName().getPath().contains("warm") && !biome.getRegistryName().getPath().contains("lukewarm")));
    }

    public static boolean isLukewarmOcean(Biome biome) {
        Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(biome);
        return types.contains(Type.OCEAN) && (biome == Biomes.DEEP_LUKEWARM_OCEAN || biome == Biomes.LUKEWARM_OCEAN || biome.getRegistryName().getPath().contains("lukewarm"));
    }

    public static Biome[] subtropicalOcean() {
        return OceanBiomeHelper.removeIf(biome -> (!OceanBiomeHelper.isWarmOcean(biome) && !OceanBiomeHelper.isLukewarmOcean(biome)) || OceanBiomeHelper.isDeepOcean(biome));
    }

    public static Biome[] returnIf(Predicate<? super Biome> filter) {
        Set<Biome> oceans = new HashSet<>();
        for(Biome b : BiomeDictionary.getBiomes(Type.OCEAN)) {
            if(filter.test(b)) {
                oceans.add(b);
            }
        }
        return oceans.toArray(new Biome[0]);
    }

    public static Biome[] removeIf(Predicate<? super Biome> filter) {
        Set<Biome> oceans = new HashSet<>(BiomeDictionary.getBiomes(Type.OCEAN));
        oceans.removeIf(filter);
        return oceans.toArray(new Biome[0]);
    }
}
