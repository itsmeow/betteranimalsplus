package dev.itsmeow.betteranimalsplus.mixin.fabric;

import dev.itsmeow.betteranimalsplus.common.CommonEventHandler;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    public LivingEntityMixin(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(at = @At("HEAD"), method = "dropAllDeathLoot(Lnet/minecraft/world/damagesource/DamageSource;)V")
    private void dropAllDeathLootHead(DamageSource source, CallbackInfo callback) {
        ((EntityMixin) (Object) this).drops = new ArrayList<>();
    }

    @Inject(at = @At("RETURN"), method = "dropAllDeathLoot(Lnet/minecraft/world/damagesource/DamageSource;)V")
    private void dropAllDeathLootReturn(DamageSource source, CallbackInfo callback) {
        ArrayList<ItemEntity> drops = ((EntityMixin) (Object) this).drops;
        ((EntityMixin) (Object) this).drops = null;
        CommonEventHandler.modifyDropsList(drops, source, (LivingEntity) (Object) this);
        drops.forEach(level::addFreshEntity);
    }

}
