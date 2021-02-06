package its_meow.betteranimalsplus.init;

import its_meow.betteranimalsplus.Ref;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.Features;
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
    public static WeightedBlockStateProvider TRILLIUM_STATE_PROVIDER = new WeightedBlockStateProvider();
    @Nullable
    public static BlockClusterFeatureConfig TRILLIUM_FEATURE_CONFIG = null;
    @Nullable
    public static ConfiguredFeature<?, ?> TRILLIUM_CF = null;

    public static void subscribe(IEventBus bus) {
        bus.addListener(ModWorldGen::setup);
    }

    public static void setup(final FMLCommonSetupEvent event) {
        TRILLIUM_STATE_PROVIDER = new WeightedBlockStateProvider();
        for(int i = 0; i < 4; i++) {
            TRILLIUM_STATE_PROVIDER.addWeightedBlockstate(ModBlocks.TRILLIUM.get().getDefaultState().with(HorizontalBlock.HORIZONTAL_FACING, Direction.byHorizontalIndex(i)), 1);
        }
        TRILLIUM_FEATURE_CONFIG = (new BlockClusterFeatureConfig.Builder(TRILLIUM_STATE_PROVIDER, new SimpleBlockPlacer())).tries(64).build();
        TRILLIUM_CF = Feature.FLOWER.withConfiguration(TRILLIUM_FEATURE_CONFIG).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT);
        event.enqueueWork(() -> {
            Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(Ref.MOD_ID, "trillium"), TRILLIUM_CF);
        });
    }

    @SubscribeEvent
    public static void biomeLoad(final BiomeLoadingEvent event) {
        if (event.getName() != null && BiomeDictionary.getTypes(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, event.getName())).contains(BiomeDictionary.Type.SWAMP))
            event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> TRILLIUM_CF);
    }
}
