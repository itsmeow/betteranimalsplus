package dev.itsmeow.betteranimalsplus.common.item;

import dev.itsmeow.betteranimalsplus.BetterAnimalsPlusMod;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemBetterFood extends Item {

    public final int itemUseDuration;

    public ItemBetterFood(int foodToFill, float saturationMultiplier, int eatLength, boolean isMeat) {
        super(new Item.Properties().group(BetterAnimalsPlusMod.GROUP).food(createFood(foodToFill, saturationMultiplier, isMeat)));
        this.itemUseDuration = eatLength;
    }

    private static Food createFood(int foodToFill, float saturationMultiplier, boolean isMeat) {
        Food.Builder builder = new Food.Builder().hunger(foodToFill).saturation(saturationMultiplier);
        if(isMeat) {
            builder.meat();
        }
        return builder.build();
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return this.itemUseDuration;
    }

}
