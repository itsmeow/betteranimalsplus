package its_meow.betteranimalsplus.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class ModOreDictSmelting {

    public static final void register() {
        // Smelting
        GameRegistry.addSmelting(new ItemStack(ModItems.venisonRaw), new ItemStack(ModItems.venisonCooked), 0.0F);
        GameRegistry.addSmelting(new ItemStack(ModItems.pheasantRaw), new ItemStack(ModItems.pheasantCooked), 0.0F);
        GameRegistry.addSmelting(new ItemStack(ModItems.CRAB_MEAT_RAW), new ItemStack(ModItems.CRAB_MEAT_COOKED), 0.0F);

        // Register oredict
        OreDictionary.registerOre("listAllmeatraw", ModItems.venisonRaw);
        OreDictionary.registerOre("listAllmeatcooked", ModItems.venisonCooked);
        OreDictionary.registerOre("listAllmeatraw", ModItems.pheasantRaw);
        OreDictionary.registerOre("listAllmeatcooked", ModItems.pheasantCooked);
        OreDictionary.registerOre("listAllvenisonraw", ModItems.venisonRaw);
        OreDictionary.registerOre("listAllvenisoncooked", ModItems.venisonCooked);
        OreDictionary.registerOre("listAllMilk", ModItems.goatMilk);
        OreDictionary.registerOre("listAllGoatMilk", ModItems.goatMilk);
        OreDictionary.registerOre("foodGoatMilk", ModItems.goatMilk);
        OreDictionary.registerOre("foodCheese", ModItems.goatCheese);
        OreDictionary.registerOre("foodGoatCheese", ModItems.goatCheese);
        OreDictionary.registerOre("foodVenisonraw", ModItems.venisonRaw);
        OreDictionary.registerOre("foodVenisoncooked", ModItems.venisonCooked);
        OreDictionary.registerOre("peltWolf", ModItems.WOLF_PELT_BLACK);
        OreDictionary.registerOre("peltWolf", ModItems.WOLF_PELT_SNOWY);
        OreDictionary.registerOre("peltWolf", ModItems.WOLF_PELT_TIMBER);
        OreDictionary.registerOre("peltBear", ModItems.BEAR_SKIN_BROWN);
        OreDictionary.registerOre("peltBear", ModItems.BEAR_SKIN_BLACK);
        OreDictionary.registerOre("peltBear", ModItems.BEAR_SKIN_KERMODE);
        OreDictionary.registerOre("skinBear", ModItems.BEAR_SKIN_BROWN);
        OreDictionary.registerOre("skinBear", ModItems.BEAR_SKIN_BLACK);
        OreDictionary.registerOre("skinBear", ModItems.BEAR_SKIN_KERMODE);
        OreDictionary.registerOre("peltBearBrown", ModItems.BEAR_SKIN_BROWN);
        OreDictionary.registerOre("peltBearBlack", ModItems.BEAR_SKIN_BLACK);
        OreDictionary.registerOre("peltBearKermode", ModItems.BEAR_SKIN_KERMODE);
        OreDictionary.registerOre("skinBearBrown", ModItems.BEAR_SKIN_BROWN);
        OreDictionary.registerOre("skinBearBlack", ModItems.BEAR_SKIN_BLACK);
        OreDictionary.registerOre("skinBearKermode", ModItems.BEAR_SKIN_KERMODE);
        OreDictionary.registerOre("egg", ModItems.PHEASANT_EGG);
        OreDictionary.registerOre("foodEgg", ModItems.PHEASANT_EGG);
        OreDictionary.registerOre("eggCookable", ModItems.PHEASANT_EGG);
    }
}
