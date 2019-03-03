package its_meow.betteranimalsplus.init;

import java.util.HashSet;
import java.util.Set;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.common.item.ItemAntler;
import its_meow.betteranimalsplus.common.item.ItemBetterFood;
import its_meow.betteranimalsplus.common.item.ItemGoatCheese;
import its_meow.betteranimalsplus.common.item.ItemHandOfFate;
import its_meow.betteranimalsplus.common.item.ItemHirschgeistSkull;
import its_meow.betteranimalsplus.common.item.ItemHirschgeistSkullWearable;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucketMilk;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class ItemRegistry {

	public static final ItemBetterFood venisonRaw = new ItemBetterFood("venisonraw", 4, 0, 32, true);
	public static final ItemBetterFood venisonCooked = new ItemBetterFood("venisoncooked", 8, 1.2F, 32, true);
	public static final ItemHirschgeistSkullWearable itemHirschgeistSkullWearable = new ItemHirschgeistSkullWearable();
	public static final ItemAntler antler = new ItemAntler();
	public static final ItemHandOfFate itemHandOfFate = new ItemHandOfFate(BlockRegistry.handoffate);
	public static final Item goatMilk = new ItemBucketMilk().setRegistryName("goatmilk").setCreativeTab(BetterAnimalsPlusMod.tab);
	public static final ItemGoatCheese goatCheese = new ItemGoatCheese();
	public static final ItemBetterFood pheasantRaw = new ItemBetterFood("pheasantraw", 3, 0, 32, true);
	public static final ItemBetterFood pheasantCooked = new ItemBetterFood("pheasantcooked", 7, 1.2F, 32, true);

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
	}

}
