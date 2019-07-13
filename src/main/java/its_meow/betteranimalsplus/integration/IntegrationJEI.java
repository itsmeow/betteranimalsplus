package its_meow.betteranimalsplus.integration;

import its_meow.betteranimalsplus.init.BetterAnimalsPlusRegistrar;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.ingredients.IIngredientBlacklist;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@JEIPlugin
public class IntegrationJEI implements IModPlugin {
    
    public IntegrationJEI() {}

    @Override
    public void register(IModRegistry registry) {
        IIngredientBlacklist blacklist = registry.getJeiHelpers().getIngredientBlacklist();
        for(Item item : BetterAnimalsPlusRegistrar.HIDE_ITEMS) {
            blacklist.addIngredientToBlacklist(new ItemStack(item));
        }
    }

}
