package dev.itsmeow.betteranimalsplus.common.item;

import dev.itsmeow.betteranimalsplus.BetterAnimalsPlusMod;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public abstract class ItemCape extends ItemModeledArmor {

    public static CanEquipFunction can_equip = (s, a, e) -> true;
    public final Item repairItem;

    public ItemCape(Item repairItem, ArmorMaterial material) {
        super(material, EquipmentSlot.CHEST, new Properties().tab(BetterAnimalsPlusMod.TAB));
        this.repairItem = repairItem;
    }

    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == repairItem;
    }

    @Environment(EnvType.CLIENT)
    @Override
    protected <A extends HumanoidModel<?>> A displays(A armorModel, EquipmentSlot slot) {
        armorModel.head.visible = false;
        armorModel.hat.visible = false;
        armorModel.body.visible = true;
        armorModel.rightArm.visible = false;
        armorModel.leftArm.visible = false;
        armorModel.rightLeg.visible = false;
        armorModel.leftLeg.visible = false;
        return armorModel;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
        return true /* TODO this.canEquip(playerIn.getItemInHand(handIn), this.getSlot(), playerIn)*/ ? super.use(worldIn, playerIn, handIn) : InteractionResultHolder.fail(playerIn.getItemInHand(handIn));
    }

    // TODO canEquip
    /*
    @Override
    public boolean canEquip(ItemStack stack, EquipmentSlot armorType, Entity entity) {
        return super.canEquip(stack, armorType, entity) && can_equip.canEquip(stack, armorType, entity);
    }*/

    @FunctionalInterface
    public interface CanEquipFunction {
        boolean canEquip(ItemStack stack, EquipmentSlot armorType, Entity entity);
    }
}
