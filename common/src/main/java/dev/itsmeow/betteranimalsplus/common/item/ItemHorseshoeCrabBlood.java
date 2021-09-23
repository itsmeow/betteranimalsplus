package dev.itsmeow.betteranimalsplus.common.item;

import java.util.List;

import dev.itsmeow.betteranimalsplus.BetterAnimalsPlusMod;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
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

import net.minecraft.item.Item.Properties;

public class ItemHorseshoeCrabBlood extends Item {

    public static final ITextComponent CURES_WITHER = new TranslationTextComponent("tooltip.betteranimalsplus.cures_wither").withStyle(TextFormatting.GREEN);

    public ItemHorseshoeCrabBlood() {
        super(new Properties().stacksTo(1).craftRemainder(Items.GLASS_BOTTLE).tab(BetterAnimalsPlusMod.GROUP));
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        return cure(entityLiving) ? new ItemStack(Items.GLASS_BOTTLE) : stack;
    }

    private static boolean cure(LivingEntity entityLiving) {
        if(entityLiving.level.isClientSide)
            return false;
        return entityLiving.removeEffect(Effects.WITHER);
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 32;
    }

    @Override
    public UseAction getUseAnimation(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
        playerIn.startUsingItem(handIn);
        return new ActionResult<>(ActionResultType.SUCCESS, playerIn.getItemInHand(handIn));
    }

    @Override
    public void appendHoverText(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(CURES_WITHER);
    }

}
