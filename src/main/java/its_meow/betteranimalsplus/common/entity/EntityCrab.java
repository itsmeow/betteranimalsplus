package its_meow.betteranimalsplus.common.entity;

import dev.itsmeow.imdlib.entity.util.EntityTypeContainer;
import its_meow.betteranimalsplus.common.entity.util.EntityUtil;
import its_meow.betteranimalsplus.common.entity.util.abstracts.EntityCrabLikeBase;
import its_meow.betteranimalsplus.init.ModEntities;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class EntityCrab extends EntityCrabLikeBase {

    protected static final DataParameter<Integer> CRAB_RAVE = EntityDataManager.createKey(EntityCrab.class, DataSerializers.VARINT);

    public EntityCrab(World world) {
        super(ModEntities.CRAB.entityType, world);
        this.setPathPriority(PathNodeType.WATER, 10F);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new MeleeAttackGoal(this, 0.9D, true) {
            @Override
            public boolean shouldExecute() {
                return EntityCrab.this.world.getDifficulty() != Difficulty.PEACEFUL && super.shouldExecute() && this.attacker.getHealth() > this.attacker.getMaxHealth() / 2F;
            }

            @Override
            public boolean shouldContinueExecuting() {
                return EntityCrab.this.world.getDifficulty() != Difficulty.PEACEFUL && super.shouldContinueExecuting() && this.attacker.getHealth() > this.attacker.getMaxHealth() / 2F;
            }
        });
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, PlayerEntity.class, 20F, 0.8F, 1.0F));
        this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 0.3D));
        this.targetSelector.addGoal(1, new AIHurtByTarget());
    }


    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(CRAB_RAVE, 0);
    }
    public int getIsCrabRave() {
        return this.dataManager.get(CRAB_RAVE);
    }

    private void setCrabRave(int in) {
        this.dataManager.set(CRAB_RAVE, in);
    }

    @Override
    public boolean canDespawn(double arg) {
        return this.getIsCrabRave() == 0 && super.canDespawn(arg);
    }

    public void crabRave() {
        this.setCrabRave(this.getRNG().nextInt(3) + 1);
        this.setAttackTarget(null);
        this.navigator.clearPath();
    }

    public void unCrabRave() {
        this.setCrabRave(0);
    }

    @Override
    public boolean isAIDisabled() {
        return this.getIsCrabRave() != 0;
    }

    @Override
    protected EntityCrab getBaseChild() {
        return new EntityCrab(this.world);
    }

    @Override
    public ILivingEntityData onInitialSpawn(IWorld world, DifficultyInstance difficulty, SpawnReason reason, ILivingEntityData livingdata, CompoundNBT compound) {
        return EntityUtil.childChance(this, reason, super.onInitialSpawn(world, difficulty, reason, livingdata, compound), 0.25F);
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
        public void startExecuting() {
            super.startExecuting();

            if(EntityCrab.this.isChild()) {
                this.alertOthers();
                this.resetTask();
            }
        }

        @Override
        protected void setAttackTarget(MobEntity mob, LivingEntity living) {
            if (mob instanceof EntityCrab && !mob.isChild()) {
                super.setAttackTarget(mob, living);
            }
        }
    }

    @Override
    public EntityTypeContainer<EntityCrab> getContainer() {
        return ModEntities.CRAB;
    }

}
