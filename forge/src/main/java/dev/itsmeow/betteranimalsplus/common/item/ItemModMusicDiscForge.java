package dev.itsmeow.betteranimalsplus.common.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;

import java.util.function.Supplier;

public class ItemModMusicDiscForge extends RecordItem {

    public ItemModMusicDiscForge(Supplier<SoundEvent> soundSupplier) {
        super(15, soundSupplier, new Item.Properties().stacksTo(1).rarity(Rarity.RARE));
    }

}
