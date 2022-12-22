package dev.itsmeow.betteranimalsplus.init;

import dev.architectury.registry.level.biome.BiomeModifications;
import dev.itsmeow.betteranimalsplus.Ref;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;
import java.util.function.Consumer;

public class ModWorldGen {

    public static ConfiguredFeature<RandomPatchConfiguration, ?> TRILLIUM_CF = null;
    public static PlacedFeature TRILLIUM_PF = null;
    public static PlacedFeature TRILLIUM_DENSE_PF = null;

    public static void init(Consumer<Runnable> enqueue) {
        // TODO
        // Mojang don't break worldgen code challenge (impossible)
        /*TRILLIUM_CF = new ConfiguredFeature(Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                        new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                .add(ModBlocks.TRILLIUM.get().defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, Direction.NORTH), 1)
                                .add(ModBlocks.TRILLIUM.get().defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, Direction.EAST), 1)
                                .add(ModBlocks.TRILLIUM.get().defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, Direction.SOUTH), 1)
                                .add(ModBlocks.TRILLIUM.get().defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, Direction.WEST), 1))),
                List.of(), 64));
        TRILLIUM_PF = new PlacedFeature(Holder.direct(TRILLIUM_CF), List.of(
                RarityFilter.onAverageOnceEvery(16),
                InSquarePlacement.spread(),
                HeightmapPlacement.onHeightmap(Heightmap.Types.MOTION_BLOCKING),
                BiomeFilter.biome()));
        TRILLIUM_DENSE_PF = new PlacedFeature(Holder.direct(TRILLIUM_CF), List.of(
                RarityFilter.onAverageOnceEvery(4),
                InSquarePlacement.spread(),
                HeightmapPlacement.onHeightmap(Heightmap.Types.MOTION_BLOCKING),
                BiomeFilter.biome()));
        enqueue.accept(() -> {
            Registry.register(Registries.CONFIGURED_FEATURE, new ResourceLocation(Ref.MOD_ID, "trillium"), TRILLIUM_CF);
            Registry.register(Registries.PLACED_FEATURE, new ResourceLocation(Ref.MOD_ID, "trillium"), TRILLIUM_PF);
            Registry.register(Registries.PLACED_FEATURE, new ResourceLocation(Ref.MOD_ID, "trillium_dense"), TRILLIUM_DENSE_PF);
        });
        BiomeModifications.addProperties(
                ctx -> isSwamp(ctx) && !isDenseSwamp(ctx),
                (ctx, mutable) -> mutable.getGenerationProperties().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TRILLIUM_PF)
        );
        BiomeModifications.addProperties(
                ctx -> isSwamp(ctx) && isDenseSwamp(ctx),
                (ctx, mutable) -> mutable.getGenerationProperties().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TRILLIUM_DENSE_PF)
        );*/
    }

    private static boolean isSwamp(BiomeModifications.BiomeContext ctx) {
        return ctx.getKey().get().getPath().contains("swamp") || ctx.hasTag(key("c", "swamp")) || ctx.hasTag(key("forge", "is_swamp")) || ctx.hasTag(key(ctx.getKey().get().getNamespace(), "is_swamp"));
    }

    private static boolean isDenseSwamp(BiomeModifications.BiomeContext ctx) {
        return "mangrove_swamp".equals(ctx.getKey().get().getPath()) || ctx.hasTag(key("c", "vegetation_dense")) || ctx.hasTag(key("forge", "is_dense")) || ctx.hasTag(key(ctx.getKey().get().getNamespace(), "is_dense"));
    }

    private static TagKey<Biome> key(String space, String key) {
        return TagKey.create(Registries.BIOME, new ResourceLocation(space, key));
    }
}
