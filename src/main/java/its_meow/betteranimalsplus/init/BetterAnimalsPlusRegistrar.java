package its_meow.betteranimalsplus.init;

import java.util.HashSet;
import java.util.Set;

import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.common.entity.EmptyEntity;
import its_meow.betteranimalsplus.common.entity.EntityLammergeier;
import its_meow.betteranimalsplus.common.entity.projectile.EntityBadgerDirt;
import its_meow.betteranimalsplus.common.entity.projectile.EntityPheasantEgg;
import its_meow.betteranimalsplus.common.entity.projectile.EntityTarantulaHair;
import its_meow.betteranimalsplus.common.entity.projectile.EntityTurkeyEgg;
import its_meow.betteranimalsplus.common.item.ItemAdvancementIcon;
import its_meow.betteranimalsplus.common.item.ItemBlockSimple;
import its_meow.betteranimalsplus.common.item.ItemHiddenItem;
import its_meow.betteranimalsplus.common.tileentity.TileEntityHandOfFate;
import its_meow.betteranimalsplus.common.tileentity.TileEntityHead;
import its_meow.betteranimalsplus.common.tileentity.TileEntityTrillium;
import its_meow.betteranimalsplus.util.EntityContainer;
import its_meow.betteranimalsplus.util.HeadTypes;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving.SpawnPlacementType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber(modid = Ref.MOD_ID)
public class BetterAnimalsPlusRegistrar {

