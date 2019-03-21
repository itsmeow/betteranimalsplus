package its_meow.betteranimalsplus.client.renderer.tileentity;

import java.util.Random;

import its_meow.betteranimalsplus.client.model.ModelHandOfFate;
import its_meow.betteranimalsplus.common.tileentity.TileEntityHandOfFate;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.init.Particles;

public class RenderBlockHandOfFate extends TileEntityRenderer<TileEntityHandOfFate> {

    ModelHandOfFate mainModel;
    Random rand = null;

    public RenderBlockHandOfFate() {
        this.mainModel = new ModelHandOfFate();
        this.rand = new Random();
    }

    private int i = 0;

    @Override
    public void render(TileEntityHandOfFate tileentity, double x, double y, double z, float partialTicks,
            int destroyStage) {
        GlStateManager.pushMatrix();
        GlStateManager.translated(x + 0.5F, y + 1.5F, z + 0.5F);
        GlStateManager.rotatef(180, 0, 0, 1);
        this.bindTexture(ModTextures.handoffate);
        float rotate = 0F;
        if (!tileentity.getWorld().isAirBlock(tileentity.getPos())) {
            rotate = tileentity.getRotation();
        }
        this.mainModel.render((Entity) null, (float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F, rotate, 0F, 0.0625F);

        if (tileentity.isOnFire() && this.i % 5 == 0) {
            tileentity.getWorld().spawnParticle(Particles.FLAME,
                    tileentity.getPos().getX() + (this.rand.nextFloat() + 0.5F) / 2,
                    tileentity.getPos().getY() + this.rand.nextFloat(),
                    tileentity.getPos().getZ() + (this.rand.nextFloat() + 0.5F) / 2, 0, 0.02F, 0);
        }

        if (this.i == 300) {
            this.i = 0;
        }
        this.i++;
        GlStateManager.popMatrix();
    }

}
