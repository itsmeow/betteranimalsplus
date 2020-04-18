package its_meow.betteranimalsplus.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;

import its_meow.betteranimalsplus.client.model.ModelBeakedWhale;
import its_meow.betteranimalsplus.client.model.ModelSmallWhale;
import its_meow.betteranimalsplus.common.entity.EntityWhale;
import net.minecraft.client.renderer.IRenderTypeBuffer;
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
    protected void preRenderCallback(EntityWhale entity, MatrixStack stack, float partialTickTime) {
        switch(entity.getVariantName()) {
        case "cuviers": stack.scale(1.7F, 1.7F, 1.7F); break;
        case "bottlenose": stack.scale(2.5F, 2.5F, 2.5F); break;
        case "false_killer": stack.scale(1.8F, 1.8F, 1.8F); break;
        case "beluga": stack.scale(1.5F, 1.5F, 1.5F); break;
        case "pilot": stack.scale(2.0F, 2.0F, 2.0F); break;
        case "narwhal": stack.scale(1.6F, 1.6F, 1.6F); break;
        }
    }

    @Override
    public void render(EntityWhale entity, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        if(entity.getVariantName().equals("cuviers") || entity.getVariantName().equals("bottlenose")) {
            this.entityModel = BEAKED_WHALE;
        } else {
            this.entityModel = SMALL_WHALE;
        }
        super.render(entity, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityWhale entity) {
        return entity.getVariantTexture();
    }

}
