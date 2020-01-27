package its_meow.betteranimalsplus.client.renderer.entity.layers;

import java.util.function.Predicate;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.util.ResourceLocation;

public class LayerEyesCondition<T extends TameableEntity, A extends EntityModel<T>> extends LayerEyes<T, A> {

    protected final Predicate<T> condition;

    public LayerEyesCondition(MobRenderer<T, A> baseRenderer, ResourceLocation texture, Predicate<T> showLayer) {
        super(baseRenderer, texture);
        this.condition = showLayer;
    }

    @Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if(condition.test(entity)) {
            super.render(matrixStackIn, bufferIn, packedLightIn, entity, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch);
        }
    }

}
