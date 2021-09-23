package dev.itsmeow.betteranimalsplus.common.item;

import dev.itsmeow.betteranimalsplus.BetterAnimalsPlusMod;
import net.minecraft.Util;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.AbstractProjectileDispenseBehavior;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;

import java.util.function.BiFunction;

public class ItemThrowableCustomEgg extends Item {

    private final BiFunction<Level, Position, ThrowableItemProjectile> eggSupplier;
    private final BiFunction<Level, LivingEntity, ThrowableItemProjectile> eggSupplier2;

    public ItemThrowableCustomEgg(BiFunction<Level, Position, ThrowableItemProjectile> egg, BiFunction<Level, LivingEntity, ThrowableItemProjectile> egg2) {
        super(new Item.Properties().stacksTo(16).tab(BetterAnimalsPlusMod.TAB));
        this.eggSupplier = egg;
        this.eggSupplier2 = egg2;
        DispenserBlock.registerBehavior(this, new AbstractProjectileDispenseBehavior() {
            @Override
            protected Projectile getProjectile(Level worldIn, Position position, ItemStack stackIn) {
                return Util.make(eggSupplier.apply(worldIn, position), (p) -> p.setItem(stackIn));
            }
        });
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack itemstack = playerIn.getItemInHand(handIn);

        if (!playerIn.abilities.instabuild) {
            itemstack.shrink(1);
        }

        worldIn.playSound(null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.EGG_THROW, SoundSource.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));

        if (!worldIn.isClientSide) {
            ThrowableItemProjectile ent = eggSupplier2.apply(playerIn.level, playerIn);
            ent.setItem(itemstack);
            ent.shootFromRotation(playerIn, playerIn.xRot, playerIn.yRot, 0.0F, 1.5F, 1.0F);
            worldIn.addFreshEntity(ent);
        }

        playerIn.awardStat(Stats.ITEM_USED.get(this));
        return new InteractionResultHolder<>(InteractionResult.SUCCESS, itemstack);
    }

}
