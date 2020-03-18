package its_meow.betteranimalsplus.common.item;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class ItemModeledArmor extends ItemArmor {
    
    public final EntityEquipmentSlot slot;

    public ItemModeledArmor(ArmorMaterial materialIn, EntityEquipmentSlot equipmentSlotIn, boolean repairable) {
        super(materialIn, -1, equipmentSlotIn);
        this.slot = equipmentSlotIn;
        this.canRepair = true;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped defaultModel) {
        if (itemStack != null && defaultModel != null && armorSlot != null) {
            if (itemStack.getItem() instanceof ItemArmor) {

                ModelBiped armorModel = this.getBaseModelInstance();
                armorModel = displays(armorModel, armorSlot);

                armorModel.isSneak = defaultModel.isSneak;
                armorModel.isRiding = defaultModel.isRiding;
                armorModel.isChild = defaultModel.isChild;
                armorModel.rightArmPose = defaultModel.rightArmPose;
                armorModel.leftArmPose = defaultModel.leftArmPose;

                return armorModel;
            }
        }
        return null;
    }
    
    @Override
    public boolean isValidArmor(ItemStack stack, EntityEquipmentSlot armorType, Entity entity) {
        return armorType == slot;
    }
    
    @SideOnly(Side.CLIENT)
    protected abstract ModelBiped getBaseModelInstance();
    
    @SideOnly(Side.CLIENT)
    protected abstract ModelBiped displays(ModelBiped armorModel, EntityEquipmentSlot slot);

}
