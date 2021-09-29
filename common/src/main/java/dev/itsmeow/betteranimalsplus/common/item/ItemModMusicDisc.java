package dev.itsmeow.betteranimalsplus.common.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;

import java.util.function.Supplier;

public class ItemModMusicDisc extends RecordItem {

    private Supplier<SoundEvent> soundSupplier;

    public ItemModMusicDisc(Supplier<SoundEvent> soundSupplier) {
        super(15, new SoundEvent(null), new Item.Properties().stacksTo(1).rarity(Rarity.RARE));
        this.soundSupplier = soundSupplier;
    }

    @Override
    public SoundEvent getSound() {
        SoundEvent sound = soundSupplier.get();
        // TODO record patch
        /*if(RecordItem.getBySound(sound) == null) {
            RecordItem.BY_NAME.put(sound, this);
        }*/
        return sound;
    }
}
