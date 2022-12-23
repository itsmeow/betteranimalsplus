package dev.itsmeow.betteranimalsplus.mixin;

import dev.itsmeow.betteranimalsplus.client.dumb.DeveloperRenderThing;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LocalPlayer.class)
public class LocalPlayerMixin {

    @Inject(method = "sendCommand(Ljava/lang/String;Lnet/minecraft/network/chat/Component;)V", at = @At("HEAD"), cancellable = true)
    public void command(String message, Component component, CallbackInfo callback) {
        if (DeveloperRenderThing.chat("/" + message).isFalse())
            callback.cancel();
    }

}
