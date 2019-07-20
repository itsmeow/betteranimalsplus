package its_meow.betteranimalsplus.common.item;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.client.model.ModelWolfCape;
import its_meow.betteranimalsplus.init.ModItems;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemWolfCape extends ItemArmor {

    public final int variant;
    
    public ItemWolfCape(int variant) {
        super(EnumHelper.addArmorMaterial("wolfcape" + variant, "betteranimalsplus:wolfcape" + variant, 5, new int[]{1, 2, 3, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F), -1, EntityEquipmentSlot.CHEST);
        this.variant = variant;
        this.setUnlocalizedName("betteranimalsplus.wolfcape" + variant);
        this.setRegistryName("wolfcape" + variant);
        this.setCreativeTab(BetterAnimalsPlusMod.tab);
        this.canRepair = true;
    }

    @Override
    public boolean isValidArmor(ItemStack stack, EntityEquipmentSlot armorType, Entity entity) {
        return armorType == EntityEquipmentSlot.CHEST;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped defaultModel) {
        if (itemStack != null) {
            if (itemStack.getItem() instanceof ItemArmor) {

                ModelBiped armorModel = ModelWolfCape.INSTANCE;
                armorModel.bipedHead.showModel = false;
                armorModel.bipedHeadwear.showModel = false;
                armorModel.bipedBody.showModel = true;
                armorModel.bipedRightArm.showModel = false;
                armorModel.bipedLeftArm.showModel = false;
                armorModel.bipedRightLeg.showModel = false;
                armorModel.bipedLeftLeg.showModel = false;

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
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        Item matchPelt = null;
        switch(this.variant) {
        case 1: matchPelt = ModItems.WOLF_PELT_SNOWY; break;
        case 2: matchPelt = ModItems.WOLF_PELT_TIMBER; break;
        case 3: matchPelt = ModItems.WOLF_PELT_BLACK; break;
        default: return false;
        }
        return repair.getItem() == matchPelt;
    }

}