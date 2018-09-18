package its_meow.betteranimalsplus.block.render;

import java.util.Random;

import javax.annotation.Nonnull;

import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.block.BlockTrillium;
import its_meow.betteranimalsplus.block.TileEntityTrillium;
import its_meow.betteranimalsplus.entity.EntityTrillium;
import its_meow.betteranimalsplus.entity.model.ModelTrilliumMulti;
import its_meow.betteranimalsplus.entity.render.RenderTrillium.Factory;
import its_meow.betteranimalsplus.registry.TextureRegistry;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.animation.FastTESR;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderBlockTrillium extends TileEntitySpecialRenderer<TileEntityTrillium> {
	
	ModelTrilliumMulti mainModel;

    public static final ResourceLocation loc1 = new ResourceLocation(Ref.MOD_ID, "textures/entities/flora/trillium.png");
    public static final ResourceLocation loc2 = new ResourceLocation(Ref.MOD_ID, "textures/entities/flora/trillium.png");

	public RenderBlockTrillium() {
		mainModel = new ModelTrilliumMulti();
	}



	@Override
    public void render(TileEntityTrillium tileentity, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        super.render(tileentity, x, y, z, partialTicks, destroyStage, alpha);
		GlStateManager.pushMatrix();
        GlStateManager.translate(x,y,z);
        GlStateManager.rotate(180, 0, 0, 1);
        this.bindTexture((new Random()).nextBoolean() ? loc1 : loc2);
        this.mainModel.render((Entity) null, 0F, 0F, 0F, 0F, 0F, 0.125F);
        GlStateManager.popMatrix();
    }


	
}
