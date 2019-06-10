package its_meow.betteranimalsplus.common.item;

import java.util.List;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.util.HeadTypes;
import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

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
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if(type == HeadTypes.HIRSCHGEIST) {
            tooltip.add(new StringTextComponent("It can be worn via placing it into an empty crafting table"));
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public String getTranslationKey() {
        return "block" + "." + Ref.MOD_ID + "." + this.type.name;
    }

}
