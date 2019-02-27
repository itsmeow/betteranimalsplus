package its_meow.betteranimalsplus.common.tileentity;

import its_meow.betteranimalsplus.client.model.ModelFoxHead;
import its_meow.betteranimalsplus.init.TextureRegistry;
import net.minecraft.client.renderer.entity.model.ModelBase;

public class TileEntityFoxHead extends TileEntityHead {

	public TileEntityFoxHead() {
		super(ModelFoxHead.class.asSubclass(ModelBase.class), TileEntityFoxHead.class, -0.1F, TextureRegistry.fox_1,
				TextureRegistry.fox_2, TextureRegistry.fox_3, TextureRegistry.fox_4);
	}

}
