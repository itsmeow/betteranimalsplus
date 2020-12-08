package its_meow.betteranimalsplus;

import java.util.UUID;

import net.minecraft.util.*;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Features;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.ImmutableList;
import dev.itsmeow.imdlib.util.ClassLoadHacks;
import its_meow.betteranimalsplus.client.ClientLifecycleHandler;
import its_meow.betteranimalsplus.client.dumb.SafeSyncThing;
import its_meow.betteranimalsplus.client.dumb.SafeSyncThing.DumbOptions;
import its_meow.betteranimalsplus.common.entity.EntityCoyote;
import its_meow.betteranimalsplus.config.BetterAnimalsPlusConfig;
import its_meow.betteranimalsplus.init.*;
import its_meow.betteranimalsplus.network.*;
import its_meow.betteranimalsplus.compat.curios.CuriosModCompat;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.dispenser.ProjectileDispenseBehavior;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.world.World;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
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
    public static final WeightedBlockStateProvider TRILLIUM_STATE_PROVIDER = new WeightedBlockStateProvider();
    static {
        for(int i = 0; i < 4; i++) {
            TRILLIUM_STATE_PROVIDER.addWeightedBlockstate(ModBlocks.TRILLIUM.get().getDefaultState().with(HorizontalBlock.HORIZONTAL_FACING, Direction.byHorizontalIndex(i)), 1);
        }
    }
    public static final BlockClusterFeatureConfig TRILLIUM_FEATURE_CONFIG = (new BlockClusterFeatureConfig.Builder(TRILLIUM_STATE_PROVIDER, new SimpleBlockPlacer())).tries(64).build();
    public static final ConfiguredFeature<?, ?> TRILLIUM_CF = Feature.FLOWER.withConfiguration(TRILLIUM_FEATURE_CONFIG).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT);
    private static final ImmutableList<UUID> DEVS = ImmutableList.of(
    UUID.fromString("81d9726a-56d4-4419-9a2a-be1d7f7f7ef1"), // its_meow
    UUID.fromString("403f2fd4-f8a2-4608-a0b8-534da4184735"), // cyber
    UUID.fromString("4605663e-fb07-4843-98c5-73adbfb2625e") // batman
    );

    public BetterAnimalsPlusMod() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        modBus.addListener(this::setup);
        modBus.addListener(this::loadComplete);
        modBus.addListener(this::dataSetup);
        modBus.<FMLClientSetupEvent>addListener(e -> new ClientLifecycleHandler().clientSetup(e));
        ModBlocks.subscribe(modBus);
        ModItems.subscribe(modBus);
        ModSoundEvents.subscribe(modBus);
        ModTileEntities.subscribe(modBus);
        ModTriggers.register();
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, BetterAnimalsPlusConfig.getClientSpec());
        BetterAnimalsPlusMod.logger.log(Level.INFO, "Injecting super coyotes...");
        ClassLoadHacks.runWhenLoaded("curios", () -> () -> {
            CuriosModCompat.subscribe(modBus);
        });
    }

    public static final boolean isDev(UUID uuid) {
        return DEVS.contains(uuid);
    }

    public static final boolean isDev(PlayerEntity player) {
        return isDev(player.getGameProfile().getId());
    }

    public static ItemGroup group = new ItemGroup("Better Animals+") {
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
            ctx.get().enqueueWork(() -> {
                ModTriggers.NO_BAM.trigger(ctx.get().getSender());
            });
            ctx.get().setPacketHandled(true);
        });
        HANDLER.<ClientRequestBAMPacket>registerMessage(packets++, ClientRequestBAMPacket.class, (pkt, buf) -> {}, buf -> new ClientRequestBAMPacket(), (pkt, ctx) -> {
            ctx.get().enqueueWork(() -> {
                if(!ModList.get().isLoaded("betteranimals")) {
                    HANDLER.sendToServer(new ServerNoBAMPacket());
                }
            });
            ctx.get().setPacketHandled(true);
        });
        HANDLER.registerMessage(packets++, StupidDevPacket.class, StupidDevPacket::encode, StupidDevPacket::decode, StupidDevPacket.Handler::handle);
        HANDLER.registerMessage(packets++, HonkPacket.class, HonkPacket::encode, HonkPacket::decode, HonkPacket.Handler::handle);
        event.enqueueWork(() -> {
            Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(Ref.MOD_ID, "trillium"), TRILLIUM_CF);
        });
        BetterAnimalsPlusMod.logger.log(Level.INFO, "Overspawning lammergeiers...");
    }

    @SubscribeEvent
    public static void biomeLoad(final BiomeLoadingEvent event) {
        BetterAnimalsPlusConfig.biomeLoad(event);
        if (event.getName() != null && BiomeDictionary.getTypes(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, event.getName())).contains(BiomeDictionary.Type.SWAMP))
            event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> TRILLIUM_CF);
    }

    private void loadComplete(final FMLLoadCompleteEvent event) {
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, BetterAnimalsPlusConfig.getServerSpec());
        BetterAnimalsPlusMod.logger.log(Level.INFO, "Finished crazy bird creation!");
    }

    private void dataSetup(final GatherDataEvent event) {
        ModEntities.H.gatherData(event.getGenerator(), event.getExistingFileHelper());
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
