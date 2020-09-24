package its_meow.betteranimalsplus.common.item;

import dev.itsmeow.imdlib.entity.util.IVariant;
import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.util.HeadType;
import net.minecraft.block.Block;

public class ItemBlockHeadType extends ItemBlockSkull {

    private final HeadType type;

    public ItemBlockHeadType(Block block, HeadType type, String id, IVariant variant) {
        super(block, type.getPlacementType(), id, variant, new Properties().group(BetterAnimalsPlusMod.group));
        this.type = type;
    }

    public ItemBlockHeadType(Block block, HeadType type, String id, IVariant variant, Properties prop) {
        super(block, type.getPlacementType(), id, variant, prop);
        this.type = type;
    }

    @Override
    public String getTranslationKey() {
        return "block" + "." + Ref.MOD_ID + "." + this.type.getName();
    }

}
