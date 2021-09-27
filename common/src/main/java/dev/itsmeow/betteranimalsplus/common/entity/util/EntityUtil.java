package dev.itsmeow.betteranimalsplus.common.entity.util;

import net.minecraft.world.entity.AgableMob;
import net.minecraft.world.entity.AgableMob.AgableMobGroupData;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;

public class EntityUtil {

    public static SpawnGroupData childChance(AgableMob e, MobSpawnType reason, SpawnGroupData livingdata, float chance) {
        if(livingdata instanceof AgableMobGroupData) {
            ((AgableMobGroupData) livingdata).babySpawnChance = chance;
        }
        return livingdata;
    }

}
