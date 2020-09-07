package its_meow.betteranimalsplus.common.item;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.UseAction;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class ItemHorseshoeCrabBlood extends ItemNamedSimple {

    public static final ITextComponent CURES_WITHER = new TranslationTextComponent("tooltip.betteranimalsplus.cures_wither").applyTextStyle(TextFormatting.GREEN);

    public ItemHorseshoeCrabBlood() {
        super("horseshoe_crab_blood", new Properties().maxStackSize(1).containerItem(Items.GLASS_BOTTLE));
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        return cure(entityLiving) ? new ItemStack(Items.GLASS_BOTTLE) : stack;
    }

    private static boolean cure(LivingEntity entityLiving) {
        if(entityLiving.world.isRemote)
            return false;
        return entityLiving.removePotionEffect(Effects.WITHER);
    }

    public int getUseDuration(ItemStack stack) {
        return 32;
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        playerIn.setActiveHand(handIn);
        return new ActionResult<>(ActionResultType.SUCCESS, playerIn.getHeldItem(handIn));
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(CURES_WITHER);
    }

}
