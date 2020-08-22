package its_meow.betteranimalsplus.init;

import java.util.HashMap;
import java.util.Map;

import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.common.advancements.CustomTrigger;
import net.minecraft.advancements.CriteriaTriggers;

public class ModTriggers {

    public static final CustomTrigger HAND_OF_FATE_SUMMON = new CustomTrigger(Ref.MOD_ID + ":hand_of_fate_summon");
    public static final CustomTrigger PUNCH_BEAR = new CustomTrigger(Ref.MOD_ID + ":punch_bear");
    public static final CustomTrigger PUNCH_BEAR_DEATH = new CustomTrigger(Ref.MOD_ID + ":punch_bear_death");
    public static final CustomTrigger USE_CRAB_DISK = new CustomTrigger(Ref.MOD_ID + ":crab_disk_used");
    public static final CustomTrigger SHARK_TARGETED = new CustomTrigger(Ref.MOD_ID + ":shark_targeted");
    public static final CustomTrigger RIDE_REINDEER = new CustomTrigger(Ref.MOD_ID + ":ride_reindeer");
    public static final CustomTrigger GOAT_FIGHT_FRIEND = new CustomTrigger(Ref.MOD_ID + ":goat_fight_friend");
    public static final CustomTrigger NO_BAM = new CustomTrigger(Ref.MOD_ID + ":no_bam");
    public static final CustomTrigger BADGERDIRT_IMPACT = new CustomTrigger(Ref.MOD_ID + ":badgerdirt_impact");
    public static final Map<Integer, CustomTrigger> SQUIRREL_KILL_TRIGGERS = new HashMap<Integer, CustomTrigger>();
    public static final CustomTrigger USE_WALRUS_DISK = new CustomTrigger(Ref.MOD_ID + ":walrus_disk_used");
    public static final CustomTrigger SQUID_TARGETED = new CustomTrigger(Ref.MOD_ID + ":squid_targeted");

    public static void register() {
        registerTriggers(HAND_OF_FATE_SUMMON,PUNCH_BEAR, PUNCH_BEAR_DEATH, USE_CRAB_DISK, SHARK_TARGETED, RIDE_REINDEER, GOAT_FIGHT_FRIEND, NO_BAM, BADGERDIRT_IMPACT, USE_WALRUS_DISK, SQUID_TARGETED);
        for(int i = 1; i <= 100; i++) {
            CustomTrigger trigger = new CustomTrigger(Ref.MOD_ID + ":squirrel_kill" + i);
            SQUIRREL_KILL_TRIGGERS.put(i, trigger);
            CriteriaTriggers.register(trigger);
        }
    }
    
    private static void registerTriggers(CustomTrigger... triggers) {
        for(CustomTrigger trigger : triggers) {
            CriteriaTriggers.register(trigger);
        }
    }

}
