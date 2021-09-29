package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.betteranimalsplus.common.entity.projectile.EntityTarantulaHair;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.interfaces.IContainerEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import java.util.EnumSet;

public class EntityTarantula extends Spider implements RangedAttackMob, IContainerEntity<EntityTarantula> {

    public EntityTarantula(EntityType<? extends EntityTarantula> entityType, Level worldIn) {
        super(entityType, worldIn);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        RangedAttackGoal atkrange = new RangedAttackGoal(this, 1.0D, 160, 15.0F);
        atkrange.setFlags(EnumSet.of(Goal.Flag.TARGET)); // Allow it to run at the same time as melee attacks
        this.goalSelector.addGoal(2, atkrange);
        this.goalSelector.addGoal(3, new LeapAtTargetGoal(this, 0.4F));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 0.8D, false));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.8D));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
    }

    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        EntityTarantulaHair entityhair = new EntityTarantulaHair(ModEntities.PROJECTILE_TARANTULA_HAIR.get(), this.level, this);
        entityhair.moveTo(this.getX(), this.getY() + 1, this.getZ(), 0, 0);
        double d0 = target.getY() + target.getEyeHeight() - 1.100000023841858D;
        double d1 = target.getX() - this.getX();
        double d2 = d0 - entityhair.getY();
        double d3 = target.getZ() - this.getZ();
        float f = Mth.sqrt(d1 * d1 + d3 * d3) * 0.2F;
        entityhair.shoot(d1, d2 + f, d3, 1.5F, 8.0F);
        this.playSound(SoundEvents.WOOL_PLACE, 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        this.level.addFreshEntity(entityhair);

    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, SpawnGroupData entityLivingData, CompoundTag itemNbt) {
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
