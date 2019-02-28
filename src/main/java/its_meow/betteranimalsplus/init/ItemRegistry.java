package its_meow.betteranimalsplus.init;

import java.util.HashSet;
import java.util.Set;

import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.common.item.ItemAntler;
import its_meow.betteranimalsplus.common.item.ItemGoatCheese;
import its_meow.betteranimalsplus.common.item.ItemGoatMilk;
import its_meow.betteranimalsplus.common.item.ItemHandOfFate;
import its_meow.betteranimalsplus.common.item.ItemHirschgeistSkull;
import its_meow.betteranimalsplus.common.item.ItemHirschgeistSkullWearable;
import its_meow.betteranimalsplus.common.item.ItemPheasantCooked;
import its_meow.betteranimalsplus.common.item.ItemPheasantRaw;
import its_meow.betteranimalsplus.common.item.ItemVenisonCooked;
import its_meow.betteranimalsplus.common.item.ItemVenisonRaw;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemSpawnEgg;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
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
	public static final ItemHirschgeistSkull itemHirschgeistSkull = new ItemHirschgeistSkull(
			BlockRegistry.hirschgeistskull);

	@Mod.EventBusSubscriber(modid = Ref.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistrationHandler {

		public static final Set<Item> ITEMS = new HashSet<>();

		/**
		 * Register this mod's {@link Item}s.
		 *
		 * @param event
		 *            The event
		 */
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {
			Item[] items = { ItemRegistry.venisonRaw, ItemRegistry.venisonCooked,
					ItemRegistry.itemHirschgeistSkullWearable, ItemRegistry.antler, ItemRegistry.goatMilk,
					ItemRegistry.goatCheese, ItemRegistry.pheasantRaw, ItemRegistry.pheasantCooked, };
			final IForgeRegistry<Item> registry = event.getRegistry();

			for(final Item item : items) {
				registry.register(item);
				RegistrationHandler.ITEMS.add(item);
			}
			for(EntityContainer ent : MobRegistry.entityList) {
				ItemSpawnEgg egg = new ItemSpawnEgg(MobRegistry.entryMap.get(ent), ent.eggColorSolid, ent.eggColorSpot,
						new Properties().group(ItemGroup.MISC));
				egg.setRegistryName(ent.entityName.toLowerCase().toString() + "_spawn_egg");
				registry.register(egg);
				MobRegistry.eggs.add(egg);
			}
		}
		
	}

}
