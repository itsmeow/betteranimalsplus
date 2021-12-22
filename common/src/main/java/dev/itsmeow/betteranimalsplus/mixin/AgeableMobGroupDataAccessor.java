package dev.itsmeow.betteranimalsplus.mixin;

import net.minecraft.world.entity.AgeableMob;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(AgeableMob.AgeableMobGroupData.class)
public interface AgeableMobGroupDataAccessor {

    @Mutable
    @Accessor("babySpawnChance")
    void setBabySpawnChance(float babySpawnChance);

}
