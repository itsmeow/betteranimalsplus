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
        if (!tileentity.getWorld().isAirBlock(tileentity.getPos())) {
            rotate = tileentity.getRotation();
        }
        int modelNum = tileentity.getModelNum();
        EntityModel<Entity> mainModel = (modelNum == 0 ? doubleT : (modelNum == 1 ? singleT : tripleT));

        matrixStackIn.push();
        {
            matrixStackIn.translate(0.5F, 1.5F, 0.5F);
            matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(180F));

            matrixStackIn.push();
            {
                Color color = new Color(tileentity.getWorld().getBiome(tileentity.getPos()).getGrassColor(0,0));
                float r = color.getRed() / 255F;
                float g = color.getGreen() / 255F;
                float b = color.getBlue() / 255F;
                r -= 20F / 255F;
                g -= 20F / 255F;
                b -= 20F / 255F;
                r = r > 255F ? 250F : r;
                g = g > 255F ? 250F : g;
                b = b > 255F ? 250F : b;
                mainModel.setRotationAngles(null, 0F, 0F, 0F, rotate, 0F);
                mainModel.render(matrixStackIn, bufferIn.getBuffer(RenderType.getEntityCutout(ModResources.trillium_base)), combinedLightIn, combinedOverlayIn, r, g, b, 1F);
            }
            matrixStackIn.pop();

            matrixStackIn.push();
            {
                mainModel.setRotationAngles(null, 0F, 0F, 0F, rotate, 0F);
                mainModel.render(matrixStackIn, bufferIn.getBuffer(RenderType.getEntityCutout(tileentity.getTexture())), combinedLightIn, combinedOverlayIn, 1F, 1F, 1F, 1F);
            }
            matrixStackIn.pop();
        }
        matrixStackIn.pop();
    }

}
