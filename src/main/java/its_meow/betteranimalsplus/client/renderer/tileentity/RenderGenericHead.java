package its_meow.betteranimalsplus.client.renderer.tileentity;

import java.util.HashMap;

import javax.annotation.Nullable;

import com.mojang.blaze3d.matrix.MatrixStack;

import its_meow.betteranimalsplus.common.block.BlockGenericSkull;
import its_meow.betteranimalsplus.common.tileentity.TileEntityHead;
import its_meow.betteranimalsplus.util.HeadType;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.entity.Entity;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;

public class RenderGenericHead extends TileEntityRenderer<TileEntityHead> {

    public static HashMap<HeadType, EntityModel<?>> modelMap = new HashMap<HeadType, EntityModel<? extends Entity>>();

    public RenderGenericHead(TileEntityRendererDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(TileEntityHead te, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
        BlockState iblockstate = te.getBlockState();
        if(iblockstate == null || !(iblockstate.getBlock() instanceof BlockGenericSkull)) {
            return;
        }
        Direction enumfacing = te.getDirection();
        enumfacing = enumfacing == null ? Direction.NORTH : enumfacing;
        float rotation = -enumfacing.getHorizontalAngle();
        rotation = (enumfacing == Direction.NORTH || enumfacing == Direction.SOUTH) ? enumfacing.getOpposite().getHorizontalAngle() : rotation;
        rotation = (enumfacing == Direction.UP) ? te.getTopRotation() : rotation;

        EntityModel<? extends Entity> model = modelMap.get(te.getHeadType());
        if(model == null) {
            EntityModel<? extends Entity> newModel = te.getNewModel();
            modelMap.put(te.getHeadType(), newModel);
            model = newModel;
        }

        this.render(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn, enumfacing, rotation, te.getTexture(), model, te.getOffset());
    }

    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, int packedOverlayIn, @Nullable Direction facing, float skullRotation, ResourceLocation texture, EntityModel<? extends Entity> model, float yOffset) {
        matrixStackIn.push();
        translateHead(matrixStackIn, facing, 1.5F + yOffset);
        matrixStackIn.scale(-1.0F, -1.0F, 1.0F);
        float rotX = 0F;
        if(facing != null) {
            rotX = facing == Direction.UP ? -90F : 0.0F;
        }
        model.setRotationAngles(null, skullRotation, rotX, 0.0F, 0.0F, 0.0F);
        model.render(matrixStackIn, bufferIn.getBuffer(RenderType.getEntityCutoutNoCull(texture)), packedLightIn, packedOverlayIn, 1F, 1F, 1F, 1F);
        matrixStackIn.pop();

    }

    private static void translateHead(MatrixStack matrixStackIn, Direction face, float yOffset) {
        if(face == null) {
            matrixStackIn.translate(0.5F, 0.25F + yOffset + 0.3F, 1.0F);
            return;
        }
        switch(face) {
        case NORTH:
            matrixStackIn.translate(0.5F, 0.25F + yOffset + 0.3F, 1.0F);
            break;
        case EAST:
            matrixStackIn.translate(0F, 0.25F + yOffset + 0.3F, 0.5F);
            break;
        case SOUTH:
            matrixStackIn.translate(0.5F, 0.25F + yOffset + 0.3F, 0F);
            break;
        case WEST:
            matrixStackIn.translate(1F, 0.25F + yOffset + 0.3F, 0.5F);
            break;
        case UP:
            matrixStackIn.translate(0.5F, 0.18F + yOffset, 0.5F);
            break;
        default:
            matrixStackIn.translate(0F, 0.25F + yOffset + 0.3F, 0.5F);
            break;
        }
    }

}
