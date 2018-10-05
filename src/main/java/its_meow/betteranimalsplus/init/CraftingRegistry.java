package its_meow.betteranimalsplus.init;

import its_meow.betteranimalsplus.Ref;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.OreIngredient;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class CraftingRegistry {

	public static final void register() {
		GameRegistry.addSmelting(new ItemStack(ItemRegistry.venisonRaw), new ItemStack(ItemRegistry.venisonCooked), 0.0F);
		for(ItemStack stack : OreDictionary.getOres("stone")) {
			GameRegistry.addShapedRecipe(new ResourceLocation(Ref.MOD_ID + ":handoffaterecipe"), new ResourceLocation(Ref.MOD_ID), new ItemStack(ItemRegistry.itemHandOfFate, 1), new Object[]{
					"ibi",
					" i ",
					"sss",
					Character.valueOf('i'), Blocks.IRON_BARS, 
					Character.valueOf('b'), Items.BLAZE_POWDER, 
					Character.valueOf('s'), stack});
		}
		OreDictionary.registerOre("listAllmeatraw", ItemRegistry.venisonRaw);
		OreDictionary.registerOre("listAllmeatcooked", ItemRegistry.venisonCooked);
	}
}
