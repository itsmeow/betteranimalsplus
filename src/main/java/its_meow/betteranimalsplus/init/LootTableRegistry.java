package its_meow.betteranimalsplus.init;

import its_meow.betteranimalsplus.Ref;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

public class LootTableRegistry {

	public static final ResourceLocation bear = new ResourceLocation(Ref.MOD_ID, "bear");
	public static final ResourceLocation deer = new ResourceLocation(Ref.MOD_ID, "deer");
	public static final ResourceLocation lammergeier = new ResourceLocation(Ref.MOD_ID, "lammergeier");
	public static final ResourceLocation hirschgeist = new ResourceLocation(Ref.MOD_ID, "hirschgeist");
	public static final ResourceLocation goat = new ResourceLocation(Ref.MOD_ID, "goat");
	public static final ResourceLocation canid = new ResourceLocation(Ref.MOD_ID, "canids");
	public static final ResourceLocation pheasant = new ResourceLocation(Ref.MOD_ID, "pheasant");
	public static final ResourceLocation reindeer = new ResourceLocation(Ref.MOD_ID, "reindeer");
	
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
