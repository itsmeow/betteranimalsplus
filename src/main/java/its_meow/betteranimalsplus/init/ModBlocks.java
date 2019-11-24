package its_meow.betteranimalsplus.init;

import its_meow.betteranimalsplus.common.block.BlockHandOfFate;
import its_meow.betteranimalsplus.common.block.BlockTrillium;
import its_meow.betteranimalsplus.common.block.BlockTurkey;
import its_meow.betteranimalsplus.common.block.BlockTurkeyRaw;

public class ModBlocks {

    public static final BlockTrillium TRILLIUM = new BlockTrillium();
    public static final BlockHandOfFate HAND_OF_FATE = new BlockHandOfFate();
    public static final BlockTurkeyRaw TURKEY_EATEN_RAW = new BlockTurkeyRaw("turkey_eaten_raw");
    public static final BlockTurkey TURKEY_EATEN_COOKED = new BlockTurkey("turkey_eaten_cooked");
    public static final BlockTurkeyRaw TURKEY_RAW = new BlockTurkeyRaw("turkey_raw", TURKEY_EATEN_RAW);
    public static final BlockTurkey TURKEY_COOKED = new BlockTurkey("turkey_cooked", TURKEY_EATEN_COOKED);

}
