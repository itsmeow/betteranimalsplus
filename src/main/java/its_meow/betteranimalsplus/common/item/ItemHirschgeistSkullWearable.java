package its_meow.betteranimalsplus.common.item;

import java.util.List;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.client.ClientLifecycleHandler;
import its_meow.betteranimalsplus.init.ModItems;
import its_meow.betteranimalsplus.util.ArmorMaterialBone;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemHirschgeistSkullWearable extends ArmorItem {

    public ItemHirschgeistSkullWearable() {
        super(new ArmorMaterialBone(), EquipmentSlotType.HEAD, new Properties().group(BetterAnimalsPlusMod.group));
        this.setRegistryName("hirschgeistskullwearable");
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A defaultModel) {
        if(itemStack != null) {
            if(itemStack.getItem() instanceof ArmorItem) {

                A armorModel = ClientLifecycleHandler.getArmorModel();
                armorModel.bipedHead.showModel = true;

                armorModel.isSneak = defaultModel.isSneak;
                armorModel.isSitting = defaultModel.isSitting;
                armorModel.isChild = defaultModel.isChild;
                armorModel.rightArmPose = defaultModel.rightArmPose;
                armorModel.leftArmPose = defaultModel.leftArmPose;

                return armorModel;
            }
        }
        return super.getArmorModel(entityLiving, itemStack, armorSlot, defaultModel);
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent("It can be placed via placing it into an empty crafting table"));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == Items.BONE || repair.getItem() == ModItems.ANTLER;
    }

}
