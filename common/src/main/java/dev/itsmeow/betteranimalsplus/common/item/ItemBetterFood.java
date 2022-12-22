package dev.itsmeow.betteranimalsplus.common.item;

import dev.itsmeow.betteranimalsplus.BetterAnimalsPlusMod;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ItemBetterFood extends Item {

    public final int itemUseDuration;

    public ItemBetterFood(int foodToFill, float saturationMultiplier, int eatLength, boolean isMeat) {
        super(new Item.Properties().arch$tab(BetterAnimalsPlusMod.TAB).food(createFood(foodToFill, saturationMultiplier, isMeat)));
        this.itemUseDuration = eatLength;
    }

    private static FoodProperties createFood(int foodToFill, float saturationMultiplier, boolean isMeat) {
        FoodProperties.Builder builder = new FoodProperties.Builder().nutrition(foodToFill).saturationMod(saturationMultiplier);
        if (isMeat) {
            builder.meat();
        }
        return builder.build();
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return this.itemUseDuration;
    }

}
