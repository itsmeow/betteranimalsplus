package dev.itsmeow.betteranimalsplus.common.item;

import dev.itsmeow.betteranimalsplus.BetterAnimalsPlusMod;
import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.IPosition;
import net.minecraft.dispenser.ProjectileDispenseBehavior;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.world.World;

import java.util.function.BiFunction;

public class ItemThrowableCustomEgg extends Item {

    private final BiFunction<World, IPosition, ProjectileItemEntity> eggSupplier;
    private final BiFunction<World, LivingEntity, ProjectileItemEntity> eggSupplier2;

    public ItemThrowableCustomEgg(BiFunction<World, IPosition, ProjectileItemEntity> egg, BiFunction<World, LivingEntity, ProjectileItemEntity> egg2) {
        super(new Item.Properties().stacksTo(16).tab(BetterAnimalsPlusMod.GROUP));
        this.eggSupplier = egg;
        this.eggSupplier2 = egg2;
        DispenserBlock.registerBehavior(this, new ProjectileDispenseBehavior() {
            @Override
            protected ProjectileEntity getProjectile(World worldIn, IPosition position, ItemStack stackIn) {
                return Util.make(eggSupplier.apply(worldIn, position), (p) -> p.setItem(stackIn));
            }
        });
    }

    @Override
    public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getItemInHand(handIn);

        if(!playerIn.abilities.instabuild) {
            itemstack.shrink(1);
        }

        worldIn.playSound(null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.EGG_THROW, SoundCategory.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));

        if(!worldIn.isClientSide) {
            ProjectileItemEntity ent = eggSupplier2.apply(playerIn.level, playerIn);
            ent.setItem(itemstack);
            ent.shootFromRotation(playerIn, playerIn.xRot, playerIn.yRot, 0.0F, 1.5F, 1.0F);
            worldIn.addFreshEntity(ent);
        }

        playerIn.awardStat(Stats.ITEM_USED.get(this));
        return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
    }

}
