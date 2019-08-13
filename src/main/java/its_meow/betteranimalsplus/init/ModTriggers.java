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
    public static final Map<Integer, CustomTrigger> SQUIRREL_KILL_TRIGGERS = new HashMap<Integer, CustomTrigger>();

    public static void register() {
        CriteriaTriggers.register(HAND_OF_FATE_SUMMON);
        CriteriaTriggers.register(PUNCH_BEAR);
        CriteriaTriggers.register(PUNCH_BEAR_DEATH);
        for(int i = 1; i <= 100; i++) {
            CustomTrigger trigger = new CustomTrigger(Ref.MOD_ID + ":squirrel_kill" + i);
            SQUIRREL_KILL_TRIGGERS.put(i, trigger);
            CriteriaTriggers.register(trigger);
        }
    }

}
