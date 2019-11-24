package its_meow.betteranimalsplus.common.item;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.Ref;
import net.minecraft.item.Item;

public class ItemNamedSimple extends Item {
    
    public ItemNamedSimple(String name) {
        this.setRegistryName(name);
        this.setTranslationKey(Ref.MOD_ID + "." + name);
        this.setCreativeTab(BetterAnimalsPlusMod.tab);
    }

}
