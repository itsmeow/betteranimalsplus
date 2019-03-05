package its_meow.betteranimalsplus.init;

import java.util.function.Supplier;

import com.google.common.base.Preconditions;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.common.block.BlockHandOfFate;
import its_meow.betteranimalsplus.common.entity.projectile.EntityTarantulaHair;
import its_meow.betteranimalsplus.common.item.ItemBetterAnimalsPlusEgg;
import its_meow.betteranimalsplus.util.EntityContainer;
import its_meow.betteranimalsplus.util.HeadTypes;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
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

		registry.registerAll(ModBlocks.trillium, ModBlocks.handoffate);

		for(HeadTypes type : HeadTypes.values()) {
			registry.registerAll(type.getBlockSet().toArray(new Block[0]));
		}
	}

	/*
	 * ItemBlocks
	 */
	@SubscribeEvent
	public static void registerItemBlocks(final RegistryEvent.Register<Item> event) {
		final ItemBlock[] items = {
				new ItemBlock(ModBlocks.trillium, new Properties().group(BetterAnimalsPlusMod.group)),
				BlockHandOfFate.getItemBlock()
		};

		final IForgeRegistry<Item> registry = event.getRegistry();

		for(final ItemBlock item : items) {
			Block block = item.getBlock();
			ResourceLocation loc = item.getRegistryName();
			if(item.getRegistryName() == null) {
				loc = Preconditions.checkNotNull(block.getRegistryName(), "Block %s has null registry name", block);
				item.setRegistryName(loc);
			}
			registry.register(item);
		}

		for(HeadTypes type : HeadTypes.values()) {
			registry.registerAll(type.getItemSet().toArray(new Item[0]));
		}
	}

	/*
	 * Items
	 */
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		Item[] items = { ModItems.venisonRaw, ModItems.venisonCooked,
				ModItems.itemHirschgeistSkullWearable, ModItems.antler, ModItems.goatMilk,
				ModItems.goatCheese, ModItems.pheasantRaw, ModItems.pheasantCooked, };
		final IForgeRegistry<Item> registry = event.getRegistry();

		for(final Item item : items) {
			registry.register(item);
		}

		for(EntityContainer ent : ModEntities.entityList) {
			ItemBetterAnimalsPlusEgg egg = new ItemBetterAnimalsPlusEgg(ModEntities.getEntityType(ent.entityClazz), ent.eggColorSolid, ent.eggColorSpot, ent);
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
		reg.register(ModTileEntities.TRILLIUM_TYPE);
		reg.register(ModTileEntities.HAND_OF_FATE_TYPE);

		for(HeadTypes type : HeadTypes.values()) {
			regTileEntity(reg, type.name, () -> type.teFactory.apply(type), type);
		}
	}

	/*
	 * Entities
	 */
	@SubscribeEvent
	public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) {
		final IForgeRegistry<EntityType<?>> registry = event.getRegistry();

		registry.register(EntityTarantulaHair.HAIR_TYPE);

		for(EntityContainer entry : ModEntities.entryMap.keySet()) {
			EntityType<?> type = ModEntities.entryMap.get(entry);
			registry.register(type);
		}
	}

	/*
	 * Helper registry methods and Getters
	 */

	private static void regTileEntity(IForgeRegistry<TileEntityType<?>> reg, String name, Supplier<? extends TileEntity> factory,
			HeadTypes type) {
		TileEntityType<?> tetype = TileEntityType.Builder.create(factory).build(null).setRegistryName(Ref.MOD_ID, name + "tileentity");
		reg.register(tetype);
		ModTileEntities.skulltetypes.put(type, tetype);
	}


}
