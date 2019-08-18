package its_meow.betteranimalsplus.init;

import static its_meow.betteranimalsplus.init.ModBlocks.handoffate;
import static its_meow.betteranimalsplus.init.ModBlocks.trillium;
import static its_meow.betteranimalsplus.init.ModEntities.entityList;
import static its_meow.betteranimalsplus.init.ModEntities.entrySet;
import static its_meow.betteranimalsplus.init.ModEntities.modEntities;
import static its_meow.betteranimalsplus.init.ModItems.CRAB_MEAT_COOKED;
import static its_meow.betteranimalsplus.init.ModItems.CRAB_MEAT_RAW;
import static its_meow.betteranimalsplus.init.ModItems.WOLF_CAPE_BLACK;
import static its_meow.betteranimalsplus.init.ModItems.WOLF_CAPE_CLASSIC;
import static its_meow.betteranimalsplus.init.ModItems.WOLF_CAPE_TIMBER;
import static its_meow.betteranimalsplus.init.ModItems.antler;
import static its_meow.betteranimalsplus.init.ModItems.goatCheese;
import static its_meow.betteranimalsplus.init.ModItems.goatMilk;
import static its_meow.betteranimalsplus.init.ModItems.itemHirschgeistSkullWearable;
import static its_meow.betteranimalsplus.init.ModItems.pheasantCooked;
import static its_meow.betteranimalsplus.init.ModItems.pheasantRaw;
import static its_meow.betteranimalsplus.init.ModItems.venisonCooked;
import static its_meow.betteranimalsplus.init.ModItems.venisonRaw;

import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Preconditions;

import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.common.entity.EmptyEntity;
import its_meow.betteranimalsplus.common.entity.EntityLammergeier;
import its_meow.betteranimalsplus.common.entity.projectile.EntityBadgerDirt;
import its_meow.betteranimalsplus.common.entity.projectile.EntityTarantulaHair;
import its_meow.betteranimalsplus.common.item.ItemAdvancementIcon;
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
import net.minecraft.item.ItemBlock;
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

		registry.registerAll(trillium, handoffate);

		for(HeadTypes type : HeadTypes.values()) {
			registry.register(new Block(Material.CLOTH).setRegistryName(Ref.MOD_ID, type.name));
			registry.registerAll(type.getBlocks().toArray(new Block[0]));
		}

		GameRegistry.registerTileEntity(TileEntityTrillium.class, new ResourceLocation(trillium.getRegistryName() + "tileentity"));
		GameRegistry.registerTileEntity(TileEntityHandOfFate.class, new ResourceLocation(handoffate.getRegistryName() + "tileentity"));
		GameRegistry.registerTileEntity(TileEntityHead.class, new ResourceLocation(Ref.MOD_ID, "head"));
	}

	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {

		// ItemBlocks

		final ItemBlock[] items = { new ItemBlock(trillium), new ItemBlock(handoffate)};

		final IForgeRegistry<Item> registry = event.getRegistry();

		for (final ItemBlock item : items) {
			final Block block = item.getBlock();
			final ResourceLocation registryName = Preconditions.checkNotNull(block.getRegistryName(), "Block %s has null registry name", block);
			registry.register(item.setRegistryName(registryName));
		}

		for(HeadTypes type : HeadTypes.values()) {
		    Item item = new Item().setRegistryName(Ref.MOD_ID, type.name);
		    HIDE_ITEMS.add(item);
			registry.register(item);
			registry.registerAll(type.getItems().toArray(new Item[0]));
		}
		
		HIDE_ITEMS.add(ModItems.RECORD_CRAB_RAVE);

		// Items

		registry.registerAll(venisonRaw, venisonCooked, itemHirschgeistSkullWearable, antler, goatMilk, goatCheese, pheasantRaw, 
		    pheasantCooked, ModItems.WOLF_PELT_SNOWY, ModItems.WOLF_PELT_TIMBER, ModItems.WOLF_PELT_BLACK, WOLF_CAPE_CLASSIC, WOLF_CAPE_TIMBER, WOLF_CAPE_BLACK, 
		    ModItems.BEAR_SKIN_BROWN, ModItems.BEAR_SKIN_BLACK, ModItems.BEAR_SKIN_KERMODE, ModItems.BEAR_CAPE_BROWN, ModItems.BEAR_CAPE_BLACK, ModItems.BEAR_CAPE_KERMODE, 
		    CRAB_MEAT_RAW, CRAB_MEAT_COOKED, ModItems.RECORD_CRAB_RAVE, new ItemAdvancementIcon("advancement_icon_jellyfish"), new ItemAdvancementIcon("advancement_icon_jellyfish_cross"), 
		    new ItemAdvancementIcon("advancement_icon_goat"), new ItemAdvancementIcon("advancement_icon_shark"), new ItemAdvancementIcon("advancement_icon_lamprey"), new ItemAdvancementIcon("advancement_icon_squirrel"), new ItemAdvancementIcon("advancement_icon_badger"));

	}

	@SubscribeEvent
	public static void registerEntities(final RegistryEvent.Register<EntityEntry> event) {
		final IForgeRegistry<EntityEntry> registry = event.getRegistry();

		for(EntityContainer container : entityList) {
		    reg(container);
		}
		EntitySpawnPlacementRegistry.setPlacementType(EntityLammergeier.class, SpawnPlacementType.IN_AIR);
		register(EntityTarantulaHair.class, "tarantulahair");
		register(EntityBadgerDirt.class, "badgerdirt");
		register(EmptyEntity.class, "kermodebear");

		if (!entrySet.isEmpty()) {
			for (final EntityEntry entityEntry : entrySet) {
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
		EntityEntry entry = EntityEntryBuilder.create().entity(EntityClass).id(new ResourceLocation(Ref.MOD_ID, entityNameIn), modEntities++).name(LOCALIZE_PREFIX + entityNameIn).tracker(64, 1, true).egg(solidColorIn, spotColorIn).build();
		if (typeIn == EnumCreatureType.WATER_CREATURE) {
			EntitySpawnPlacementRegistry.setPlacementType(EntityClass, SpawnPlacementType.IN_WATER);
		}
		entrySet.add(entry);
	}

	public static void register(Class<? extends Entity> EntityClass, String entityNameIn) {
		EntityEntry entry = EntityEntryBuilder.create().entity(EntityClass).id(new ResourceLocation(Ref.MOD_ID, entityNameIn), modEntities++).name(LOCALIZE_PREFIX + entityNameIn).tracker(64, 1, true).build();

		entrySet.add(entry);
	}

}