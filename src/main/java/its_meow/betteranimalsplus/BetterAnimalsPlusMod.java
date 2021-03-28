package its_meow.betteranimalsplus;

import com.google.common.collect.ImmutableList;
import dev.itsmeow.imdlib.util.ClassLoadHacks;
import its_meow.betteranimalsplus.client.ClientLifecycleHandler;
import its_meow.betteranimalsplus.client.dumb.SafeSyncThing;
import its_meow.betteranimalsplus.client.dumb.SafeSyncThing.DumbOptions;
import its_meow.betteranimalsplus.common.entity.EntityCoyote;
import its_meow.betteranimalsplus.compat.curios.CuriosModCompat;
import its_meow.betteranimalsplus.config.BetterAnimalsPlusConfig;
import its_meow.betteranimalsplus.init.*;
import its_meow.betteranimalsplus.network.*;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.placement.NoiseDependant;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.UUID;

@SuppressWarnings("deprecation")
@Mod.EventBusSubscriber(modid = Ref.MOD_ID)
@Mod(value = Ref.MOD_ID)
public class BetterAnimalsPlusMod {
    
    public static final Logger logger = LogManager.getLogger();
    public static final String PROTOCOL_VERSION = "2";
    public static final SimpleChannel HANDLER = NetworkRegistry.ChannelBuilder
            .named(new ResourceLocation(Ref.MOD_ID, "main_channel"))
            .clientAcceptedVersions(PROTOCOL_VERSION::equals)
            .serverAcceptedVersions(PROTOCOL_VERSION::equals)
            .networkProtocolVersion(() -> PROTOCOL_VERSION)
            .simpleChannel();
    public static int packets = 0;
    private static final ImmutableList<UUID> DEVS = ImmutableList.of(
    UUID.fromString("81d9726a-56d4-4419-9a2a-be1d7f7f7ef1"), // its_meow
    UUID.fromString("403f2fd4-f8a2-4608-a0b8-534da4184735"), // cyber
    UUID.fromString("4605663e-fb07-4843-98c5-73adbfb2625e") // batman
    );

    public BetterAnimalsPlusMod() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        modBus.addListener(this::setup);
        modBus.addListener(this::loadComplete);
        modBus.<FMLClientSetupEvent>addListener(e -> new ClientLifecycleHandler().clientSetup(e));
        ModResources.Tags.Blocks.loadTags();
        ModResources.Tags.Items.loadTags();
        ModEntities.subscribe(modBus);
        ModBlocks.subscribe(modBus);
        ModItems.subscribe(modBus);
        ModSoundEvents.subscribe(modBus);
        ModTileEntities.subscribe(modBus);
        ModTriggers.register();
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, BetterAnimalsPlusConfig.getClientSpec());
        BetterAnimalsPlusMod.logger.log(Level.INFO, "Injecting super coyotes...");
        ClassLoadHacks.runWhenLoaded("curios", () -> () -> CuriosModCompat.subscribe(modBus));
    }

    public static boolean isDev(UUID uuid) {
        return DEVS.contains(uuid);
    }

    public static boolean isDev(PlayerEntity player) {
        return isDev(player.getGameProfile().getId());
    }

    public static final ItemGroup GROUP = new ItemGroup("Better Animals+") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.ANTLER.get());
        }

        @Override
        public void fill(NonNullList<ItemStack> toDisplay) {
            super.fill(toDisplay);
            ModEntities.getEntities().values().forEach(cont -> toDisplay.add(new ItemStack(cont.egg)));
        }
    };

    private void setup(final FMLCommonSetupEvent event) {
        HANDLER.registerMessage(packets++, ClientConfigurationPacket.class, ClientConfigurationPacket::encode, ClientConfigurationPacket::decode, ClientConfigurationPacket.Handler::handle);
        HANDLER.registerMessage(packets++, ServerNoBAMPacket.class, (pkt, buf) -> {}, buf -> new ServerNoBAMPacket(), (pkt, ctx) -> {
            ctx.get().enqueueWork(() -> ModTriggers.NO_BAM.trigger(ctx.get().getSender()));
            ctx.get().setPacketHandled(true);
        });
        HANDLER.registerMessage(packets++, ClientRequestBAMPacket.class, (pkt, buf) -> {}, buf -> new ClientRequestBAMPacket(), (pkt, ctx) -> {
            ctx.get().enqueueWork(() -> {
                if(!ModList.get().isLoaded("betteranimals")) {
                    HANDLER.sendToServer(new ServerNoBAMPacket());
                }
            });
            ctx.get().setPacketHandled(true);
        });
        HANDLER.registerMessage(packets++, StupidDevPacket.class, StupidDevPacket::encode, StupidDevPacket::decode, StupidDevPacket.Handler::handle);
        HANDLER.registerMessage(packets++, HonkPacket.class, HonkPacket::encode, HonkPacket::decode, HonkPacket.Handler::handle);
        DeferredWorkQueue.runLater(() -> {
            WeightedBlockStateProvider trilliumState = new WeightedBlockStateProvider();
            for (int i = 0; i < 4; i++) {
                trilliumState.addWeightedBlockstate(ModBlocks.TRILLIUM.get().getDefaultState().with(HorizontalBlock.HORIZONTAL_FACING, Direction.byHorizontalIndex(i)), 1);
            }
            BlockClusterFeatureConfig featureConfig = (new BlockClusterFeatureConfig.Builder(trilliumState, new SimpleBlockPlacer())).tries(64).build();
            BiomeDictionary.getBiomes(BiomeDictionary.Type.SWAMP).forEach(biome -> biome.addFeature(net.minecraft.world.gen.GenerationStage.Decoration.VEGETAL_DECORATION,
                    Feature.FLOWER.withConfiguration(featureConfig).withPlacement(Placement.NOISE_HEIGHTMAP_32.configure(new NoiseDependant(-0.8D, 0, 3)))));
        });
        BetterAnimalsPlusMod.logger.log(Level.INFO, "Overspawning lammergeiers...");
    }
    
    private void loadComplete(final FMLLoadCompleteEvent event) {
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, BetterAnimalsPlusConfig.getServerSpec());
        BetterAnimalsPlusMod.logger.log(Level.INFO, "Finished crazy bird creation!");
    }

	@SubscribeEvent
	public static void onPlayerJoin(PlayerLoggedInEvent e) {
	    if(e.getPlayer() instanceof ServerPlayerEntity) {
	        HANDLER.sendTo(new ClientConfigurationPacket(EntityCoyote.HOSTILE_DAYTIME, BetterAnimalsPlusConfig.getTameItemsMap()), ((ServerPlayerEntity) e.getPlayer()).connection.netManager, NetworkDirection.PLAY_TO_CLIENT);
	        HANDLER.sendTo(new ClientRequestBAMPacket(), ((ServerPlayerEntity) e.getPlayer()).connection.netManager, NetworkDirection.PLAY_TO_CLIENT);
            for(UUID devId : DEVS) {
                HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) e.getPlayer()), new StupidDevPacket(SafeSyncThing.get(devId), devId));
            }
	    }
	}

    @SubscribeEvent
    public static void onPlayerLeave(PlayerLoggedInEvent e) {
        if (e.getPlayer() instanceof ServerPlayerEntity) {
            for (UUID devId : DEVS) {
                SafeSyncThing.put(devId, DumbOptions.OFF);
                HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) e.getPlayer()), new StupidDevPacket(DumbOptions.OFF, devId));
            }
        }
    }

}
