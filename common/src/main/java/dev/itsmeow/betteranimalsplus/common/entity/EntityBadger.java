package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.betteranimalsplus.common.entity.projectile.EntityBadgerDirt;
import dev.itsmeow.betteranimalsplus.common.entity.util.EntityUtil;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityAnimalWithSelectiveTypes;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.util.BiomeTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.EnumSet;
import java.util.Set;

public class EntityBadger extends EntityAnimalWithSelectiveTypes implements Enemy {

	private static final String[] SAVANNA_TYPES = new String[] { "honey" };
	private static final String[] FOREST_TYPES = new String[] { "european" };
	private static final String[] CONIFEROUS_TYPES = new String[] { "american" };
	private static final String[] ALL_TYPES = new String[] { "american", "european", "honey" };

    public EntityBadger(EntityType<? extends EntityBadger> entityType, Level worldIn) {
        super(entityType, worldIn);
    }

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));
		if (!this.isBaby() && this.getCommandSenderWorld().getDifficulty() != Difficulty.PEACEFUL) {
			this.goalSelector.addGoal(1, new EntityAIBadgerDigDirtThrow(this));
			this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 0.5D, true));
		}
		this.goalSelector.addGoal(3, new RandomStrollGoal(this, 0.4D));
		this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 6.0F));
		if (!this.isBaby() && this.getCommandSenderWorld().getDifficulty() != Difficulty.PEACEFUL) {
			this.targetSelector.addGoal(0, new HurtByTargetGoal(this));
			this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Animal.class, 90, true, true, (LivingEntity in) -> in instanceof Chicken || in instanceof EntityPheasant || (in instanceof Animal && in.isBaby() && !(in instanceof EntityBadger))));
		}
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
			this.setFlags(EnumSet.of(Flag.MOVE, Flag.TARGET));
		}

		@Override
		public boolean canUse() {
			tick = 0;
			Level world = badger.level;
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
			Level world = badger.level;
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
			Level world = badger.level;
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
			if(tick % 15 == 0) { // Throw dirt every second (20 ticks)
				LivingEntity t = badger.getTarget();
				EntityBadgerDirt proj = new EntityBadgerDirt(ModEntities.PROJECTILE_BADGER_DIRT.get(), badger.level, badger, stateId);
				proj.moveTo(badger.getX(), badger.getY() + 1, badger.getZ(), 0, 0);
				double d0 = t.getY() + t.getEyeHeight() - 1.100000023841858D;
				double d1 = t.getX() - badger.getX();
				double d2 = d0 - proj.getY();
				double d3 = t.getZ() - badger.getZ();
				double f = Math.sqrt(d1 * d1 + d3 * d3) * 0.2F;
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
    public String[] getTypesFor(ResourceKey<Biome> biomeKey, Biome biome, Set<BiomeTypes.Type> types, MobSpawnType reason) {
        if(types.contains(BiomeTypes.SAVANNA)) {
            return SAVANNA_TYPES;
        } else if(types.contains(BiomeTypes.FOREST) && !types.contains(BiomeTypes.CONIFEROUS)) {
            return FOREST_TYPES;
        } else if(types.contains(BiomeTypes.CONIFEROUS)) {
            return CONIFEROUS_TYPES;
        } else {
            return ALL_TYPES;
        }
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, SpawnGroupData livingdata, CompoundTag compound) {
        return EntityUtil.childChance(this, reason, super.finalizeSpawn(world, difficulty, reason, livingdata, compound), 0.25F);
    }

    @Override
    public EntityTypeContainer<EntityBadger> getContainer() {
        return ModEntities.BADGER;
    }

}