package its_meow.betteranimalsplus.init;

import java.util.HashMap;
import java.util.Map;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.common.item.ItemAntler;
import its_meow.betteranimalsplus.common.item.ItemBetterFood;
import its_meow.betteranimalsplus.common.item.ItemGoatCheese;
import its_meow.betteranimalsplus.common.item.ItemHandOfFate;
import its_meow.betteranimalsplus.common.item.ItemHirschgeistSkullWearable;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.ItemBucketMilk;
import net.minecraft.item.ItemSpawnEgg;

public class ModItems {
	
	public static final ItemBetterFood venisonRaw = new ItemBetterFood("venisonraw", 4, 0, 32, true);
	public static final ItemBetterFood venisonCooked = new ItemBetterFood("venisoncooked", 8, 1.2F, 32, true);
	public static final ItemHirschgeistSkullWearable itemHirschgeistSkullWearable = new ItemHirschgeistSkullWearable();
	public static final ItemAntler antler = new ItemAntler();
	public static final ItemHandOfFate itemHandOfFate = new ItemHandOfFate(ModBlocks.handoffate);
	public static final Item goatMilk = new ItemBucketMilk(new Properties().containerItem(Items.BUCKET).group(BetterAnimalsPlusMod.group).maxStackSize(1)).setRegistryName("goatmilk");
	public static final ItemGoatCheese goatCheese = new ItemGoatCheese();
	public static final ItemBetterFood pheasantRaw = new ItemBetterFood("pheasantraw", 3, 0, 32, true);
	public static final ItemBetterFood pheasantCooked = new ItemBetterFood("pheasantcooked", 7, 1.2F, 32, true);
	
	public static Map<ItemSpawnEgg, Class<? extends Entity>> eggs = new HashMap<ItemSpawnEgg, Class<? extends Entity>>();
	
}
