package its_meow.betteranimalsplus.common.item;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.Ref;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;

public class ItemBetterFood extends Item {

    public final int itemUseDuration;

    public ItemBetterFood(int foodToFill, float saturationMultiplier, int eatLength, boolean isMeat) {
        super(new Item.Properties().group(BetterAnimalsPlusMod.group).food(createFood(foodToFill, saturationMultiplier, isMeat)));
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
