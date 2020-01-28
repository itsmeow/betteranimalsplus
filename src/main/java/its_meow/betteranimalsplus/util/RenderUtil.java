package its_meow.betteranimalsplus.util;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderUtil {
    
    public static void partScaleTranslate(MatrixStack stack, ModelRenderer part, float scale) {
        RenderUtil.offsetTranslate(stack, part);
        RenderUtil.pointTranslate(stack, part);
        RenderUtil.scale(stack, scale);
        RenderUtil.negativeOffsetTranslate(stack, part);
        RenderUtil.negativePointTranslate(stack, part);
        
    }

    public static void partScaleTranslate(MatrixStack stack, ModelRenderer part, double scale) {
        partScaleTranslate(stack, part, (float) scale);
    }
    
    public static void offsetTranslate(MatrixStack stack, ModelRenderer part) {
        stack.translate(xOffset(part), yOffset(part), zOffset(part));
    }

    public static void negativeOffsetTranslate(MatrixStack stack, ModelRenderer part) {
        stack.translate(-xOffset(part), -yOffset(part), -zOffset(part));
    }

    public static void pointTranslate(MatrixStack stack, ModelRenderer part) {
        stack.translate(part.rotationPointX / 16, part.rotationPointY / 16, part.rotationPointZ / 16);
    }
    
    public static void negativePointTranslate(MatrixStack stack, ModelRenderer part) {
        stack.translate(-part.rotationPointX / 16, -part.rotationPointY / 16, -part.rotationPointZ / 16);
    }
    
    public static void scale(MatrixStack stack, float scale) {
        stack.scale(scale, scale, scale);
    }
    
    public static void scale(MatrixStack stack, double scale) {
        scale(stack, (float) scale);
    }
    
    public static float xOffset(ModelRenderer part) {
        return part.cubeList.get(0).posX1 / 16;
    }
    
    public static float yOffset(ModelRenderer part) {
        return part.cubeList.get(0).posY1 / 16;
    }
    
    public static float zOffset(ModelRenderer part) {
        return part.cubeList.get(0).posZ1 / 16;
    }

}
