package dev.itsmeow.betteranimalsplus.fabric;

import dev.itsmeow.betteranimalsplus.BetterAnimalsPlusMod;
import dev.itsmeow.betteranimalsplus.Ref;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.betteranimalsplus.init.ModItems;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.Iterator;
import java.util.stream.Collectors;

public class BetterAnimalsPlusModImpl {
    public static CreativeModeTab getPlatformTab() {
        return FabricItemGroupBuilder.create(new ResourceLocation(Ref.MOD_ID, "main"))
                .icon(() -> new ItemStack(ModItems.ANTLER.get()))
                .appendItems(list -> {
                    NonNullList<ItemStack> tabList = NonNullList.create();
                    Registry.ITEM.forEach(item -> item.fillItemCategory(BetterAnimalsPlusMod.TAB, tabList));
                    list.addAll(tabList);
                    list.addAll(ModEntities.getEntities().values().stream().map(cont -> new ItemStack(cont.getEggItem().get())).collect(Collectors.toList()));
                })
                .build();
    }
}
