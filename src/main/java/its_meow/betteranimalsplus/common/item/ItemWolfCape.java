package its_meow.betteranimalsplus.common.item;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.client.model.ModelWolfCape;
import its_meow.betteranimalsplus.init.ModItems;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemWolfCape extends ItemModeledArmor {

    public final int variant;
    
    public ItemWolfCape(int variant) {
        super(EnumHelper.addArmorMaterial("wolfcape" + variant, "betteranimalsplus:wolfcape" + variant, 5, new int[]{1, 2, 3, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F), EntityEquipmentSlot.CHEST, true);
        this.variant = variant;
        this.setUnlocalizedName("betteranimalsplus.wolfcape" + variant);
        this.setRegistryName("wolfcape" + variant);
        this.setCreativeTab(BetterAnimalsPlusMod.tab);
    }

    @SideOnly(Side.CLIENT)
    @Override
    protected ModelBiped displays(ModelBiped armorModel, EntityEquipmentSlot slot) {
        armorModel.bipedHead.showModel = false;
        armorModel.bipedHeadwear.showModel = false;
        armorModel.bipedBody.showModel = true;
        armorModel.bipedRightArm.showModel = false;
        armorModel.bipedLeftArm.showModel = false;
        armorModel.bipedRightLeg.showModel = false;
        armorModel.bipedLeftLeg.showModel = false;
        return armorModel;
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

    @SideOnly(Side.CLIENT)
    @Override
    protected ModelBiped getBaseModelInstance() {
        return ModelWolfCape.INSTANCE;
    }

}