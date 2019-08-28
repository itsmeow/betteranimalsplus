package its_meow.betteranimalsplus.common.entity;

import java.util.EnumSet;
import java.util.Set;

import javax.annotation.Nullable;

import its_meow.betteranimalsplus.common.entity.projectile.EntityBadgerDirt;
import its_meow.betteranimalsplus.init.ModEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

public class EntityBadger extends EntityAnimalWithSelectiveTypes implements IMob {

    public EntityBadger(World worldIn) {
        super(ModEntities.getEntityType("badger"), worldIn);
    }

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new SwimGoal(this));
		if (!this.isChild() && this.getEntityWorld().getDifficulty() != Difficulty.PEACEFUL) {
			this.goalSelector.addGoal(1, new EntityAIBadgerDigDirtThrow(this));
			this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 0.5D, true));
		}
		this.goalSelector.addGoal(3, new RandomWalkingGoal(this, 0.4D));
		this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 6.0F));
		if (!this.isChild() && this.getEntityWorld().getDifficulty() != Difficulty.PEACEFUL) {
			this.targetSelector.addGoal(0, new HurtByTargetGoal(this, new Class[0]));
			this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<AnimalEntity>(this, AnimalEntity.class, 90, true, true, (@Nullable LivingEntity in) -> in instanceof ChickenEntity || in instanceof EntityPheasant || (in instanceof AnimalEntity && ((AnimalEntity) in).isChild() && !(in instanceof EntityBadger))));
		}
	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(12.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4D);
		this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.5D);
	}

	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		// Vanilla attack code for mobs
		float f = (float) this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue();
		int i = 0;

		if (entityIn instanceof LivingEntity) {
			f += EnchantmentHelper.getModifierForCreature(this.getHeldItemMainhand(), ((LivingEntity) entityIn).getCreatureAttribute());
			i += EnchantmentHelper.getKnockbackModifier(this);
		}

		boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), f);

		if (flag) {
			if (i > 0 && entityIn instanceof LivingEntity) {
				((LivingEntity) entityIn).knockBack(this, i * 0.5F, MathHelper.sin(this.rotationYaw * 0.017453292F), (-MathHelper.cos(this.rotationYaw * 0.017453292F)));
				this.setMotion(this.getMotion().getX() * 0.6D, this.getMotion().getY(), this.getMotion().getZ() * 0.6D);
			}

			int j = EnchantmentHelper.getFireAspectModifier(this);

			if (j > 0) {
				entityIn.setFire(j * 4);
			}

			if (entityIn instanceof PlayerEntity) {
				PlayerEntity entityplayer = (PlayerEntity) entityIn;
				ItemStack itemstack = this.getHeldItemMainhand();
				ItemStack itemstack1 = entityplayer.isHandActive() ? entityplayer.getActiveItemStack() : ItemStack.EMPTY;

				if (!itemstack.isEmpty() && !itemstack1.isEmpty() && itemstack.getItem().canDisableShield(itemstack, itemstack1, entityplayer, this) && itemstack1.getItem().isShield(itemstack1, entityplayer)) {
					float f1 = 0.25F + EnchantmentHelper.getEfficiencyModifier(this) * 0.05F;

					if (this.rand.nextFloat() < f1) {
						entityplayer.getCooldownTracker().setCooldown(itemstack1.getItem(), 100);
						this.world.setEntityState(entityplayer, (byte) 30);
					}
				}
			}

			this.applyEnchantments(this, entityIn);
		}

		return flag;
	}

	@Override
	public int getVariantMax() {
		return 3;
	}

	@Override
	protected IVariantTypes getBaseChild() {
		return new EntityBadger(this.world);
	}

	public static class EntityAIBadgerDigDirtThrow extends Goal {

		private final EntityBadger badger;
		public int tick = 0;
		private int stateId = -1;

		public EntityAIBadgerDigDirtThrow(EntityBadger badger) {
			this.badger = badger;
			this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.TARGET));
		}

		@Override
		public boolean shouldExecute() {
			tick = 0;
			World world = badger.world;
			BlockPos below = badger.getPosition().down();
			if(world.isBlockPresent(below)) {
				BlockState state = world.getBlockState(below);
				double dist = badger.getAttackTarget() == null ? 0 : Math.sqrt(badger.getPosition().distanceSq(badger.getAttackTarget().getPosition()));
				return badger.getAttackTarget() != null && dist < 10 && dist > 2 && (state.getBlock() == Blocks.DIRT || state.getBlock() == Blocks.GRASS_BLOCK || state.getBlock() == Blocks.SAND || state.getBlock() == Blocks.GRAVEL || state.getBlock() == Blocks.MYCELIUM);
			}
			return false;
		}

		@Override
		public boolean shouldContinueExecuting() {
			boolean onDiggable = false;
			World world = badger.world;
			BlockPos below = badger.getPosition().down();
			if(world.isBlockPresent(below)) {
				BlockState state = world.getBlockState(below);
				if(state.getBlock() == Blocks.DIRT || state.getBlock() == Blocks.GRASS_BLOCK || state.getBlock() == Blocks.SAND || state.getBlock() == Blocks.GRAVEL || state.getBlock() == Blocks.MYCELIUM) {
					if(state.getBlock() == Blocks.GRASS_BLOCK) {
						state = Blocks.DIRT.getDefaultState();
					}
					stateId = Block.getStateId(state);
					onDiggable = true;
				}
			}
			double dist = badger.getAttackTarget() == null ? 0 : Math.sqrt(badger.getPosition().distanceSq(badger.getAttackTarget().getPosition()));
			return badger.getAttackTarget() != null && tick <= 200 + Math.random() * 300 && dist < 10 && dist > 2 && onDiggable;
		}

		@Override
		public void startExecuting() {
			World world = badger.world;
			BlockPos below = badger.getPosition().down();
			if(world.isBlockPresent(below)) {
				BlockState state = world.getBlockState(below);
				if(state.getBlock() == Blocks.DIRT || state.getBlock() == Blocks.GRASS_BLOCK || state.getBlock() == Blocks.SAND || state.getBlock() == Blocks.GRAVEL || state.getBlock() == Blocks.MYCELIUM) {
					if(state.getBlock() == Blocks.GRASS_BLOCK) {
						state = Blocks.DIRT.getDefaultState();
					}
					stateId = Block.getStateId(state);
					tick = 1;      
				}
			}
		}

		@Override
		public void tick() {
			tick++;
			LivingEntity t = badger.getAttackTarget();
			if(tick % 15 == 0) { // Throw dirt every second (20 ticks)
				EntityBadgerDirt proj = new EntityBadgerDirt(badger.world, badger, stateId);
				proj.setLocationAndAngles(badger.posX, badger.posY + 1, badger.posZ, 0, 0);
				double d0 = t.posY + t.getEyeHeight() - 1.100000023841858D;
				double d1 = t.posX - badger.posX;
				double d2 = d0 - proj.posY;
				double d3 = t.posZ - badger.posZ;
				float f = MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F;
				proj.shoot(d1, d2 + f, d3, 0.6F, 4.8F);
				badger.playSound(SoundEvents.BLOCK_GRASS_BREAK, 1.0F, 1.0F / (badger.getRNG().nextFloat() * 0.4F + 0.8F));
				badger.world.addEntity(proj);
			}
			if(tick % 5 == 0) {
				badger.playSound(SoundEvents.BLOCK_GRASS_BREAK, 1.0F, 1.0F / (badger.getRNG().nextFloat() * 0.4F + 0.8F));
			}
		}

		@Override
		public void resetTask() {
			tick = 0;
		}

	}
	
    @Override
    protected int[] getTypesFor(Set<BiomeDictionary.Type> types) {
        if(types.contains(Type.FOREST) && !types.contains(Type.CONIFEROUS)) {
            return new int[] {2};
        } else if(types.contains(Type.CONIFEROUS) && !types.contains(Type.SNOWY)) {
            return new int[] {1};
        } else if(types.contains(Type.CONIFEROUS) && types.contains(Type.SNOWY)) {
            return new int[] {1};
        } else {
            return new int[] {1, 2, 3};
        }
    }

    @Override
    protected String getContainerName() {
        return "badger";
    }

}