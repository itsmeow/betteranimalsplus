package its_meow.betteranimalsplus.init;

import java.util.LinkedHashMap;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.common.item.ItemBetterFood;
import its_meow.betteranimalsplus.common.item.ItemHirschgeistSkullWearable;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBucketMilk;
import net.minecraft.item.ItemSpawnEgg;

public class ModItems {

    public static final ItemBetterFood VENISON_RAW = new ItemBetterFood("venisonraw", 4, 0, 32, true);
    public static final ItemBetterFood VENISON_COOKED = new ItemBetterFood("venisoncooked", 8, 1.2F, 32, true);
    public static final ItemHirschgeistSkullWearable HIRSCHGEIST_SKULL_WEARABLE = new ItemHirschgeistSkullWearable();
    public static final Item ANTLER = new Item(new Properties().group(BetterAnimalsPlusMod.group))
            .setRegistryName("antler");
    public static final Item GOAT_MILK = new ItemBucketMilk(
            new Properties().containerItem(Items.BUCKET).group(BetterAnimalsPlusMod.group).maxStackSize(1))
                    .setRegistryName("goatmilk");
    public static final ItemBetterFood GOAT_CHEESE = new ItemBetterFood("goatcheese", 3, 1, 15, false);
    public static final ItemBetterFood PHEASANT_RAW = new ItemBetterFood("pheasantraw", 3, 0, 32, true);
    public static final ItemBetterFood PHEASANT_COOKED = new ItemBetterFood("pheasantcooked", 7, 1.2F, 32, true);

    public static final ItemBlock ITEMBLOCK_TRILLIUM = new ItemBlock(ModBlocks.TRILLIUM,
            new Properties().group(BetterAnimalsPlusMod.group));
    public static final ItemBlock ITEMBLOCK_HAND_OF_FATE = new ItemBlock(ModBlocks.HAND_OF_FATE,
            new Properties().group(BetterAnimalsPlusMod.group));

    public static LinkedHashMap<ItemSpawnEgg, Class<? extends Entity>> eggs = new LinkedHashMap<ItemSpawnEgg, Class<? extends Entity>>();

}