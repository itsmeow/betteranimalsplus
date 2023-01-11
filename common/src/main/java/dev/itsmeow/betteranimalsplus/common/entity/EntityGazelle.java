package dev.itsmeow.betteranimalsplus.common.entity;

import com.google.common.collect.Lists;
import dev.itsmeow.betteranimalsplus.common.entity.util.EntityUtil;
import dev.itsmeow.betteranimalsplus.common.entity.util.IDropHead;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityAnimalEatsGrassWithTypes;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityAnimalWithTypes;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.random.WeightedRandom;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.behavior.LongJumpToRandomPos;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EntityGazelle extends EntityAnimalEatsGrassWithTypes implements IDropHead<EntityAnimalWithTypes> {

    public EntityGazelle(EntityType<? extends EntityGazelle> entityType, Level level) {
        super(entityType, level, 6);
    }

    @Override
    protected int calculateFallDamage(float f, float g) {
        return super.calculateFallDamage(f, g) - 5;
    }

    @Override
    public int getEatTime() {
        return eatTimer;
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void handleEntityEvent(byte id) {
        if (id == 10) {
            this.eatTimer = 40;
        } else {
            super.handleEntityEvent(id);
        }
    }

    @Override
    public void baseTick() {
        super.baseTick();
        if (this.level.isClientSide) {
            this.eatTimer = Math.max(0, this.eatTimer - 1);
        }
    }

    @Override
    public boolean isFood(ItemStack stack) {
        Item i = stack.getItem();
        return i == Items.WHEAT || i == Items.CARROT || i == Items.GOLDEN_CARROT || i == Items.APPLE || i == Items.GOLDEN_APPLE;
    }

    @Override
    public int getMaxSpawnClusterSize() {
        return 4;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.SHEEP_STEP, 0.15F, 1.0F);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new BreedGoal(this, 0.45D));
        this.goalSelector.addGoal(2, new PanicGoal(this, 0.65D));
        ItemLike[] temptItems = new ItemLike[]{Items.APPLE, Items.GOLDEN_APPLE, Items.CARROT, Items.CARROT_ON_A_STICK, Items.GOLDEN_CARROT, Items.WHEAT};
        this.goalSelector.addGoal(3, new TemptGoal(this, 0.45D, Ingredient.of(temptItems), false));
        this.goalSelector.addGoal(4, new AvoidEntityGoal<>(this, Player.class, 20, 0.55D, 0.7D));
        this.goalSelector.addGoal(5, new FollowParentGoal(this, 1D));
        // Eat Grass at Priority 6
        this.goalSelector.addGoal(6, new RandomStrollGoal(this, 0.45D));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(8, new LongJumpToRandomPosGoal(this, 1, 2, 1.5F, m -> SoundEvents.GOAT_LONG_JUMP, LongJumpToRandomPos::defaultAcceptableLandingSpot));
    }

    @Override
    public void ate() {
        super.ate();
        this.ageUp(60);
    }

    @Override
    public void die(DamageSource cause) {
        super.die(cause);
        this.doHeadDrop();
    }

    @Override
    protected EntityGazelle getBaseChild() {
        return getContainer().getEntityType().create(level);
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, SpawnGroupData livingdata, CompoundTag compound) {
        return EntityUtil.childChance(this, reason, super.finalizeSpawn(world, difficulty, reason, livingdata, compound), 0.25F);
    }

    @Override
    public EntityTypeContainer<EntityGazelle> getContainer() {
        return ModEntities.GAZELLE;
    }

    /*
    Cannibalized vanilla code, converted to a Goal
    Absolutely devious
     */
    public static class LongJumpToRandomPosGoal extends Goal {

        private static final List<Integer> ALLOWED_ANGLES = Lists.newArrayList(new Integer[]{65, 70, 75, 80});
        protected final int maxLongJumpHeight;
        protected final int maxLongJumpWidth;
        protected final float maxJumpVelocity;
        protected List<LongJumpToRandomPos.PossibleJump> jumpCandidates;
        protected Optional<Vec3> initialPosition;
        @Nullable
        protected Vec3 chosenJump;
        protected Vec3 chosenPos;
        protected int findJumpTries;
        protected long prepareJumpStart;
        private final Function<Mob, SoundEvent> getJumpSound;
        private final BiPredicate<Mob, BlockPos> acceptableLandingSpot;
        private final Mob mob;
        private int ticksRan = 0;

        public LongJumpToRandomPosGoal(Mob mob, int maxLongJumpHeight, int maxLongJumpWidth, float maxJumpVelocity, Function<Mob, SoundEvent> soundEvent, BiPredicate<Mob, BlockPos> acceptableLandingSpot) {
            this.mob = mob;
            this.setFlags(EnumSet.of(Flag.LOOK, Flag.TARGET));
            this.jumpCandidates = Lists.newArrayList();
            this.initialPosition = Optional.empty();
            this.maxLongJumpHeight = maxLongJumpHeight;
            this.maxLongJumpWidth = maxLongJumpWidth;
            this.maxJumpVelocity = maxJumpVelocity;
            this.getJumpSound = soundEvent;
            this.acceptableLandingSpot = acceptableLandingSpot;
        }

        @Override
        public boolean canUse() {
            return mob.isOnGround() && !mob.isInWater() && !mob.isInLava() && !mob.level.getBlockState(mob.blockPosition()).is(Blocks.HONEY_BLOCK);
        }

        @Override
        public boolean canContinueToUse() {
            return this.initialPosition.isPresent() && ((Vec3)this.initialPosition.get()).equals(mob.position()) && this.findJumpTries > 0 && !mob.isInWaterOrBubble() && (this.chosenJump != null || !this.jumpCandidates.isEmpty());
        }

        @Override
        public void start() {
            super.start();
            mob.setDiscardFriction(false);
            this.chosenJump = null;
            this.chosenPos = null;
            this.findJumpTries = 20;
            this.initialPosition = Optional.of(mob.position());
            this.ticksRan = 0;
            BlockPos blockPos = mob.blockPosition();
            int i = blockPos.getX();
            int j = blockPos.getY();
            int k = blockPos.getZ();
            this.jumpCandidates = BlockPos.betweenClosedStream(i - this.maxLongJumpWidth, j - this.maxLongJumpHeight, k - this.maxLongJumpWidth, i + this.maxLongJumpWidth, j + this.maxLongJumpHeight, k + this.maxLongJumpWidth).filter((blockPos2) -> {
                return !blockPos2.equals(blockPos);
            }).map((blockPos2) -> {
                return new LongJumpToRandomPos.PossibleJump(blockPos2.immutable(), Mth.ceil(blockPos.distSqr(blockPos2)));
            }).collect(Collectors.toCollection(Lists::newArrayList));
        }

        @Override
        public void tick() {
            super.tick();
            if (this.chosenJump != null) {
                if (this.ticksRan - this.prepareJumpStart >= 40L) {
                    mob.setYRot(mob.yBodyRot);
                    mob.setDiscardFriction(true);
                    double d = this.chosenJump.length();
                    double e = d + mob.getJumpBoostPower();
                    mob.setDeltaMovement(this.chosenJump.scale(e / d));
                    mob.level.playSound(null, mob, this.getJumpSound.apply(mob), SoundSource.NEUTRAL, 1.0F, 1.0F);
                    mob.lookAt(EntityAnchorArgument.Anchor.FEET, chosenJump);
                }
            } else {
                --this.findJumpTries;
                this.pickCandidate(mob.level, mob, this.ticksRan);
            }
            this.ticksRan++;
        }

        @Override
        public void stop() {
            super.stop();
            this.ticksRan = 0;
            mob.setDiscardFriction(false);
        }


        protected void pickCandidate(Level serverLevel, Mob mob, long l) {
            while(true) {
                if (!this.jumpCandidates.isEmpty()) {
                    Optional<LongJumpToRandomPos.PossibleJump> optional = this.getJumpCandidate(serverLevel);
                    if (optional.isEmpty()) {
                        continue;
                    }

                    LongJumpToRandomPos.PossibleJump possibleJump = optional.get();
                    BlockPos blockPos = possibleJump.getJumpTarget();
                    if (!this.isAcceptableLandingPosition(mob, blockPos)) {
                        continue;
                    }

                    Vec3 vec3 = Vec3.atCenterOf(blockPos);
                    Vec3 vec32 = this.calculateOptimalJumpVector(mob, vec3);
                    if (vec32 == null) {
                        continue;
                    }

                    PathNavigation pathNavigation = mob.getNavigation();
                    Path path = pathNavigation.createPath(blockPos, 0, 8);
                    if (path != null && path.canReach()) {
                        continue;
                    }

                    this.chosenJump = vec32;
                    this.chosenPos = vec3;
                    this.prepareJumpStart = l;
                    return;
                }

                return;
            }
        }

        protected Optional<LongJumpToRandomPos.PossibleJump> getJumpCandidate(Level serverLevel) {
            Optional<LongJumpToRandomPos.PossibleJump> optional = WeightedRandom.getRandomItem(serverLevel.random, this.jumpCandidates);
            List var10001 = this.jumpCandidates;
            Objects.requireNonNull(var10001);
            optional.ifPresent(var10001::remove);
            return optional;
        }

        private boolean isAcceptableLandingPosition(Mob mob, BlockPos blockPos) {
            BlockPos blockPos2 = mob.blockPosition();
            int i = blockPos2.getX();
            int j = blockPos2.getZ();
            return i == blockPos.getX() && j == blockPos.getZ() ? false : this.acceptableLandingSpot.test(mob, blockPos);
        }

        @Nullable
        protected Vec3 calculateOptimalJumpVector(Mob mob, Vec3 vec3) {
            List<Integer> list = Lists.newArrayList(ALLOWED_ANGLES);
            Collections.shuffle(list);
            Iterator var4 = list.iterator();

            Vec3 vec32;
            do {
                if (!var4.hasNext()) {
                    return null;
                }

                int i = (Integer)var4.next();
                vec32 = this.calculateJumpVectorForAngle(mob, vec3, i);
            } while(vec32 == null);

            return vec32;
        }

        /**
         * Absolute vanilla clusterfuck, god save us
         */
        @Nullable
        private Vec3 calculateJumpVectorForAngle(Mob mob, Vec3 vec3, int i) {
            Vec3 vec32 = mob.position();
            Vec3 vec33 = (new Vec3(vec3.x - vec32.x, 0.0, vec3.z - vec32.z)).normalize().scale(0.5);
            vec3 = vec3.subtract(vec33);
            Vec3 vec34 = vec3.subtract(vec32);
            float f = (float) i * 3.1415927F / 180.0F;
            double d = Math.atan2(vec34.z, vec34.x);
            double e = vec34.subtract(0.0, vec34.y, 0.0).lengthSqr();
            double g = Math.sqrt(e);
            double h = vec34.y;
            double j = Math.sin(2.0F * f);
            double k = 0.08;
            double l = Math.pow(Math.cos(f), 2.0);
            double m = Math.sin(f);
            double n = Math.cos(f);
            double o = Math.sin(d);
            double p = Math.cos(d);
            double q = e * 0.08 / (g * j - 2.0 * h * l);
            if (q < 0.0) {
                return null;
            } else {
                double r = Math.sqrt(q);
                if (r > (double)this.maxJumpVelocity) {
                    return null;
                } else {
                    double s = r * n;
                    double t = r * m;
                    int u = Mth.ceil(g / s) * 2;
                    double v = 0.0;
                    Vec3 vec35 = null;
                    EntityDimensions entityDimensions = mob.getDimensions(Pose.LONG_JUMPING);

                    for(int w = 0; w < u - 1; ++w) {
                        v += g / (double)u;
                        double x = m / n * v - Math.pow(v, 2.0) * 0.08 / (2.0 * q * Math.pow(n, 2.0));
                        double y = v * p;
                        double z = v * o;
                        Vec3 vec36 = new Vec3(vec32.x + y, vec32.y + x, vec32.z + z);
                        if (vec35 != null && !this.isClearTransition(mob, entityDimensions, vec35, vec36)) {
                            return null;
                        }

                        vec35 = vec36;
                    }

                    return (new Vec3(s * p, t, s * o)).scale(0.949999988079071);
                }
            }
        }

        private boolean isClearTransition(Mob mob, EntityDimensions entityDimensions, Vec3 vec3, Vec3 vec32) {
            Vec3 vec33 = vec32.subtract(vec3);
            double d = Math.min(entityDimensions.width, entityDimensions.height);
            int i = Mth.ceil(vec33.length() / d);
            Vec3 vec34 = vec33.normalize();
            Vec3 vec35 = vec3;

            for(int j = 0; j < i; ++j) {
                vec35 = j == i - 1 ? vec32 : vec35.add(vec34.scale(d * 0.8999999761581421));
                if (!mob.level.noCollision(mob, entityDimensions.makeBoundingBox(vec35))) {
                    return false;
                }
            }

            return true;
        }

    }
}
