package its_meow.betteranimalsplus.common.item;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class ItemCape extends ItemModeledArmor {

    public final String variant;
    public final Item repairItem;

    public ItemCape(String name, String variant, Item repairItem) {
        super(EnumHelper.addArmorMaterial(name + variant, "betteranimalsplus:" + name + variant, 5, new int[]{1, 2, 3, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F), EntityEquipmentSlot.CHEST, true);
        this.variant = variant;
        this.setTranslationKey("betteranimalsplus." + name + variant);
        this.setRegistryName(name + variant);
        this.setCreativeTab(BetterAnimalsPlusMod.tab);
        this.repairItem = repairItem;
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == repairItem;
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

}
