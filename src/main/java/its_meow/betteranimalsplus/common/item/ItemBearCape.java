package its_meow.betteranimalsplus.common.item;

import its_meow.betteranimalsplus.client.model.ModelBearCape;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBearCape extends ItemCape {

    public ItemBearCape(String variant, Item repairItem) {
        super("bear_cape_", variant, repairItem);
    }

    @SideOnly(Side.CLIENT)
    @Override
    protected ModelBiped getBaseModelInstance() {
        return ModelBearCape.INSTANCE;
    }

}
