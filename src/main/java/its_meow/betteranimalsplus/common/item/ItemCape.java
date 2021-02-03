package its_meow.betteranimalsplus.common.item;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
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

public abstract class ItemCape extends ItemModeledArmor {

    public static CanEquipFunction can_equip = (s, a, e) -> true;
    public final Item repairItem;

    public ItemCape(Item repairItem, IArmorMaterial material) {
        super(material, EquipmentSlotType.CHEST, new Properties().group(BetterAnimalsPlusMod.GROUP));
        this.repairItem = repairItem;
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == repairItem;
    }
    
    @OnlyIn(Dist.CLIENT)
    @Override
    protected <A extends BipedModel<?>> A displays(A armorModel, EquipmentSlotType slot) {
        armorModel.bipedHead.showModel = false;
        armorModel.bipedHeadwear.showModel = false;
        armorModel.bipedBody.showModel = true;
        armorModel.bipedRightArm.showModel = false;
        armorModel.bipedLeftArm.showModel = false;
        armorModel.bipedRightLeg.showModel = false;
        armorModel.bipedLeftLeg.showModel = false;
        return armorModel;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        return this.canEquip(playerIn.getHeldItem(handIn), this.getEquipmentSlot(), playerIn) ? super.onItemRightClick(worldIn, playerIn, handIn) : ActionResult.resultFail(playerIn.getHeldItem(handIn));
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
