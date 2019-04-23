package its_meow.betteranimalsplus.common.item;

import java.util.List;

import its_meow.betteranimalsplus.util.HeadTypes;
import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBlockHeadType extends ItemBlockSkull {

    private final HeadTypes type;

    public ItemBlockHeadType(Block block, HeadTypes type, int i) {
        super(block, type.allowFloor, i);
        this.type = type;
    }

    public HeadTypes getType() {
        return type;
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        if(type == HeadTypes.HIRSCHGEIST) {
            tooltip.add("It can be worn via placing it into an empty crafting table");
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

}