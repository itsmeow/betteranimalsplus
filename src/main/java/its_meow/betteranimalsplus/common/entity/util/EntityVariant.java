package its_meow.betteranimalsplus.common.entity.util;

import its_meow.betteranimalsplus.Ref;
import net.minecraft.util.ResourceLocation;

public class EntityVariant implements IVariant {

    protected String name;
    protected ResourceLocation texture;
    protected boolean hasHead = true;
    
    public EntityVariant(String nameTexture) {
        this.texture = new ResourceLocation(Ref.MOD_ID, "textures/entities/" + nameTexture + ".png");
        this.name = nameTexture;
    }
    
    public EntityVariant(String nameTexture, boolean hasHead) {
        this.texture = new ResourceLocation(Ref.MOD_ID, "textures/entities/" + nameTexture + ".png");
        this.hasHead = hasHead;
    }

    public EntityVariant(String name, String texture) {
       this.texture = new ResourceLocation(Ref.MOD_ID, "textures/entities/" + texture + ".png");
       this.name = name;
    }
    
    public EntityVariant(String name, String texture, boolean hasHead) {
        this.texture = new ResourceLocation(Ref.MOD_ID, "textures/entities/" + texture + ".png");
        this.name = name;
        this.hasHead = hasHead;
     }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ResourceLocation getTexture() {
        return texture;
    }

    @Override
    public boolean hasHead() {
        return hasHead;
    }

}
