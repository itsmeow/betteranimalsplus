package its_meow.betteranimalsplus.init;

import dev.itsmeow.imdlib.entity.util.EntityTypeContainer;
import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.common.entity.projectile.EntityBadgerDirt;
import its_meow.betteranimalsplus.common.entity.projectile.EntityGoldenGooseEgg;
import its_meow.betteranimalsplus.common.entity.projectile.EntityGooseEgg;
import its_meow.betteranimalsplus.common.entity.projectile.EntityPheasantEgg;
import its_meow.betteranimalsplus.common.entity.projectile.EntityTarantulaHair;
import its_meow.betteranimalsplus.common.entity.projectile.EntityTurkeyEgg;
import its_meow.betteranimalsplus.common.entity.util.EntityTypeContainerBAPContainable;
import its_meow.betteranimalsplus.common.item.ItemAdvancementIcon;
import its_meow.betteranimalsplus.common.item.ItemBlockSimple;
import its_meow.betteranimalsplus.util.HeadType;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = Ref.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BetterAnimalsPlusRegistrar {

    /*
     * Blocks
     */
    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event) {
        final IForgeRegistry<Block> registry = event.getRegistry();

        registry.registerAll(
        ModBlocks.TRILLIUM,
        ModBlocks.HAND_OF_FATE,
        ModBlocks.TURKEY_RAW,
        ModBlocks.TURKEY_COOKED
        );

        for (HeadType type : HeadType.values()) {
            registry.registerAll(type.getBlockSet().toArray(new Block[0]));
        }
    }

    /*
     * Items
     */
    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry();

        // ItemBlocks
        registry.registerAll(
        new ItemBlockSimple(ModBlocks.TRILLIUM),
        new ItemBlockSimple(ModBlocks.HAND_OF_FATE),
        new ItemBlockSimple(ModBlocks.TURKEY_RAW),
        new ItemBlockSimple(ModBlocks.TURKEY_COOKED)
        );
        
        // Heads
        for (HeadType type : HeadType.values()) {
            registry.registerAll(type.getItemSet().toArray(new Item[0]));
        }
        
        // Items
        registry.registerAll(
        ModItems.VENISON_RAW,
        ModItems.VENISON_COOKED,
        ModItems.HIRSCHGEIST_SKULL_WEARABLE,
        ModItems.ANTLER,
        ModItems.BLUBBER,
        ModItems.GOAT_MILK,
        ModItems.GOAT_CHEESE,
        ModItems.PHEASANT_RAW,
        ModItems.PHEASANT_COOKED,
        ModItems.CRAB_MEAT_RAW,
        ModItems.CRAB_MEAT_COOKED,
        ModItems.WOLF_PELT_SNOWY,
        ModItems.WOLF_PELT_TIMBER,
        ModItems.WOLF_PELT_BLACK, 
        ModItems.WOLF_PELT_ARCTIC,
        ModItems.WOLF_PELT_BROWN,
        ModItems.WOLF_PELT_RED,
        ModItems.WOLF_CAPE_CLASSIC,
        ModItems.WOLF_CAPE_TIMBER,
        ModItems.WOLF_CAPE_BLACK,
        ModItems.WOLF_CAPE_ARCTIC,
        ModItems.WOLF_CAPE_BROWN,
        ModItems.WOLF_CAPE_RED,
        ModItems.RECORD_CRAB_RAVE,
        ModItems.RECORD_WALRUS,
        ModItems.BEAR_SKIN_BROWN,
        ModItems.BEAR_SKIN_BLACK,
        ModItems.BEAR_SKIN_KERMODE,
        ModItems.BEAR_CAPE_BROWN,
        ModItems.BEAR_CAPE_BLACK,
        ModItems.BEAR_CAPE_KERMODE,
        ModItems.PHEASANT_EGG,
        ModItems.TURKEY_EGG,
        ModItems.GOOSE_EGG,
        ModItems.GOLDEN_GOOSE_EGG,
        ModItems.TURKEY_LEG_RAW,
        ModItems.TURKEY_LEG_COOKED,
        ModItems.EEL_MEAT_RAW,
        ModItems.EEL_MEAT_COOKED,
        ModItems.FRIED_EGG,
        ModItems.CALAMARI_RAW,
        ModItems.CALAMARI_COOKED,
        ModItems.HORSESHOE_CRAB_BLOOD
        );

        for(EntityTypeContainer<?> container : ModEntities.getEntities().values()) {
            if(container instanceof EntityTypeContainerBAPContainable<?, ?>) {
                EntityTypeContainerBAPContainable<?, ?> c = (EntityTypeContainerBAPContainable<?, ?>) container;
                if(!ForgeRegistries.ITEMS.containsValue(c.getContainerItem())) {
                    event.getRegistry().register(c.getContainerItem());
                }
                if(!ForgeRegistries.ITEMS.containsValue(c.getEmptyContainerItem())) {
                    event.getRegistry().register(c.getEmptyContainerItem());
                }
            }
        }

        registry.registerAll(
        new ItemAdvancementIcon("advancement_icon_jellyfish"),
        new ItemAdvancementIcon("advancement_icon_jellyfish_cross"),
        new ItemAdvancementIcon("advancement_icon_goat"), 
        new ItemAdvancementIcon("advancement_icon_shark"),
        new ItemAdvancementIcon("advancement_icon_lamprey"),
        new ItemAdvancementIcon("advancement_icon_squirrel"),
        new ItemAdvancementIcon("advancement_icon_badger"),
        new ItemAdvancementIcon("advancement_icon_succening")
        );

        // Eggs
        ModEntities.H.ENTITIES.values().forEach(e -> {
            if(e.hasEgg) {
                event.getRegistry().register(e.egg);
            }
        });
    }

    @SubscribeEvent
    public static void registerSounds(final RegistryEvent.Register<SoundEvent> event) {
        ModSoundEvents.SOUNDS.values().forEach(sound -> event.getRegistry().register(sound));
    }

    /*
     * Tile Entities
     */
    @SubscribeEvent
    public static void registerTileEntities(final RegistryEvent.Register<TileEntityType<?>> event) {
        final IForgeRegistry<TileEntityType<?>> reg = event.getRegistry();
        registerTE(reg, ModTileEntities.TRILLIUM_TYPE);
        registerTE(reg, ModTileEntities.HAND_OF_FATE_TYPE);
        registerTE(reg, ModTileEntities.HEAD_TYPE);
    }

    /*
     * Entities
     */
    @SubscribeEvent
    public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) {
        final IForgeRegistry<EntityType<?>> registry = event.getRegistry();

        registry.registerAll(EntityTarantulaHair.HAIR_TYPE, EntityBadgerDirt.DIRT_TYPE, EntityPheasantEgg.PHEASANT_EGG_TYPE, EntityTurkeyEgg.TURKEY_EGG_TYPE, EntityGooseEgg.GOOSE_EGG_TYPE, EntityGoldenGooseEgg.GOLDEN_GOOSE_EGG_TYPE);

        for(EntityTypeContainer<?> container : ModEntities.getEntities().values()) {
            event.getRegistry().register(container.entityType);
        }
    }

    private static void registerTE(IForgeRegistry<TileEntityType<?>> reg, TileEntityType<?> type) {
        reg.register(type);
    }

}
