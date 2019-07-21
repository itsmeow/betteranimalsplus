package its_meow.betteranimalsplus.common.item;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.client.model.ModelWolfCape;
import its_meow.betteranimalsplus.init.ModItems;
import its_meow.betteranimalsplus.util.ArmorMaterialWolfCape;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemWolfCape extends ItemModeledArmor {

    public final int variant;
    
    public ItemWolfCape(int variant) {
        super(new ArmorMaterialWolfCape(variant), EquipmentSlotType.CHEST, new Properties().group(BetterAnimalsPlusMod.group));
        this.variant = variant;
        this.setRegistryName("wolfcape" + variant);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    protected <A extends BipedModel<?>> A displays(A armorModel, EquipmentSlotType slot) {
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

    @SuppressWarnings("unchecked")
    @OnlyIn(Dist.CLIENT)
    @Override
    protected <A extends BipedModel<?>> A getBaseModelInstance() {
        return (A) ModelWolfCape.INSTANCE;
    }

}