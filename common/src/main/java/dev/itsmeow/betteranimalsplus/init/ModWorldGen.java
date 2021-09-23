package dev.itsmeow.betteranimalsplus.init;

import dev.itsmeow.betteranimalsplus.Ref;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.Features;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.blockplacers.SimpleBlockPlacer;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber(modid = Ref.MOD_ID)
public class ModWorldGen {

    @Nullable
    public static WeightedStateProvider TRILLIUM_STATE_PROVIDER = new WeightedStateProvider();
    @Nullable
    public static RandomPatchConfiguration TRILLIUM_FEATURE_CONFIG = null;
    @Nullable
    public static ConfiguredFeature<?, ?> TRILLIUM_CF = null;

    public static void subscribe(IEventBus bus) {
        bus.addListener(ModWorldGen::setup);
    }

    public static void setup(final FMLCommonSetupEvent event) {
        TRILLIUM_STATE_PROVIDER = new WeightedStateProvider();
        for (int i = 0; i < 4; i++) {
            TRILLIUM_STATE_PROVIDER.add(ModBlocks.TRILLIUM.get().getDefaultState().with(HorizontalDirectionalBlock.FACING, Direction.from2DDataValue(i)), 1);
        }
        TRILLIUM_FEATURE_CONFIG = (new RandomPatchConfiguration.GrassConfigurationBuilder(TRILLIUM_STATE_PROVIDER, new SimpleBlockPlacer())).tries(64).build();
        TRILLIUM_CF = Feature.FLOWER.configured(TRILLIUM_FEATURE_CONFIG).decorated(Features.Decorators.ADD_32).decorated(Features.Decorators.HEIGHTMAP_SQUARE);
        event.enqueueWork(() -> {
            Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(Ref.MOD_ID, "trillium"), TRILLIUM_CF);
        });
    }

    @SubscribeEvent
    public static void biomeLoad(final BiomeLoadingEvent event) {
        if (event.getName() != null && BiomeDictionary.getTypes(ResourceKey.create(Registry.BIOME_REGISTRY, event.getName())).contains(BiomeDictionary.Type.SWAMP))
            event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> TRILLIUM_CF);
    }
}
