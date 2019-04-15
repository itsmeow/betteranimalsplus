package its_meow.betteranimalsplus.common.item;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.util.HeadTypes;
import net.minecraft.block.Block;

public class ItemBlockHeadType extends ItemBlockSkull {

	private final HeadTypes type;

	public ItemBlockHeadType(Block block, HeadTypes type, int i) {
		super(block, type.allowFloor, i);
		this.type = type;
		this.setCreativeTab(BetterAnimalsPlusMod.tab);
	}

	public HeadTypes getType() {
		return type;
	}

}