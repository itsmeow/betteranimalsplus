package dev.itsmeow.betteranimalsplus.util;

import dev.itsmeow.betteranimalsplus.Ref;
import dev.architectury.platform.Platform;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

public class ArmorMaterialCape implements ArmorMaterial {

    private final String name;
    private final String variant;

    public ArmorMaterialCape(String name, String variant) {
        this.name = name;
        this.variant = variant;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot arg0) {
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
    public int getDurabilityForSlot(EquipmentSlot slotIn) {
        return 81; // leather chestplate https://minecraft.gamepedia.com/Armor#Durability
    }

    @Override
    public String getName() {
        return (Platform.isForge() ? Ref.MOD_ID + ":" : "") + name + variant;
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }
}
