package its_meow.betteranimalsplus.common.tileentity;

import its_meow.betteranimalsplus.client.model.ModelFoxHead;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.model.ModelBase;

public class TileEntityFoxHead extends TileEntityHead {

    public TileEntityFoxHead() {
        super(ModelFoxHead.class.asSubclass(ModelBase.class), -0.1F, ModTextures.fox_1, ModTextures.fox_2, ModTextures.fox_3, ModTextures.fox_4);
    }

}
