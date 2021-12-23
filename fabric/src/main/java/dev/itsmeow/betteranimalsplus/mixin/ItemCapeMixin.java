package dev.itsmeow.betteranimalsplus.mixin;

import dev.emi.trinkets.api.SlotGroups;
import dev.emi.trinkets.api.Slots;
import dev.emi.trinkets.api.Trinket;
import dev.itsmeow.betteranimalsplus.common.item.ItemCape;
import dev.itsmeow.betteranimalsplus.common.item.ItemModeledArmor;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ItemCape.class)
public abstract class ItemCapeMixin extends ItemModeledArmor implements Trinket {

    public ItemCapeMixin(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
        super(material, slot, properties);
    }

    @Override
    public boolean canWearInSlot(String group, String slot) {
        return group.equals(SlotGroups.CHEST) && slot.equals(Slots.CAPE);
    }

}
