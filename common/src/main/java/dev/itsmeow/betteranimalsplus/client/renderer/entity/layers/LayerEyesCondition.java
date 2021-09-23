package dev.itsmeow.betteranimalsplus.client.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;

import java.util.function.Predicate;

public class LayerEyesCondition<T extends Mob, A extends EntityModel<T>> extends LayerEyes<T, A> {

    protected final Predicate<T> condition;

    public LayerEyesCondition(MobRenderer<T, A> baseRenderer, ResourceLocation texture, Predicate<T> showLayer) {
        super(baseRenderer, texture);
        this.condition = showLayer;
    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, T entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (condition.test(entity)) {
            super.render(matrixStackIn, bufferIn, packedLightIn, entity, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch);
        }
    }

}
