package dev.itsmeow.betteranimalsplus.common.item;

import net.minecraft.item.Item;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.Rarity;
import net.minecraft.util.SoundEvent;

import java.util.function.Supplier;

public class ItemModMusicDisc extends MusicDiscItem {
    public ItemModMusicDisc(Supplier<SoundEvent> soundSupplier) {
        super(15, soundSupplier, new Item.Properties().maxStackSize(1).rarity(Rarity.RARE));
    }
}
