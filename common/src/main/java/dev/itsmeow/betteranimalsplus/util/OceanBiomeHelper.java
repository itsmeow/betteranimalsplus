package dev.itsmeow.betteranimalsplus.util;

import dev.itsmeow.imdlib.entity.util.BiomeTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class OceanBiomeHelper {

    public static boolean isColdOrFrozenOcean(ResourceKey<Biome> biome) {
        Set<BiomeTypes.Type> types = BiomeTypes.getTypes(biome);
        return types.contains(BiomeTypes.OCEAN) && (biome == Biomes.COLD_OCEAN || biome == Biomes.DEEP_COLD_OCEAN || biome == Biomes.DEEP_FROZEN_OCEAN || biome == Biomes.FROZEN_OCEAN || (types.contains(BiomeTypes.COLD) && types.contains(BiomeTypes.OCEAN)));
    }

    public static boolean isDeepOcean(ResourceKey<Biome> biome) {
        Set<BiomeTypes.Type> types = BiomeTypes.getTypes(biome);
        return types.contains(BiomeTypes.OCEAN) && (biome == Biomes.DEEP_FROZEN_OCEAN || biome == Biomes.DEEP_COLD_OCEAN || biome == Biomes.DEEP_LUKEWARM_OCEAN || biome == Biomes.DEEP_OCEAN || biome == Biomes.DEEP_WARM_OCEAN || biome.location().getPath().contains("deep"));
    }

    public static boolean isFrozenOcean(ResourceKey<Biome> biome) {
        Set<BiomeTypes.Type> types = BiomeTypes.getTypes(biome);
        return types.contains(BiomeTypes.OCEAN) && (biome == Biomes.DEEP_FROZEN_OCEAN || biome == Biomes.FROZEN_OCEAN || biome.location().getPath().contains("frozen"));
    }

    public static boolean isWarmOcean(ResourceKey<Biome> biome) {
        Set<BiomeTypes.Type> types = BiomeTypes.getTypes(biome);
        return types.contains(BiomeTypes.OCEAN) && (biome == Biomes.DEEP_WARM_OCEAN || biome == Biomes.WARM_OCEAN || (biome.location().getPath().contains("warm") && !biome.location().getPath().contains("lukewarm")));
    }

    public static boolean isLukewarmOcean(ResourceKey<Biome> biome) {
        Set<BiomeTypes.Type> types = BiomeTypes.getTypes(biome);
        return types.contains(BiomeTypes.OCEAN) && (biome == Biomes.DEEP_LUKEWARM_OCEAN || biome == Biomes.LUKEWARM_OCEAN || biome.location().getPath().contains("lukewarm"));
    }

    public static ResourceKey<Biome>[] subtropicalOcean() {
        return OceanBiomeHelper.removeIf(biome -> (!OceanBiomeHelper.isWarmOcean(biome) && !OceanBiomeHelper.isLukewarmOcean(biome)) || OceanBiomeHelper.isDeepOcean(biome));
    }

    public static ResourceKey<Biome>[] returnIf(Predicate<ResourceKey<Biome>> filter) {
        Set<ResourceKey<Biome>> oceans = new HashSet<>();
        for (ResourceKey<Biome> b : BiomeTypes.getBiomes(BiomeTypes.OCEAN)) {
            if (filter.test(b)) {
                oceans.add(b);
            }
        }
        return oceans.toArray(new ResourceKey[0]);
    }

    public static ResourceKey<Biome>[] removeIf(Predicate<ResourceKey<Biome>> filter) {
        Set<ResourceKey<Biome>> oceans = new HashSet<>(BiomeTypes.getBiomes(BiomeTypes.OCEAN));
        oceans.removeIf(filter);
        return oceans.toArray(new ResourceKey[0]);
    }

    public static class Wrapper {
        private final boolean coldOrFrozen;
        private final boolean deep;
        private final boolean frozen;
        private final boolean warm;
        private final boolean lukewarm;

        public Wrapper(ResourceKey<Biome> biome) {
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
}
