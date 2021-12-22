package dev.itsmeow.betteranimalsplus.common.entity.util;

import dev.itsmeow.betteranimalsplus.mixin.AgeableMobGroupDataAccessor;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AgeableMob.AgeableMobGroupData;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;

public class EntityUtil {

    public static SpawnGroupData childChance(AgeableMob e, MobSpawnType reason, SpawnGroupData livingdata, float chance) {
        if(livingdata instanceof AgeableMobGroupData) {
            ((AgeableMobGroupDataAccessor) livingdata).setBabySpawnChance(chance);
        }
        return livingdata;
    }

}
