package its_meow.betteranimalsplus.init;

import java.util.LinkedHashMap;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.common.item.ItemBetterFood;
import its_meow.betteranimalsplus.common.item.ItemHirschgeistSkullWearable;
import its_meow.betteranimalsplus.common.item.ItemWolfCape;
import net.minecraft.entity.Entity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.Items;
import net.minecraft.item.MilkBucketItem;
import net.minecraft.item.SpawnEggItem;

public class ModItems {

    public static final ItemBetterFood VENISON_RAW = new ItemBetterFood("venisonraw", 4, 0, 32, true);
    public static final ItemBetterFood VENISON_COOKED = new ItemBetterFood("venisoncooked", 8, 1.2F, 32, true);
    public static final ItemHirschgeistSkullWearable HIRSCHGEIST_SKULL_WEARABLE = new ItemHirschgeistSkullWearable();
    public static final Item ANTLER = new Item(new Properties().group(BetterAnimalsPlusMod.group))
            .setRegistryName("antler");
    public static final Item GOAT_MILK = new MilkBucketItem(
            new Properties().containerItem(Items.BUCKET).group(BetterAnimalsPlusMod.group).maxStackSize(1))
                    .setRegistryName("goatmilk");
    public static final ItemBetterFood GOAT_CHEESE = new ItemBetterFood("goatcheese", 3, 1, 15, false);
    public static final ItemBetterFood PHEASANT_RAW = new ItemBetterFood("pheasantraw", 3, 0, 32, true);
    public static final ItemBetterFood PHEASANT_COOKED = new ItemBetterFood("pheasantcooked", 7, 1.2F, 32, true);

    public static final BlockItem ITEMBLOCK_TRILLIUM = new BlockItem(ModBlocks.TRILLIUM,
            new Properties().group(BetterAnimalsPlusMod.group));
    public static final BlockItem ITEMBLOCK_HAND_OF_FATE = new BlockItem(ModBlocks.HAND_OF_FATE,
            new Properties().group(BetterAnimalsPlusMod.group));

    public static LinkedHashMap<SpawnEggItem, Class<? extends Entity>> eggs = new LinkedHashMap<SpawnEggItem, Class<? extends Entity>>();

    public static final ItemWolfCape WOLF_CAPE_CLASSIC = new ItemWolfCape(1);
    public static final ItemWolfCape WOLF_CAPE_TIMBER = new ItemWolfCape(2);
    public static final ItemWolfCape WOLF_CAPE_BLACK = new ItemWolfCape(3);

}
