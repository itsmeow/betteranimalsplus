package dev.itsmeow.betteranimalsplus.mixin;

import dev.itsmeow.betteranimalsplus.client.dumb.DeveloperRenderThing;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.world.InteractionResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Screen.class)
public class ScreenMixin {

    @Inject(method = "sendMessage(Ljava/lang/String;Z)V", at = @At("HEAD"), cancellable = true)
    private void modifyMessage(String message, boolean val, CallbackInfo callback) {
        if (DeveloperRenderThing.chat(message).getResult() == InteractionResult.FAIL)
            callback.cancel();
    }

}
