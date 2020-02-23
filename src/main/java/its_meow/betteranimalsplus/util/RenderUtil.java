package its_meow.betteranimalsplus.util;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderUtil {
    
    public static Vec3d partLocation(ModelRenderer... parts) {
        float x = 0F;
        float y = 0F;
        float z = 0F;
        for(ModelRenderer part : parts) {
            x += part.rotateAngleX + part.offsetX / 16;
            y += part.rotateAngleY + part.offsetY / 16;
            z += part.rotateAngleZ + part.offsetZ / 16;
        }
        return new Vec3d(x, y, z);
    }

    public static void partTranslateRotate(ModelRenderer... parts) {
        for(ModelRenderer part : parts) {
            RenderUtil.offsetTranslate(part);
            RenderUtil.pointTranslate(part);
            GlStateManager.rotate((float) Math.toDegrees(part.rotateAngleX), 1.0F, 0F, 0F);
            GlStateManager.rotate((float) Math.toDegrees(part.rotateAngleY), 0F, 1.0F, 0F);
            GlStateManager.rotate((float) Math.toDegrees(part.rotateAngleZ), 0F, 0F, 1.0F);
        }
    }
    
    public static void partScaleTranslate(ModelRenderer part, float scale) {
        RenderUtil.offsetTranslate(part);
        RenderUtil.pointTranslate(part);
        RenderUtil.scale(scale);
        RenderUtil.negativeOffsetTranslate(part);
        RenderUtil.negativePointTranslate(part);
    }

    public static void partScaleTranslate(ModelRenderer part, double scale) {
        partScaleTranslate(part, (float) scale);
    }
    
    public static void partScaleTranslate(ModelRenderer part, float scaleX, float scaleY, float scaleZ) {
        RenderUtil.offsetTranslate(part);
        RenderUtil.pointTranslate(part);
        GlStateManager.scale(scaleX, scaleY, scaleZ);
        RenderUtil.negativeOffsetTranslate(part);
        RenderUtil.negativePointTranslate(part);
    }

    public static void partScaleTranslate(ModelRenderer part, double scaleX, double scaleY, double scaleZ) {
        partScaleTranslate(part, (float) scaleX, (float) scaleY, (float) scaleZ);
    }
    
    public static void offsetTranslate(ModelRenderer part) {
        GlStateManager.translate(part.offsetX / 16, part.offsetY / 16, part.offsetZ / 16);
    }

    public static void negativeOffsetTranslate(ModelRenderer part) {
        GlStateManager.translate(-part.offsetX / 16, -part.offsetY / 16, -part.offsetZ / 16);
    } 

    public static void pointTranslate(ModelRenderer part) {
        GlStateManager.translate(part.rotationPointX / 16, part.rotationPointY / 16, part.rotationPointZ / 16);
    }
    
    public static void negativePointTranslate(ModelRenderer part) {
        GlStateManager.translate(-part.rotationPointX / 16, -part.rotationPointY / 16, -part.rotationPointZ / 16);
    }
    
    public static void scale(float scale) {
        GlStateManager.scale(scale, scale, scale);
    }
    
    public static void scale(double scale) {
        scale((float) scale);
    }

}
