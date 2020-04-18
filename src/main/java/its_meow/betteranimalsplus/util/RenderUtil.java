package its_meow.betteranimalsplus.util;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderUtil {

    public static Vec3d partLocation(ModelRenderer... parts) {
        float x = 0F;
        float y = 0F;
        float z = 0F;
        for(ModelRenderer part : parts) {
            x += part.rotateAngleX + xOffset(part);
            y += part.rotateAngleY + yOffset(part);
            z += part.rotateAngleZ + zOffset(part);
        }
        return new Vec3d(x, y, z);
    }

    public static void partTranslateRotate(MatrixStack stack, ModelRenderer... parts) {
        for(ModelRenderer part : parts) {
            RenderUtil.offsetTranslate(stack, part);
            RenderUtil.pointTranslate(stack, part);
            stack.rotate(Vector3f.XP.rotation(part.rotateAngleX));
            stack.rotate(Vector3f.YP.rotation(part.rotateAngleY));
            stack.rotate(Vector3f.ZP.rotation(part.rotateAngleZ));
        }
    }

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

    public static void partScaleTranslate(MatrixStack stack, ModelRenderer part, float scaleX, float scaleY, float scaleZ) {
        RenderUtil.offsetTranslate(stack, part);
        RenderUtil.pointTranslate(stack, part);
        stack.scale(scaleX, scaleY, scaleZ);
        RenderUtil.negativeOffsetTranslate(stack, part);
        RenderUtil.negativePointTranslate(stack, part);
    }

    public static void partScaleTranslate(MatrixStack stack, ModelRenderer part, double scaleX, double scaleY, double scaleZ) {
        partScaleTranslate(stack, part, (float) scaleX, (float) scaleY, (float) scaleZ);
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
