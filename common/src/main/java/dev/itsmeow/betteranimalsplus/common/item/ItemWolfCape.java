package dev.itsmeow.betteranimalsplus.common.item;

import dev.itsmeow.betteranimalsplus.Ref;
import dev.itsmeow.betteranimalsplus.client.model.armor.ModelWolfCape;
import dev.itsmeow.betteranimalsplus.util.ArmorMaterialCape;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class ItemWolfCape extends ItemCape {

    public ItemWolfCape(String variant, Item repairItem) {
        super(repairItem, new ArmorMaterialCape("wolf_cape_", variant));
    }

    @SuppressWarnings("unchecked")
    @Environment(EnvType.CLIENT)
    @Override
    protected <A extends HumanoidModel<?>> A getBaseModelInstance() {
        if(ModelWolfCape.INSTANCE == null) {
            ModelWolfCape.INSTANCE = new ModelWolfCape<>(new EntityRendererProvider.Context(Minecraft.getInstance().getEntityRenderDispatcher(), Minecraft.getInstance().getItemRenderer(), Minecraft.getInstance().getResourceManager(), Minecraft.getInstance().getEntityModels(), Minecraft.getInstance().font).bakeLayer(new ModelLayerLocation(new ResourceLocation(Ref.MOD_ID, "wolf_cape"), "main")));
        }
        return (A) ModelWolfCape.INSTANCE;
    }

}