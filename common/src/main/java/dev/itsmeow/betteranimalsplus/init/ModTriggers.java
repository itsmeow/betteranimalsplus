package dev.itsmeow.betteranimalsplus.init;

import dev.itsmeow.betteranimalsplus.Ref;
import dev.itsmeow.betteranimalsplus.common.advancements.CustomTrigger;
import me.shedaniel.architectury.registry.CriteriaTriggersRegistry;

import java.util.HashMap;
import java.util.Map;

public class ModTriggers {

    public static final CustomTrigger PUNCH_BEAR = new CustomTrigger(Ref.MOD_ID + ":punch_bear");
    public static final CustomTrigger PUNCH_BEAR_DEATH = new CustomTrigger(Ref.MOD_ID + ":punch_bear_death");
    public static final CustomTrigger USE_CRAB_DISK = new CustomTrigger(Ref.MOD_ID + ":crab_disk_used");
    public static final CustomTrigger SHARK_TARGETED = new CustomTrigger(Ref.MOD_ID + ":shark_targeted");
    public static final CustomTrigger RIDE_REINDEER = new CustomTrigger(Ref.MOD_ID + ":ride_reindeer");
    public static final CustomTrigger GOAT_FIGHT_FRIEND = new CustomTrigger(Ref.MOD_ID + ":goat_fight_friend");
    public static final CustomTrigger NO_BAM = new CustomTrigger(Ref.MOD_ID + ":no_bam");
    public static final CustomTrigger BADGERDIRT_IMPACT = new CustomTrigger(Ref.MOD_ID + ":badgerdirt_impact");
    public static final Map<Integer, CustomTrigger> SQUIRREL_KILL_TRIGGERS = new HashMap<>();
    public static final CustomTrigger USE_WALRUS_DISK = new CustomTrigger(Ref.MOD_ID + ":walrus_disk_used");
    public static final CustomTrigger SQUID_TARGETED = new CustomTrigger(Ref.MOD_ID + ":squid_targeted");
    public static final CustomTrigger OCTOPUS_SAVE_PLAYER = new CustomTrigger(Ref.MOD_ID + ":octopus_save_player");

    public static void register() {
        registerTriggers(PUNCH_BEAR, PUNCH_BEAR_DEATH, USE_CRAB_DISK, SHARK_TARGETED, RIDE_REINDEER, GOAT_FIGHT_FRIEND, NO_BAM, BADGERDIRT_IMPACT, USE_WALRUS_DISK, SQUID_TARGETED, OCTOPUS_SAVE_PLAYER);
        for (int i = 1; i <= 100; i++) {
            CustomTrigger trigger = new CustomTrigger(Ref.MOD_ID + ":squirrel_kill" + i);
            SQUIRREL_KILL_TRIGGERS.put(i, trigger);
            // TODO test
            CriteriaTriggersRegistry.register(trigger);
        }
    }

    private static void registerTriggers(CustomTrigger... triggers) {
        for (CustomTrigger trigger : triggers) {
            CriteriaTriggersRegistry.register(trigger);
        }
    }

}
