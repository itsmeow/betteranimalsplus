package its_meow.betteranimalsplus.registry;

import its_meow.betteranimalsplus.Ref;
import net.minecraft.util.ResourceLocation;

public class TextureRegistry {
	
	private static final String entitytex = Ref.MOD_ID + ":textures/entities/";
	
	
	//Bear Variants
	public static final ResourceLocation bear_brown = 
			new ResourceLocation(entitytex, "bear_brown.png");
	public static final ResourceLocation bear_black = 
			new ResourceLocation(entitytex, "bear_black.png");
	public static final ResourceLocation bear_kermode = 
			new ResourceLocation(entitytex, "bear_kermode.png");
	
	
}
