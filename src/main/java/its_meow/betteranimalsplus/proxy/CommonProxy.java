package its_meow.betteranimalsplus.proxy;

import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.common.world.gen.TrilliumGenerator;
import its_meow.betteranimalsplus.init.BlockRegistry;
import its_meow.betteranimalsplus.init.CraftingRegistry;
import its_meow.betteranimalsplus.init.MobRegistry;
import net.minecraft.block.BlockFlowerPot.EnumFlowerType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
	

	public void preInit(FMLPreInitializationEvent event) {

	}

	public void init(FMLInitializationEvent e) {
		CraftingRegistry.register(); 
		GameRegistry.registerWorldGenerator(new TrilliumGenerator(BlockRegistry.trillium), 1);
	}
	
	public void postInit(FMLPostInitializationEvent e) {

	}
	
	
}
