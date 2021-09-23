package dev.itsmeow.betteranimalsplus.common.item;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public abstract class ItemModeledArmor extends ArmorItem {

    public ItemModeledArmor(ArmorMaterial material, EquipmentSlot slot, Item.Properties properties) {
        super(material, slot, properties);
    }

    //TODO ARMOR MODELS
    //@Override
    @Environment(EnvType.CLIENT)
    public <A extends HumanoidModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlot armorSlot, A defaultModel) {
        if (itemStack != null) {
            if (itemStack.getItem() instanceof ArmorItem && armorSlot != null) {
                A armorModel = this.getBaseModelInstance();
                armorModel = displays(armorModel, armorSlot);

                if (defaultModel != null) {
                    armorModel.crouching = defaultModel.crouching;
                    armorModel.riding = defaultModel.riding;
                    armorModel.young = defaultModel.young;
                    armorModel.rightArmPose = defaultModel.rightArmPose;
                    armorModel.leftArmPose = defaultModel.leftArmPose;
                }

                return armorModel;
            }
        }
        return null;
    }

    @Environment(EnvType.CLIENT)
    protected abstract <A extends HumanoidModel<?>> A getBaseModelInstance();

    @Environment(EnvType.CLIENT)
    protected abstract <A extends HumanoidModel<?>> A displays(A armorModel, EquipmentSlot slot);

}
