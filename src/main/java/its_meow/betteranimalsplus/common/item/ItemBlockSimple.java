package its_meow.betteranimalsplus.common.item;

import com.google.common.base.Preconditions;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;

public class ItemBlockSimple extends BlockItem {

    public ItemBlockSimple(Block block) {
        super(block, new Properties().group(BetterAnimalsPlusMod.group));
        this.setRegistryName(Preconditions.checkNotNull(block.getRegistryName(), "Block %s has null registry name", block));
    }

}