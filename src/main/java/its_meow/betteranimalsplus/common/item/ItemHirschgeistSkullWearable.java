package its_meow.betteranimalsplus.common.item;

import java.util.List;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.client.ClientLifecycleHandler;
import its_meow.betteranimalsplus.init.ModItems;
import its_meow.betteranimalsplus.util.ArmorMaterialBone;
import net.minecraft.client.renderer.entity.model.ModelBiped;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemHirschgeistSkullWearable extends ItemArmor {

    public ItemHirschgeistSkullWearable() {
        super(new ArmorMaterialBone(), EntityEquipmentSlot.HEAD, new Properties().group(BetterAnimalsPlusMod.group));
        this.setRegistryName("hirschgeistskullwearable");
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot,
            ModelBiped defaultModel) {
        if (itemStack != null) {
            if (itemStack.getItem() instanceof ItemArmor) {

                ModelBiped armorModel = ClientLifecycleHandler.armorModel;
                armorModel.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;
                armorModel.bipedHeadwear.showModel = armorSlot == EntityEquipmentSlot.HEAD;
                armorModel.bipedBody.showModel = armorSlot == EntityEquipmentSlot.CHEST
                        || armorSlot == EntityEquipmentSlot.CHEST;
                armorModel.bipedRightArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
                armorModel.bipedLeftArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
                armorModel.bipedRightLeg.showModel = armorSlot == EntityEquipmentSlot.LEGS
                        || armorSlot == EntityEquipmentSlot.FEET;
                armorModel.bipedLeftLeg.showModel = armorSlot == EntityEquipmentSlot.LEGS
                        || armorSlot == EntityEquipmentSlot.FEET;

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
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TextComponentString("It can be placed via placing it into an empty crafting table"));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == Items.BONE || repair.getItem() == ModItems.ANTLER;
    }

}
