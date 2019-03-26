package its_meow.betteranimalsplus.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class ModOreDictSmelting {

    public static final void register() {
        // Smelting
        GameRegistry.addSmelting(new ItemStack(ModItems.venisonRaw), new ItemStack(ModItems.venisonCooked), 0.0F);
        GameRegistry.addSmelting(new ItemStack(ModItems.pheasantRaw), new ItemStack(ModItems.pheasantCooked), 0.0F);

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
    }
}
