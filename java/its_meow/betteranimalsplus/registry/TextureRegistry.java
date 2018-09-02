package its_meow.betteranimalsplus.registry;

import its_meow.betteranimalsplus.Ref;
import net.minecraft.util.ResourceLocation;

public class TextureRegistry {
	
	private static final String entitytex = Ref.MOD_ID + ":textures/entities/";
	
	
	//Bear Variants
	public static final ResourceLocation bear_brown = 
			new ResourceLocation(entitytex + "bear_brown.png");
	public static final ResourceLocation bear_black = 
			new ResourceLocation(entitytex + "bear_black.png");
	public static final ResourceLocation bear_kermode = 
			new ResourceLocation(entitytex + "bear_kermode.png");
	
	//Deer Variants
	public static final ResourceLocation deer_1 = 
			new ResourceLocation(entitytex + "deer_1.png");
	public static final ResourceLocation deer_2 = 
			new ResourceLocation(entitytex + "deer_2.png");
	
	//Lammergeier Variants
	public static final ResourceLocation lam_orange = 
			new ResourceLocation(entitytex + "lammergeier_orange.png");
	public static final ResourceLocation lam_red = 
			new ResourceLocation(entitytex + "lammergeier_red.png");
	public static final ResourceLocation lam_white = 
			new ResourceLocation(entitytex + "lammergeier_white.png");
	public static final ResourceLocation lam_yellow = 
			new ResourceLocation(entitytex + "lammergeier_yellow.png");
	
	//Wolf Variants
	public static final ResourceLocation wolf_black = 
			new ResourceLocation(entitytex + "feral_wolf_black.png");
	public static final ResourceLocation wolf_snowy = 
			new ResourceLocation(entitytex + "feral_wolf_snowy.png");
	public static final ResourceLocation wolf_timber = 
			new ResourceLocation(entitytex + "feral_wolf_timber.png");
	public static final ResourceLocation wolf_black_tame = 
			new ResourceLocation(entitytex + "feral_wolf_black_tame.png");
	public static final ResourceLocation wolf_snowy_tame = 
			new ResourceLocation(entitytex + "feral_wolf_snowy_tame.png");
	public static final ResourceLocation wolf_timber_tame = 
			new ResourceLocation(entitytex + "feral_wolf_timber_tame.png");
	public static final ResourceLocation wolf_black_neutral = 
			new ResourceLocation(entitytex + "feral_wolf_black_neutral.png");
	public static final ResourceLocation wolf_snowy_neutral = 
			new ResourceLocation(entitytex + "feral_wolf_snowy_neutral.png");
	public static final ResourceLocation wolf_timber_neutral = 
			new ResourceLocation(entitytex + "feral_wolf_timber_neutral.png");
	public static final ResourceLocation wolf_eyes = 
			new ResourceLocation(entitytex + "feral_wolf_eyes.png");
	
	//Coyote Variants
	public static final ResourceLocation coyote_hostile = 
			new ResourceLocation(entitytex + "coyote_hostile.png");
	public static final ResourceLocation coyote_neutral = 
			new ResourceLocation(entitytex + "coyote_neutral.png");
	public static final ResourceLocation coyote_eyes = 
			new ResourceLocation(entitytex + "coyote_hostile_eyes.png");
	
	//Trillium Variants
	public static final ResourceLocation trillium = 
			new ResourceLocation(entitytex + "flora/trillium.png");
	public static final ResourceLocation trillium2 = 
			new ResourceLocation(entitytex + "flora/trillium_2.png");
	
	
}
