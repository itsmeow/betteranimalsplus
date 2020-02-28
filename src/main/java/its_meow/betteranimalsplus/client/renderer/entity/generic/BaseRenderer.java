package its_meow.betteranimalsplus.client.renderer.entity.generic;

import java.util.function.Function;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.MobEntity;

public abstract class BaseRenderer<T extends MobEntity, M extends EntityModel<T>> extends MobRenderer<T, M> {

    public BaseRenderer(EntityRendererManager renderManagerIn, M entityModelIn, float shadowSizeIn) {
        super(renderManagerIn, entityModelIn, shadowSizeIn);
    }

    public BaseRenderer<T, M> layer(Function<BaseRenderer<T, M>, LayerRenderer<T, M>> layer) {
        this.addLayer(layer.apply(this));
        return this;
    }

}
