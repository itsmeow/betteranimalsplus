package its_meow.betteranimalsplus.registry;

import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class CraftingRegistry {

	public static final void register() {
		GameRegistry.addSmelting(new ItemStack(ItemRegistry.venisonRaw), new ItemStack(ItemRegistry.venisonCooked), 0.0F);
	}
}
