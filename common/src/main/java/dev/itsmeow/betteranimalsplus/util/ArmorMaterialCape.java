package dev.itsmeow.betteranimalsplus.util;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public class ArmorMaterialCape implements IArmorMaterial {
    
    private final String name;
    private final String variant;
    
    public ArmorMaterialCape(String name, String variant) {
        this.name = name;
        this.variant = variant;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlotType arg0) {
        return 3;
    }

    @Override
    public int getEnchantmentValue() {
        return 15;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ARMOR_EQUIP_LEATHER;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }

    @Override
    public float getToughness() {
        return 0;
    }

    @Override
    public int getDurabilityForSlot(EquipmentSlotType slotIn) {
        return 81; // leather chestplate https://minecraft.gamepedia.com/Armor#Durability
    }

    @Override
    public String getName() {
        return "betteranimalsplus:" + name + variant;
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }
}
