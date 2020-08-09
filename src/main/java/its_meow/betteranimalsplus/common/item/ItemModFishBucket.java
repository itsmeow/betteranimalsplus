package its_meow.betteranimalsplus.common.item;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

import javax.annotation.Nullable;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.common.entity.util.EntityTypeContainerBAP;
import its_meow.betteranimalsplus.common.entity.util.EntityTypeContainerBAPContainable;
import its_meow.betteranimalsplus.common.entity.util.IContainable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemModFishBucket<T extends MobEntity & IContainable> extends BucketItem implements IContainerItem<T> {
    private final EntityTypeContainerBAPContainable<T, ItemModFishBucket<T>> typeContainer;
    private ITooltipFunction tooltip;

    public static final <T extends MobEntity & IContainable> BiFunction<EntityTypeContainerBAPContainable<T, ItemModFishBucket<T>>, ITooltipFunction, ItemModFishBucket<T>> waterBucket() {
        return (container, tooltip) -> {
            return new ItemModFishBucket<T>(container, () -> Fluids.WATER, tooltip);
        };
    }

    public ItemModFishBucket(EntityTypeContainerBAPContainable<T, ItemModFishBucket<T>> typeContainer, Supplier<? extends Fluid> fluid) {
        this(typeContainer, fluid, IContainerItem.VARIANT_TOOLTIP);
    }

    public ItemModFishBucket(EntityTypeContainerBAPContainable<T, ItemModFishBucket<T>> typeContainer, Supplier<? extends Fluid> fluid, ITooltipFunction tooltip) {
        super(fluid, new Item.Properties().maxStackSize(1).group(BetterAnimalsPlusMod.group));
        this.addPropertyOverrides(this);
        this.typeContainer = typeContainer;
        this.setRegistryName(typeContainer.entityName + "_bucket");
        this.tooltip = tooltip;
    }

    @Override
    public void onLiquidPlaced(World worldIn, ItemStack stack, BlockPos pos) {
        if(!worldIn.isRemote) {
            this.placeEntity(worldIn, stack, pos);
        }
    }

    @Override
    protected void playEmptySound(@Nullable PlayerEntity player, IWorld worldIn, BlockPos pos) {
        worldIn.playSound(player, pos, SoundEvents.ITEM_BUCKET_EMPTY_FISH, SoundCategory.NEUTRAL, 1.0F, 1.0F);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        this.tooltip.addInformation(this.typeContainer, stack, worldIn, tooltip);
    }

    @Override
    public EntityTypeContainerBAP<T> getContainer() {
        return typeContainer;
    }

}
