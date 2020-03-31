package its_meow.betteranimalsplus.client.renderer.entity;

import java.util.Calendar;

import its_meow.betteranimalsplus.client.model.ModelDeer;
import its_meow.betteranimalsplus.common.entity.EntityDeer;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderDeer extends RenderLiving<EntityDeer> {

    private static boolean isChristmas = false;
    static {
        Calendar calendar = Calendar.getInstance();
        isChristmas = calendar.get(2) + 1 == 12 && calendar.get(5) >= 24 && calendar.get(5) <= 26;
    }

    public RenderDeer(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelDeer(), 1F);

    }

    @Override
    protected void preRenderCallback(EntityDeer entitylivingbaseIn, float partialTickTime) {
        if(this.getMainModel().isChild) {
            GlStateManager.scale(0.6D, 0.6D, 0.6D);
        } else {
            GlStateManager.scale(1.0D, 1.0D, 1.0D);
        }
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityDeer entity) {
        int type = entity.getTypeNumber();
        if(isChristmas) {
            switch(type) {
            case 1:
                return ModTextures.deer_1_christmas;
            case 2:
                return this.getMainModel().isChild ? ModTextures.deer_1_christmas : ModTextures.deer_2_christmas;
            case 3:
                return this.getMainModel().isChild ? ModTextures.deer_4_christmas : ModTextures.deer_3_christmas;
            case 4:
                return ModTextures.deer_4_christmas;
            default:
                return ModTextures.deer_1_christmas;
            }
        } else {
            switch(type) {
            case 1:
                return ModTextures.deer_1;
            case 2:
                return this.getMainModel().isChild ? ModTextures.deer_1 : ModTextures.deer_2;
            case 3:
                return this.getMainModel().isChild ? ModTextures.deer_4 : ModTextures.deer_3;
            case 4:
                return ModTextures.deer_4;
            default:
                return ModTextures.deer_1;
            }
        }
    }

}
