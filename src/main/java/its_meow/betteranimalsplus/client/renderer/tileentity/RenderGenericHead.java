package its_meow.betteranimalsplus.client.renderer.tileentity;

import java.util.HashMap;

import javax.annotation.Nullable;

import com.mojang.blaze3d.platform.GlStateManager;

import its_meow.betteranimalsplus.common.block.BlockAnimalSkull;
import its_meow.betteranimalsplus.common.tileentity.TileEntityHead;
import its_meow.betteranimalsplus.util.HeadType;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;

public class RenderGenericHead extends TileEntityRenderer<TileEntityHead> {

    public static HashMap<HeadType, EntityModel<Entity>> modelMap = new HashMap<HeadType, EntityModel<Entity>>();

    @Override
    public void render(TileEntityHead te, double x, double y, double z, float partialTicks, int destroyStage) {

        BlockState iblockstate = te.getBlockState();
        if(iblockstate == null || !(iblockstate.getBlock() instanceof BlockAnimalSkull)) {
            return;
        }
        Direction enumfacing = iblockstate.get(BlockAnimalSkull.FACING_EXCEPT_DOWN);
        enumfacing = enumfacing == null ? Direction.NORTH : enumfacing;
        float rotation = -enumfacing.getHorizontalAngle();
        rotation = (enumfacing == Direction.NORTH || enumfacing == Direction.SOUTH)
                ? enumfacing.getOpposite().getHorizontalAngle()
                : rotation;
        rotation = (enumfacing == Direction.UP) ? te.getSkullRotation() : rotation;

        EntityModel<Entity> model = modelMap.get(te.type);
        if (model == null) {
            EntityModel<Entity> newModel = te.getModel();
            modelMap.put(te.type, newModel);
            model = newModel;
        }

        this.render((float) x, (float) y, (float) z, enumfacing, rotation, destroyStage, te.getTexture(), model,
                te.getOffset());
    }

    public void render(float x, float y, float z, @Nullable Direction facing, float skullRotation, int destroyStage,
                       ResourceLocation texture, EntityModel<Entity> model, float yOffset) {
        if (destroyStage >= 0) {
            this.bindTexture(DESTROY_STAGES[destroyStage]);
            GlStateManager.matrixMode(5890);
            GlStateManager.pushMatrix();
            GlStateManager.scalef(4.0F, 2.0F, 1.0F);
            GlStateManager.translatef(0.0625F, 0.0625F, 0.0625F);
            GlStateManager.matrixMode(5888);
        } else if(texture != null) {
            this.bindTexture(texture);
        }

        GlStateManager.pushMatrix();
        GlStateManager.disableCull();
        translateHead(x, y, z, facing, 1.5F + yOffset);

        GlStateManager.enableRescaleNormal();
        GlStateManager.scalef(-1.0F, -1.0F, 1.0F);
        GlStateManager.enableAlphaTest();
        float rotX = 0F;
        if (facing != null) {
            rotX = facing == Direction.UP ? -90F : 0.0F;
        }
        model.render((Entity) null, skullRotation, rotX, 0.0F, 0.0F, 0.0F, 0.0625F);
        GlStateManager.popMatrix();
        if (destroyStage >= 0) {
            GlStateManager.matrixMode(5890);
            GlStateManager.popMatrix();
            GlStateManager.matrixMode(5888);
        }

    }

    private static void translateHead(float x, float y, float z, Direction face, float yOffset) {
        if (face == null) {
            GlStateManager.translatef(x + 0.5F, y + 0.25F + yOffset + 0.3F, z + 1.0F);
            return;
        }
        switch (face) {
        case NORTH:
            GlStateManager.translatef(x + 0.5F, y + 0.25F + yOffset + 0.3F, z + 1.0F);
            break;
        case EAST:
            GlStateManager.translatef(x, y + 0.25F + yOffset + 0.3F, z + 0.5F);
            break;
        case SOUTH:
            GlStateManager.translatef(x + 0.5F, y + 0.25F + yOffset + 0.3F, z + 0.26F - 0.25F);
            break;
        case WEST:
            GlStateManager.translatef(x + 0.74F + 0.25F, y + 0.25F + yOffset + 0.3F, z + 0.5F);
            break;
        case UP:
            GlStateManager.translatef(x + 0.74F - 0.25F, y + 0.18F + yOffset, z + 0.5F);
            break;
        default:
            GlStateManager.translatef(x + 0.26F - 0.25F, y + 0.25F + yOffset + 0.3F, z + 0.5F);
            break;
        }
    }

}
