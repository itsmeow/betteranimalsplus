package dev.itsmeow.betteranimalsplus.common.item;

import dev.itsmeow.betteranimalsplus.BetterAnimalsPlusMod;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.item.Item.Properties;

public abstract class ItemCape extends ItemModeledArmor {

    public static CanEquipFunction can_equip = (s, a, e) -> true;
    public final Item repairItem;

    public ItemCape(Item repairItem, IArmorMaterial material) {
        super(material, EquipmentSlotType.CHEST, new Properties().tab(BetterAnimalsPlusMod.GROUP));
        this.repairItem = repairItem;
    }

    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == repairItem;
    }
    
    @OnlyIn(Dist.CLIENT)
    @Override
    protected <A extends BipedModel<?>> A displays(A armorModel, EquipmentSlotType slot) {
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
    public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
        return this.canEquip(playerIn.getItemInHand(handIn), this.getSlot(), playerIn) ? super.use(worldIn, playerIn, handIn) : ActionResult.fail(playerIn.getItemInHand(handIn));
    }

    @Override
    public boolean canEquip(ItemStack stack, EquipmentSlotType armorType, Entity entity) {
        return super.canEquip(stack, armorType, entity) && can_equip.canEquip(stack, armorType, entity);
    }

    @FunctionalInterface
    public interface CanEquipFunction {
        boolean canEquip(ItemStack stack, EquipmentSlotType armorType, Entity entity);
    }
}
