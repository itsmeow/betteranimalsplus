package its_meow.betteranimalsplus.common.item;

import java.util.List;

import dev.itsmeow.imdlib.entity.util.IVariant;
import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.util.HeadType;
import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

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
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if(type == ModEntities.HIRSCHGEIST.getHeadType()) {
            tooltip.add(new StringTextComponent("It can be worn via placing it into an empty crafting table"));
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public String getTranslationKey() {
        return "block" + "." + Ref.MOD_ID + "." + this.type.getName();
    }

}
