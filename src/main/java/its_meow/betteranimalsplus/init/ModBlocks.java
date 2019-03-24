package its_meow.betteranimalsplus.init;

import java.util.HashMap;

import its_meow.betteranimalsplus.common.block.BlockGenericSkull;
import its_meow.betteranimalsplus.common.block.BlockHandOfFate;
import its_meow.betteranimalsplus.common.block.BlockHirschgeistSkull;
import its_meow.betteranimalsplus.common.block.BlockTrillium;
import its_meow.betteranimalsplus.common.item.ItemBlockSkull;
import its_meow.betteranimalsplus.common.tileentity.TileEntityBoarHead;
import its_meow.betteranimalsplus.common.tileentity.TileEntityDeerHead;
import its_meow.betteranimalsplus.common.tileentity.TileEntityFoxHead;
import its_meow.betteranimalsplus.common.tileentity.TileEntityReindeerHead;
import its_meow.betteranimalsplus.common.tileentity.TileEntityWolfHead;

public class ModBlocks {

    public static final BlockTrillium trillium = new BlockTrillium();
    public static final BlockHirschgeistSkull hirschgeistskull = new BlockHirschgeistSkull();
    public static final BlockHandOfFate handoffate = new BlockHandOfFate();

    // Generic Skulls
    public static final BlockGenericSkull deerhead = new BlockGenericSkull(TileEntityDeerHead.class, "deerhead", false, 2);
    public static final BlockGenericSkull wolfhead = new BlockGenericSkull(TileEntityWolfHead.class, "wolfhead", true, 4);
    public static final BlockGenericSkull reindeerhead = new BlockGenericSkull(TileEntityReindeerHead.class, "reindeerhead", false, 4);
    public static final BlockGenericSkull foxhead = new BlockGenericSkull(TileEntityFoxHead.class, "foxhead", true, 4);
    public static final BlockGenericSkull boarhead = new BlockGenericSkull(TileEntityBoarHead.class, "boarhead", false, 4);

    public static HashMap<BlockGenericSkull, ItemBlockSkull> genericskulls = new HashMap<BlockGenericSkull, ItemBlockSkull>();

    public static void addGenericSkull(BlockGenericSkull block) {
        genericskulls.put(block, new ItemBlockSkull(block, block.allowFloor));
    }

    public static ItemBlockSkull getSkullItemForBlock(BlockGenericSkull block) {
        return genericskulls.get(block);
    }

}
