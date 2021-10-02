package dev.itsmeow.betteranimalsplus.init;

import dev.itsmeow.betteranimalsplus.Ref;
import dev.itsmeow.imdlib.entity.util.BiomeTypes;
import me.shedaniel.architectury.registry.BiomeModifications;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.Features;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.blockplacers.SimpleBlockPlacer;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;

import java.util.function.Consumer;

public class ModWorldGen {

    public static WeightedStateProvider TRILLIUM_STATE_PROVIDER = new WeightedStateProvider();
    public static RandomPatchConfiguration TRILLIUM_FEATURE_CONFIG = null;
    public static ConfiguredFeature<?, ?> TRILLIUM_CF = null;

    public static void init(Consumer<Runnable> enqueue) {
        TRILLIUM_STATE_PROVIDER = new WeightedStateProvider();
        for (int i = 0; i < 4; i++) {
            TRILLIUM_STATE_PROVIDER.add(ModBlocks.TRILLIUM.get().defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, Direction.from2DDataValue(i)), 1);
        }
        TRILLIUM_FEATURE_CONFIG = (new RandomPatchConfiguration.GrassConfigurationBuilder(TRILLIUM_STATE_PROVIDER, new SimpleBlockPlacer())).tries(64).build();
        TRILLIUM_CF = Feature.FLOWER.configured(TRILLIUM_FEATURE_CONFIG).decorated(Features.Decorators.ADD_32).decorated(Features.Decorators.HEIGHTMAP_SQUARE);
        enqueue.accept(() -> Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(Ref.MOD_ID, "trillium"), ModWorldGen.TRILLIUM_CF));
        BiomeModifications.addProperties(
                ctx -> BiomeTypes.getTypes(ctx).contains(BiomeTypes.SWAMP),
                (ctx, mutable) -> mutable.getGenerationProperties().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TRILLIUM_CF)
        );
    }

}
