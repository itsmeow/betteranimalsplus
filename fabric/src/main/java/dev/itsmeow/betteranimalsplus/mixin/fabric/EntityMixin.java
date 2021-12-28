package dev.itsmeow.betteranimalsplus.mixin.fabric;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.ArrayList;

@Mixin(Entity.class)
public class EntityMixin {

    @Unique
    public ArrayList<ItemEntity> drops = null;

    @Inject(at = @At(value = "FIELD", target = "Lnet/minecraft/world/entity/Entity;level:Lnet/minecraft/world/level/Level;", ordinal = 2), method = "spawnAtLocation(Lnet/minecraft/world/item/ItemStack;F)Lnet/minecraft/world/entity/item/ItemEntity;", cancellable = true, locals = LocalCapture.CAPTURE_FAILEXCEPTION)
    private void spawnAtLocation(ItemStack itemStack, float f, CallbackInfoReturnable<ItemEntity> callback, ItemEntity itemEntity) {
        if (drops != null) {
            drops.add(itemEntity);
            callback.setReturnValue(itemEntity);
            callback.cancel();
        }
    }

}
