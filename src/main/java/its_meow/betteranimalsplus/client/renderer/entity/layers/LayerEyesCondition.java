package its_meow.betteranimalsplus.client.renderer.entity.layers;

import java.util.function.Predicate;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class LayerEyesCondition<T extends EntityLiving> extends LayerEyes<T> {
    
    protected final Predicate<T> condition;

    public LayerEyesCondition(RenderLiving<T> baseRenderer, ResourceLocation texture, Predicate<T> showLayer) {
        super(baseRenderer, texture);
        this.condition = showLayer;
    }

    @Override
    public void doRenderLayer(T entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        if(condition.test(entity)) {
            super.doRenderLayer(entity, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch, scale);
        }
    }

}
