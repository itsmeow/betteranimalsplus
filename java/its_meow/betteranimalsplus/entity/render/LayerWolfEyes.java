package its_meow.betteranimalsplus.entity.render;

import its_meow.betteranimalsplus.entity.EntityFeralWolf;
import its_meow.betteranimalsplus.registry.TextureRegistry;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderWolf;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LayerWolfEyes implements LayerRenderer<EntityFeralWolf>
{
    private final RenderCustomWolf wolfRenderer;

    public LayerWolfEyes(RenderCustomWolf wolfRendererIn)
    {
        this.wolfRenderer = wolfRendererIn;
    }

    public void doRenderLayer(EntityFeralWolf entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        if (entitylivingbaseIn.isTamed() && !entitylivingbaseIn.isInvisible())
        {
            this.wolfRenderer.bindTexture(TextureRegistry.wolf_eyes);
            float f = entitylivingbaseIn.getBrightness() * 1.5F;
            GlStateManager.color(f, f, f);
            this.wolfRenderer.getMainModel().render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        }
    }

    public boolean shouldCombineTextures()
    {
        return true;
    }
}