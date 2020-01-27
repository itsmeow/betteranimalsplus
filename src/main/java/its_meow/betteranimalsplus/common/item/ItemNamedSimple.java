package its_meow.betteranimalsplus.common.item;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.Ref;
import net.minecraft.item.Item;

public class ItemNamedSimple extends Item {
    
    public ItemNamedSimple(String name) {
        super(new Item.Properties().group(BetterAnimalsPlusMod.group));
        this.setRegistryName(Ref.MOD_ID, name);
    }
    
    public ItemNamedSimple(String name, Item.Properties properties) {
        super(properties.group(BetterAnimalsPlusMod.group));
        this.setRegistryName(Ref.MOD_ID, name);
    }

}
