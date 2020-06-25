package its_meow.betteranimalsplus.client.renderer.tileentity;

import java.util.Random;

import com.mojang.blaze3d.matrix.MatrixStack;

import its_meow.betteranimalsplus.client.model.ModelHandOfFate;
import its_meow.betteranimalsplus.common.tileentity.TileEntityHandOfFate;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.entity.Entity;
import net.minecraft.particles.ParticleTypes;

public class RenderBlockHandOfFate extends TileEntityRenderer<TileEntityHandOfFate> {

    private ModelHandOfFate<Entity> mainModel;
    private Random rand = null;

    public RenderBlockHandOfFate(TileEntityRendererDispatcher dispatcher) {
        super(dispatcher);
        this.mainModel = new ModelHandOfFate<Entity>();
        this.rand = new Random();
    }

    private int i = 0;

    @Override
    public void render(TileEntityHandOfFate tileentity, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
        matrixStackIn.push();
        matrixStackIn.translate(0.5F, 1.5F, 0.5F);
        matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(180F));
        float rotate = 0F;
        if (!tileentity.getWorld().isAirBlock(tileentity.getPos())) {
            rotate = tileentity.getRotation();
        }
        this.mainModel.setRotationAngles(null, 0, 0, 0, rotate, 0);
        this.mainModel.render(matrixStackIn, bufferIn.getBuffer(RenderType.getEntitySolid(ModTextures.handoffate)), combinedLightIn, combinedOverlayIn, 1F, 1F, 1F, 1F);
        if (tileentity.isOnFire() && this.i % 5 == 0) {
            tileentity.getWorld().addParticle(ParticleTypes.FLAME,
                    tileentity.getPos().getX() + (this.rand.nextFloat() + 0.5F) / 2,
                    tileentity.getPos().getY() + this.rand.nextFloat(),
                    tileentity.getPos().getZ() + (this.rand.nextFloat() + 0.5F) / 2, 0, 0.02F, 0);
        }

        if (this.i == 300) {
            this.i = 0;
        }
        this.i++;
        matrixStackIn.pop();
    }

}
