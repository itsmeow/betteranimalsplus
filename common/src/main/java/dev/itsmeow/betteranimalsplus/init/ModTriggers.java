package dev.itsmeow.betteranimalsplus.init;

import dev.itsmeow.betteranimalsplus.Ref;
import dev.itsmeow.betteranimalsplus.common.advancements.CustomTrigger;
import net.minecraft.advancements.CriteriaTriggers;

import java.util.HashMap;
import java.util.Map;

public class ModTriggers {

    public static final CustomTrigger PUNCH_BEAR = new CustomTrigger(Ref.MOD_ID + ":punch_bear");
    public static final CustomTrigger PUNCH_BEAR_DEATH = new CustomTrigger(Ref.MOD_ID + ":punch_bear_death");
    public static final CustomTrigger CRAB_DANCE = new CustomTrigger(Ref.MOD_ID + ":crab_dance");
    public static final CustomTrigger SHARK_TARGETED = new CustomTrigger(Ref.MOD_ID + ":shark_targeted");
    public static final CustomTrigger RIDE_REINDEER = new CustomTrigger(Ref.MOD_ID + ":ride_reindeer");
    public static final CustomTrigger GOAT_FIGHT_FRIEND = new CustomTrigger(Ref.MOD_ID + ":goat_fight_friend");
    public static final CustomTrigger NO_BAM = new CustomTrigger(Ref.MOD_ID + ":no_bam");
    public static final CustomTrigger BADGERDIRT_IMPACT = new CustomTrigger(Ref.MOD_ID + ":badgerdirt_impact");
    public static final Map<Integer, CustomTrigger> SQUIRREL_KILL_TRIGGERS = new HashMap<>();
    public static final CustomTrigger SQUID_TARGETED = new CustomTrigger(Ref.MOD_ID + ":squid_targeted");
    public static final CustomTrigger OCTOPUS_SAVE_PLAYER = new CustomTrigger(Ref.MOD_ID + ":octopus_save_player");
    public static final CustomTrigger WALRUS_EASTER_EGG = new CustomTrigger(Ref.MOD_ID + ":walrus_easter_egg");

    public static void register() {
        registerTriggers(PUNCH_BEAR, PUNCH_BEAR_DEATH, CRAB_DANCE, SHARK_TARGETED, RIDE_REINDEER, GOAT_FIGHT_FRIEND, NO_BAM, BADGERDIRT_IMPACT, SQUID_TARGETED, OCTOPUS_SAVE_PLAYER, WALRUS_EASTER_EGG);
        for (int i = 1; i <= 100; i++) {
            CustomTrigger trigger = new CustomTrigger(Ref.MOD_ID + ":squirrel_kill" + i);
            SQUIRREL_KILL_TRIGGERS.put(i, trigger);
            CriteriaTriggers.register(trigger);
        }
    }

    private static void registerTriggers(CustomTrigger... triggers) {
        for (CustomTrigger trigger : triggers) {
            CriteriaTriggers.register(trigger);
        }
    }

}
