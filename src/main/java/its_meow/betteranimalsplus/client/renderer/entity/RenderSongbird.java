package its_meow.betteranimalsplus.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;

import its_meow.betteranimalsplus.client.model.ModelSongbird;
import its_meow.betteranimalsplus.client.model.ModelSongbirdSmall;
import its_meow.betteranimalsplus.common.entity.EntitySongbird;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;

public class RenderSongbird extends MobRenderer<EntitySongbird, EntityModel<EntitySongbird>> {

    public static final EntityModel<EntitySongbird> SONG_BIRD = new ModelSongbird<EntitySongbird>();
    public static final EntityModel<EntitySongbird> SMALL_SONG_BIRD = new ModelSongbirdSmall<EntitySongbird>();

    public RenderSongbird(EntityRendererManager mgr) {
        super(mgr, SONG_BIRD, 0.3F);
    }

    @Override
    protected void preRenderCallback(EntitySongbird entity, MatrixStack matrixStackIn, float partialTickTime) {
        if (this.entityModel.isChild) {
            matrixStackIn.scale(0.35F, 0.35F, 0.35F);
        } else {
            matrixStackIn.scale(0.5F, 0.5F, 0.5F);
        }
    }

    @Override
    public void render(EntitySongbird entity, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        if(entity.getVariantName().startsWith("small")) {
            this.entityModel = SMALL_SONG_BIRD;
        } else {
            this.entityModel = SONG_BIRD;
        }
        super.render(entity, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    @Override
    public ResourceLocation getEntityTexture(EntitySongbird entity) {
        return entity.getVariantTexture();
    }

}
