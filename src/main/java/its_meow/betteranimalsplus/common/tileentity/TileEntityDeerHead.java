package its_meow.betteranimalsplus.common.tileentity;

import its_meow.betteranimalsplus.client.model.ModelDeerHead;
import its_meow.betteranimalsplus.init.TextureRegistry;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;

public class TileEntityDeerHead extends TileEntityHead {

	public TileEntityDeerHead() {
		super(ModelDeerHead.class.asSubclass(ModelBase.class), TextureRegistry.deer_1, TextureRegistry.deer_2);
	}

}
