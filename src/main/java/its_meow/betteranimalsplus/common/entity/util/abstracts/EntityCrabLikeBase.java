package its_meow.betteranimalsplus.common.entity.util.abstracts;

import its_meow.betteranimalsplus.init.ModLootTables;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public abstract class EntityCrabLikeBase extends EntityAnimalWithTypes {

    public int snipTime = 0;

    public EntityCrabLikeBase(EntityType<? extends EntityCrabLikeBase> type, World worldIn) {
        super(type, worldIn);
        this.setPathPriority(PathNodeType.WATER, 10F);
    }
    
    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6.5D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
        this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3D);
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        if(snipTime == 0) {
            snipTime = 20;
        }
        Vec3d pos = this.getPositionVector();
        Vec3d targetPos = entityIn.getPositionVector();
        if(entityIn instanceof LivingEntity) {
            ((LivingEntity) entityIn).knockBack(entityIn, 0.1F, pos.x - targetPos.x, pos.z - targetPos.z);
        }
        
        // vanilla things
        
        float f = (float)this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue();

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

}
