package dev.itsmeow.betteranimalsplus.fabric;

import dev.itsmeow.betteranimalsplus.Ref;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.betteranimalsplus.init.ModItems;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

import java.util.stream.Collectors;

public class BetterAnimalsPlusModImpl {
    private static CreativeModeTab getPlatformTab() {
        return FabricItemGroupBuilder.create(new ResourceLocation(Ref.MOD_ID, "main"))
                .icon(() -> new ItemStack(ModItems.ANTLER.get()))
                .appendItems(list -> list.addAll(ModEntities.getEntities().values().stream().map(cont -> new ItemStack((ItemLike) cont.getEggItem().get())).collect(Collectors.toList())))
                .build();
    }
}
