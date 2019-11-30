package its_meow.betteranimalsplus.client.renderer.entity.layers;

import com.mojang.blaze3d.platform.GLX;
import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.ResourceLocation;

public class LayerEyes<T extends MobEntity, A extends EntityModel<T>> extends LayerRenderer<T, A> {

    protected final MobRenderer<T, A> baseRenderer;
    protected final ResourceLocation texture;

    public LayerEyes(MobRenderer<T, A> baseRenderer, ResourceLocation texture) {
        super(baseRenderer);
        this.baseRenderer = baseRenderer;
        this.texture = texture;
    }

    @Override
    public void render(T entity, float p_212842_2_, float p_212842_3_, float p_212842_4_, float p_212842_5_, float p_212842_6_, float p_212842_7_, float p_212842_8_) {
        if (!entity.isInvisible() && !entity.isChild()) {
            this.bindTexture(texture);
            GlStateManager.enableBlend();
            GlStateManager.disableAlphaTest();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
            GlStateManager.depthMask(false);

            int i = 240;
            int j = i % 65536;
            int k = i / 65536;
            GLX.glMultiTexCoord2f(GLX.GL_TEXTURE1, (float)j, (float)k);
            GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
            GameRenderer gamerenderer = Minecraft.getInstance().gameRenderer;
            gamerenderer.setupFogColor(true);
            ((A)this.getEntityModel()).render(entity, p_212842_2_, p_212842_3_, p_212842_5_, p_212842_6_, p_212842_7_, p_212842_8_);
            gamerenderer.setupFogColor(false);
            i = entity.getBrightnessForRender();
            j = i % 65536;
            k = i / 65536;
            GLX.glMultiTexCoord2f(GLX.GL_TEXTURE1, (float)j, (float)k);
            this.func_215334_a(entity);
            GlStateManager.depthMask(true);
            GlStateManager.disableBlend();
            GlStateManager.enableAlphaTest();
        }

    }

    @Override
    public boolean shouldCombineTextures() {
        return false;
    }

}