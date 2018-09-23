package its_meow.betteranimalsplus.entity.miniboss.hirschgeist;

import com.google.common.base.Predicate;

import its_meow.betteranimalsplus.entity.miniboss.hirschgeist.ai.HirschgeistAIAttackMelee;
import its_meow.betteranimalsplus.entity.miniboss.hirschgeist.ai.HirschgeistAIFlameAttack;
import its_meow.betteranimalsplus.registry.LootTableRegistry;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFindEntityNearestPlayer;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.dragon.phase.IPhase;
import net.minecraft.entity.boss.dragon.phase.PhaseList;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenEndPodium;

public class EntityHirschgeist extends EntityLiving implements IMob {

	public EntityHirschgeist(World worldIn) {
		super(worldIn);
		//this.setSize(3, 4);
	}

	@Override
	public void initEntityAI() {
		super.initEntityAI();
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new HirschgeistAIAttackMelee(this, 0.7D));
		this.tasks.addTask(2, new HirschgeistAIFlameAttack(this));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 15F));
		this.targetTasks.addTask(1, new EntityAIFindEntityNearestPlayer(this));
	}
	
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(150.0D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(50.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.65D);
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
	}

	public boolean isDaytime() {
		return !(world.getWorldTime() >= 13000 && world.getWorldTime() <= 23000);
	}
	
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		if(this.isDaytime()) {
			this.setSize(1,2);
		} else {
			this.setSize(3, 4);
		}
	}
	
	
	
	@Override
	protected ResourceLocation getLootTable() {
		return LootTableRegistry.hirschgeist;
	}

	@Override
	public boolean attackable() {
		return !this.isDaytime();
	}
	
	

	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		return this.isDaytime() ? false : super.attackEntityFrom(source, amount);
	}

	@Override
	public void setAttackTarget(EntityLivingBase entityIn) {
		super.setAttackTarget(this.isDaytime() ? null : entityIn);
	}

	public Vec3d getHeadLookVec(float p_184665_1_)
	{
		Vec3d vec3d;
		if(this.getAttackTarget() != null) {
			BlockPos blockpos = this.getAttackTarget().getPosition();
			float f = Math.max(MathHelper.sqrt(this.getDistanceSqToCenter(blockpos)) / 4.0F, 1.0F);
			float f1 = 6.0F / f;
			float f2 = this.rotationPitch;
			float f3 = 1.5F;
			this.rotationPitch = -f1 * 1.5F * 5.0F;
			vec3d = this.getLook(p_184665_1_);
			this.rotationPitch = f2;

			return vec3d;
		}
		return null;
	}


}
