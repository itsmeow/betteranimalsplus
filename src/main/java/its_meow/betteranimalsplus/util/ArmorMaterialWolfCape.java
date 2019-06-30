package its_meow.betteranimalsplus.util;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public class ArmorMaterialWolfCape implements IArmorMaterial {
    
    private int variant = 0;
    
    public ArmorMaterialWolfCape(int variant) {
        this.variant = variant;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType arg0) {
        return 3;
    }

    @Override
    public int getEnchantability() {
        return 15;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return SoundEvents.ITEM_ARMOR_EQUIP_LEATHER;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return null;
    }

    @Override
    public float getToughness() {
        return 0;
    }

    @Override
    public int getDurability(EquipmentSlotType slotIn) {
        return 0;
    }

    @Override
    public String getName() {
        return "betteranimalsplus:wolfcape" + variant;
    }

}
