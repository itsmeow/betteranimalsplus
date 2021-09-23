package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.betteranimalsplus.common.entity.projectile.EntityBadgerDirt;
import dev.itsmeow.betteranimalsplus.common.entity.util.EntityUtil;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityAnimalWithSelectiveTypes;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.Set;

public class EntityBadger extends EntityAnimalWithSelectiveTypes implements IMob {

    public EntityBadger(EntityType<? extends EntityBadger> entityType, World worldIn) {
        super(entityType, worldIn);
    }

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new SwimGoal(this));
		if (!this.isBaby() && this.getCommandSenderWorld().getDifficulty() != Difficulty.PEACEFUL) {
			this.goalSelector.addGoal(1, new EntityAIBadgerDigDirtThrow(this));
			this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 0.5D, true));
		}
		this.goalSelector.addGoal(3, new RandomWalkingGoal(this, 0.4D));
		this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 6.0F));
		if (!this.isBaby() && this.getCommandSenderWorld().getDifficulty() != Difficulty.PEACEFUL) {
			this.targetSelector.addGoal(0, new HurtByTargetGoal(this));
			this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, AnimalEntity.class, 90, true, true, (@Nullable LivingEntity in) -> in instanceof ChickenEntity || in instanceof EntityPheasant || (in instanceof AnimalEntity && in.isBaby() && !(in instanceof EntityBadger))));
		}
	}

	@Override
	public boolean doHurtTarget(Entity entityIn) {
		// Vanilla attack code for mobs
		float f = (float) this.getAttribute(Attributes.ATTACK_DAMAGE).getValue();
		int i = 0;

		if (entityIn instanceof LivingEntity) {
			f += EnchantmentHelper.getDamageBonus(this.getMainHandItem(), ((LivingEntity) entityIn).getMobType());
			i += EnchantmentHelper.getKnockbackBonus(this);
		}

		boolean flag = entityIn.hurt(DamageSource.mobAttack(this), f);

		if (flag) {
			if (i > 0) {
				((LivingEntity) entityIn).knockback(i * 0.5F, MathHelper.sin(this.yRot * 0.017453292F), (-MathHelper.cos(this.yRot * 0.017453292F)));
				this.setDeltaMovement(this.getDeltaMovement().x() * 0.6D, this.getDeltaMovement().y(), this.getDeltaMovement().z() * 0.6D);
			}

			int j = EnchantmentHelper.getFireAspect(this);

			if (j > 0) {
				entityIn.setSecondsOnFire(j * 4);
			}

			if (entityIn instanceof PlayerEntity) {
				PlayerEntity entityplayer = (PlayerEntity) entityIn;
				ItemStack itemstack = this.getMainHandItem();
				ItemStack itemstack1 = entityplayer.isUsingItem() ? entityplayer.getUseItem() : ItemStack.EMPTY;

				if (!itemstack.isEmpty() && !itemstack1.isEmpty() && itemstack.getItem().canDisableShield(itemstack, itemstack1, entityplayer, this) && itemstack1.getItem().isShield(itemstack1, entityplayer)) {
					float f1 = 0.25F + EnchantmentHelper.getBlockEfficiency(this) * 0.05F;

					if (this.random.nextFloat() < f1) {
						entityplayer.getCooldowns().addCooldown(itemstack1.getItem(), 100);
						this.level.broadcastEntityEvent(entityplayer, (byte) 30);
					}
				}
			}

			this.doEnchantDamageEffects(this, entityIn);
		}

		return flag;
	}

	@Override
	protected EntityBadger getBaseChild() {
		return getContainer().getEntityType().create(level);
	}

	public static class EntityAIBadgerDigDirtThrow extends Goal {

		private final EntityBadger badger;
		public int tick = 0;
		private int stateId = -1;

		public EntityAIBadgerDigDirtThrow(EntityBadger badger) {
			this.badger = badger;
			this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.TARGET));
		}

		@Override
		public boolean canUse() {
			tick = 0;
			World world = badger.level;
			BlockPos below = badger.blockPosition().below();
			if(world.isLoaded(below)) {
				BlockState state = world.getBlockState(below);
				double dist = badger.getTarget() == null ? 0 : Math.sqrt(badger.blockPosition().distSqr(badger.getTarget().blockPosition()));
				return badger.getTarget() != null && dist < 10 && dist > 2 && (state.getBlock() == Blocks.DIRT || state.getBlock() == Blocks.GRASS_BLOCK || state.getBlock() == Blocks.SAND || state.getBlock() == Blocks.GRAVEL || state.getBlock() == Blocks.MYCELIUM);
			}
			return false;
		}

		@Override
		public boolean canContinueToUse() {
			boolean onDiggable = false;
			World world = badger.level;
			BlockPos below = badger.blockPosition().below();
			if(world.isLoaded(below)) {
				BlockState state = world.getBlockState(below);
				if(state.getBlock() == Blocks.DIRT || state.getBlock() == Blocks.GRASS_BLOCK || state.getBlock() == Blocks.SAND || state.getBlock() == Blocks.GRAVEL || state.getBlock() == Blocks.MYCELIUM) {
					if(state.getBlock() == Blocks.GRASS_BLOCK) {
						state = Blocks.DIRT.defaultBlockState();
					}
					stateId = Block.getId(state);
					onDiggable = true;
				}
			}
			double dist = badger.getTarget() == null ? 0 : Math.sqrt(badger.blockPosition().distSqr(badger.getTarget().blockPosition()));
			return badger.getTarget() != null && tick <= 200 + Math.random() * 300 && dist < 10 && dist > 2 && onDiggable;
		}

		@Override
		public void start() {
			World world = badger.level;
			BlockPos below = badger.blockPosition().below();
			if(world.isLoaded(below)) {
				BlockState state = world.getBlockState(below);
				if(state.getBlock() == Blocks.DIRT || state.getBlock() == Blocks.GRASS_BLOCK || state.getBlock() == Blocks.SAND || state.getBlock() == Blocks.GRAVEL || state.getBlock() == Blocks.MYCELIUM) {
					if(state.getBlock() == Blocks.GRASS_BLOCK) {
						state = Blocks.DIRT.defaultBlockState();
					}
					stateId = Block.getId(state);
					tick = 1;      
				}
			}
		}

		@Override
		public void tick() {
			tick++;
			LivingEntity t = badger.getTarget();
			if(tick % 15 == 0) { // Throw dirt every second (20 ticks)
				EntityBadgerDirt proj = new EntityBadgerDirt(badger.level, badger, stateId);
				proj.moveTo(badger.getX(), badger.getY() + 1, badger.getZ(), 0, 0);
				double d0 = t.getY() + t.getEyeHeight() - 1.100000023841858D;
				double d1 = t.getX() - badger.getX();
				double d2 = d0 - proj.getY();
				double d3 = t.getZ() - badger.getZ();
				float f = MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F;
				proj.shoot(d1, d2 + f, d3, 0.6F, 4.8F);
				badger.playSound(SoundEvents.GRASS_BREAK, 1.0F, 1.0F / (badger.getRandom().nextFloat() * 0.4F + 0.8F));
				badger.level.addFreshEntity(proj);
			}
			if(tick % 5 == 0) {
				badger.playSound(SoundEvents.GRASS_BREAK, 1.0F, 1.0F / (badger.getRandom().nextFloat() * 0.4F + 0.8F));
			}
		}

		@Override
		public void stop() {
			tick = 0;
		}

	}
	
    @Override
    public String[] getTypesFor(RegistryKey<Biome> biomeKey, Biome biome, Set<BiomeDictionary.Type> types, SpawnReason reason) {
        if(types.contains(Type.SAVANNA)) {
            return new String[] { "honey" };
        } else if(types.contains(Type.FOREST) && !types.contains(Type.CONIFEROUS)) {
            return new String[] { "european" };
        } else if(types.contains(Type.CONIFEROUS) && !types.contains(Type.SNOWY)) {
            return new String[] { "american" };
        } else if(types.contains(Type.CONIFEROUS) && types.contains(Type.SNOWY)) {
            return new String[] { "american" };
        } else {
            return new String[] { "american", "european", "honey" };
        }
    }

    @Override
    public ILivingEntityData finalizeSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason, ILivingEntityData livingdata, CompoundNBT compound) {
        return EntityUtil.childChance(this, reason, super.finalizeSpawn(world, difficulty, reason, livingdata, compound), 0.25F);
    }

    @Override
    public EntityTypeContainer<EntityBadger> getContainer() {
        return ModEntities.BADGER;
    }

}