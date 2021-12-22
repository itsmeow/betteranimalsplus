package dev.itsmeow.betteranimalsplus.mixin.fabric;

import dev.itsmeow.betteranimalsplus.common.CommonEventHandler;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;

@Mixin(LivingEntity.class)
public class LivingEntityMixin extends EntityMixin {

    @Inject(at = @At("HEAD"), method = "dropAllDeathLoot(Lnet/minecraft/world/damagesource/DamageSource;)V")
    private void dropAllDeathLootHead(DamageSource source, CallbackInfo callback) {
        this.drops = new ArrayList<>();
    }

    @Inject(at = @At("RETURN"), method = "dropAllDeathLoot(Lnet/minecraft/world/damagesource/DamageSource;)V")
    private void dropAllDeathLootReturn(DamageSource source, CallbackInfo callback) {
        ArrayList<ItemEntity> drops = this.drops;
        this.drops = null;
        CommonEventHandler.modifyDropsList(drops, source, (LivingEntity) (Object) this);
        drops.forEach(level::addFreshEntity);
    }

}
