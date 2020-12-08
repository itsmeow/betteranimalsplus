package its_meow.betteranimalsplus.common.entity.util.abstracts;

import its_meow.betteranimalsplus.common.entity.EntityHorseshoeCrab;
import its_meow.betteranimalsplus.init.ModLootTables;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.pathfinding.PathType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import java.util.Random;

public abstract class EntityCrabLikeBase extends EntityAnimalWithTypes {

    public int snipTime = 0;

    public EntityCrabLikeBase(EntityType<? extends EntityCrabLikeBase> type, World worldIn) {
        super(type, worldIn);
        this.setPathPriority(PathNodeType.WATER, 10F);
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        if(snipTime == 0) {
            snipTime = 20;
        }
        Vector3d pos = this.getPositionVec();
        Vector3d targetPos = entityIn.getPositionVec();
        if(entityIn instanceof LivingEntity) {
            ((LivingEntity) entityIn).applyKnockback(0.1F, pos.x - targetPos.x, pos.z - targetPos.z);
        }
        
        // vanilla things
        
        float f = (float)this.getAttribute(Attributes.ATTACK_DAMAGE).getValue();

        if(entityIn instanceof LivingEntity) {
            f += EnchantmentHelper.getModifierForCreature(this.getHeldItemMainhand(), ((LivingEntity)entityIn).getCreatureAttribute());
        }
        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), f);
        if(flag) {
            if(entityIn instanceof PlayerEntity) {
                PlayerEntity entityplayer = (PlayerEntity)entityIn;
                ItemStack itemstack = this.getHeldItemMainhand();
                ItemStack itemstack1 = entityplayer.isHandActive() ? entityplayer.getActiveItemStack() : ItemStack.EMPTY;
                if(!itemstack.isEmpty() && !itemstack1.isEmpty() && itemstack.getItem().canDisableShield(itemstack, itemstack1, entityplayer, this) && itemstack1.getItem().isShield(itemstack1, entityplayer)) {
                    float f1 = 0.25F + (float)EnchantmentHelper.getEfficiencyModifier(this) * 0.05F;
                    if(this.rand.nextFloat() < f1) {
                        entityplayer.getCooldownTracker().setCooldown(itemstack1.getItem(), 100);
                        this.world.setEntityState(entityplayer, (byte)30);
                    }
                }
            }
            this.applyEnchantments(this, entityIn);
        }
        return flag;
    }

    @Override
    public void tick() {
        super.tick();
        if(snipTime == 0 && Math.random() < 0.005) {
            snipTime = 20;
        } else if(snipTime > 0) {
            snipTime--;
        } else {
            snipTime = 0;
        }
    }
    
    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }

    @Override
    public boolean canSpawn(IWorld p_213380_1_, SpawnReason p_213380_2_) {
        return true;
    }

    @Override
    public int getTalkInterval() {
        return 120;
    }

    @Override
    protected int getExperiencePoints(PlayerEntity player) {
        return 1 + this.world.rand.nextInt(3);
    }

    @Override
    public boolean isPushedByWater() {
        return false;
    }
    
    @Override
    protected ResourceLocation getLootTable() {
        return ModLootTables.CRAB;
    }

    @Override
    public boolean canDespawn(double range) {
        return !this.hasCustomName() && super.canDespawn(range);
    }

    public static <T extends EntityCrabLikeBase> boolean canCrabSpawn(EntityType<T> type, IServerWorld world, SpawnReason reason, BlockPos pos, Random rand) {
        return (world.getBlockState(pos).allowsMovement(world, pos, PathType.WATER) || world.getBlockState(pos).allowsMovement(world, pos, PathType.LAND)) && !world.getBlockState(pos.down()).allowsMovement(world, pos.down(), PathType.LAND) && !world.getBlockState(pos.down()).allowsMovement(world, pos.down(), PathType.WATER);
    }
}