    public static final Set<Item> HIDE_ITEMS = new HashSet<Item>();

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event) {
        final IForgeRegistry<Block> registry = event.getRegistry();

        registry.registerAll(
        ModBlocks.TRILLIUM,
        ModBlocks.HAND_OF_FATE,
        ModBlocks.TURKEY_RAW,
        ModBlocks.TURKEY_COOKED,
        ModBlocks.TURKEY_EATEN_RAW,
        ModBlocks.TURKEY_EATEN_COOKED
        );

        for(HeadTypes type : HeadTypes.values()) {
            registry.register(new Block(Material.CLOTH).setRegistryName(Ref.MOD_ID, type.name));
            registry.registerAll(type.getBlocks().toArray(new Block[0]));
        }
        
        registry.register(new Block(Material.CLOTH).setRegistryName(Ref.MOD_ID, "wolfhead_4"));

        GameRegistry.registerTileEntity(TileEntityTrillium.class, new ResourceLocation(ModBlocks.TRILLIUM.getRegistryName() + "tileentity"));
        GameRegistry.registerTileEntity(TileEntityHandOfFate.class, new ResourceLocation(ModBlocks.HAND_OF_FATE.getRegistryName() + "tileentity"));
        GameRegistry.registerTileEntity(TileEntityHead.class, new ResourceLocation(Ref.MOD_ID, "head"));
    }

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry();

        for(HeadTypes type : HeadTypes.values()) {
            Item item = new Item().setRegistryName(Ref.MOD_ID, type.name);
            HIDE_ITEMS.add(item);
            registry.register(item);
            registry.registerAll(type.getItems().toArray(new Item[0]));
        }

        HIDE_ITEMS.add(ModItems.RECORD_CRAB_RAVE);

        // Items

        registry.registerAll(
        ModItems.VENISON_RAW,
        ModItems.VENISON_COOKED,
        ModItems.HIRSCHGEIST_SKULL_WEARABLE,
        ModItems.ANTLER,
        ModItems.GOAT_MILK,
        ModItems.GOAT_CHEESE,
        ModItems.PHEASANT_RAW,
        ModItems.PHEASANT_COOKED,
        ModItems.WOLF_PELT_SNOWY,
        ModItems.WOLF_PELT_TIMBER,
        ModItems.WOLF_PELT_BLACK,
        ModItems.WOLF_CAPE_CLASSIC,
        ModItems.WOLF_CAPE_TIMBER,
        ModItems.WOLF_CAPE_BLACK,
        ModItems.BEAR_SKIN_BROWN,
        ModItems.BEAR_SKIN_BLACK,
        ModItems.BEAR_SKIN_KERMODE,
        ModItems.BEAR_CAPE_BROWN,
        ModItems.BEAR_CAPE_BLACK,
        ModItems.BEAR_CAPE_KERMODE,
        ModItems.CRAB_MEAT_RAW,
        ModItems.CRAB_MEAT_COOKED,
        ModItems.RECORD_CRAB_RAVE,
        ModItems.PHEASANT_EGG,
        ModItems.TURKEY_EGG,
        ModItems.TURKEY_LEG_RAW,
        ModItems.TURKEY_LEG_COOKED,
        ModItems.FRIED_EGG,
        new ItemAdvancementIcon("advancement_icon_jellyfish"),
        new ItemAdvancementIcon("advancement_icon_jellyfish_cross"),
        new ItemAdvancementIcon("advancement_icon_goat"),
        new ItemAdvancementIcon("advancement_icon_shark"),
        new ItemAdvancementIcon("advancement_icon_lamprey"),
        new ItemAdvancementIcon("advancement_icon_squirrel"),
        new ItemAdvancementIcon("advancement_icon_badger"),
        new ItemHiddenItem("wolfhead_4")
        );
        
        // ItemBlocks
        
        registry.registerAll(
        new ItemBlockSimple(ModBlocks.TRILLIUM),
        new ItemBlockSimple(ModBlocks.HAND_OF_FATE),
        new ItemBlockSimple(ModBlocks.TURKEY_RAW),
        new ItemBlockSimple(ModBlocks.TURKEY_COOKED)
        );
    }

    @SubscribeEvent
    public static void registerEntities(final RegistryEvent.Register<EntityEntry> event) {
        final IForgeRegistry<EntityEntry> registry = event.getRegistry();

        for(EntityContainer container : ModEntities.entityList) {
            reg(container);
        }
        EntitySpawnPlacementRegistry.setPlacementType(EntityLammergeier.class, SpawnPlacementType.IN_AIR);
        register(EntityTarantulaHair.class, "tarantulahair");
        register(EntityBadgerDirt.class, "badgerdirt");
        register(EmptyEntity.class, "kermodebear");
        register(EntityPheasantEgg.class, "pheasantegg");
        register(EntityTurkeyEgg.class, "turkeyegg");

        if(!ModEntities.entrySet.isEmpty()) {
            for(final EntityEntry entityEntry : ModEntities.entrySet) {
                registry.register(entityEntry);
            }
        }
    }

    @SubscribeEvent
    public static void registerSounds(final RegistryEvent.Register<SoundEvent> event) {
        event.getRegistry().register(ModSoundEvents.CRAB_RAVE.setRegistryName(new ResourceLocation(Ref.MOD_ID, "crabrave")));
    }

    // Entity Registration Helpers

    private static final String LOCALIZE_PREFIX = Ref.MOD_ID + ".";

    public static void reg(EntityContainer c) {
        registerWithEgg(c.entityClazz, c.entityName, c.eggColorSolid, c.eggColorSpot, c.type);
    }

    public static void registerWithEgg(Class<? extends Entity> EntityClass, String entityNameIn, int solidColorIn, int spotColorIn, EnumCreatureType typeIn) {
        EntityEntry entry = EntityEntryBuilder.create().entity(EntityClass).id(new ResourceLocation(Ref.MOD_ID, entityNameIn), ModEntities.modEntities++).name(LOCALIZE_PREFIX + entityNameIn).tracker(64, 1, true).egg(solidColorIn, spotColorIn).build();
        if(typeIn == EnumCreatureType.WATER_CREATURE) {
            EntitySpawnPlacementRegistry.setPlacementType(EntityClass, SpawnPlacementType.IN_WATER);
        }
        ModEntities.entrySet.add(entry);
    }

    public static void register(Class<? extends Entity> EntityClass, String entityNameIn) {
        EntityEntry entry = EntityEntryBuilder.create().entity(EntityClass).id(new ResourceLocation(Ref.MOD_ID, entityNameIn), ModEntities.modEntities++).name(LOCALIZE_PREFIX + entityNameIn).tracker(64, 1, true).build();

        ModEntities.entrySet.add(entry);
    }

}