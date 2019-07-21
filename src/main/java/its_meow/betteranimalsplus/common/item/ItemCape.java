package its_meow.betteranimalsplus.common.item;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public abstract class ItemCape extends ItemModeledArmor {

    public final String variant;
    public final Item repairItem;

    public ItemCape(String name, String variant, Item repairItem, IArmorMaterial material) {
        super(material, EquipmentSlotType.CHEST, new Properties().group(BetterAnimalsPlusMod.group));
        this.variant = variant;
        this.setRegistryName(name + variant);
        this.repairItem = repairItem;
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == repairItem;
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

}
