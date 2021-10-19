package dev.itsmeow.betteranimalsplus.common.item;

import dev.itsmeow.betteranimalsplus.client.model.armor.ModelWolfCape;
import dev.itsmeow.betteranimalsplus.util.ArmorMaterialCape;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.item.Item;

public class ItemWolfCape extends ItemCape {

    public ItemWolfCape(String variant, Item repairItem) {
        super(repairItem, new ArmorMaterialCape("wolf_cape_", variant));
    }

    @SuppressWarnings("unchecked")
    @Environment(EnvType.CLIENT)
    @Override
    protected <A extends HumanoidModel<?>> A getBaseModelInstance() {
        return (A) ModelWolfCape.INSTANCE;
    }

}