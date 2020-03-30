package its_meow.betteranimalsplus.client.renderer.entity;

import com.mojang.blaze3d.platform.GlStateManager;

import its_meow.betteranimalsplus.client.model.ModelBeakedWhale;
import its_meow.betteranimalsplus.client.model.ModelSmallWhale;
import its_meow.betteranimalsplus.common.entity.EntityWhale;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;

public class RenderWhale extends MobRenderer<EntityWhale, EntityModel<EntityWhale>> {

    public static final EntityModel<EntityWhale> SMALL_WHALE = new ModelSmallWhale<EntityWhale>();
    public static final EntityModel<EntityWhale> BEAKED_WHALE = new ModelBeakedWhale<EntityWhale>();

    public RenderWhale(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, SMALL_WHALE, 3F);
    }

    @Override
    protected void preRenderCallback(EntityWhale entity, float partialTickTime) {
        switch(entity.getVariantName()) {
        case "cuviers": GlStateManager.scaled(1.7D, 1.7D, 1.7D); break;
        case "bottlenose": GlStateManager.scaled(2.5D, 2.5D, 2.5D); break;
        case "false_killer": GlStateManager.scaled(1.8D, 1.8D, 1.8D); break;
        case "beluga": GlStateManager.scaled(1.5D, 1.5D, 1.5D); break;
        case "pilot": GlStateManager.scaled(2.0D, 2.0D, 2.0D); break;
        case "narwhal": GlStateManager.scaled(1.6D, 1.6D, 1.6D); break;
        }
    }

    @Override
    public void doRender(EntityWhale entity, double x, double y, double z, float entityYaw, float partialTicks) {
        if(entity.getVariantName().equals("cuviers") || entity.getVariantName().equals("bottlenose")) {
            this.entityModel = BEAKED_WHALE;
        } else {
            this.entityModel = SMALL_WHALE;
        }
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityWhale entity) {
        return entity.getVariantTexture();
    }

}
