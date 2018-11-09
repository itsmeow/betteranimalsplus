package its_meow.betteranimalsplus.common.tileentity;

import its_meow.betteranimalsplus.client.model.ModelHirschgeistSkull;
import its_meow.betteranimalsplus.init.TextureRegistry;
import net.minecraft.client.model.ModelBase;

public class TileEntityHirschgeistSkull extends TileEntityHead {

	public TileEntityHirschgeistSkull() {
		super(ModelHirschgeistSkull.class.asSubclass(ModelBase.class), TextureRegistry.hirschgeist);
	}

}
