package its_meow.betteranimalsplus.proxy;

import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.block.TileEntityHirschgeistSkull;
import its_meow.betteranimalsplus.block.TileEntityTrillium;
import its_meow.betteranimalsplus.block.render.RenderBlockHirschgeistSkull;
import its_meow.betteranimalsplus.block.render.RenderBlockTrillium;
import its_meow.betteranimalsplus.entity.model.ModelHirschgeistSkullArmorPiece;
import its_meow.betteranimalsplus.registry.BlockRegistry;
import its_meow.betteranimalsplus.registry.MobRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
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
		
		ItemModelMesher mesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
		Item item = BlockRegistry.hirschgeistskull.getItemBlock();
    	ModelResourceLocation model = new ModelResourceLocation(Ref.MOD_ID + ":" + BlockRegistry.hirschgeistskull.getRegistryName(), "inventory");
    	ModelLoader.registerItemVariants(item, model);
    	mesher.register(item, 0, model);
    	
	}
    
	
}
