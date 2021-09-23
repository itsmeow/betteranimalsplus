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
        atkrange.setMutexFlags(EnumSet.of(Goal.Flag.TARGET)); // Allow it to run at the same time as melee attacks
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
    public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {
        EntityTarantulaHair entityhair = new EntityTarantulaHair(this.world, this);
        entityhair.setLocationAndAngles(this.getPosX(), this.getPosY() + 1, this.getPosZ(), 0, 0);
        double d0 = target.getPosY() + target.getEyeHeight() - 1.100000023841858D;
        double d1 = target.getPosX() - this.getPosX();
        double d2 = d0 - entityhair.getPosY();
        double d3 = target.getPosZ() - this.getPosZ();
        float f = MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F;
        entityhair.shoot(d1, d2 + f, d3, 1.5F, 8.0F);
        this.playSound(SoundEvents.BLOCK_WOOL_PLACE, 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
        this.world.addEntity(entityhair);

    }

    @Override
    public ILivingEntityData onInitialSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason, ILivingEntityData entityLivingData, CompoundNBT itemNbt) {
        this.setLocationAndAngles(this.getPosX(), this.getPosY(), this.getPosZ(), this.rotationYaw, 0F);
        return super.onInitialSpawn(world, difficulty, reason, entityLivingData, itemNbt);
    }
    
    @Override
    public boolean canDespawn(double range) {
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
