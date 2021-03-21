package its_meow.betteranimalsplus.common.item;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
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
        super(new Item.Properties().maxStackSize(16).group(BetterAnimalsPlusMod.GROUP));
        this.eggSupplier = egg;
        this.eggSupplier2 = egg2;
        DispenserBlock.registerDispenseBehavior(this, new ProjectileDispenseBehavior() {
            @Override
            protected ProjectileEntity getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
                return Util.make(eggSupplier.apply(worldIn, position), (p) -> p.setItem(stackIn));
            }
        });
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        if(!playerIn.abilities.isCreativeMode) {
            itemstack.shrink(1);
        }

        worldIn.playSound(null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.ENTITY_EGG_THROW, SoundCategory.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));

        if(!worldIn.isRemote) {
            ProjectileItemEntity ent = eggSupplier2.apply(playerIn.world, playerIn);
            ent.setItem(itemstack);
            ent.setDirectionAndMovement(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
            worldIn.addEntity(ent);
        }

        playerIn.addStat(Stats.ITEM_USED.get(this));
        return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
    }

}
