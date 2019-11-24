package its_meow.betteranimalsplus.common.item;

import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.init.BetterAnimalsPlusRegistrar;
import net.minecraft.item.Item;

public class ItemHiddenItem extends Item {
    
    public ItemHiddenItem(String name) {
        this.setRegistryName(Ref.MOD_ID, name);
        this.setTranslationKey(Ref.MOD_ID + "." + name);
        BetterAnimalsPlusRegistrar.HIDE_ITEMS.add(this);
    }
    
}
