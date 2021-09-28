package dev.itsmeow.betteranimalsplus.forge;

import dev.itsmeow.betteranimalsplus.Ref;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.betteranimalsplus.init.ModItems;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

public class BetterAnimalsPlusModImpl {
    public static CreativeModeTab getPlatformTab() {
        return new CreativeModeTab(Ref.MOD_ID + ".main") {
            @Override
            public ItemStack makeIcon() {
                return new ItemStack(ModItems.ANTLER.get());
            }

            @Override
            public void fillItemList(NonNullList<ItemStack> toDisplay) {
                super.fillItemList(toDisplay);
                ModEntities.getEntities().values().forEach(cont -> toDisplay.add(new ItemStack((ItemLike) cont.getEggItem().get())));
            }
        };
    }
}
