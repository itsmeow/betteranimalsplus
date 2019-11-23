package its_meow.betteranimalsplus.common.item;

import com.google.common.base.Preconditions;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemBlockSimple extends ItemBlock {

    public ItemBlockSimple(Block block) {
        super(block);
        this.setRegistryName(Preconditions.checkNotNull(block.getRegistryName(), "Block %s has null registry name", block));
        block.setCreativeTab(BetterAnimalsPlusMod.tab);
    }

}
