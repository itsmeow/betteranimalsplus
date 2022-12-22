package dev.itsmeow.betteranimalsplus.common.item;

import dev.itsmeow.betteranimalsplus.BetterAnimalsPlusMod;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.phys.AABB;

import java.util.List;

public abstract class ItemCape extends ItemModeledArmor {

    public static CanEquipFunction can_equip = (s, a, e) -> true;
    public final Item repairItem;
    public static final DispenseItemBehavior DISPENSE_ITEM_BEHAVIOR = new DefaultDispenseItemBehavior() {
        protected ItemStack execute(BlockSource blockSource, ItemStack itemStack) {
            return ItemCape.dispenseArmor(blockSource, itemStack) ? itemStack : super.execute(blockSource, itemStack);
        }
    };

    public static boolean dispenseArmor(BlockSource blockSource, ItemStack stack) {
        BlockPos blockPos = blockSource.getPos().relative(blockSource.getBlockState().getValue(DispenserBlock.FACING));
        List<LivingEntity> list = blockSource.getLevel().getEntitiesOfClass(LivingEntity.class, new AABB(blockPos), EntitySelector.NO_SPECTATORS.and(new EntitySelector.MobCanWearArmorEntitySelector(stack)));
        if (list.isEmpty()) {
            return false;
        } else {
            LivingEntity entity = list.get(0);
            EquipmentSlot slot = Mob.getEquipmentSlotForItem(stack);
            if(!can_equip.canEquip(stack, slot, entity)) {
                return false;
            }
            ItemStack itemStack2 = stack.split(1);
            entity.setItemSlot(slot, itemStack2);
            if (entity instanceof Mob) {
                ((Mob) entity).setDropChance(slot, 2.0F);
                ((Mob) entity).setPersistenceRequired();
            }
            return true;
        }
    }

    public ItemCape(Item repairItem, ArmorMaterial material) {
        super(material, EquipmentSlot.CHEST, new Properties().arch$tab(BetterAnimalsPlusMod.TAB));
        this.repairItem = repairItem;
        DispenserBlock.registerBehavior(this, DISPENSE_ITEM_BEHAVIOR);
    }

    //@Override on Forge
    public boolean canEquip(ItemStack stack, EquipmentSlot armorType, Entity entity) {
        return armorType == EquipmentSlot.CHEST && can_equip.canEquip(stack, armorType, entity);
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
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack stack = player.getItemInHand(interactionHand);
        EquipmentSlot slot = Mob.getEquipmentSlotForItem(stack);
        if(!can_equip.canEquip(stack, slot, player)) {
            return InteractionResultHolder.fail(stack);
        }
        ItemStack inSlot = player.getItemBySlot(slot);
        if (inSlot.isEmpty()) {
            player.setItemSlot(slot, stack.copy());
            stack.setCount(0);
            return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
        } else {
            return InteractionResultHolder.fail(stack);
        }
    }

    @FunctionalInterface
    public interface CanEquipFunction {
        boolean canEquip(ItemStack stack, EquipmentSlot armorType, Entity entity);
    }
}
