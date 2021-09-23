package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.betteranimalsplus.common.entity.ai.EntityAIEatBerries;
import dev.itsmeow.betteranimalsplus.common.entity.util.EntityUtil;
import dev.itsmeow.betteranimalsplus.common.entity.util.IDropHead;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityAnimalWithSelectiveTypes;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityAnimalWithTypes;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropsBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.monster.HoglinEntity;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.monster.ZombifiedPiglinEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.*;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

import javax.annotation.Nullable;
import java.util.Set;

public class EntityBoar extends EntityAnimalWithSelectiveTypes implements IMob, IDropHead<EntityAnimalWithTypes> {

    public EntityBoar(EntityType<? extends EntityBoar> entityType, World worldIn) {
        super(entityType, worldIn);
        this.setPathfindingMalus(PathNodeType.DANGER_OTHER, 0.0F);
        this.setPathfindingMalus(PathNodeType.DAMAGE_OTHER, 0.0F);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2D, false) {
            @Override
            public boolean canUse() {
                return !EntityBoar.this.isBaby() && super.canUse();
            }

            @Override
            public boolean canContinueToUse() {
                return !EntityBoar.this.isBaby() && super.canContinueToUse();
            }
        });
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.1D));
        if(this.getContainer().getCustomConfiguration().getBoolean("nerf_options/eat_crops")) {
            this.goalSelector.addGoal(4, new BoarAIEatCrops(this));
            this.goalSelector.addGoal(5, new EntityAIEatBerries(this, 1.0D, 12, 2) {
                @Override
                protected void eatBerry() {
                    super.eatBerry();
                    if (EntityBoar.this.getContainer().getCustomConfiguration().getBoolean("nerf_options/breed_from_crops"))
                        EntityBoar.this.setInLove(null);
                }
            });
        }
        this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.targetSelector.addGoal(0, new HurtByTargetGoal(this) {
            @Override
            public boolean canUse() {
                return !EntityBoar.this.isBaby() && !EntityBoar.this.isPeaceful() && super.canUse();
            }

            @Override
            public boolean canContinueToUse() {
                return !EntityBoar.this.isBaby() && !EntityBoar.this.isPeaceful() && super.canContinueToUse();
            }
        }.setAlertOthers(EntityBoar.class));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<AnimalEntity>(this, AnimalEntity.class, 90, true, true, (@Nullable LivingEntity in) -> in instanceof ChickenEntity || in instanceof EntityPheasant || in instanceof AnimalEntity && in.isBaby() && !(in instanceof EntityBoar || in instanceof PigEntity || in instanceof HoglinEntity)) {
            @Override
            public boolean canUse() {
                return EntityBoar.this.shouldAttack() && EntityBoar.this.attackChance() && super.canUse();
            }

            @Override
            public boolean canContinueToUse() {
                return EntityBoar.this.shouldAttack() && super.canContinueToUse();
            }
        });
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<LivingEntity>(this, LivingEntity.class, 50, true, true, (@Nullable LivingEntity in) -> in instanceof AnimalEntity && !(in instanceof EntityBoar || in instanceof PigEntity || in instanceof HoglinEntity) || in instanceof PlayerEntity) {
            @Override
            public boolean canUse() {
                return EntityBoar.this.shouldAttack() && EntityBoar.this.attackChance() && super.canUse();
            }

            @Override
            public boolean canContinueToUse() {
                return EntityBoar.this.shouldAttack() && super.canContinueToUse();
            }
        });
    }

    public boolean shouldAttack() {
        return !this.isBaby() && !this.isPeaceful();
    }

    public boolean attackChance() {
        return ((double) this.getContainer().getCustomConfiguration().getInt("nerf_options/target_chance") / 100D) > Math.random();
    }

    public boolean isPeaceful() {
        return level.getDifficulty() == Difficulty.PEACEFUL;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.PIG_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.PIG_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.PIG_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.PIG_STEP, 0.15F, 1.0F);
    }

    @Override
    public void die(DamageSource cause) {
        super.die(cause);
        this.doHeadDrop();
    }

    @Override
    protected ResourceLocation getDefaultLootTable() {
        return EntityType.PIG.getDefaultLootTable();
    }

    @Override
    public boolean doHurtTarget(Entity entityIn) {
        Vector3d pos = this.position();
        Vector3d targetPos = entityIn.position();
        ((LivingEntity) entityIn).knockback(0.8F, pos.x - targetPos.x, pos.z - targetPos.z);

        // Vanilla attack code for mobs

        float f = (float) this.getAttribute(Attributes.ATTACK_DAMAGE).getValue();
        int i = 0;

        f += EnchantmentHelper.getDamageBonus(this.getMainHandItem(),
        ((LivingEntity) entityIn).getMobType());
        i += EnchantmentHelper.getKnockbackBonus(this);

        boolean flag = entityIn.hurt(DamageSource.mobAttack(this), f);

        if (flag) {
            if (i > 0) {
                ((LivingEntity) entityIn).knockback(i * 0.5F, MathHelper.sin(this.yRot * 0.017453292F), -MathHelper.cos(this.yRot * 0.017453292F));
                this.setDeltaMovement(this.getDeltaMovement().x() * 0.6D, this.getDeltaMovement().y(), this.getDeltaMovement().z() * 0.6D);
            }

            int j = EnchantmentHelper.getFireAspect(this);

            if(j > 0) {
                entityIn.setSecondsOnFire(j * 4);
            }

            if(entityIn instanceof PlayerEntity) {
                PlayerEntity entityplayer = (PlayerEntity) entityIn;
                ItemStack itemstack = this.getMainHandItem();
                ItemStack itemstack1 = entityplayer.isUsingItem() ? entityplayer.getUseItem()
                : ItemStack.EMPTY;

                if(!itemstack.isEmpty() && !itemstack1.isEmpty()
                && itemstack.getItem().canDisableShield(itemstack, itemstack1, entityplayer, this)
                && itemstack1.getItem().isShield(itemstack1, entityplayer)) {
                    float f1 = 0.25F + EnchantmentHelper.getBlockEfficiency(this) * 0.05F;

                    if(this.random.nextFloat() < f1) {
                        entityplayer.getCooldowns().addCooldown(itemstack1.getItem(), 100);
                        this.level.broadcastEntityEvent(entityplayer, (byte) 30);
                    }
                }
            }

            this.doEnchantDamageEffects(this, entityIn);
        }

        return flag;
    }

    @Override
    public void thunderHit(ServerWorld p_241841_1_, LightningBoltEntity p_241841_2_) {
        if (!this.level.isClientSide && !this.dead) {
            ZombifiedPiglinEntity entitypigzombie = EntityType.ZOMBIFIED_PIGLIN.create(this.level);
            entitypigzombie.setItemSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.GOLDEN_SWORD));
            entitypigzombie.moveTo(this.getX(), this.getY(), this.getZ(), this.yRot, this.xRot);
            entitypigzombie.setNoAi(this.isNoAi());

            if(this.hasCustomName()) {
                entitypigzombie.setCustomName(this.getCustomName());
                entitypigzombie.setCustomNameVisible(true);
            }

            this.level.addFreshEntity(entitypigzombie);
            this.remove();
        }
    }

    @Override
    public AgeableEntity getBreedOffspring(ServerWorld world, AgeableEntity ageable) {
        if(this.getVariant().isPresent()) {
            if (ageable instanceof EntityBoar) {
                EntityBoar boar = getContainer().getEntityType().create(world);
                boar.setType(this.getVariant().get());
                return boar;
            } else if (ageable instanceof PigEntity) {
                PigEntity pig = new PigEntity(EntityType.PIG, this.level);
                EntityBoar boar = getContainer().getEntityType().create(world);
                boar.setType(this.getVariant().get());
                return this.random.nextBoolean() ? pig : boar;
            }
        }
        return null;
    }

    @Override
    public boolean canMate(AnimalEntity otherAnimal) {
        if(otherAnimal != this) {
            if(otherAnimal instanceof EntityBoar || otherAnimal instanceof PigEntity) {
                return otherAnimal.isInLove() && this.isInLove();
            }
        }

        return false;
    }

    @Override
    public boolean isInvulnerableTo(DamageSource source) {
        return super.isInvulnerableTo(source) || source == DamageSource.SWEET_BERRY_BUSH;
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return stack.getItem() == Items.CARROT || stack.getItem() == Items.GOLDEN_CARROT;
    }

    @Override
    public String[] getTypesFor(RegistryKey<Biome> biomeKey, Biome biome, Set<BiomeDictionary.Type> types, SpawnReason reason) {
        if(types.contains(Type.FOREST) && !types.contains(Type.CONIFEROUS)) {
            return new String[] { "1", "2", "3" };
        } else if(types.contains(Type.CONIFEROUS) && !types.contains(Type.SNOWY)) {
            return new String[] { "1", "2", "3" };
        } else if(types.contains(Type.CONIFEROUS) && types.contains(Type.SNOWY)) {
            return new String[] { "1", "4" };
        } else if(types.contains(Type.SNOWY) && !types.contains(Type.CONIFEROUS)) {
            return new String[] { "4" };
        } else if(types.contains(Type.SAVANNA) || types.contains(Type.PLAINS)) {
            return new String[] { "1", "2", "3" };
        } else {
            return new String[] { "1", "2", "3", "4" };
        }
    }

    @Override
    public EntityTypeContainer<EntityBoar> getContainer() {
        return ModEntities.BOAR;
    }

    public static class BoarAIEatCrops extends MoveToBlockGoal {
        private final EntityBoar boar;

        public BoarAIEatCrops(EntityBoar boarIn) {
            super(boarIn, 0.7, 16);
            this.boar = boarIn;
        }

        @Override
        public boolean canUse() {
            if(this.nextStartTick <= 0) {
                if(!net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.boar.level, this.boar)) {
                    return false;
                }
            }

            return !this.boar.isInLove() && super.canUse();
        }

        @Override
        public boolean canContinueToUse() {
            return !this.boar.isInLove() && super.canContinueToUse();
        }

        @Override
        public void tick() {
            if(!this.blockPos.closerThan(this.mob.position(), this.acceptedDistance())) {
                this.boar.getMoveControl().setWantedPosition((double) this.blockPos.getX() + 0.5D, this.blockPos.getY(), (double) this.blockPos.getZ() + 0.5D, this.speedModifier);
            } else {
                World world = this.boar.level;
                BlockPos pos = this.blockPos;
                BlockState state = world.getBlockState(pos);
                Block block = state.getBlock();

                if(!this.boar.isInLove() && block instanceof CropsBlock && ((CropsBlock) block).isMaxAge(state)) {
                    world.setBlock(pos, Blocks.AIR.defaultBlockState(), 2);
                    world.destroyBlock(pos, true);
                    if(boar.getContainer().getCustomConfiguration().getBoolean("nerf_options/breed_from_crops"))
                        boar.setInLove(null);
                }
            }
            this.boar.getLookControl().setLookAt((double) this.blockPos.getX() + 0.5D, this.blockPos.getY() + 0.5D, (double) this.blockPos.getZ() + 0.5D, 10.0F, (float) this.boar.getMaxHeadXRot());
        }

        @Override
        protected boolean isValidTarget(IWorldReader worldIn, BlockPos pos) {
            BlockState state = worldIn.getBlockState(pos);
            Block block = state.getBlock();
            if(!this.boar.isInLove() && block instanceof CropsBlock && ((CropsBlock) block).isMaxAge(state)) {
                return worldIn.getBlockState(pos.below()).getBlock() == Blocks.FARMLAND;
            }
            return false;
        }
    }

    @Override
    protected EntityAnimalWithTypes getBaseChild() {
        return getContainer().getEntityType().create(level);
    }

    @Override
    public ILivingEntityData finalizeSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason, ILivingEntityData livingdata, CompoundNBT compound) {
        return EntityUtil.childChance(this, reason, super.finalizeSpawn(world, difficulty, reason, livingdata, compound), 0.25F);
    }

}
