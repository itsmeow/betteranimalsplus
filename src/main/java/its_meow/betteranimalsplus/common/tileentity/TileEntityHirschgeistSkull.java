package its_meow.betteranimalsplus.common.tileentity;

import its_meow.betteranimalsplus.client.model.ModelHirschgeistSkull;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.model.ModelBase;

public class TileEntityHirschgeistSkull extends TileEntityHead {

    public TileEntityHirschgeistSkull() {
        super(ModelHirschgeistSkull.class.asSubclass(ModelBase.class), 0F, ModTextures.hirschgeist);
    }

}
