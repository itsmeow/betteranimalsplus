package its_meow.betteranimalsplus.client.renderer.entity;

import com.mojang.blaze3d.platform.GlStateManager;

import its_meow.betteranimalsplus.client.model.ModelSongbird;
import its_meow.betteranimalsplus.client.model.ModelSongbirdSmall;
import its_meow.betteranimalsplus.common.entity.EntitySongbird;
import its_meow.betteranimalsplus.init.ModTextures;
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
        if (this.entityModel.isChild) {
            GlStateManager.scaled(0.35D, 0.35D, 0.35D);
        } else {
            GlStateManager.scaled(0.5D, 0.5D, 0.5D);
        }
    }

    @Override
    public void doRender(EntitySongbird entity, double x, double y, double z, float entityYaw, float partialTicks) {
        if (entity.getTypeNumber() > 4) {
            this.entityModel = SMALL_SONG_BIRD;
        } else {
            this.entityModel = SONG_BIRD;
        }
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntitySongbird entity) {
        switch (entity.getTypeNumber()) {
        case 1:
            return ModTextures.songbird_1;
        case 2:
            return ModTextures.songbird_2;
        case 3:
            return ModTextures.songbird_3;
        case 4:
            return ModTextures.songbird_4;
        case 5:
            return ModTextures.songbird_small_1;
        case 6:
            return ModTextures.songbird_small_2;
        case 7:
            return ModTextures.songbird_small_3;
        case 8:
            return ModTextures.songbird_small_4;
        case 9:
            return ModTextures.songbird_small_5;
        case 10:
            return ModTextures.songbird_small_6;
        default:
            return ModTextures.songbird_1;
        }
    }

}
