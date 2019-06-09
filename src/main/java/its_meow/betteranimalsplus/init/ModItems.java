package its_meow.betteranimalsplus.init;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.common.item.ItemBetterFood;
import its_meow.betteranimalsplus.common.item.ItemHirschgeistSkullWearable;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucketMilk;

public class ModItems {

    public static final ItemBetterFood venisonRaw = new ItemBetterFood("venisonraw", 4, 0, 32, true);
    public static final ItemBetterFood venisonCooked = new ItemBetterFood("venisoncooked", 8, 1.2F, 32, true);
    public static final ItemHirschgeistSkullWearable itemHirschgeistSkullWearable = new ItemHirschgeistSkullWearable();
    public static final Item antler = new Item().setRegistryName("antler").setCreativeTab(BetterAnimalsPlusMod.tab).setUnlocalizedName(Ref.MOD_ID + "." + "antler");
    public static final Item goatMilk = new ItemBucketMilk().setRegistryName("goatmilk").setCreativeTab(BetterAnimalsPlusMod.tab).setUnlocalizedName(Ref.MOD_ID + "." + "goatmilk").setContainerItem(Items.BUCKET);
    public static final ItemBetterFood goatCheese = new ItemBetterFood("goatcheese", 3, 1, 15, false);
    public static final ItemBetterFood pheasantRaw = new ItemBetterFood("pheasantraw", 3, 0, 32, true);
    public static final ItemBetterFood pheasantCooked = new ItemBetterFood("pheasantcooked", 7, 1.2F, 32, true);

}
