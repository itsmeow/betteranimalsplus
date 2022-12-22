package dev.itsmeow.betteranimalsplus.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import dev.itsmeow.betteranimalsplus.Ref;
import dev.itsmeow.betteranimalsplus.client.model.block.ModelTrillium;
import dev.itsmeow.betteranimalsplus.client.model.block.ModelTrilliumMulti;
import dev.itsmeow.betteranimalsplus.client.model.block.ModelTrilliumMulti2;
import dev.itsmeow.betteranimalsplus.common.blockentity.BlockEntityTrillium;
import dev.itsmeow.betteranimalsplus.init.ModResources;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class RenderBlockTrillium implements BlockEntityRenderer<BlockEntityTrillium> {

    public static final ModelLayerLocation TRILLIUM_SINGLE = new ModelLayerLocation(new ResourceLocation(Ref.MOD_ID, "trillium_single"), "main");
    public static final ModelLayerLocation TRILLIUM_DOUBLE = new ModelLayerLocation(new ResourceLocation(Ref.MOD_ID, "trillium_double"), "main");
    public static final ModelLayerLocation TRILLIUM_TRIPLE = new ModelLayerLocation(new ResourceLocation(Ref.MOD_ID, "trillium_triple"), "main");
    public ModelTrillium<Entity> singleT;
    public ModelTrilliumMulti<Entity> doubleT;
    public ModelTrilliumMulti2<Entity> tripleT;

    public RenderBlockTrillium(BlockEntityRendererProvider.Context ctx) {
        singleT = new ModelTrillium<>(ctx.bakeLayer(TRILLIUM_SINGLE));
        doubleT = new ModelTrilliumMulti<>(ctx.bakeLayer(TRILLIUM_DOUBLE));
        tripleT = new ModelTrilliumMulti2<>(ctx.bakeLayer(TRILLIUM_TRIPLE));
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
            matrixStackIn.mulPose(Axis.ZP.rotationDegrees(180F));

            matrixStackIn.pushPose();
            {
                int color = BiomeColors.getAverageGrassColor(blockEntity.getLevel(), blockEntity.getBlockPos());
                float r = ((color >> 16) & 0xFF) / 255F;
                float g = ((color >> 8) & 0xFF) / 255F;
                float b = (color & 0xFF) / 255F;
                r -= 20F / 255F;
                g -= 20F / 255F;
                b -= 20F / 255F;
                r = Mth.clamp(r, 0F, 1F);
                g = Mth.clamp(g, 0F, 1F);
                b = Mth.clamp(b, 0F, 1F);
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
