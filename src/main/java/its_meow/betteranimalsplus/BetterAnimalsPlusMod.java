package its_meow.betteranimalsplus;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import its_meow.betteranimalsplus.client.ClientLifecycleHandler;
import its_meow.betteranimalsplus.common.world.gen.TrilliumGenerator;
import its_meow.betteranimalsplus.config.BetterAnimalsPlusConfig;
import its_meow.betteranimalsplus.init.ModItems;
import its_meow.betteranimalsplus.network.ClientConfigurationPacket;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;


@Mod.EventBusSubscriber(modid = Ref.MOD_ID)
@Mod(value = Ref.MOD_ID)
public class BetterAnimalsPlusMod {
    
    public static final Logger logger = LogManager.getLogger();
    private static final String PROTOCOL_VERSION = "1";
    private static final SimpleChannel HANDLER = NetworkRegistry.ChannelBuilder
            .named(new ResourceLocation(Ref.MOD_ID, "main_channel"))
            .clientAcceptedVersions(PROTOCOL_VERSION::equals)
            .serverAcceptedVersions(PROTOCOL_VERSION::equals)
            .networkProtocolVersion(() -> PROTOCOL_VERSION)
            .simpleChannel();
    public static int packets = 0;

    public BetterAnimalsPlusMod() {

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus()
                .<FMLClientSetupEvent>addListener(e -> new ClientLifecycleHandler().clientSetup(e));

        BetterAnimalsPlusConfig.setupConfig();
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, BetterAnimalsPlusConfig.SERVER_CONFIG);
        
        BetterAnimalsPlusMod.logger.log(Level.INFO, "Injecting super coyotes...");
    }

    public static ItemGroup group = new ItemGroup("Better Animals+") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.ANTLER);
        }

        @Override
        public void fill(NonNullList<ItemStack> toDisplay) {
            super.fill(toDisplay);
            for (SpawnEggItem egg : ModItems.eggs.keySet()) {
                ItemStack stack = new ItemStack(egg);
                toDisplay.add(stack);
            }
        }
    };

    private void setup(final FMLCommonSetupEvent event) {
        HANDLER.registerMessage(packets++, ClientConfigurationPacket.class, ClientConfigurationPacket::encode, ClientConfigurationPacket::decode, ClientConfigurationPacket.Handler::handle);
        BiomeDictionary.getBiomes(BiomeDictionary.Type.SWAMP).forEach(biome -> biome.addFeature(net.minecraft.world.gen.GenerationStage.Decoration.VEGETAL_DECORATION,
                        Biome.createDecoratedFeature(new TrilliumGenerator(), new NoFeatureConfig(), Placement.TOP_SOLID_HEIGHTMAP, IPlacementConfig.NO_PLACEMENT_CONFIG)));
        BetterAnimalsPlusMod.logger.log(Level.INFO, "Overspawning lammergeiers...");
    }
	
	@SubscribeEvent
	public static void onPlayerJoin(PlayerLoggedInEvent e) {
	    if(e.getPlayer() instanceof ServerPlayerEntity) {
	        HANDLER.sendTo(new ClientConfigurationPacket(BetterAnimalsPlusConfig.coyotesHostileDaytime, BetterAnimalsPlusConfig.getTameItemsMap()), ((ServerPlayerEntity) e.getPlayer()).connection.netManager, NetworkDirection.PLAY_TO_CLIENT);
	    }
	}

}
