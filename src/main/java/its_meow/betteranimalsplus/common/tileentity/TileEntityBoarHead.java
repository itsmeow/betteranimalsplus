package its_meow.betteranimalsplus.common.tileentity;

import its_meow.betteranimalsplus.client.model.ModelBoarHead;
import its_meow.betteranimalsplus.init.TextureRegistry;
import net.minecraft.client.renderer.entity.model.ModelBase;

public class TileEntityBoarHead extends TileEntityHead {

	public TileEntityBoarHead() {
		super(ModelBoarHead.class.asSubclass(ModelBase.class), TileEntityBoarHead.class, 0F, TextureRegistry.boar_1, TextureRegistry.boar_2, TextureRegistry.boar_3, TextureRegistry.boar_4);
	}

}
