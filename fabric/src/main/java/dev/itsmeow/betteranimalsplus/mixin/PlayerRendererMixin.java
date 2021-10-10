package dev.itsmeow.betteranimalsplus.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.itsmeow.betteranimalsplus.client.dumb.DeveloperRenderThing;
import dev.itsmeow.betteranimalsplus.client.dumb.SafeSyncThing;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerRenderer.class)
public abstract class PlayerRendererMixin {

    @Inject(at = @At("HEAD"), method = "render(Lnet/minecraft/client/player/AbstractClientPlayer;FFLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V", cancellable = true)
    public void render(AbstractClientPlayer player, float rot, float partialTicks, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, CallbackInfo callback) {
        if(DeveloperRenderThing.shouldRender(player)) {
            this.setModelProperties(player);
            DeveloperRenderThing.playerRender(player, (PlayerRenderer) (Object) this, partialTicks, poseStack, multiBufferSource, packedLight);
            callback.cancel();
        }
    }

    @Shadow
    public abstract void setModelProperties(AbstractClientPlayer player);
}
