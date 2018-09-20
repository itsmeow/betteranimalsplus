package its_meow.betteranimalsplus.proxy;

import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.registry.BlockRegistry;
import its_meow.betteranimalsplus.registry.CraftingRegistry;
import its_meow.betteranimalsplus.registry.MobRegistry;
import its_meow.betteranimalsplus.world.gen.TrilliumGenerator;
import net.minecraft.block.BlockFlowerPot.EnumFlowerType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
	

	public void preInit(FMLPreInitializationEvent event) {
		MobRegistry.init();
	}

	public void init(FMLInitializationEvent e) {
		CraftingRegistry.register(); 
		GameRegistry.registerWorldGenerator(new TrilliumGenerator(BlockRegistry.trillium), 1);
	}
	
	public void postInit(FMLPostInitializationEvent e) {

	}
	
	
}
