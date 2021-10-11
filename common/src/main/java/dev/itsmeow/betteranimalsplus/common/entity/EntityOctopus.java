package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.betteranimalsplus.common.entity.ai.HungerNearestAttackableTargetGoal;
import dev.itsmeow.betteranimalsplus.common.entity.ai.HybridMoveController;
import dev.itsmeow.betteranimalsplus.common.entity.ai.HybridPathNavigator;
import dev.itsmeow.betteranimalsplus.common.entity.ai.PeacefulNearestAttackableTargetGoal;
import dev.itsmeow.betteranimalsplus.common.entity.util.IHaveHunger;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityBAPCephalopod;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityWaterMobPathing;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.betteranimalsplus.init.ModLootTables;
import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.interfaces.IVariantTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.pathfinder.BlockPathTypes;

import java.util.UUID;

public class EntityOctopus extends EntityBAPCephalopod implements IVariantTypes<EntityWaterMobPathing>, IHaveHunger<EntityWaterMobPathing> {

    public UUID friend = null;
    private int hunger = 0;

    public EntityOctopus(EntityType<? extends EntityOctopus> entityType, Level world) {
        super(entityType, world);
        this.setPathfindingMalus(BlockPathTypes.WALKABLE, 1.5F);
        this.setPathfindingMalus(BlockPathTypes.WATER, 1.5F);
        this.setPathfindingMalus(BlockPathTypes.WATER_BORDER, 1F);
        this.moveControl = new HybridMoveController(this);
        this.maxUpStep = 1F;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new GoToWaterGoal(this, 2D));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 0.8D, true));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, WaterAnimal.class, 10.0F));
        this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(3, new MoveRandomGoal(this));
        this.targetSelector.addGoal(0, new HurtByTargetGoal(this) {
            @Override
            public boolean canUse() {
                return EntityOctopus.this.level.getDifficulty() != Difficulty.PEACEFUL && "blue_ringed".equals(EntityOctopus.this.getVariantNameOrEmpty()) && super.canUse();
            }

            @Override
            public void start() {
                super.start();
                if(this.mob.getLastHurtByMob() instanceof Player && ((Player) this.mob.getLastHurtByMob()).getGameProfile().getId() == friend) {
                    EntityOctopus.this.friend = null;
                }
            }
        });
        this.targetSelector.addGoal(1, new OctopusAIAttackForFriend(this));
        this.targetSelector.addGoal(2, new PeacefulNearestAttackableTargetGoal<>(this, Player.class, 0, true, true, e -> (friend == null || ((Player) e).getGameProfile().getId() != friend) && e.distanceTo(EntityOctopus.this) < 4D && "blue_ringed".equals(EntityOctopus.this.getVariantNameOrEmpty())));
        this.targetSelector.addGoal(3, new HungerNearestAttackableTargetGoal<>(this, WaterAnimal.class, 0, true, true, e -> !(e instanceof Enemy) && e.getDimensions(Pose.STANDING).width < this.getDimensions(Pose.STANDING).width));
    }

    @Override
    protected PathNavigation createNavigation(Level worldIn) {
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
            ((LivingEntity)entityIn).addEffect(new MobEffectInstance(MobEffects.POISON, 200, 1, false, false));
        }
        return b;
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        if(!"blue_ringed".equals(this.getVariantNameOrEmpty()) && ItemTags.FISHES.contains(player.getItemInHand(hand).getItem()) && !this.isBaby()) {
            this.friend = player.getGameProfile().getId();
            if(!player.isCreative()) {
                player.getItemInHand(hand).shrink(1);
            }
            if(this.getCommandSenderWorld() instanceof ServerLevel) {
                ServerLevel s = (ServerLevel) this.getCommandSenderWorld();
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
            Player p = octo.level.getPlayerByUUID(octo.friend);
            return p != null && p.getKillCredit() != null;
        }

        @Override
        public void start() {
            Player p = octo.level.getPlayerByUUID(octo.friend);
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
        protected boolean isValidTarget(LevelReader worldIn, BlockPos pos) {
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
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        this.writeType(compound);
        this.writeHunger(compound);
        if(friend != null) {
            compound.putUUID("Friend", this.friend);
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.readType(compound);
        this.readHunger(compound);
        if (compound.contains("Friend"))
            this.friend = compound.getUUID("Friend");
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, SpawnGroupData livingdata, CompoundTag compound) {
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
