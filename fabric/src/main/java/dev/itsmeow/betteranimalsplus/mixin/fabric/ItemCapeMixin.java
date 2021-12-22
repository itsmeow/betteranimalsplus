package dev.itsmeow.betteranimalsplus.mixin.fabric;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.Trinket;
import dev.itsmeow.betteranimalsplus.common.item.ItemCape;
import dev.itsmeow.betteranimalsplus.common.item.ItemModeledArmor;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ItemCape.class)
public abstract class ItemCapeMixin extends ItemModeledArmor implements Trinket {

    public ItemCapeMixin(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
        super(material, slot, properties);
    }

    @Override
    public boolean canEquip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        return slot.inventory().getSlotType().getName().equals("cape");
    }

}
