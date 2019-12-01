package its_meow.betteranimalsplus.client.renderer.entity.layers;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.util.ResourceLocation;

public class LayerEyesTamed<T extends EntityTameable> extends LayerEyes<T> {

    public LayerEyesTamed(RenderLiving<T> baseRenderer, ResourceLocation texture) {
        super(baseRenderer, texture);
    }

    @Override
    public void doRenderLayer(T entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        if(!entity.isTamed()) {
            super.doRenderLayer(entity, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch, scale);
        }
    }

}
