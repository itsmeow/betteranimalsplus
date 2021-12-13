package dev.itsmeow.betteranimalsplus.mixin;

import dev.itsmeow.imdlib.entity.interfaces.IContainerEntity;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SynchedEntityData.class)
public class SynchedEntityDataMixin {

    @Inject(at = @At(value = "FIELD", target = "Lnet/minecraft/network/syncher/SynchedEntityData;LOGGER:Lorg/apache/logging/log4j/Logger;", ordinal = 1), method = "defineId(Ljava/lang/Class;Lnet/minecraft/network/syncher/EntityDataSerializer;)Lnet/minecraft/network/syncher/EntityDataAccessor;")
    private static <T> void defineId(Class<? extends Entity> class_, EntityDataSerializer<T> entityDataSerializer, CallbackInfoReturnable<EntityDataAccessor<T>> callback) throws ClassNotFoundException {
        if(IContainerEntity.class.isAssignableFrom(class_))
            throw new ClassNotFoundException();
    }

    @Inject(at = @At(value = "FIELD", target = "Lnet/minecraft/network/syncher/SynchedEntityData;LOGGER:Lorg/apache/logging/log4j/Logger;", ordinal = 2), method = "defineId(Ljava/lang/Class;Lnet/minecraft/network/syncher/EntityDataSerializer;)Lnet/minecraft/network/syncher/EntityDataAccessor;")
    private static <T> void defineId2(Class<? extends Entity> class_, EntityDataSerializer<T> entityDataSerializer, CallbackInfoReturnable<EntityDataAccessor<T>> callback) throws ClassNotFoundException {
        if(IContainerEntity.class.isAssignableFrom(class_))
            throw new ClassNotFoundException();
    }

}
