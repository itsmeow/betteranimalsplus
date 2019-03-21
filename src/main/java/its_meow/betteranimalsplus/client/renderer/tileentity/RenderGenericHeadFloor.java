package its_meow.betteranimalsplus.client.renderer.tileentity;

import com.mojang.authlib.GameProfile;

import its_meow.betteranimalsplus.common.tileentity.TileEntityHead;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGenericHeadFloor extends TileEntitySpecialRenderer<TileEntityHead> {

    @Override
    public void render(TileEntityHead tile, double x, double y, double z, float partialTickTime, int destroyStage, float alpha) {
        this.renderHead((float) x, (float) y, (float) z, tile.getBlockMetadata() & 7, tile.getSkullRotation() * 360 / 16.0F, tile.getPlayerProfile(), tile.getModel(), destroyStage, tile.getTexture(), tile.getOffset());
    }

    private void renderHead(float x, float y, float z, int meta, float skullRotation, GameProfile profile, ModelBase model, int destroyStage, ResourceLocation texture, float offset) {

        this.bindTexture(texture);

        GlStateManager.pushMatrix();

        this.translateHead(x, y, z, meta, 1.5F + offset);

        float newRotation = this.adjustRotation(meta, skullRotation);
        float skullRotationX = this.adjustRotationX(meta);

        GlStateManager.scale(-1.0F, -1.0F, 1.0F);

        model.render((Entity) null, newRotation, skullRotationX, 0, 0, 0, 0.0625F);

        GlStateManager.popMatrix();
    }

    private void translateHead(float x, float y, float z, int meta, float yOffset) {
        switch (meta) {
        case 1:
            GlStateManager.translate(x + 0.5F, y + yOffset + 0.15F, z + 0.5F);
            break;
        case 2:
            GlStateManager.translate(x + 0.5F, y + 0.25F + yOffset + 0.3F, z + 0.74F + 0.25F);
            break;
        case 3:
            GlStateManager.translate(x + 0.5F, y + 0.25F + yOffset + 0.3F, z + 0.26F - 0.25F);
            break;
        case 4:
            GlStateManager.translate(x + 0.74F + 0.25F, y + 0.25F + yOffset + 0.3F, z + 0.5F);
            break;
        default:
            GlStateManager.translate(x + 0.26F - 0.25F, y + 0.25F + yOffset + 0.3F, z + 0.5F);
            break;
        }
    }

    private float adjustRotation(int meta, float rotation) {
        switch (meta) {
        case 1:
            return rotation;
        case 2:
            return rotation;
        case 3:
            return 180.0F;
        case 4:
            return 270.0F;
        default:
            return 90.0F;
        }
    }

    private float adjustRotationX(int meta) {
        if (meta != 1) {
            return 0.0F;
        }
        return 0.0F;
    }

}
