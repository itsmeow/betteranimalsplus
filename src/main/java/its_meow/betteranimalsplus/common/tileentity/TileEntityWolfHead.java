package its_meow.betteranimalsplus.common.tileentity;

import its_meow.betteranimalsplus.client.model.ModelWolfHead;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.model.ModelBase;

public class TileEntityWolfHead extends TileEntityHead {

    public TileEntityWolfHead() {
        super(ModelWolfHead.class.asSubclass(ModelBase.class), 0F, ModTextures.wolf_black,      // 1
                ModTextures.wolf_snowy,      // 2
                ModTextures.wolf_timber,     // 3
                ModTextures.coyote_hostile); // 4
    }
}
