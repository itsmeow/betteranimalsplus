package dev.itsmeow.betteranimalsplus.init;

import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;

//@Mod.EventBusSubscriber(modid = Ref.MOD_ID)
public class ModWorldGen {
    // TODO port worldgen

    public static WeightedStateProvider TRILLIUM_STATE_PROVIDER = new WeightedStateProvider();
    public static RandomPatchConfiguration TRILLIUM_FEATURE_CONFIG = null;
    public static ConfiguredFeature<?, ?> TRILLIUM_CF = null;

    public static void setup() {/*
        TRILLIUM_STATE_PROVIDER = new WeightedStateProvider();
        for (int i = 0; i < 4; i++) {
            TRILLIUM_STATE_PROVIDER.add(ModBlocks.TRILLIUM.get().getDefaultState().with(HorizontalDirectionalBlock.FACING, Direction.from2DDataValue(i)), 1);
        }
        TRILLIUM_FEATURE_CONFIG = (new RandomPatchConfiguration.GrassConfigurationBuilder(TRILLIUM_STATE_PROVIDER, new SimpleBlockPlacer())).tries(64).build();
        TRILLIUM_CF = Feature.FLOWER.configured(TRILLIUM_FEATURE_CONFIG).decorated(Features.Decorators.ADD_32).decorated(Features.Decorators.HEIGHTMAP_SQUARE);
        event.enqueueWork(() -> {
            Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(Ref.MOD_ID, "trillium"), TRILLIUM_CF);
        });*/
    }

    public static void biomeLoad() {
        /*
        if (event.getName() != null && BiomeDictionary.getTypes(ResourceKey.create(Registry.BIOME_REGISTRY, event.getName())).contains(BiomeDictionary.Type.SWAMP))
            event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> TRILLIUM_CF);*/
    }
}
