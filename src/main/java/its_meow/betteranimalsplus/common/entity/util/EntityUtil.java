package its_meow.betteranimalsplus.common.entity.util;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.AgeableEntity.AgeableData;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;

public class EntityUtil {

    public static ILivingEntityData childChance(AgeableEntity e, SpawnReason reason, ILivingEntityData livingdata, float chance) {
        if(livingdata != null && livingdata instanceof AgeableData) {
            int i = ((AgeableData) livingdata).getIndexInGroup();
            livingdata = new AgeableData(chance);
            ((AgeableData) livingdata).indexInGroup = i;
        }
        return livingdata;
    }

}
