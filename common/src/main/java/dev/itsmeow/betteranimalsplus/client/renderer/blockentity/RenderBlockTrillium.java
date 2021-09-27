package dev.itsmeow.betteranimalsplus.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import dev.itsmeow.betteranimalsplus.common.blockentity.BlockEntityTrillium;
import dev.itsmeow.betteranimalsplus.client.model.ModelTrillium;
import dev.itsmeow.betteranimalsplus.client.model.ModelTrilliumMulti;
import dev.itsmeow.betteranimalsplus.client.model.ModelTrilliumMulti2;
import dev.itsmeow.betteranimalsplus.init.ModResources;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.world.entity.Entity;

import java.awt.*;

public class RenderBlockTrillium extends BlockEntityRenderer<BlockEntityTrillium> {

    public static ModelTrillium<Entity> singleT = new ModelTrillium<>();
    public static ModelTrilliumMulti<Entity> doubleT = new ModelTrilliumMulti<>();
    public static ModelTrilliumMulti2<Entity> tripleT = new ModelTrilliumMulti2<>();

    public RenderBlockTrillium(BlockEntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(BlockEntityTrillium blockEntity, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {
        float rotate = 0F;
        if (!blockEntity.getLevel().isEmptyBlock(blockEntity.getBlockPos())) {
            rotate = blockEntity.getRotation();
        }
        int modelNum = blockEntity.getModelNum();
        EntityModel<Entity> mainModel = (modelNum == 0 ? doubleT : (modelNum == 1 ? singleT : tripleT));

        matrixStackIn.pushPose();
        {
            matrixStackIn.translate(0.5F, 1.5F, 0.5F);
            matrixStackIn.mulPose(Vector3f.ZP.rotationDegrees(180F));

            matrixStackIn.pushPose();
            {
                Color color = new Color(blockEntity.getLevel().getBiome(blockEntity.getBlockPos()).getGrassColor(0, 0));
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
                mainModel.renderToBuffer(matrixStackIn, bufferIn.getBuffer(RenderType.entityCutout(blockEntity.getTexture())), combinedLightIn, combinedOverlayIn, 1F, 1F, 1F, 1F);
            }
            matrixStackIn.popPose();
        }
        matrixStackIn.popPose();
    }

}
