package its_meow.betteranimalsplus.common.item;

import its_meow.betteranimalsplus.client.model.ModelWolfCape;
import its_meow.betteranimalsplus.util.ArmorMaterialCape;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;


public class ItemWolfCape extends ItemCape {

    public ItemWolfCape(String variant, Item repairItem) {
        super(repairItem, new ArmorMaterialCape("wolf_cape_", variant));
    }

    @SuppressWarnings("unchecked")
    @OnlyIn(Dist.CLIENT)
    @Override
    protected <A extends BipedModel<?>> A getBaseModelInstance() {
        return (A) ModelWolfCape.INSTANCE;
    }

}