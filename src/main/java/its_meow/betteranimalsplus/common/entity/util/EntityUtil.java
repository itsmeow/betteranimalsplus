package its_meow.betteranimalsplus.common.entity.util;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.AgeableEntity.AgeableData;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.logging.log4j.LogManager;

import java.lang.reflect.Field;

public class EntityUtil {

    private static boolean hasFailed =  false;

    public static ILivingEntityData childChance(AgeableEntity e, SpawnReason reason, ILivingEntityData livingdata, float chance) {
        if(livingdata != null && livingdata instanceof AgeableData) {
            try {
                Field babySpawnProbability = ObfuscationReflectionHelper.findField(AgeableData.class, "field_226256_c_");
                FieldUtils.removeFinalModifier(babySpawnProbability);
                babySpawnProbability.set(livingdata, chance);
            } catch(Exception ex) {
                if(!hasFailed) {
                    LogManager.getLogger().error("Error setting baby spawn probability! It will now be 5% (default)");
                    ex.printStackTrace();
                    hasFailed = true;
                }
            }
        }
        return livingdata;
    }

}
