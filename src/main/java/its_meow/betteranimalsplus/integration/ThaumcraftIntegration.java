package its_meow.betteranimalsplus.integration;

import its_meow.betteranimalsplus.init.ModBlocks;
import its_meow.betteranimalsplus.init.ModItems;
import its_meow.betteranimalsplus.util.HeadTypes;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import thaumcraft.api.ThaumcraftApi;
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
		
		event.register.registerObjectTag(new ItemStack(ModItems.FRIED_EGG), new AspectList().add(Aspect.BEAST, 5).add(Aspect.FIRE, 5));
		
		event.register.registerObjectTag(new ItemStack(ModItems.CRAB_MEAT_RAW), new AspectList().add(Aspect.LIFE, 5).add(Aspect.BEAST, 5).add(Aspect.PROTECT, 5));
		event.register.registerObjectTag(new ItemStack(ModItems.CRAB_MEAT_COOKED), new AspectList().add(Aspect.LIFE, 5).add(Aspect.BEAST, 5).add(Aspect.CRAFT, 1));
		
		event.register.registerObjectTag(new ItemStack(ModItems.ANTLER), new AspectList().add(Aspect.AVERSION, 5).add(Aspect.BEAST, 5).add(Aspect.EARTH, 5));
		event.register.registerObjectTag(new ItemStack(ModItems.WOLF_PELT_BLACK), new AspectList().add(Aspect.BEAST, 5).add(Aspect.CRAFT, 5));
		event.register.registerObjectTag(new ItemStack(ModItems.WOLF_PELT_TIMBER), new AspectList().add(Aspect.BEAST, 5).add(Aspect.CRAFT, 5));
		event.register.registerObjectTag(new ItemStack(ModItems.WOLF_PELT_SNOWY), new AspectList().add(Aspect.BEAST, 5).add(Aspect.CRAFT, 5));
		event.register.registerObjectTag(new ItemStack(ModItems.BEAR_SKIN_BLACK), new AspectList().add(Aspect.BEAST, 5).add(Aspect.CRAFT, 5));
		event.register.registerObjectTag(new ItemStack(ModItems.BEAR_SKIN_BROWN), new AspectList().add(Aspect.BEAST, 5).add(Aspect.CRAFT, 5));
		event.register.registerObjectTag(new ItemStack(ModItems.BEAR_SKIN_KERMODE), new AspectList().add(Aspect.BEAST, 5).add(Aspect.CRAFT, 5));
		event.register.registerObjectTag(new ItemStack(ModItems.TURKEY_COOKED), new AspectList().add(Aspect.CRAFT, 5).add(Aspect.LIFE, 5).add(Aspect.DESIRE, 5));
		event.register.registerObjectTag(new ItemStack(ModItems.TURKEY_RAW), new AspectList().add(Aspect.BEAST, 5).add(Aspect.LIFE, 5).add(Aspect.DESIRE, 5));
		event.register.registerObjectTag(new ItemStack(ModItems.PHEASANT_COOKED), new AspectList().add(Aspect.CRAFT, 5).add(Aspect.LIFE, 5).add(Aspect.DESIRE, 5));
		event.register.registerObjectTag(new ItemStack(ModItems.PHEASANT_RAW), new AspectList().add(Aspect.BEAST, 5).add(Aspect.LIFE, 5).add(Aspect.DESIRE, 5));
		event.register.registerObjectTag(new ItemStack(ModItems.VENISON_COOKED), new AspectList().add(Aspect.CRAFT, 5).add(Aspect.LIFE, 5).add(Aspect.PROTECT, 5));
		event.register.registerObjectTag(new ItemStack(ModItems.VENISON_RAW), new AspectList().add(Aspect.BEAST, 5).add(Aspect.LIFE, 5).add(Aspect.PROTECT, 5));
		
		event.register.registerObjectTag(new ItemStack(ModItems.GOAT_MILK), new AspectList().add(Aspect.METAL, 33).add(Aspect.LIFE, 10).add(Aspect.VOID, 5).add(Aspect.BEAST, 5).add(Aspect.WATER, 5));
		event.register.registerObjectTag(new ItemStack(ModItems.GOAT_CHEESE), new AspectList().add(Aspect.BEAST, 5).add(Aspect.LIFE, 5).add(Aspect.CRAFT, 5));
		
		event.register.registerObjectTag(new ItemStack(ModBlocks.TRILLIUM), new AspectList().add(Aspect.PLANT, 5).add(Aspect.EARTH, 5));
		event.register.registerObjectTag(new ItemStack(ModBlocks.TURKEY_RAW), new AspectList().add(Aspect.BEAST, 5).add(Aspect.LIFE, 5).add(Aspect.DESIRE, 5));
		event.register.registerObjectTag(new ItemStack(ModItems.TURKEY_LEG_RAW), new AspectList().add(Aspect.BEAST, 5).add(Aspect.LIFE, 5).add(Aspect.DESIRE, 5));
		event.register.registerObjectTag(new ItemStack(ModItems.TURKEY_LEG_COOKED), new AspectList().add(Aspect.CRAFT, 5).add(Aspect.LIFE, 5).add(Aspect.DESIRE, 5));
		event.register.registerObjectTag(new ItemStack(ModBlocks.TURKEY_EATEN_RAW), new AspectList().add(Aspect.BEAST, 3).add(Aspect.LIFE, 3).add(Aspect.DESIRE, 3));
		event.register.registerObjectTag(new ItemStack(ModBlocks.TURKEY_COOKED), new AspectList().add(Aspect.CRAFT, 5).add(Aspect.LIFE, 5).add(Aspect.DESIRE, 5));
		event.register.registerObjectTag(new ItemStack(ModBlocks.TURKEY_EATEN_COOKED), new AspectList().add(Aspect.CRAFT, 3).add(Aspect.LIFE, 3).add(Aspect.DESIRE, 3));
		event.register.registerObjectTag(new ItemStack(ModBlocks.HAND_OF_FATE), new AspectList().add(Aspect.MAGIC, 40).add(Aspect.SOUL, 40).add(Aspect.DESIRE, 40));
		
		ThaumcraftApi.registerEntityTag("betteranimalsplus.lammergeier", new AspectList().add(Aspect.BEAST, 5).add(Aspect.DEATH, 5).add(Aspect.FLIGHT, 5));
		ThaumcraftApi.registerEntityTag("betteranimalsplus.turkey", new AspectList().add(Aspect.BEAST, 5).add(Aspect.DESIRE, 5).add(Aspect.AIR, 5));
		ThaumcraftApi.registerEntityTag("betteranimalsplus.fox", new AspectList().add(Aspect.BEAST, 15).add(Aspect.DARKNESS, 15).add(Aspect.SENSES, 15));
		ThaumcraftApi.registerEntityTag("betteranimalsplus.boar", new AspectList().add(Aspect.BEAST, 35).add(Aspect.AVERSION, 35).add(Aspect.EARTH, 35));
		ThaumcraftApi.registerEntityTag("betteranimalsplus.jellyfish", new AspectList().add(Aspect.BEAST, 5).add(Aspect.WATER, 5).add(Aspect.AVERSION, 5));
		ThaumcraftApi.registerEntityTag("betteranimalsplus.lamprey", new AspectList().add(Aspect.BEAST, 5).add(Aspect.WATER, 5).add(Aspect.AVERSION, 5));
		ThaumcraftApi.registerEntityTag("betteranimalsplus.songbird", new AspectList().add(Aspect.BEAST, 5).add(Aspect.AIR, 5).add(Aspect.FLIGHT, 5));
		ThaumcraftApi.registerEntityTag("betteranimalsplus.squirrel", new AspectList().add(Aspect.BEAST, 5).add(Aspect.DESIRE, 5).add(Aspect.EARTH, 5));
		ThaumcraftApi.registerEntityTag("betteranimalsplus.badger", new AspectList().add(Aspect.BEAST, 10).add(Aspect.AVERSION, 10).add(Aspect.EARTH, 10));
		ThaumcraftApi.registerEntityTag("betteranimalsplus.feralwolf", new AspectList().add(Aspect.BEAST, 20).add(Aspect.AVERSION, 20).add(Aspect.DARKNESS, 20));
		ThaumcraftApi.registerEntityTag("betteranimalsplus.coyote", new AspectList().add(Aspect.BEAST, 20).add(Aspect.AVERSION, 20).add(Aspect.DARKNESS, 20));
		ThaumcraftApi.registerEntityTag("betteranimalsplus.shark", new AspectList().add(Aspect.BEAST, 35).add(Aspect.WATER, 35).add(Aspect.DARKNESS, 35).add(Aspect.AVERSION, 35));
	}
}
