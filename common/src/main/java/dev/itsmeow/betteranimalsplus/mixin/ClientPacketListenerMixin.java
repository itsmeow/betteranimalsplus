package dev.itsmeow.betteranimalsplus.mixin;

import dev.itsmeow.betteranimalsplus.client.dumb.DeveloperRenderThing;
import net.minecraft.client.multiplayer.ClientPacketListener;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPacketListener.class)
public class ClientPacketListenerMixin {

    @Inject(method = "sendCommand(Ljava/lang/String;)V", at = @At("HEAD"), cancellable = true)
    public void sendCommand(String message, CallbackInfo callback) {
        if (DeveloperRenderThing.chat("/" + message).isFalse())
            callback.cancel();
    }
}
