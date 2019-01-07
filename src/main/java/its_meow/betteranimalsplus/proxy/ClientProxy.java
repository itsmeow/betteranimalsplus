package its_meow.betteranimalsplus.proxy;

import its_meow.betteranimalsplus.client.EventHandlerClient;
import its_meow.betteranimalsplus.client.model.ModelHirschgeistHelmet;
import its_meow.betteranimalsplus.client.renderer.TESR.RenderBlockHandOfFate;
import its_meow.betteranimalsplus.client.renderer.TESR.RenderBlockTrillium;
import its_meow.betteranimalsplus.client.renderer.TESR.RenderGenericHead;
import its_meow.betteranimalsplus.client.renderer.TESR.RenderGenericHeadFloor;
import its_meow.betteranimalsplus.client.renderer.entity.EntityRendererRegistry;
import its_meow.betteranimalsplus.common.block.BlockGenericSkull;
import its_meow.betteranimalsplus.common.tileentity.TileEntityHandOfFate;
import its_meow.betteranimalsplus.common.tileentity.TileEntityHead;
import its_meow.betteranimalsplus.common.tileentity.TileEntityTrillium;
import its_meow.betteranimalsplus.init.BlockRegistry;
import net.minecraft.client.model.ModelBiped;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

	public static final ModelHirschgeistHelmet armorModel = new ModelHirschgeistHelmet();

	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		MinecraftForge.EVENT_BUS.register(new EventHandlerClient());
		EntityRendererRegistry.registerEntityRenderers();
	}

	public void init(FMLInitializationEvent event) {
		super.init(event);
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTrillium.class, new RenderBlockTrillium());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHandOfFate.class, new RenderBlockHandOfFate());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHead.class, new RenderGenericHead());
		for(BlockGenericSkull block : BlockRegistry.genericskulls.keySet()) {
			if(block.allowFloor) {
				ClientRegistry.bindTileEntitySpecialRenderer(block.teClass.asSubclass(TileEntityHead.class), new RenderGenericHeadFloor());
			}
		}
	}

	public static ModelBiped getArmorModel(){
		return armorModel;
	}

}
