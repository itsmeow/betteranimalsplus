package its_meow.betteranimalsplus.init;

import java.util.HashSet;
import java.util.Set;

import its_meow.betteranimalsplus.common.block.BlockGenericSkull;
import its_meow.betteranimalsplus.common.item.ItemAntler;
import its_meow.betteranimalsplus.common.item.ItemBlockSkull;
import its_meow.betteranimalsplus.common.item.ItemGoatCheese;
import its_meow.betteranimalsplus.common.item.ItemGoatMilk;
import its_meow.betteranimalsplus.common.item.ItemHandOfFate;
import its_meow.betteranimalsplus.common.item.ItemHirschgeistSkull;
import its_meow.betteranimalsplus.common.item.ItemHirschgeistSkullWearable;
import its_meow.betteranimalsplus.common.item.ItemPheasantCooked;
import its_meow.betteranimalsplus.common.item.ItemPheasantRaw;
import its_meow.betteranimalsplus.common.item.ItemVenisonCooked;
import its_meow.betteranimalsplus.common.item.ItemVenisonRaw;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class ItemRegistry {

	public static final ItemVenisonRaw venisonRaw = new ItemVenisonRaw(4, true);
	public static final ItemVenisonCooked venisonCooked = new ItemVenisonCooked(8, true);
	public static final ItemHirschgeistSkullWearable itemHirschgeistSkullWearable = new ItemHirschgeistSkullWearable();
	public static final ItemAntler antler = new ItemAntler();
	public static final ItemHandOfFate itemHandOfFate = new ItemHandOfFate(BlockRegistry.handoffate);
	public static final ItemGoatMilk goatMilk = new ItemGoatMilk();
	public static final ItemGoatCheese goatCheese = new ItemGoatCheese();
	public static final ItemPheasantRaw pheasantRaw = new ItemPheasantRaw(3, true);
	public static final ItemPheasantCooked pheasantCooked = new ItemPheasantCooked(7, true);

	// These are not registered
	public static final ItemHirschgeistSkull itemHirschgeistSkull = new ItemHirschgeistSkull(BlockRegistry.hirschgeistskull);
	/*public static final ItemBlockSkull wolfhead = new ItemBlockSkull(BlockRegistry.wolfhead, true);
	public static final ItemBlockSkull deerhead = new ItemBlockSkull(BlockRegistry.deerhead, true);
	public static final ItemBlockSkull reindeerhead = new ItemBlockSkull(BlockRegistry.reindeerhead, true);
	
	
	public static ItemBlock getItemFor(BlockGenericSkull blockGenericSkull) {
		String regName = blockGenericSkull.getRegistryName().getResourcePath();
		if(regName == "wolfhead") {
			return wolfhead;
		}
		if(regName == "deerhead") {
			return deerhead;
		}
		if(regName == "reindeerhead") {
			return reindeerhead;
		}
		return null;
	}*/
	
	@Mod.EventBusSubscriber
	public static class RegistrationHandler {
		public static final Set<Item> ITEMS = new HashSet<>();

		/**
		 * Register this mod's {@link Item}s.
		 *
		 * @param event The event
		 */
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {
			Item[] items = {
					venisonRaw,
					venisonCooked,
					itemHirschgeistSkullWearable,
					antler,
					goatMilk,
					goatCheese,
					pheasantRaw,
					pheasantCooked,
			};
			final IForgeRegistry<Item> registry = event.getRegistry();

			for (final Item item : items) {
				registry.register(item);
				ITEMS.add(item);
			}
		}

		@SubscribeEvent
		public static void registerItemBlockModels(final ModelRegistryEvent event) {
			initModel(venisonRaw, 0);
			initModel(venisonCooked, 0);
			initModel(itemHirschgeistSkullWearable, 0);
			initModel(antler, 0);
			initModel(goatMilk, 0);
			initModel(goatCheese, 0);
			initModel(pheasantRaw, 0);
			initModel(pheasantCooked, 0);
		}


		public static void initModel(Item item, int meta) {
			ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		}
	}

}
