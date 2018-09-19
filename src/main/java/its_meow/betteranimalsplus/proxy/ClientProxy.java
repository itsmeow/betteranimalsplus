package its_meow.betteranimalsplus.proxy;

import its_meow.betteranimalsplus.block.TileEntityHirschgeistSkull;
import its_meow.betteranimalsplus.block.TileEntityTrillium;
import its_meow.betteranimalsplus.block.render.RenderBlockHirschgeistSkull;
import its_meow.betteranimalsplus.block.render.RenderBlockTrillium;
import its_meow.betteranimalsplus.entity.model.ModelHirschgeistSkullArmorPiece;
import its_meow.betteranimalsplus.registry.BlockRegistry;
import its_meow.betteranimalsplus.registry.MobRegistry;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	
	public static final ModelHirschgeistSkullArmorPiece helmetModel = new ModelHirschgeistSkullArmorPiece(0.0625F);
	
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		MobRegistry.initModels();
	}

	public void init(FMLInitializationEvent event) {
		super.init(event);
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTrillium.class, new RenderBlockTrillium());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHirschgeistSkull.class, new RenderBlockHirschgeistSkull());
	}
	
}
