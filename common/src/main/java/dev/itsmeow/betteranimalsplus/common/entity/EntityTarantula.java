package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.interfaces.IContainerEntity;
import dev.itsmeow.betteranimalsplus.common.entity.projectile.EntityTarantulaHair;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

import java.util.EnumSet;

public class EntityTarantula extends SpiderEntity implements IRangedAttackMob, IContainerEntity<EntityTarantula> {

    public EntityTarantula(EntityType<? extends EntityTarantula> entityType, World worldIn) {
        super(entityType, worldIn);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new SwimGoal(this));
        RangedAttackGoal atkrange = new RangedAttackGoal(this, 1.0D, 160, 15.0F);
        atkrange.setFlags(EnumSet.of(Goal.Flag.TARGET)); // Allow it to run at the same time as melee attacks
        this.goalSelector.addGoal(2, atkrange);
        this.goalSelector.addGoal(3, new LeapAtTargetGoal(this, 0.4F));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 0.8D, false));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 0.8D));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
    }

    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        EntityTarantulaHair entityhair = new EntityTarantulaHair(this.level, this);
        entityhair.moveTo(this.getX(), this.getY() + 1, this.getZ(), 0, 0);
        double d0 = target.getY() + target.getEyeHeight() - 1.100000023841858D;
        double d1 = target.getX() - this.getX();
        double d2 = d0 - entityhair.getY();
        double d3 = target.getZ() - this.getZ();
        float f = MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F;
        entityhair.shoot(d1, d2 + f, d3, 1.5F, 8.0F);
        this.playSound(SoundEvents.WOOL_PLACE, 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        this.level.addFreshEntity(entityhair);

    }

    @Override
    public ILivingEntityData finalizeSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason, ILivingEntityData entityLivingData, CompoundNBT itemNbt) {
        this.moveTo(this.getX(), this.getY(), this.getZ(), this.yRot, 0F);
        return super.finalizeSpawn(world, difficulty, reason, entityLivingData, itemNbt);
    }
    
    @Override
    public boolean removeWhenFarAway(double range) {
        return despawn(range);
    }

    @Override
    public EntityTarantula getImplementation() {
        return this;
    }

    @Override
    public EntityTypeContainer<? extends EntityTarantula> getContainer() {
        return ModEntities.TARANTULA;
    }
}
