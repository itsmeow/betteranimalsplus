package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.betteranimalsplus.common.entity.util.EntityUtil;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityCrabLikeBase;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.util.EntityTypeContainerContainable;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.pathfinder.BlockPathTypes;

public class EntityCrab extends EntityCrabLikeBase {

    protected static final EntityDataAccessor<Integer> CRAB_RAVE = SynchedEntityData.defineId(EntityCrab.class, EntityDataSerializers.INT);
    private int raveTicks = 0;

    public EntityCrab(EntityType<? extends EntityCrab> entityType, Level worldIn) {
        super(entityType, worldIn);
        this.setPathfindingMalus(BlockPathTypes.WATER, 10F);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new MeleeAttackGoal(this, 0.9D, true) {
            @Override
            public boolean canUse() {
                return EntityCrab.this.level.getDifficulty() != Difficulty.PEACEFUL && super.canUse() && this.mob.getHealth() > this.mob.getMaxHealth() / 2F;
            }

            @Override
            public boolean canContinueToUse() {
                return EntityCrab.this.level.getDifficulty() != Difficulty.PEACEFUL && super.canContinueToUse() && this.mob.getHealth() > this.mob.getMaxHealth() / 2F;
            }
        });
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Player.class, 20F, 0.8F, 1.0F));
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 0.3D));
        this.targetSelector.addGoal(1, new AIHurtByTarget());
    }


    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(CRAB_RAVE, 0);
    }
    public int getIsCrabRave() {
        return this.entityData.get(CRAB_RAVE);
    }

    private void setCrabRave(int in) {
        this.entityData.set(CRAB_RAVE, in);
    }

    @Override
    public boolean removeWhenFarAway(double arg) {
        return this.getIsCrabRave() == 0 && super.removeWhenFarAway(arg);
    }

    public void crabRave() {
        this.setCrabRave(this.getRandom().nextInt(3) + 1);
        this.setTarget(null);
        this.navigation.stop();
        this.raveTicks = 2840; // 2:20 in ticks
    }

    public void unCrabRave() {
        this.setCrabRave(0);
        this.raveTicks = 0;
    }

    @Override
    public void tick() {
        super.tick();
        if(!level.isClientSide()) {
            if (this.raveTicks > 0) {
                this.raveTicks--;
            } else if (this.getIsCrabRave() > 0) {
                this.unCrabRave();
            }
        }
    }

    @Override
    public boolean isNoAi() {
        return this.getIsCrabRave() != 0;
    }

    @Override
    protected EntityCrab getBaseChild() {
        return getContainer().getEntityType().create(level);
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, SpawnGroupData livingdata, CompoundTag compound) {
        return EntityUtil.childChance(this, reason, super.finalizeSpawn(world, difficulty, reason, livingdata, compound), 0.25F);
    }

    @Override
    protected float getWaterSlowDown() {
        return 0F;
    }

    class AIHurtByTarget extends HurtByTargetGoal {
        public AIHurtByTarget() {
            super(EntityCrab.this);
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        @Override
        public void start() {
            super.start();

            if(EntityCrab.this.isBaby()) {
                this.alertOthers();
                this.stop();
            }
        }

        @Override
        protected void alertOther(Mob mob, LivingEntity living) {
            if (mob instanceof EntityCrab && !mob.isBaby()) {
                super.alertOther(mob, living);
            }
        }
    }

    @Override
    public EntityTypeContainer<EntityCrab> getContainer() {
        return ModEntities.CRAB;
    }

    @Override
    public EntityTypeContainerContainable<?, ?> getContainableContainer() {
        return ModEntities.CRAB;
    }
}
