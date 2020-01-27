package its_meow.betteranimalsplus.client.renderer.entity;

import java.util.Calendar;

import com.mojang.blaze3d.matrix.MatrixStack;

import its_meow.betteranimalsplus.client.model.ModelDeer;
import its_meow.betteranimalsplus.common.entity.EntityDeer;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderDeer extends MobRenderer<EntityDeer, ModelDeer<EntityDeer>> {

    private boolean isChristmas = false;

    public RenderDeer(EntityRendererManager rendermanagerIn) {
        super(rendermanagerIn, new ModelDeer<EntityDeer>(), 1F);
        Calendar calendar = Calendar.getInstance();

        if (calendar.get(2) + 1 == 12 && calendar.get(5) >= 24 && calendar.get(5) <= 26) {
            this.isChristmas = true;
        }
    }

    @Override
    protected void preRenderCallback(EntityDeer entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        if (this.entityModel.isChild) {
            matrixStackIn.scale(0.6F, 0.6F, 0.6F);
        } else {
            matrixStackIn.scale(1.0F, 1.0F, 1.0F);
        }
    }

    @Override
    public ResourceLocation getEntityTexture(EntityDeer entity) {
        int type = entity.getTypeNumber();
        if (!this.isChristmas) {
            if (this.entityModel.isChild) {
                return ModTextures.deer_1;
            }
            if (type == 1) {
                return ModTextures.deer_1;
            }
            return ModTextures.deer_2;
        } else {
            if (this.entityModel.isChild) {
                return ModTextures.deer_1_christmas;
            }
            if (type == 1) {
                return ModTextures.deer_1_christmas;
            }
            return ModTextures.deer_2_christmas;
        }
    }

}
