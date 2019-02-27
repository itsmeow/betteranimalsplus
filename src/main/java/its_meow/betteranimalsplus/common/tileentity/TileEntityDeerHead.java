package its_meow.betteranimalsplus.common.tileentity;

import java.util.Calendar;

import its_meow.betteranimalsplus.client.model.ModelDeerHead;
import its_meow.betteranimalsplus.init.TextureRegistry;
import net.minecraft.util.ResourceLocation;

public class TileEntityDeerHead extends TileEntityHead {

	private boolean isChristmas = false;

	public TileEntityDeerHead() {
		super(ModelDeerHead.class, TileEntityDeerHead.class, 0F, TextureRegistry.deer_1, TextureRegistry.deer_2);
		Calendar calendar = Calendar.getInstance();

		if(calendar.get(2) + 1 == 12 && calendar.get(5) >= 24 && calendar.get(5) <= 26) {
			this.isChristmas = true;
		}
	}

	@Override
	public ResourceLocation getTexture() {
		if(!this.isChristmas) {
			if(this.typeNum == 1) {
				return TextureRegistry.deer_1;
			}
			return TextureRegistry.deer_2;
		} else {
			if(this.typeNum == 1) {
				return TextureRegistry.deer_1_christmas;
			}
			return TextureRegistry.deer_2_christmas;
		}
	}

}
