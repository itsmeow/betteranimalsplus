package its_meow.betteranimalsplus.client.renderer.entity.layers;

import com.mojang.blaze3d.platform.GLX;
import com.mojang.blaze3d.platform.GlStateManager;

import its_meow.betteranimalsplus.client.model.ModelCustomWolf;
import its_meow.betteranimalsplus.common.entity.EntityFeralWolf;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class LayerWolfEyes extends LayerRenderer<EntityFeralWolf, ModelCustomWolf<EntityFeralWolf>> {

    public LayerWolfEyes(IEntityRenderer<EntityFeralWolf, ModelCustomWolf<EntityFeralWolf>> p_i50921_1_) {
        super(p_i50921_1_);
    }

    public void func_212842_a_(EntityFeralWolf p_212842_1_, float p_212842_2_, float p_212842_3_, float p_212842_4_, float p_212842_5_, float p_212842_6_, float p_212842_7_, float p_212842_8_) {
        if(!p_212842_1_.isTamed()) {
            this.func_215333_a(ModTextures.wolf_eyes);
            GlStateManager.enableBlend();
            GlStateManager.disableAlphaTest();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
            if (p_212842_1_.isInvisible()) {
                GlStateManager.depthMask(false);
            } else {
                GlStateManager.depthMask(true);
            }

            int i = 61680;
            int j = i % 65536;
            int k = i / 65536;
            GLX.glMultiTexCoord2f(GLX.GL_TEXTURE1, (float)j, (float)k);
            GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
            GameRenderer gamerenderer = Minecraft.getInstance().gameRenderer;
            gamerenderer.setupFogColor(true);
            ((ModelCustomWolf<EntityFeralWolf>)this.func_215332_c()).render(p_212842_1_, p_212842_2_, p_212842_3_, p_212842_5_, p_212842_6_, p_212842_7_, p_212842_8_);
            gamerenderer.setupFogColor(false);
            i = p_212842_1_.getBrightnessForRender();
            j = i % 65536;
            k = i / 65536;
            GLX.glMultiTexCoord2f(GLX.GL_TEXTURE1, (float)j, (float)k);
            this.func_215334_a(p_212842_1_);
            GlStateManager.depthMask(true);
            GlStateManager.disableBlend();
            GlStateManager.enableAlphaTest();
        }
    }

    public boolean shouldCombineTextures() {
        return false;
    }
}