package dev.itsmeow.betteranimalsplus.mixin.fabric;

import dev.itsmeow.betteranimalsplus.common.entity.EntityLamprey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Iterator;
import java.util.Optional;
import java.util.function.Predicate;

@Mixin(ProjectileUtil.class)
public class ProjectileUtilMixin {

    @Inject(at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/world/phys/Vec3;distanceToSqr(Lnet/minecraft/world/phys/Vec3;)D", ordinal = 0), method = "getEntityHitResult(Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;D)Lnet/minecraft/world/phys/EntityHitResult;", cancellable = true, locals = LocalCapture.CAPTURE_FAILHARD)
    private static void getEntityHitResult(Entity entity, Vec3 vec3, Vec3 vec32, AABB aABB, Predicate<Entity> predicate, double d, CallbackInfoReturnable<EntityHitResult> callbackInfoReturnable, Level level, double e, Entity entity2, Vec3 vec33, Iterator var12, Entity entity3, AABB aABB2, Optional<Vec3> optional, Vec3 vec34, double f) {
        if (f < e || e == 0.0D) {
            if (entity3.getRootVehicle() == entity.getRootVehicle() && entity instanceof Player && entity3 instanceof EntityLamprey && ((EntityLamprey) entity3).canRiderInteract()) {
                callbackInfoReturnable.setReturnValue(new EntityHitResult(entity3, vec34));
                callbackInfoReturnable.cancel();
            }
        }
    }

}
