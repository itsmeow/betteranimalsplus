package dev.itsmeow.betteranimalsplus.init.forge;

import dev.itsmeow.betteranimalsplus.common.item.ItemModMusicDiscForge;
import dev.itsmeow.betteranimalsplus.init.ModItems;
import dev.itsmeow.betteranimalsplus.init.ModSoundEvents;

public class ModItemsImpl extends ModItems {

    public static void platformStatic() {
        ModItems.RECORD_CRAB_RAVE = ModItems.r("record_crab_rave", () -> new ItemModMusicDiscForge(ModSoundEvents.CRAB_RAVE::get));
        ModItems.RECORD_WALRUS = ModItems.r("record_walrus", () -> new ItemModMusicDiscForge(ModSoundEvents.WALRUS::get));
    }

}
