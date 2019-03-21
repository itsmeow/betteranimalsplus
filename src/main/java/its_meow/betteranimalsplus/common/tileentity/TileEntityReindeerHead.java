package its_meow.betteranimalsplus.common.tileentity;

import its_meow.betteranimalsplus.client.model.ModelReindeerHead;
import its_meow.betteranimalsplus.init.TextureRegistry;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;

public class TileEntityReindeerHead extends TileEntityHead {

    public TileEntityReindeerHead() {
        super(ModelReindeerHead.class.asSubclass(ModelBase.class), 0F, TextureRegistry.reindeer_1, TextureRegistry.reindeer_2, TextureRegistry.reindeer_3, TextureRegistry.reindeer_4);
    }

    @Override
    public ResourceLocation getTexture() {
        if (this.typeNum <= 4) {
            return this.textures.get(this.typeNum);
        } else {
            return getEntityTexture(this.typeNum);
        }
    }

    protected static ResourceLocation getEntityTexture(int type) {
        switch (type) {
        case 1:
            return TextureRegistry.reindeer_1;
        case 2:
            return TextureRegistry.reindeer_2;
        case 3:
            return TextureRegistry.reindeer_3;
        case 4:
            return TextureRegistry.reindeer_4;
        case 5:
            return TextureRegistry.reindeer_1_christmas;
        case 6:
            return TextureRegistry.reindeer_2_christmas;
        case 7:
            return TextureRegistry.reindeer_3_christmas;
        case 8:
            return TextureRegistry.reindeer_4_christmas;
        default:
            return TextureRegistry.reindeer_1;
        }
    }

}
