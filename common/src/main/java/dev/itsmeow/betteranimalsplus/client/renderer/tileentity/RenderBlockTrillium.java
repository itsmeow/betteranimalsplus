package dev.itsmeow.betteranimalsplus.client.renderer.tileentity;

import com.mojang.blaze3d.matrix.MatrixStack;
import dev.itsmeow.betteranimalsplus.client.model.ModelTrillium;
import dev.itsmeow.betteranimalsplus.client.model.ModelTrilliumMulti;
import dev.itsmeow.betteranimalsplus.client.model.ModelTrilliumMulti2;
import dev.itsmeow.betteranimalsplus.common.tileentity.TileEntityTrillium;
import dev.itsmeow.betteranimalsplus.init.ModResources;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.vector.Vector3f;

import java.awt.*;

public class RenderBlockTrillium extends TileEntityRenderer<TileEntityTrillium> {

    public static ModelTrillium<Entity> singleT = new ModelTrillium<>();
    public static ModelTrilliumMulti<Entity> doubleT = new ModelTrilliumMulti<>();
    public static ModelTrilliumMulti2<Entity> tripleT = new ModelTrilliumMulti2<>();
    
    public RenderBlockTrillium(TileEntityRendererDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(TileEntityTrillium tileentity, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
        float rotate = 0F;
        if (!tileentity.getLevel().isEmptyBlock(tileentity.getBlockPos())) {
            rotate = tileentity.getRotation();
        }
        int modelNum = tileentity.getModelNum();
        EntityModel<Entity> mainModel = (modelNum == 0 ? doubleT : (modelNum == 1 ? singleT : tripleT));

        matrixStackIn.pushPose();
        {
            matrixStackIn.translate(0.5F, 1.5F, 0.5F);
            matrixStackIn.mulPose(Vector3f.ZP.rotationDegrees(180F));

            matrixStackIn.pushPose();
            {
                Color color = new Color(tileentity.getLevel().getBiome(tileentity.getBlockPos()).getGrassColor(0,0));
                float r = color.getRed() / 255F;
                float g = color.getGreen() / 255F;
                float b = color.getBlue() / 255F;
                r -= 20F / 255F;
                g -= 20F / 255F;
                b -= 20F / 255F;
                r = r > 255F ? 250F : r;
                g = g > 255F ? 250F : g;
                b = b > 255F ? 250F : b;
                mainModel.setupAnim(null, 0F, 0F, 0F, rotate, 0F);
                mainModel.renderToBuffer(matrixStackIn, bufferIn.getBuffer(RenderType.entityCutout(ModResources.trillium_base)), combinedLightIn, combinedOverlayIn, r, g, b, 1F);
            }
            matrixStackIn.popPose();

            matrixStackIn.pushPose();
            {
                mainModel.setupAnim(null, 0F, 0F, 0F, rotate, 0F);
                mainModel.renderToBuffer(matrixStackIn, bufferIn.getBuffer(RenderType.entityCutout(tileentity.getTexture())), combinedLightIn, combinedOverlayIn, 1F, 1F, 1F, 1F);
            }
            matrixStackIn.popPose();
        }
        matrixStackIn.popPose();
    }

}
