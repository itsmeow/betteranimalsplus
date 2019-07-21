package its_meow.betteranimalsplus.common.item;

import its_meow.betteranimalsplus.client.model.ModelBearCape;
import its_meow.betteranimalsplus.util.ArmorMaterialCape;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemBearCape extends ItemCape {

    public ItemBearCape(String variant, Item repairItem) {
        super("bear_cape_", variant, repairItem, new ArmorMaterialCape("bear_cape_", variant));
    }

    @SuppressWarnings("unchecked")
    @OnlyIn(Dist.CLIENT)
    @Override
    protected <A extends BipedModel<?>> A getBaseModelInstance() {
        return (A) ModelBearCape.INSTANCE;
    }

}
