package its_meow.betteranimalsplus.common.item;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.util.HeadTypes;
import net.minecraft.block.Block;

public class ItemBlockHeadType extends ItemBlockSkull {

    private final HeadTypes type;

    public ItemBlockHeadType(Block block, HeadTypes type, int i) {
        super(block, type.allowFloor, i, new Properties().group(BetterAnimalsPlusMod.group));
        this.type = type;
    }

    public ItemBlockHeadType(Block block, HeadTypes type, int i, Properties prop) {
        super(block, type.allowFloor, i, prop);
        this.type = type;
    }

    @Override
    public String getTranslationKey() {
        return "block" + "." + Ref.MOD_ID + "." + this.type.name;
    }

}
