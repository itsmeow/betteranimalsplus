package its_meow.betteranimalsplus.common.config;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.proxy.CommonProxy;
import net.minecraftforge.common.config.Configuration;

public class BetterAnimalsPlusConfig {

	private static final String cS = "spawning";
	private static final String cDS = "dospawning";

	public static int brownBearWeight = 4;
	public static int blackBearWeight = 4;
	public static int kermodeBearWeight = 2;
	public static int deerWeight = 13;
	public static int lammergeierWeight = 6;
	public static int feralWolfWeight = 6;
	public static int coyoteWeight = 6;
	public static int foxWeight = 8;
	public static int tarantulaWeight = 10;
	public static int hirschgeistWeight = 1;
	
	public static boolean spawnTrillium = true;
	public static boolean spawnBrownBear = true;
	public static boolean spawnBlackBear = true;
	public static boolean spawnKermodeBear = true;
	public static boolean spawnDeer = true;
	public static boolean spawnLammergeier = true;
	public static boolean spawnFeralWolf = true;
	public static boolean spawnCoyote = true;
	public static boolean spawnFox = true;
	public static boolean spawnTarantula = true;
	public static boolean spawnHirschgeist = true;
	
	public static void readConfig(){
		Configuration cfg = CommonProxy.config;
		try {
			cfg.load();
			initConfig(cfg);
		} catch (Exception e1) {
			BetterAnimalsPlusMod.logger.log(org.apache.logging.log4j.Level.ERROR, "Problem Loading Config!!", e1);
		} finally {
			if(cfg.hasChanged()){
				cfg.save();
			}
		}
	}

	public static void initConfig(Configuration cfg) {
		cfg.addCustomCategoryComment(cS, "Spawning Configuration");
		cfg.addCustomCategoryComment(cDS, "Disable/Enable Mobs");
		
		brownBearWeight = cfg.getInt("brownbearweight", cS, brownBearWeight, 1, 100, "");
		blackBearWeight = cfg.getInt("blackbearweight", cS, blackBearWeight, 1, 100, "");
		kermodeBearWeight = cfg.getInt("kermodebearweight", cS, kermodeBearWeight, 1, 100, "");
		deerWeight = cfg.getInt("deerweight", cS, deerWeight, 1, 100, "");
		lammergeierWeight = cfg.getInt("lammergeierweight", cS, lammergeierWeight, 1, 100, "");
		feralWolfWeight = cfg.getInt("feralwolfweight", cS, feralWolfWeight, 1, 100, "");
		coyoteWeight = cfg.getInt("coyoteweight", cS, coyoteWeight, 1, 100, "");
		foxWeight = cfg.getInt("foxweight", cS, foxWeight, 1, 100, "");
		tarantulaWeight = cfg.getInt("tarantulaweight", cS, tarantulaWeight, 1, 100, "");
		hirschgeistWeight = cfg.getInt("weight", cS, hirschgeistWeight, 1, 100, "");
		
		spawnTrillium = cfg.getBoolean("generatetrillium", cDS, true, "Does not remove item, prevents world gen");
		
		spawnBrownBear = cfg.getBoolean("enablebrownbear", cDS, true, "If set to false, removes from game!");
		spawnBlackBear = cfg.getBoolean("enableblackbear", cDS, true, "If set to false, removes from game!");
		spawnKermodeBear = cfg.getBoolean("enablekermodebear", cDS, true, "If set to false, removes from game!");
		spawnDeer = cfg.getBoolean("enabledeer", cDS, true, "If set to false, removes from game!");
		spawnLammergeier = cfg.getBoolean("enablelammergeier", cDS, true, "If set to false, removes from game!");
		spawnFeralWolf = cfg.getBoolean("enableferalwolf", cDS, true, "If set to false, removes from game!");
		spawnCoyote = cfg.getBoolean("enablecoyote", cDS, true, "If set to false, removes from game!");
		spawnFox = cfg.getBoolean("enablefox", cDS, true, "If set to false, removes from game!");
		spawnTarantula = cfg.getBoolean("enabletarantula", cDS, true, "If set to false, removes from game!");
		spawnHirschgeist = cfg.getBoolean("enablehirschgeist", cDS, true, "If set to false, removes from game!");
	}

}
