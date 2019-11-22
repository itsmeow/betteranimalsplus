package its_meow.betteranimalsplus.common.item;

import its_meow.betteranimalsplus.util.EntityTypeContainer;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class ItemBetterAnimalsPlusEgg extends SpawnEggItem {

    private final EntityType<?> type;

    public ItemBetterAnimalsPlusEgg(EntityTypeContainer<?> container) {
        super(container.entityType, container.eggColorSolid, container.eggColorSpot, new Properties().group(ItemGroup.MISC));
        this.type = container.entityType;
    }

    @Override
    public String getTranslationKey(ItemStack stack) {
        if(type != null) {
            return "entity.betteranimalsplus." + this.type.getRegistryName().getPath();
        }
        return "item.betteranimalsplus.emptyegg";
    }

    @Override
    public ITextComponent getDisplayName(ItemStack stack) {
        return new TranslationTextComponent("misc.betteranimalsplus.eggorder",
        new TranslationTextComponent(this.getTranslationKey(stack)));
    }

    @Override
    public EntityType<?> getType(CompoundNBT tag) {
        return this.type;
    }

    @Override
    public boolean hasType(CompoundNBT tag, EntityType<?> type) {
        return type == this.type;
    }

}
