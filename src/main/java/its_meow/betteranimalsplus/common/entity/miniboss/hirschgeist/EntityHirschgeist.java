package its_meow.betteranimalsplus.common.entity.miniboss.hirschgeist;

import its_meow.betteranimalsplus.common.entity.miniboss.hirschgeist.ai.HirschgeistAIAttackMelee;
import its_meow.betteranimalsplus.common.entity.miniboss.hirschgeist.ai.HirschgeistAIFlameAttack;
import its_meow.betteranimalsplus.init.LootTableRegistry;
import its_meow.betteranimalsplus.init.MobRegistry;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFindEntityNearestPlayer;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.thread.SidedThreadGroups;
import net.minecraftforge.fml.loading.FMLEnvironment;

public class EntityHirschgeist extends EntityLiving implements IMob {

	public EntityHirschgeist(World worldIn) {
		super(MobRegistry.getType(EntityHirschgeist.class), worldIn);
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

	@Override
	protected void registerAttributes()
	{
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(150.0D);
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(50.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.65D);
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
	}

	public boolean isDaytime() {
		long time = this.world.getDayTime() % 24000L; // Time can go over values of 24000, so divide and take the remainder
		return !(time >= 13000L && time <= 23000L);
	}

	@Override
	public void livingTick() {
		super.livingTick();
		if(this.isDaytime()) {
			this.setSize(1,2);
		} else {
			this.setSize(3, 4);
		}
	}
	
	
	
	@Override
	public boolean canSpawn(IWorld world, boolean b) {
		if(this.world.getEntitiesWithinAABB(EntityHirschgeist.class, this.getBoundingBox().grow(150)).size() == 1) {
			return false;
		} else {
			return false;
		}
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.ENTITY_SKELETON_HORSE_AMBIENT;
	}

	@Override
	protected float getSoundPitch() {
		return 0.3F; // Lower pitch of skeleton horse sound
	}

	@Override
	protected void playStepSound(BlockPos pos, IBlockState state)
	{
		this.playSound(SoundEvents.ENTITY_SHEEP_STEP, 0.5F, 0.6F);
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
		if(this.isDaytime() && FMLEnvironment.dist == Dist.CLIENT && Thread.currentThread().getThreadGroup() == SidedThreadGroups.CLIENT) {
			if(source.getTrueSource() instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer) source.getTrueSource();
				player.sendMessage(new TextComponentString("The " + I18n.format("entity.betteranimalsplus.Hirschgeist") + " is immortal in the daytime. Try fighting it later."));
			}
		}
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
			this.rotationPitch = -f1 * 1.5F * 5.0F;
			vec3d = this.getLook(p_184665_1_);
			this.rotationPitch = f2;

			return vec3d;
		}
		return null;
	}


}
