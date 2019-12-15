package its_meow.betteranimalsplus.common.item;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public abstract class ItemModeledArmor extends ArmorItem {

    public ItemModeledArmor(IArmorMaterial material, EquipmentSlotType slot, Item.Properties properties) {
        super(material, slot, properties);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A defaultModel) {
        if (itemStack != null) {
            if (itemStack.getItem() instanceof ArmorItem && defaultModel != null && armorSlot != null) {
                A armorModel = this.getBaseModelInstance();
                armorModel = displays(armorModel, armorSlot);

                armorModel.isSneak = defaultModel.isSneak;
                armorModel.isSitting = defaultModel.isSitting;
                armorModel.isChild = defaultModel.isChild;
                armorModel.rightArmPose = defaultModel.rightArmPose;
                armorModel.leftArmPose = defaultModel.leftArmPose;

                return armorModel;
            }
        }
        return null;
    }

    @OnlyIn(Dist.CLIENT)
    protected abstract <A extends BipedModel<?>> A getBaseModelInstance();

    @OnlyIn(Dist.CLIENT)
    protected abstract <A extends BipedModel<?>> A displays(A armorModel, EquipmentSlotType slot);

}
