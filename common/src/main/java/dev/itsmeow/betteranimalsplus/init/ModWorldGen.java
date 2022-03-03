package dev.itsmeow.betteranimalsplus.init;

import dev.architectury.registry.level.biome.BiomeModifications;
import dev.itsmeow.betteranimalsplus.Ref;
import dev.itsmeow.imdlib.entity.util.BiomeTypes;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
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

    public static void init(Consumer<Runnable> enqueue) {
        TRILLIUM_CF = new ConfiguredFeature(Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                        new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                .add(ModBlocks.TRILLIUM.get().defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, Direction.NORTH), 1)
                                .add(ModBlocks.TRILLIUM.get().defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, Direction.EAST), 1)
                                .add(ModBlocks.TRILLIUM.get().defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, Direction.SOUTH), 1)
                                .add(ModBlocks.TRILLIUM.get().defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, Direction.WEST), 1))),
                List.of(), 64));
        TRILLIUM_PF = new PlacedFeature(Holder.direct(TRILLIUM_CF), List.of(
                RarityFilter.onAverageOnceEvery(32),
                InSquarePlacement.spread(),
                HeightmapPlacement.onHeightmap(Heightmap.Types.MOTION_BLOCKING),
                BiomeFilter.biome()));
        enqueue.accept(() -> {
            Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(Ref.MOD_ID, "trillium"), TRILLIUM_CF);
            Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(Ref.MOD_ID, "trillium"), TRILLIUM_PF);
        });
        BiomeModifications.addProperties(
                ctx -> BiomeTypes.getTypes(ctx).contains(BiomeTypes.SWAMP),
                (ctx, mutable) -> mutable.getGenerationProperties().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TRILLIUM_PF)
        );

    }
}
