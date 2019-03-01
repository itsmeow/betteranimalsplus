package its_meow.betteranimalsplus.common.item;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.util.HeadTypes;
import net.minecraft.block.Block;

public class ItemBlockHeadType extends ItemBlockSkull {

	public ItemBlockHeadType(Block block, HeadTypes type, int i) {
		super(block, type.allowFloor, i, new Properties().group(BetterAnimalsPlusMod.group));
	}

	public ItemBlockHeadType(Block block, HeadTypes type, int i, Properties prop) {
		super(block, type.allowFloor, i, prop);
	}



}
