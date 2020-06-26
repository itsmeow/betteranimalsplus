package its_meow.betteranimalsplus.common.item;

import java.util.List;
import java.util.function.Supplier;

import javax.annotation.Nullable;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.common.entity.util.EntityTypeContainerBAP;
import its_meow.betteranimalsplus.common.entity.util.IBucketable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.Constants;

public class ItemModFishBucket<T extends MobEntity> extends BucketItem {
    public static final IBucketTooltipFunction defaultVariantFunc = (container, stack, world, tooltip) -> {
        CompoundNBT compoundnbt = stack.getTag();
        if(compoundnbt != null && compoundnbt.contains("BucketVariantTag", Constants.NBT.TAG_STRING)) {
            String id = compoundnbt.getString("BucketVariantTag");
            tooltip.add((new TranslationTextComponent("entity.betteranimalsplus." + container.entityName.toLowerCase() + ".type." + container.getVariantForName(id).getName())).func_240699_a_(TextFormatting.ITALIC).func_240699_a_(TextFormatting.GRAY));
        }
    };

    private final EntityTypeContainerBAP<T> typeContainer;
    private IBucketTooltipFunction tooltip;

    public ItemModFishBucket(EntityTypeContainerBAP<T> typeContainer, Supplier<? extends Fluid> fluid, IBucketTooltipFunction tooltip) {
        super(fluid, new Item.Properties().maxStackSize(1).group(BetterAnimalsPlusMod.group));
        this.typeContainer = typeContainer;
        this.setRegistryName(typeContainer.entityName + "_bucket");
        this.tooltip = tooltip;
    }

    @Override
    public void onLiquidPlaced(World worldIn, ItemStack stack, BlockPos pos) {
        if(!worldIn.isRemote) {
            this.placeFish(worldIn, stack, pos);
        }

    }

    @Override
    protected void playEmptySound(@Nullable PlayerEntity player, IWorld worldIn, BlockPos pos) {
        worldIn.playSound(player, pos, SoundEvents.ITEM_BUCKET_EMPTY_FISH, SoundCategory.NEUTRAL, 1.0F, 1.0F);
    }

    private void placeFish(World worldIn, ItemStack stack, BlockPos pos) {
        Entity entity = this.getFishType().spawn(worldIn, stack, (PlayerEntity) null, pos, SpawnReason.BUCKET, true, false);
        if(entity != null) {
            if(entity instanceof IBucketable) {
                ((IBucketable) entity).setFromBucket(true);
                ((IBucketable) entity).readFromBucket(stack);
                if(stack.getTag() != null) {
                    ((IBucketable) entity).readFromBucketTag(stack.getTag());
                }
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        this.tooltip.addInformation(this.typeContainer, stack, worldIn, tooltip);
    }

    public EntityTypeContainerBAP<T> getContainer() {
        return typeContainer;
    }

    public EntityType<T> getFishType() {
        return typeContainer.entityType;
    }
    
    @FunctionalInterface
    public static interface IBucketTooltipFunction {
        void addInformation(EntityTypeContainerBAP<? extends MobEntity> container, ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip);
    }
}
