package its_meow.betteranimalsplus.init;

import java.util.HashSet;
import java.util.Set;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.common.item.ItemAntler;
import its_meow.betteranimalsplus.common.item.ItemBetterAnimalsPlusEgg;
import its_meow.betteranimalsplus.common.item.ItemBetterFood;
import its_meow.betteranimalsplus.common.item.ItemGoatCheese;
import its_meow.betteranimalsplus.common.item.ItemHandOfFate;
import its_meow.betteranimalsplus.common.item.ItemHirschgeistSkull;
import its_meow.betteranimalsplus.common.item.ItemHirschgeistSkullWearable;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.ItemBucketMilk;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

public class ItemRegistry {

	public static final ItemBetterFood venisonRaw = new ItemBetterFood("venisonraw", 4, 0, 32, true);
	public static final ItemBetterFood venisonCooked = new ItemBetterFood("venisoncooked", 8, 1.2F, 32, true);
	public static final ItemHirschgeistSkullWearable itemHirschgeistSkullWearable = new ItemHirschgeistSkullWearable();
	public static final ItemAntler antler = new ItemAntler();
	public static final ItemHandOfFate itemHandOfFate = new ItemHandOfFate(BlockRegistry.handoffate);
	public static final Item goatMilk = new ItemBucketMilk(new Properties().containerItem(Items.BUCKET).group(BetterAnimalsPlusMod.group).maxStackSize(1)).setRegistryName("goatmilk");
	public static final ItemGoatCheese goatCheese = new ItemGoatCheese();
	public static final ItemBetterFood pheasantRaw = new ItemBetterFood("pheasantraw", 3, 0, 32, true);
	public static final ItemBetterFood pheasantCooked = new ItemBetterFood("pheasantcooked", 7, 1.2F, 32, true);

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
			//ItemSpawnEgg egg = null;
			for(EntityContainer ent : MobRegistry.entityList) {
				ItemBetterAnimalsPlusEgg egg = new ItemBetterAnimalsPlusEgg(MobRegistry.getType(ent.entityClazz), ent.eggColorSolid, ent.eggColorSpot, ent);
				egg.setRegistryName(ent.entityName.toLowerCase().toString() + "_spawn_egg");
				registry.register(egg);
				MobRegistry.eggs.put(egg, ent.entityClazz);
			}
			//egg.setRegistryName("better_animals_spawn_egg");
			//registry.register(egg);
			//MobRegistry.egg = egg;
		}
		
	}

}
