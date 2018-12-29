package its_meow.betteranimalsplus.init;

import its_meow.betteranimalsplus.Ref;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class CraftingRegistry {

	public static final void register() {
		//Smelting
		GameRegistry.addSmelting(new ItemStack(ItemRegistry.venisonRaw), new ItemStack(ItemRegistry.venisonCooked), 0.0F);
		GameRegistry.addSmelting(new ItemStack(ItemRegistry.pheasantRaw), new ItemStack(ItemRegistry.pheasantCooked), 0.0F);
		
		//Recipe with OreDict
		for(ItemStack stack : OreDictionary.getOres("stone")) {
			GameRegistry.addShapedRecipe(new ResourceLocation(Ref.MOD_ID + ":handoffaterecipe"), new ResourceLocation(Ref.MOD_ID), new ItemStack(ItemRegistry.itemHandOfFate, 1), new Object[]{
					"ibi",
					" i ",
					"sss",
					Character.valueOf('i'), Blocks.IRON_BARS, 
					Character.valueOf('b'), Items.BLAZE_POWDER, 
					Character.valueOf('s'), stack});
		}
		
		//Register oredict
		OreDictionary.registerOre("listAllmeatraw", ItemRegistry.venisonRaw);
		OreDictionary.registerOre("listAllmeatcooked", ItemRegistry.venisonCooked);
		OreDictionary.registerOre("listAllmeatraw", ItemRegistry.pheasantRaw);
		OreDictionary.registerOre("listAllmeatcooked", ItemRegistry.pheasantCooked);
	}
}
