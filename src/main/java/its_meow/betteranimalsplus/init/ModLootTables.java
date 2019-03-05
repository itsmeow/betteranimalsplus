package its_meow.betteranimalsplus.init;

import its_meow.betteranimalsplus.Ref;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

public class ModLootTables {
	public static final String pr = Ref.MOD_ID + "/";
	public static final ResourceLocation bear = new ResourceLocation(Ref.MOD_ID, pr + "bear");
	public static final ResourceLocation deer = new ResourceLocation(Ref.MOD_ID, pr + "deer");
	public static final ResourceLocation lammergeier = new ResourceLocation(Ref.MOD_ID, pr + "lammergeier");
	public static final ResourceLocation hirschgeist = new ResourceLocation(Ref.MOD_ID, pr + "hirschgeist");
	public static final ResourceLocation goat = new ResourceLocation(Ref.MOD_ID, pr + "goat");
	public static final ResourceLocation canid = new ResourceLocation(Ref.MOD_ID, pr + "canids");
	public static final ResourceLocation pheasant = new ResourceLocation(Ref.MOD_ID, pr + "pheasant");
	public static final ResourceLocation reindeer = new ResourceLocation(Ref.MOD_ID, pr + "reindeer");
	
	public static void register() {
		LootTableList.register(bear);
		LootTableList.register(deer);
		LootTableList.register(lammergeier);
		LootTableList.register(hirschgeist);
		LootTableList.register(goat);
		LootTableList.register(canid);
		LootTableList.register(pheasant);
		LootTableList.register(reindeer);
	}

}
