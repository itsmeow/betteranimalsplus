package its_meow.betteranimalsplus.integration;

import its_meow.betteranimalsplus.init.ModBlocks;
import its_meow.betteranimalsplus.init.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.aspects.AspectRegistryEvent;

/**
 * Created by Joseph on 11/22/2019.
 */
public class ThaumcraftIntegration {
	@SubscribeEvent
	public void aspectRegistrationEvent(AspectRegistryEvent event) {
		event.register.registerObjectTag(new ItemStack(ModItems.PHEASANT_EGG), new AspectList().add(Aspect.BEAST, 5).add(Aspect.LIFE, 5));
		event.register.registerObjectTag(new ItemStack(ModItems.TURKEY_EGG), new AspectList().add(Aspect.BEAST, 5).add(Aspect.LIFE, 5));
		
		event.register.registerObjectTag(new ItemStack(ModItems.CRAB_MEAT_RAW), new AspectList().add(Aspect.LIFE, 5).add(Aspect.BEAST, 5).add(Aspect.PROTECT, 5));
		event.register.registerObjectTag(new ItemStack(ModItems.CRAB_MEAT_RAW), new AspectList().add(Aspect.LIFE, 5).add(Aspect.BEAST, 5).add(Aspect.CRAFT, 1));
		
		event.register.registerObjectTag(new ItemStack(ModItems.goatMilk), new AspectList().add(Aspect.METAL, 33).add(Aspect.LIFE, 10).add(Aspect.VOID, 5).add(Aspect.BEAST, 5).add(Aspect.WATER, 5));
		event.register.registerObjectTag(new ItemStack(ModItems.goatCheese), new AspectList().add(Aspect.BEAST, 5).add(Aspect.LIFE, 5).add(Aspect.CRAFT, 5));
		
		event.register.registerObjectTag(new ItemStack(ModBlocks.trillium), new AspectList().add(Aspect.PLANT, 5).add(Aspect.EARTH, 5));
	}
}
