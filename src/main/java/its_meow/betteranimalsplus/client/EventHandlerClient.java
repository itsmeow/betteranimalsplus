package its_meow.betteranimalsplus.client;

import its_meow.betteranimalsplus.Ref;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Ref.MOD_ID, value = Dist.CLIENT)
public class EventHandlerClient {
	
	/*
	@SubscribeEvent
	public void textureStitchEventPre(TextureStitchEvent.Pre event)
	{	
		event.getMap().registerSprite(TextureRegistry.sparks);
		event.getMap().registerSprite(TextureRegistry.ember_left);
		event.getMap().registerSprite(TextureRegistry.ember_mid);
		event.getMap().registerSprite(TextureRegistry.ember_right);
	}
	*/
	
	@SubscribeEvent
	public static void registerItemBlockModels(final ModelRegistryEvent event) {
		//Blocks
		
		//OBJLoader.INSTANCE.addDomain(Ref.MOD_ID);
		
		/*initModel(BlockRegistry.trillium, 0);
		initModel(BlockRegistry.hirschgeistskull, 0);
		initModel(BlockRegistry.handoffate, 0);

		// generics
		for(BlockGenericSkull skull : BlockRegistry.genericskulls.keySet()) {
			
		}
		
		//Items
		
		initModel(ItemRegistry.venisonRaw, 0);
		initModel(ItemRegistry.venisonCooked, 0);
		initModel(ItemRegistry.itemHirschgeistSkullWearable, 0);
		initModel(ItemRegistry.antler, 0);
		initModel(ItemRegistry.goatMilk, 0);
		initModel(ItemRegistry.goatCheese, 0);
		initModel(ItemRegistry.pheasantRaw, 0);
		initModel(ItemRegistry.pheasantCooked, 0);*/
	}
	
	/*public static void initModel(Item item, int meta) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}

	public static void initModel(Block block, int meta) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}

	public static void initModelOBJ(Block block, int meta) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, new ModelResourceLocation(block.getRegistryName() + ".obj", "inventory"));
	}*/
	
}
