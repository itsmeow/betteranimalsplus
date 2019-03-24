package its_meow.betteranimalsplus.common.tileentity;

import its_meow.betteranimalsplus.client.model.ModelBoarHead;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.model.ModelBase;

public class TileEntityBoarHead extends TileEntityHead {

    public TileEntityBoarHead() {
        super(ModelBoarHead.class.asSubclass(ModelBase.class), 0F, ModTextures.boar_1, ModTextures.boar_2, ModTextures.boar_3, ModTextures.boar_4);
    }

}
