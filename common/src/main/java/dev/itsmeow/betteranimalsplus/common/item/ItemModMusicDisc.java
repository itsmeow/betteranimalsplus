package dev.itsmeow.betteranimalsplus.common.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;

public class ItemModMusicDisc extends RecordItem {
    public ItemModMusicDisc(SoundEvent soundEvent) {
        super(15, soundEvent, new Item.Properties().stacksTo(1).rarity(Rarity.RARE));
    }
}
