package its_meow.betteranimalsplus.util;

import its_meow.betteranimalsplus.init.ModItems;
import net.minecraft.item.Items;
import net.minecraft.util.SoundEvents;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;

public class ArmorMaterialBone implements IArmorMaterial {

    @Override
    public int getDamageReductionAmount(EquipmentSlotType arg0) {
        return 2;
    }

    @Override
    public int getDurability(EquipmentSlotType arg0) {
        return 50;
    }

    @Override
    public int getEnchantability() {
        return 12;
    }

    @Override
    public String getName() {
        return "betteranimalsplus:bone";
    }

    @Override
    public Ingredient getRepairMaterial() {
        return Ingredient.fromItems(Items.BONE, ModItems.ANTLER);
    }

    @Override
    public SoundEvent getSoundEvent() {
        return SoundEvents.ITEM_ARMOR_EQUIP_GENERIC;
    }

    @Override
    public float getToughness() {
        return 0;
    }

}
