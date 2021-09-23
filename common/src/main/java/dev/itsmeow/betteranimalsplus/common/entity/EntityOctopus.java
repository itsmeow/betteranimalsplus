package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.interfaces.IVariantTypes;
import dev.itsmeow.betteranimalsplus.common.entity.ai.HungerNearestAttackableTargetGoal;
import dev.itsmeow.betteranimalsplus.common.entity.ai.HybridMoveController;
import dev.itsmeow.betteranimalsplus.common.entity.ai.HybridPathNavigator;
import dev.itsmeow.betteranimalsplus.common.entity.ai.PeacefulNearestAttackableTargetGoal;
import dev.itsmeow.betteranimalsplus.common.entity.util.IHaveHunger;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityBAPCephalopod;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityWaterMobPathing;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.betteranimalsplus.init.ModLootTables;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.WaterMobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.UUID;

import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityBAPCephalopod.MoveRandomGoal;

public class EntityOctopus extends EntityBAPCephalopod implements IVariantTypes<EntityWaterMobPathing>, IHaveHunger<EntityWaterMobPathing> {

    public UUID friend = null;
    private int hunger = 0;

    public EntityOctopus(EntityType<? extends EntityOctopus> entityType, World world) {
        super(entityType, world);
        this.setPathfindingMalus(PathNodeType.WALKABLE, 1.5F);
        this.setPathfindingMalus(PathNodeType.WATER, 1.5F);
        this.setPathfindingMalus(PathNodeType.WATER_BORDER, 1F);
        this.moveControl = new HybridMoveController(this);
        this.maxUpStep = 1F;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new GoToWaterGoal(this, 2D));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 0.8D, true));
        this.goalSelector.addGoal(2, new LookAtGoal(this, WaterMobEntity.class, 10.0F));
        this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(3, new MoveRandomGoal(this));
        this.targetSelector.addGoal(0, new HurtByTargetGoal(this) {
            @Override
            public boolean canUse() {
                return EntityOctopus.this.level.getDifficulty() != Difficulty.PEACEFUL && "blue_ringed".equals(EntityOctopus.this.getVariantNameOrEmpty()) && super.canUse();
            }

            @Override
            public void start() {
                super.start();
                if(this.mob.getLastHurtByMob() instanceof PlayerEntity && ((PlayerEntity) this.mob.getLastHurtByMob()).getGameProfile().getId() == friend) {
                    EntityOctopus.this.friend = null;
                }
            }
        });
        this.targetSelector.addGoal(1, new OctopusAIAttackForFriend(this));
        this.targetSelector.addGoal(2, new PeacefulNearestAttackableTargetGoal<>(this, PlayerEntity.class, 0, true, true, e -> (friend == null || ((PlayerEntity) e).getGameProfile().getId() != friend) && e.distanceTo(EntityOctopus.this) < 4D && "blue_ringed".equals(EntityOctopus.this.getVariantNameOrEmpty())));
        this.targetSelector.addGoal(3, new HungerNearestAttackableTargetGoal<>(this, WaterMobEntity.class, 0, true, true, e -> !(e instanceof IMob) && e.getDimensions(Pose.STANDING).width < this.getDimensions(Pose.STANDING).width));
    }

    @Override
    protected PathNavigator createNavigation(World worldIn) {
        return new HybridPathNavigator<>(this, worldIn, e -> e.getTarget() == null || (e.getTarget().isInWater() && this.isInWater()) || (!e.getTarget().isInWater() && this.isInWater()));
    }

    @Override
    protected void handleAirSupply(int air) {
        if(this.isAlive() && !this.isInWaterOrBubble()) {
            this.setAirSupply(air - 1);
            if(this.getAirSupply() == -20) {
                this.setAirSupply(0);
                this.hurt(DamageSource.DROWN, 2.0F);
            }
        } else {
            this.setAirSupply(1600);
        }
    }

    @Override
    public int getHunger() {
        return hunger;
    }

    @Override
    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.tickCount % 20 == 0) {
            this.incrementHunger();
        }
    }

    @Override
    public boolean doHurtTarget(Entity entityIn) {
        boolean b = super.doHurtTarget(entityIn);
        if(b && entityIn instanceof LivingEntity && "blue_ringed".equals(this.getVariantNameOrEmpty())) {
            ((LivingEntity)entityIn).addEffect(new EffectInstance(Effects.POISON, 200, 1, false, false));
        }
        return b;
    }

    @Override
    public ActionResultType mobInteract(PlayerEntity player, Hand hand) {
        if(!"blue_ringed".equals(this.getVariantNameOrEmpty()) && ItemTags.FISHES.contains(player.getItemInHand(hand).getItem()) && !this.isBaby()) {
            this.friend = player.getGameProfile().getId();
            if(!player.isCreative()) {
                player.getItemInHand(hand).shrink(1);
            }
            if(this.getCommandSenderWorld() instanceof ServerWorld) {
                ServerWorld s = (ServerWorld) this.getCommandSenderWorld();
                s.sendParticles(ParticleTypes.HEART, this.position().x(), this.position().y(), this.position().z(), 20, 0.5, 0.5, 0.5, 0.3D);
            }
        }
        return super.mobInteract(player, hand);
    }

    public boolean isAboveBlock() {
        return level.isLoaded(this.blockPosition().below()) && level.getBlockState(this.blockPosition().below()).canOcclude() && this.getY() - (double) ((int) this.getY()) <= 0.25D;
    }

    @Override
    protected ResourceLocation getDefaultLootTable() {
        return ModLootTables.OCTOPUS;
    }

    @Override
    public EntityTypeContainer<? extends EntityOctopus> getContainer() {
        return ModEntities.OCTOPUS;
    }

    public static class OctopusAIAttackForFriend extends Goal {

        EntityOctopus octo;

        public OctopusAIAttackForFriend(EntityOctopus entity) {
            this.octo = entity;
        }

        @Override
        public boolean canUse() {
            if(this.octo.friend == null) {
                return false;
            }
            PlayerEntity p = octo.level.getPlayerByUUID(octo.friend);
            return p != null && p.getKillCredit() != null;
        }

        @Override
        public void start() {
            PlayerEntity p = octo.level.getPlayerByUUID(octo.friend);
            this.octo.setTarget(p.getKillCredit());
        }

        @Override
        public boolean canContinueToUse() {
            return false;
        }

    }

    public static class GoToWaterGoal extends MoveToBlockGoal {
        private final EntityOctopus octo;

        public GoToWaterGoal(EntityOctopus octo, double speed) {
            super(octo, speed, 24);
            this.octo = octo;
            this.verticalSearchStart = -1;
        }

        @Override
        public boolean canContinueToUse() {
            return !this.octo.isInWater() && this.tryTicks <= 1200 && this.isValidTarget(this.octo.level, this.blockPos);
        }

        @Override
        public boolean canUse() {
            return !this.octo.isInWater() && this.octo.getTarget() == null && super.canUse();
        }

        @Override
        public boolean shouldRecalculatePath() {
            return this.tryTicks % 160 == 0;
        }

        @Override
        protected boolean isValidTarget(IWorldReader worldIn, BlockPos pos) {
            Block block = worldIn.getBlockState(pos).getBlock();
            return block == Blocks.WATER;
        }
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.registerTypeKey();
    }

    @Override
    public void addAdditionalSaveData(CompoundNBT compound) {
        super.addAdditionalSaveData(compound);
        this.writeType(compound);
        this.writeHunger(compound);
        if(friend != null) {
            compound.putUUID("Friend", this.friend);
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundNBT compound) {
        super.readAdditionalSaveData(compound);
        this.readType(compound);
        this.readHunger(compound);
        this.friend = compound.getUUID("Friend");
    }

    @Override
    @Nullable
    public ILivingEntityData finalizeSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData livingdata, CompoundNBT compound) {
        this.setInitialHunger();
        return this.initData(world, reason, super.finalizeSpawn(world, difficulty, reason, livingdata, compound));
    }

    @Override
    public EntityOctopus getImplementation() {
        return this;
    }

    @Override
    public boolean removeWhenFarAway(double range) {
        return super.removeWhenFarAway(range) && this.friend == null;
    }
}
