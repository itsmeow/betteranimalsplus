package its_meow.betteranimalsplus.common.tileentity;

import its_meow.betteranimalsplus.client.model.ModelWolfHead;
import its_meow.betteranimalsplus.init.TextureRegistry;
import net.minecraft.client.model.ModelBase;

public class TileEntityWolfHead extends TileEntityHead {
	
	public TileEntityWolfHead() {
		super(ModelWolfHead.class.asSubclass(ModelBase.class), 
				TextureRegistry.wolf_black,      // 1
				TextureRegistry.wolf_snowy,      // 2
				TextureRegistry.wolf_timber,     // 3
				TextureRegistry.coyote_hostile); // 4
	}
}
