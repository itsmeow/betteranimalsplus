package its_meow.betteranimalsplus.common.item;

import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.init.ModItems;
import net.minecraft.item.Item;

public class ItemAdvancementIcon extends Item {

    public ItemAdvancementIcon(String name) {
        super(new Item.Properties());
        this.setRegistryName(Ref.MOD_ID, name);
        ModItems.ADVANCEMENT_ICONS.put(name, this);
    }

}
