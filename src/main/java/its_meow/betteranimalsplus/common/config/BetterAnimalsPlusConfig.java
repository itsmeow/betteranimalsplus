package its_meow.betteranimalsplus.common.config;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.proxy.CommonProxy;
import net.minecraftforge.common.config.Configuration;

public class BetterAnimalsPlusConfig {

	private static final String cS = "spawning";
	private static final String cDS = "dospawning";

	public static int brownBearWeight = 7;
	public static int blackBearWeight = 5;
	public static int kermodeBearWeight = 4;
	public static int deerWeight = 16;
	public static int lammergeierWeight = 7;
	public static int feralWolfWeight = 8;
	public static int coyoteWeight = 6;
	public static int foxWeight = 10;
	public static int tarantulaWeight = 13;
	public static int hirschgeistWeight = 2;
	public static int goatWeight = 10;
	public static int jellyFishWeight = 10;
	public static int pheasantWeight = 10;
	public static int reindeerWeight = 10;
	
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
	public static boolean spawnGoat = true;
	public static boolean spawnJellyfish = true;
	public static boolean spawnPheasant = true;
	public static boolean spawnReindeer = true;
	
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
		hirschgeistWeight = cfg.getInt("hirschgeistweight", cS, hirschgeistWeight, 1, 100, "");
		goatWeight = cfg.getInt("goatweight", cS, goatWeight, 1, 100, "");
		jellyFishWeight = cfg.getInt("jellyfishweight", cS, jellyFishWeight, 1, 100, "");
		pheasantWeight = cfg.getInt("pheasantweight", cS, pheasantWeight, 1, 100, "");
		reindeerWeight = cfg.getInt("reindeerweight", cS, reindeerWeight, 1, 100, "");
		
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
		spawnGoat = cfg.getBoolean("enablegoat", cDS, true, "If set to false, removes from game!");
		spawnJellyfish = cfg.getBoolean("enablejellyfish", cDS, true, "If set to false, removes from game!");
		spawnPheasant = cfg.getBoolean("enablepheasant", cDS, true, "If set to false, removes from game!");
		spawnReindeer = cfg.getBoolean("enablereindeer", cDS, true, "If set to false, removes from game!");
	}

}
