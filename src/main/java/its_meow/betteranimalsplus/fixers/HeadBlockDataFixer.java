package its_meow.betteranimalsplus.fixers;

import java.util.HashMap;
import java.util.Map;

import its_meow.betteranimalsplus.common.block.BlockAnimalSkull;
import its_meow.betteranimalsplus.common.block.BlockGenericSkull;
import its_meow.betteranimalsplus.util.HeadTypes;
import net.minecraft.util.EnumFacing;

public class HeadBlockDataFixer extends FlatteningFixer {

    private static Map<String, HeadTypes> headIDs = new HashMap<String, HeadTypes>();

	static {
		headIDs.put("foxhead", HeadTypes.FOXHEAD);
		headIDs.put("boarhead", HeadTypes.BOARHEAD);
		headIDs.put("deerhead", HeadTypes.DEERHEAD);
		headIDs.put("hirschgeistskull", HeadTypes.HIRSCHGEIST);
		headIDs.put("wolfhead", HeadTypes.WOLFHEAD);
		headIDs.put("reindeerhead", HeadTypes.REINDEERHEAD);
	}

	@Override
	public int getFixVersion() {
		return 1;
	}

	public HeadBlockDataFixer() {
		for (String id : headIDs.keySet()) {
			for (int i = 0; i < EnumFacing.values().length; i++) {
				this.flatteningDefinitions.add(new FlatteningDefinition(id, i, (oldID, meta, tag) -> {
					BlockGenericSkull newBlock = headIDs.get(oldID).getBlock(tag.getInteger("TYPENUM"));
					return newBlock.getDefaultState().withProperty(BlockAnimalSkull.FACING,
							EnumFacing.values()[meta]);
				}));
			}
		}
	}
	
}
