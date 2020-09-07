package its_meow.betteranimalsplus.common.entity.util;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;

public class EntityUtil {

    public static void childChance(AgeableEntity e, SpawnReason reason, ILivingEntityData livingdata, float chance) {
        if((reason == SpawnReason.NATURAL || reason == SpawnReason.CHUNK_GENERATION) && livingdata != null && e.getRNG().nextFloat() <= chance) {
            e.setGrowingAge(-24000);
        }
    }

}
