package its_meow.betteranimalsplus.client.renderer.entity;

import com.mojang.blaze3d.platform.GlStateManager;

import its_meow.betteranimalsplus.client.model.ModelSongbird;
import its_meow.betteranimalsplus.client.model.ModelSongbirdSmall;
import its_meow.betteranimalsplus.common.entity.EntitySongbird;
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
    protected void preRenderCallback(EntitySongbird entity, float partialTickTime) {
        if(this.entityModel.isChild) {
            GlStateManager.scaled(0.35D, 0.35D, 0.35D);
        } else {
            GlStateManager.scaled(0.5D, 0.5D, 0.5D);
        }
    }

    @Override
    public void doRender(EntitySongbird entity, double x, double y, double z, float entityYaw, float partialTicks) {
        if(entity.getVariantName().startsWith("small")) {
            this.entityModel = SMALL_SONG_BIRD;
        } else {
            this.entityModel = SONG_BIRD;
        }
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntitySongbird entity) {
        return entity.getVariantTexture();
    }

}
