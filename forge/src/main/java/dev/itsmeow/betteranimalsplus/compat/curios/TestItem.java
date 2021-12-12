package dev.itsmeow.betteranimalsplus.compat.curios;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class TestItem extends Item {
    public TestItem(Properties arg) {
        super(arg);
    }

    @Override
    public boolean canEquip(ItemStack stack, EquipmentSlot armorType, Entity entity) {
        return super.canEquip(stack, armorType, entity);
    }
}
