package its_meow.betteranimalsplus.common.tileentity;

import its_meow.betteranimalsplus.client.model.ModelReindeerHead;
import its_meow.betteranimalsplus.init.TextureRegistry;
import net.minecraft.client.model.ModelBase;

public class TileEntityReindeerHead extends TileEntityHead {
	
	public TileEntityReindeerHead() {
		super(ModelReindeerHead.class.asSubclass(ModelBase.class), TextureRegistry.reindeer_1, TextureRegistry.reindeer_2, TextureRegistry.reindeer_3, TextureRegistry.reindeer_4);
	}
	
}
