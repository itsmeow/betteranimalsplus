package its_meow.betteranimalsplus.fixers;

import its_meow.betteranimalsplus.common.block.BlockAnimalSkull;
import its_meow.betteranimalsplus.common.block.BlockGenericSkull;
import its_meow.betteranimalsplus.util.HeadTypes;
import net.minecraft.util.EnumFacing;

public class CoyoteHeadBlockDataFixer extends FlatteningFixer {

    @Override
    public int getFixVersion() {
        return 4;
    }

    public CoyoteHeadBlockDataFixer() {
        for (int i = 0; i < EnumFacing.values().length; i++) {
            this.flatteningDefinitions.add(new FlatteningDefinition("betteranimalsplus:wolfhead_4", i, (oldID, meta, tag) -> {
                BlockGenericSkull newBlock = HeadTypes.COYOTEHEAD.getBlock(1);
                return newBlock.getDefaultState().withProperty(BlockAnimalSkull.FACING,
                EnumFacing.values()[meta]);
            }));
        }
    }

}
