package dev.itsmeow.betteranimalsplus.common.entity.util.abstracts;

import dev.itsmeow.betteranimalsplus.common.entity.ai.HybridMoveController;
import dev.itsmeow.betteranimalsplus.common.entity.ai.HybridPathNavigator;
import dev.itsmeow.betteranimalsplus.common.entity.ai.PeacefulNearestAttackableTargetGoal;
import dev.itsmeow.betteranimalsplus.common.entity.util.IPeacefulAware;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.goal.BreathAirGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.TryFindWaterGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;

public abstract class EntityCrocidilian extends EntityAnimalWithTypes implements Enemy, IPeacefulAware {

    public EntityCrocidilian(EntityType<? extends EntityCrocidilian> entityType, Level level) {
        super(entityType, level);
        this.setPathfindingMalus(BlockPathTypes.WALKABLE, 1.5F);
        this.setPathfindingMalus(BlockPathTypes.WATER, 1.5F);
        this.setPathfindingMalus(BlockPathTypes.WATER_BORDER, 1F);
        this.moveControl = new HybridMoveController(this);
        this.maxUpStep = 1F;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new BreathAirGoal(this));
        this.goalSelector.addGoal(0, new TryFindWaterGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1D, true));
        this.goalSelector.addGoal(3, new RandomSwimmingGoal(this, 1.0D, 10));
        this.targetSelector.addGoal(0, new HurtByTargetGoal(this) {
            @Override
            public boolean canUse() {
                return !EntityCrocidilian.this.isPeaceful() && super.canUse();
            }
        });
        this.targetSelector.addGoal(1, new PeacefulNearestAttackableTargetGoal<>(this, Player.class, 15, false, false, e -> !e.isPassenger()));
    }

    public boolean isPeaceful() {
        return this.level.getDifficulty() == Difficulty.PEACEFUL;
    }

    @Override
    protected PathNavigation createNavigation(Level worldIn) {
        return new HybridPathNavigator<>(this, worldIn, e -> e.getTarget() == null || (e.getTarget().isInWater() && this.isInWater()) || (!e.getTarget().isInWater() && this.isInWater()));
    }

    @Override
    public void travel(Vec3 moveVec) {
        if(this.isEffectiveAi() && this.isInWater()) {
            this.moveRelative(0.1F, moveVec);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9D));
            if(this.getTarget() == null) {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.005D, 0.0D));
            }
        } else {
            super.travel(moveVec);
        }

    }

    @Override
    public boolean canBeLeashed(Player player) {
        return false;
    }

    @Override
    public int getMaxAirSupply() {
        return 4800;
    }

    @Override
    protected int increaseAirSupply(int currentAir) {
        return this.getMaxAirSupply();
    }

    @Override
    public boolean canBreatheUnderwater() {
        return false;
    }

    @Override
    public boolean isPushedByFluid() {
        return false;
    }

    @Override
    public MobType getMobType() {
        return MobType.WATER;
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel world, AgeableMob ageable) {
        return null;
    }

    @Override
    protected EntityAnimalWithTypes getBaseChild() {
        return null;
    }

}
