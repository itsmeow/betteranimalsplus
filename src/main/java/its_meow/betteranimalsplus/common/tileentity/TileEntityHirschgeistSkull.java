package its_meow.betteranimalsplus.common.tileentity;

import its_meow.betteranimalsplus.client.model.ModelHirschgeistSkull;
import its_meow.betteranimalsplus.init.TextureRegistry;
import net.minecraft.client.renderer.entity.model.ModelBase;
import net.minecraft.tileentity.TileEntityType;

public class TileEntityHirschgeistSkull extends TileEntityHead {

	public static final TileEntityType<TileEntityHirschgeistSkull> HIRSCHGEIST_SKULL_TYPE = TileEntityType.Builder.create(TileEntityHirschgeistSkull::new).build(null);

	public TileEntityHirschgeistSkull() {
		super(ModelHirschgeistSkull.class.asSubclass(ModelBase.class), 0F, TextureRegistry.hirschgeist);
	}

}
