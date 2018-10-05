package its_meow.betteranimalsplus.common.entity;

import its_meow.betteranimalsplus.common.entity.projectile.EntityTarantulaHair;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;

public class EntityTarantula extends EntitySpider implements IRangedAttackMob {
	
	protected World world;
	
	public EntityTarantula(World worldIn) {
		super(worldIn);
		this.world = worldIn;
	}
	
	protected void initEntityAI()
    {
        this.tasks.addTask(1, new EntityAISwimming(this));
        EntityAIAttackRanged atkrange = new EntityAIAttackRanged(this, 1.0D, 160, 15.0F);
        atkrange.setMutexBits(4); //Allow it to run at the same time as melee attacks
        this.tasks.addTask(3, atkrange);
        this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4F));
        this.tasks.addTask(3, new EntityAIAttackMelee(this, 0.8D, false));
        this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 0.8D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<EntityPlayer>(this, EntityPlayer.class, true));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget<EntityIronGolem>(this, EntityIronGolem.class, true));
    }



	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {
		EntityTarantulaHair entityhair = new EntityTarantulaHair(this.world, this);
		entityhair.setLocationAndAngles(this.posX, this.posY + 1, this.posZ, 0, 0);
        double d0 = target.posY + (double)target.getEyeHeight() - 1.100000023841858D;
        double d1 = target.posX - this.posX;
        double d2 = d0 - entityhair.posY;
        double d3 = target.posZ - this.posZ;
        float f = MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F;
        entityhair.shoot(d1, d2 + (double)f, d3, 1.5F, 8.0F);
        this.playSound(SoundEvents.BLOCK_CLOTH_PLACE, 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
        this.world.spawnEntity(entityhair);
		
	}

	@Override
	public void setSwingingArms(boolean swingingArms) {
		
	}

	@Override
	protected ResourceLocation getLootTable() {
		return LootTableList.ENTITIES_SPIDER;
	}
	
	

}
