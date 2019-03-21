package its_meow.betteranimalsplus.common.item;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.Ref;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class ItemBetterFood extends ItemFood {

    public final int itemUseDuration;

    public ItemBetterFood(String name, int foodToFill, float saturationMultiplier, int eatLength, boolean isMeat) {
        super(foodToFill, saturationMultiplier, isMeat);
        this.setRegistryName(name);
        this.setUnlocalizedName(Ref.MOD_ID + "." + name);
        this.itemUseDuration = eatLength;
        this.setCreativeTab(BetterAnimalsPlusMod.tab);
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return this.itemUseDuration;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.EAT;
    }

}