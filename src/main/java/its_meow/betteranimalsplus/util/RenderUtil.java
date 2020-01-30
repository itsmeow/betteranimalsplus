package its_meow.betteranimalsplus.util;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderUtil {
    
    public static void partTranslateRotate(RendererModel... parts) {
        for(RendererModel part : parts) {
            RenderUtil.offsetTranslate(part);
            RenderUtil.pointTranslate(part);
            GlStateManager.rotatef((float) Math.toDegrees(part.rotateAngleX), 1.0F, 0F, 0F);
            GlStateManager.rotatef((float) Math.toDegrees(part.rotateAngleY), 0.0F, 1.0F, 0F);
            GlStateManager.rotatef((float) Math.toDegrees(part.rotateAngleZ), 0F, 0F, 1.0F);
        }
    }
    
    public static void partScaleTranslate(RendererModel part, float scale) {
        RenderUtil.offsetTranslate(part);
        RenderUtil.pointTranslate(part);
        RenderUtil.scale(scale);
        RenderUtil.negativeOffsetTranslate(part);
        RenderUtil.negativePointTranslate(part);
    }

    public static void partScaleTranslate(RendererModel part, double scale) {
        partScaleTranslate(part, (float) scale);
    }
    
    public static void partScaleTranslate(RendererModel part, float scaleX, float scaleY, float scaleZ) {
        RenderUtil.offsetTranslate(part);
        RenderUtil.pointTranslate(part);
        GlStateManager.scalef(scaleX, scaleY, scaleZ);
        RenderUtil.negativeOffsetTranslate(part);
        RenderUtil.negativePointTranslate(part);
    }

    public static void partScaleTranslate(RendererModel part, double scaleX, double scaleY, double scaleZ) {
        partScaleTranslate(part, (float) scaleX, (float) scaleY, (float) scaleZ);
    }
    
    public static void offsetTranslate(RendererModel part) {
        GlStateManager.translatef(xOffset(part), yOffset(part), zOffset(part));
    }

    public static void negativeOffsetTranslate(RendererModel part) {
        GlStateManager.translatef(-xOffset(part), -yOffset(part), -zOffset(part));
    } 

    public static void pointTranslate(RendererModel part) {
        GlStateManager.translatef(part.rotationPointX / 16, part.rotationPointY / 16, part.rotationPointZ / 16);
    }
    
    public static void negativePointTranslate(RendererModel part) {
        GlStateManager.translatef(-part.rotationPointX / 16, -part.rotationPointY / 16, -part.rotationPointZ / 16);
    }
    
    public static void scale(float scale) {
        GlStateManager.scalef(scale, scale, scale);
    }
    
    public static void scale(double scale) {
        scale((float) scale);
    }
    
    public static float xOffset(RendererModel part) {
        return part.offsetX / 16;
    }
    
    public static float yOffset(RendererModel part) {
        return part.offsetY / 16;
    }
    
    public static float zOffset(RendererModel part) {
        return part.offsetZ/ 16;
    }

}