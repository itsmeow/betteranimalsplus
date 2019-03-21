package its_meow.betteranimalsplus.common.item;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemHirschgeistSkull extends ItemBlockSkull {

    public ItemHirschgeistSkull(Block block) {
        super(block, true);
        this.setMaxDamage(0);
        this.setUnlocalizedName("betteranimalsplus.hirschgeistskull");
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add("It can be worn via placing it into an empty crafting table");
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

}
