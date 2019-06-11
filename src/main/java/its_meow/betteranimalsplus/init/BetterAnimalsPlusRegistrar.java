package its_meow.betteranimalsplus.init;

import com.google.common.base.Preconditions;

import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.common.entity.projectile.EntityBadgerDirt;
import its_meow.betteranimalsplus.common.entity.projectile.EntityTarantulaHair;
import its_meow.betteranimalsplus.common.item.ItemBetterAnimalsPlusEgg;
import its_meow.betteranimalsplus.util.EntityContainer;
import its_meow.betteranimalsplus.util.HeadTypes;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = Ref.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BetterAnimalsPlusRegistrar {

	/*
	 * Blocks
	 */
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		final IForgeRegistry<Block> registry = event.getRegistry();

		registry.registerAll(ModBlocks.TRILLIUM, ModBlocks.HAND_OF_FATE);

		for (HeadTypes type : HeadTypes.values()) {
			//registry.registerAll(type.getBlockSet().toArray(new Block[0]));
		}
	}

	/*
	 * ItemBlocks
	 */
	@SubscribeEvent
	public static void registerItemBlocks(final RegistryEvent.Register<Item> event) {
		final BlockItem[] items = { ModItems.ITEMBLOCK_TRILLIUM, ModItems.ITEMBLOCK_HAND_OF_FATE };

		final IForgeRegistry<Item> registry = event.getRegistry();

		for (final BlockItem item : items) {
			Block block = item.getBlock();
			ResourceLocation loc = item.getRegistryName();
			if (item.getRegistryName() == null) {
				loc = Preconditions.checkNotNull(block.getRegistryName(), "Block %s has null registry name", block);
				item.setRegistryName(loc);
			}
			registry.register(item);
		}

		for (HeadTypes type : HeadTypes.values()) {
			registry.registerAll(type.getItemSet().toArray(new Item[0]));
		}
	}

	/*
	 * Items
	 */
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		final IForgeRegistry<Item> registry = event.getRegistry();

		registry.registerAll(ModItems.VENISON_RAW, ModItems.VENISON_COOKED, ModItems.HIRSCHGEIST_SKULL_WEARABLE,
				ModItems.ANTLER, ModItems.GOAT_MILK, ModItems.GOAT_CHEESE, ModItems.PHEASANT_RAW,
				ModItems.PHEASANT_COOKED);

		for (EntityContainer<?> ent : ModEntities.entityList) {
			ItemBetterAnimalsPlusEgg egg = new ItemBetterAnimalsPlusEgg(ModEntities.getEntityType(ent.entityName),
					ent.eggColorSolid, ent.eggColorSpot, ent);
			egg.setRegistryName(ent.entityName.toLowerCase().toString() + "_spawn_egg");
			registry.register(egg);
			ModItems.eggs.put(egg, ent.entityClazz);
		}
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

		registry.register(EntityTarantulaHair.HAIR_TYPE);
		registry.register(EntityBadgerDirt.DIRT_TYPE);

		for (EntityContainer<?> entry : ModEntities.entryMapContainers.keySet()) {
			EntityType<?> type = ModEntities.entryMapContainers.get(entry);
			registry.register(type);
		}
	}

	private static void registerTE(IForgeRegistry<TileEntityType<?>> reg, TileEntityType<?> type) {
		reg.register(type);
	}

}
