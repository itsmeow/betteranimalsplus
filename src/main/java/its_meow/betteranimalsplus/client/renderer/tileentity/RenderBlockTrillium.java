package its_meow.betteranimalsplus.client.renderer.tileentity;

import java.awt.Color;

import its_meow.betteranimalsplus.client.model.ModelTrillium;
import its_meow.betteranimalsplus.client.model.ModelTrilliumMulti;
import its_meow.betteranimalsplus.client.model.ModelTrilliumMulti2;
import its_meow.betteranimalsplus.common.tileentity.TileEntityTrillium;
import its_meow.betteranimalsplus.init.TextureRegistry;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderBlockTrillium extends TileEntitySpecialRenderer<TileEntityTrillium> {

    public static ModelTrillium singleT = new ModelTrillium();
    public static ModelTrilliumMulti doubleT = new ModelTrilliumMulti();
    public static ModelTrilliumMulti2 tripleT = new ModelTrilliumMulti2();

    @Override
    public void render(TileEntityTrillium tileentity, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        float rotate = 0F;
        if (!tileentity.getWorld().isAirBlock(tileentity.getPos())) {
            rotate = tileentity.getRotation();
        }
        int modelNum = tileentity.getModelNum();
        ModelBase mainModel = (modelNum == 0 ? doubleT : (modelNum == 1 ? singleT : tripleT));

        GlStateManager.pushMatrix();
        {
            GlStateManager.translate(x + 0.5F, y + 1.5F, z + 0.5F);
            GlStateManager.rotate(180, 0, 0, 1);

            GlStateManager.pushMatrix();
            {
                Color color = new Color(tileentity.getWorld().getBiome(tileentity.getPos()).getGrassColorAtPos(tileentity.getPos()));
                float r = color.getRed() / 255F;
                float g = color.getGreen() / 255F;
                float b = color.getBlue() / 255F;
                r -= 20F / 255F;
                g -= 20F / 255F;
                b -= 20F / 255F;
                r = r > 255F ? 250F : r;
                g = g > 255F ? 250F : g;
                b = b > 255F ? 250F : b;
                GlStateManager.color(r, g, b);
                this.bindTexture(TextureRegistry.trillium_base);
                mainModel.render((Entity) null, 0F, 0F, 0F, rotate, 0F, 0.0625F);
                GlStateManager.color(1.0F, 1.0F, 1.0F);
            }
            GlStateManager.popMatrix();

            GlStateManager.pushMatrix();
            {
                this.bindTexture(tileentity.getTexture());
                mainModel.render((Entity) null, 0F, 0F, 0F, rotate, 0F, 0.0625F);
            }
            GlStateManager.popMatrix();
        }
        GlStateManager.popMatrix();
    }

}
