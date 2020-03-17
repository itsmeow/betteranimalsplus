package its_meow.betteranimalsplus.common.item;

import java.util.List;
import java.util.function.Supplier;

import javax.annotation.Nullable;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.common.entity.util.EntityTypeContainer;
import its_meow.betteranimalsplus.common.entity.util.IBucketable;
import its_meow.betteranimalsplus.common.entity.util.IVariantTypes;
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
    private final EntityTypeContainer<T> typeContainer;

    public ItemModFishBucket(EntityTypeContainer<T> typeContainer, Supplier<? extends Fluid> fluid) {
        super(fluid, new Item.Properties().maxStackSize(1).group(BetterAnimalsPlusMod.group));
        this.typeContainer = typeContainer;
        this.setRegistryName(typeContainer.entityName + "_bucket");
    }

    public void onLiquidPlaced(World worldIn, ItemStack stack, BlockPos pos) {
        if(!worldIn.isRemote) {
            this.placeFish(worldIn, stack, pos);
        }

    }

    protected void playEmptySound(@Nullable PlayerEntity player, IWorld worldIn, BlockPos pos) {
        worldIn.playSound(player, pos, SoundEvents.ITEM_BUCKET_EMPTY_FISH, SoundCategory.NEUTRAL, 1.0F, 1.0F);
    }

    private void placeFish(World worldIn, ItemStack stack, BlockPos pos) {
        Entity entity = this.getFishType().spawn(worldIn, stack, (PlayerEntity) null, pos, SpawnReason.BUCKET, true, false);
        if(entity != null) {
            ((IBucketable) entity).setFromBucket(true);
            if(stack.getTag() != null && stack.getTag().contains("BucketVariantTag") && entity instanceof IVariantTypes) {
                ((IVariantTypes<?>)entity).setType(stack.getTag().getString("BucketVariantTag"));
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        CompoundNBT compoundnbt = stack.getTag();
        if(compoundnbt != null && compoundnbt.contains("BucketVariantTag", Constants.NBT.TAG_STRING)) {
            String id = compoundnbt.getString("BucketVariantTag");
            TextFormatting[] atextformatting = new TextFormatting[] { TextFormatting.ITALIC, TextFormatting.GRAY };
            tooltip.add((new TranslationTextComponent("entity.betteranimalsplus." + this.typeContainer.entityName.toLowerCase() + ".type." + this.typeContainer.getVariant(id).getName())).applyTextStyles(atextformatting));
        }
    }

    protected EntityType<T> getFishType() {
        return typeContainer.entityType;
    }
}
