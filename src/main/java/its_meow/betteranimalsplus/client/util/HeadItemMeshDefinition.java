package its_meow.betteranimalsplus.client.util;

import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.common.block.BlockGenericSkull;
import its_meow.betteranimalsplus.common.item.ItemBlockSkull;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemStack;

public class HeadItemMeshDefinition implements ItemMeshDefinition {
    public final ModelResourceLocation defaultModelResourceLocation;

    public HeadItemMeshDefinition(BlockGenericSkull head) {
        this.defaultModelResourceLocation = new ModelResourceLocation(head.getRegistryName(), "inventory");
    }

    @Override
    public ModelResourceLocation getModelLocation(ItemStack stack) {
        if (stack != null && stack.getItem() instanceof ItemBlockSkull && stack.hasTagCompound()) {
            return new ModelResourceLocation(Ref.MOD_ID + ":" + this.defaultModelResourceLocation.getResourcePath() + "_" + stack.getTagCompound().getInteger("TYPENUM"), "inventory");
        }
        return this.defaultModelResourceLocation;
    }
}