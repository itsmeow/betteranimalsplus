package its_meow.betteranimalsplus.client.renderer.entity.layers;

import java.util.function.Predicate;

import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.util.ResourceLocation;

public class LayerEyesCondition<T extends TameableEntity, A extends EntityModel<T>> extends LayerEyes<T, A> {
    
    protected final Predicate<T> condition;

    public LayerEyesCondition(MobRenderer<T, A> baseRenderer, ResourceLocation texture, Predicate<T> showLayer) {
        super(baseRenderer, texture);
        this.condition = showLayer;
    }

    @Override
    public void render(T entity, float p_212842_2_, float p_212842_3_, float p_212842_4_, float p_212842_5_, float p_212842_6_, float p_212842_7_, float p_212842_8_) {
        if(condition.test(entity)) {
            super.render(entity, p_212842_2_, p_212842_3_, p_212842_4_, p_212842_5_, p_212842_6_, p_212842_7_, p_212842_8_);
        }
    }

}
