package its_meow.betteranimalsplus.common.entity;

import dev.itsmeow.imdlib.entity.util.EntityTypeContainer;
import its_meow.betteranimalsplus.common.entity.ai.EntityAIEatBerries;
import its_meow.betteranimalsplus.common.entity.util.EntityUtil;
import its_meow.betteranimalsplus.common.entity.util.IDropHead;
import its_meow.betteranimalsplus.common.entity.util.abstracts.EntityAnimalWithSelectiveTypes;
import its_meow.betteranimalsplus.common.entity.util.abstracts.EntityAnimalWithTypes;
import its_meow.betteranimalsplus.init.ModEntities;
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

    public EntityBoar(World worldIn) {
        super(ModEntities.BOAR.entityType, worldIn);
        this.setPathPriority(PathNodeType.DANGER_OTHER, 0.0F);
        this.setPathPriority(PathNodeType.DAMAGE_OTHER, 0.0F);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2D, false) {
            @Override
            public boolean shouldExecute() {
                return !EntityBoar.this.isChild() && super.shouldExecute();
            }

            @Override
            public boolean shouldContinueExecuting() {
                return !EntityBoar.this.isChild() && super.shouldContinueExecuting();
            }
        });
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(4, new BoarAIEatCrops(this));
        this.goalSelector.addGoal(5, new EntityAIEatBerries(this, 1.0D, 12, 2) {
            @Override
            protected void eatBerry() {
                super.eatBerry();
                EntityBoar.this.setInLove(null);
            }
        });
        this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.targetSelector.addGoal(0, new HurtByTargetGoal(this) {
            @Override
            public boolean shouldExecute() {
                return !EntityBoar.this.isChild() && !EntityBoar.this.isPeaceful() && super.shouldExecute();
            }

            @Override
            public boolean shouldContinueExecuting() {
                return !EntityBoar.this.isChild() && !EntityBoar.this.isPeaceful() && super.shouldContinueExecuting();
            }
        }.setCallsForHelp(EntityBoar.class));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<AnimalEntity>(this, AnimalEntity.class, 90, true, true, (@Nullable LivingEntity in) -> in instanceof ChickenEntity || in instanceof EntityPheasant || in instanceof AnimalEntity && in.isChild() && !(in instanceof EntityBoar || in instanceof PigEntity || in instanceof HoglinEntity)) {
            @Override
            public boolean shouldExecute() {
                return !EntityBoar.this.isChild() && super.shouldExecute();
            }

            @Override
            public boolean shouldContinueExecuting() {
                return !EntityBoar.this.isChild() && super.shouldContinueExecuting();
            }
        });
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<LivingEntity>(this, LivingEntity.class, 50, true, true, (@Nullable LivingEntity in) -> in instanceof AnimalEntity && !(in instanceof EntityBoar || in instanceof PigEntity || in instanceof HoglinEntity) || in instanceof PlayerEntity) {
            @Override
            public boolean shouldExecute() {
                return !EntityBoar.this.isChild() && !EntityBoar.this.isPeaceful() && super.shouldExecute();
            }

            @Override
            public boolean shouldContinueExecuting() {
                return !EntityBoar.this.isChild() && !EntityBoar.this.isPeaceful() && super.shouldContinueExecuting();
            }
        });
    }

    public boolean isPeaceful() {
        return world.getDifficulty() == Difficulty.PEACEFUL;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_PIG_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_PIG_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_PIG_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.ENTITY_PIG_STEP, 0.15F, 1.0F);
    }

    @Override
    public void onDeath(DamageSource cause) {
        super.onDeath(cause);
        this.doHeadDrop();
    }

    @Override
    protected ResourceLocation getLootTable() {
        return EntityType.PIG.getLootTable();
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        Vector3d pos = this.getPositionVec();
        Vector3d targetPos = entityIn.getPositionVec();
        ((LivingEntity) entityIn).applyKnockback(0.8F, pos.x - targetPos.x, pos.z - targetPos.z);

        // Vanilla attack code for mobs

        float f = (float) this.getAttribute(Attributes.ATTACK_DAMAGE).getValue();
        int i = 0;

        f += EnchantmentHelper.getModifierForCreature(this.getHeldItemMainhand(),
        ((LivingEntity) entityIn).getCreatureAttribute());
        i += EnchantmentHelper.getKnockbackModifier(this);

        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), f);

        if (flag) {
            if (i > 0) {
                ((LivingEntity) entityIn).applyKnockback(i * 0.5F, MathHelper.sin(this.rotationYaw * 0.017453292F), -MathHelper.cos(this.rotationYaw * 0.017453292F));
                this.setMotion(this.getMotion().getX() * 0.6D, this.getMotion().getY(), this.getMotion().getZ() * 0.6D);
            }

            int j = EnchantmentHelper.getFireAspectModifier(this);

            if(j > 0) {
                entityIn.setFire(j * 4);
            }

            if(entityIn instanceof PlayerEntity) {
                PlayerEntity entityplayer = (PlayerEntity) entityIn;
                ItemStack itemstack = this.getHeldItemMainhand();
                ItemStack itemstack1 = entityplayer.isHandActive() ? entityplayer.getActiveItemStack()
                : ItemStack.EMPTY;

                if(!itemstack.isEmpty() && !itemstack1.isEmpty()
                && itemstack.getItem().canDisableShield(itemstack, itemstack1, entityplayer, this)
                && itemstack1.getItem().isShield(itemstack1, entityplayer)) {
                    float f1 = 0.25F + EnchantmentHelper.getEfficiencyModifier(this) * 0.05F;

                    if(this.rand.nextFloat() < f1) {
                        entityplayer.getCooldownTracker().setCooldown(itemstack1.getItem(), 100);
                        this.world.setEntityState(entityplayer, (byte) 30);
                    }
                }
            }

            this.applyEnchantments(this, entityIn);
        }

        return flag;
    }

    @Override
    public void func_241841_a(ServerWorld p_241841_1_, LightningBoltEntity p_241841_2_) {
        if (!this.world.isRemote && !this.dead) {
            ZombifiedPiglinEntity entitypigzombie = EntityType.ZOMBIFIED_PIGLIN.create(this.world);
            entitypigzombie.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.GOLDEN_SWORD));
            entitypigzombie.setLocationAndAngles(this.getPosX(), this.getPosY(), this.getPosZ(), this.rotationYaw, this.rotationPitch);
            entitypigzombie.setNoAI(this.isAIDisabled());

            if(this.hasCustomName()) {
                entitypigzombie.setCustomName(this.getCustomName());
                entitypigzombie.setCustomNameVisible(true);
            }

            this.world.addEntity(entitypigzombie);
            this.remove();
        }
    }

    @Override
    public AgeableEntity func_241840_a(ServerWorld world, AgeableEntity ageable) {
        if(this.getVariant().isPresent()) {
            if (ageable instanceof EntityBoar) {
                EntityBoar boar = new EntityBoar(this.world);
                boar.setType(this.getVariant().get());
                return boar;
            } else if (ageable instanceof PigEntity) {
                PigEntity pig = new PigEntity(EntityType.PIG, this.world);
                EntityBoar boar = new EntityBoar(this.world);
                boar.setType(this.getVariant().get());
                return this.rand.nextBoolean() ? pig : boar;
            }
        }
        return null;
    }

    @Override
    public boolean canMateWith(AnimalEntity otherAnimal) {
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
    public boolean isBreedingItem(ItemStack stack) {
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
        public boolean shouldExecute() {
            if(this.runDelay <= 0) {
                if(!net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.boar.world, this.boar)) {
                    return false;
                }
            }

            return !this.boar.isInLove() && super.shouldExecute();
        }

        @Override
        public boolean shouldContinueExecuting() {
            return !this.boar.isInLove() && super.shouldContinueExecuting();
        }

        @Override
        public void tick() {
            if(!this.destinationBlock.withinDistance(this.creature.getPositionVec(), this.getTargetDistanceSq())) {
                this.boar.getMoveHelper().setMoveTo((double) this.destinationBlock.getX() + 0.5D, this.destinationBlock.getY(), (double) this.destinationBlock.getZ() + 0.5D, this.movementSpeed);
            } else {
                World world = this.boar.world;
                BlockPos pos = this.destinationBlock;
                BlockState state = world.getBlockState(pos);
                Block block = state.getBlock();

                if(!this.boar.isInLove() && block instanceof CropsBlock && ((CropsBlock) block).isMaxAge(state)) {
                    world.setBlockState(pos, Blocks.AIR.getDefaultState(), 2);
                    world.destroyBlock(pos, true);
                    boar.setInLove(null);
                }
            }
            this.boar.getLookController().setLookPosition((double) this.destinationBlock.getX() + 0.5D, this.destinationBlock.getY() + 0.5D, (double) this.destinationBlock.getZ() + 0.5D, 10.0F, (float) this.boar.getVerticalFaceSpeed());
        }

        @Override
        protected boolean shouldMoveTo(IWorldReader worldIn, BlockPos pos) {
            BlockState state = worldIn.getBlockState(pos);
            Block block = state.getBlock();
            if(!this.boar.isInLove() && block instanceof CropsBlock && ((CropsBlock) block).isMaxAge(state)) {
                return worldIn.getBlockState(pos.down()).getBlock() == Blocks.FARMLAND;
            }
            return false;
        }
    }

    @Override
    protected EntityAnimalWithTypes getBaseChild() {
        return new EntityBoar(world);
    }

    @Override
    public ILivingEntityData onInitialSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason, ILivingEntityData livingdata, CompoundNBT compound) {
        return EntityUtil.childChance(this, reason, super.onInitialSpawn(world, difficulty, reason, livingdata, compound), 0.25F);
    }

}
