package its_meow.betteranimalsplus.common.item;

import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.init.BetterAnimalsPlusRegistrar;
import its_meow.betteranimalsplus.init.ModItems;
import net.minecraft.item.Item;

public class ItemAdvancementIcon extends Item {

    public ItemAdvancementIcon(String name) {
        this.setRegistryName(Ref.MOD_ID, name);
        this.setUnlocalizedName(Ref.MOD_ID + "." + name);
        BetterAnimalsPlusRegistrar.HIDE_ITEMS.add(this);
        ModItems.ADVANCEMENT_ICONS.put(name, this);
    }

}
