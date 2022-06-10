package dev.itsmeow.betteranimalsplus.mixin.fabric;

import net.minecraft.client.gui.screens.Screen;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Screen.class)
public class ScreenMixin {
/*
    @Inject(method = "sendMessage(Ljava/lang/String;Z)V", at = @At("HEAD"), cancellable = true)
    private void modifyMessage(String message, boolean val, CallbackInfo callback) {
        if (DeveloperRenderThing.chat(message).isFalse())
            callback.cancel();
    }
*/
}
