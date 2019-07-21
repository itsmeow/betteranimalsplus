package its_meow.betteranimalsplus.common.item;

import java.util.List;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.client.model.ModelHirschgeistHelmet;
import its_meow.betteranimalsplus.init.ModItems;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemHirschgeistSkullWearable extends ItemModeledArmor {
    
    public static final ArmorMaterial BONE_ARMOR = EnumHelper.addArmorMaterial("bone", "betteranimalsplus:hirschgeistskull", 15, new int[] { 1, 4, 5, 2 }, 12, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.1F);

    public ItemHirschgeistSkullWearable() {
        super(BONE_ARMOR, EntityEquipmentSlot.HEAD, true);
        this.setUnlocalizedName("betteranimalsplus.hirschgeistskullwearable");
        this.setRegistryName("hirschgeistskullwearable");
        this.setCreativeTab(BetterAnimalsPlusMod.tab);
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add("It can be placed via placing it into an empty crafting table");
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == Items.BONE || repair.getItem() == ModItems.antler;
    }

    @Override
    @SideOnly(Side.CLIENT)
    protected ModelBiped getBaseModelInstance() {
        return ModelHirschgeistHelmet.INSTANCE;
    }

    @Override
    @SideOnly(Side.CLIENT)
    protected ModelBiped displays(ModelBiped armorModel, EntityEquipmentSlot slot) {
        armorModel.bipedHead.showModel = true;
        armorModel.bipedHeadwear.showModel = true;
        armorModel.bipedBody.showModel = false;
        armorModel.bipedRightArm.showModel = false;
        armorModel.bipedLeftArm.showModel = false;
        armorModel.bipedRightLeg.showModel = false;
        armorModel.bipedLeftLeg.showModel = false;
        return armorModel;
    }

}
