package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.util.variant.IVariant;
import dev.itsmeow.betteranimalsplus.common.entity.ai.WaterfowlNavigator;
import dev.itsmeow.betteranimalsplus.common.entity.util.EntityUtil;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityAnimalWithTypes;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.betteranimalsplus.init.ModItems;
import dev.itsmeow.betteranimalsplus.init.ModSoundEvents;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.nbt.StringNBT;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.Constants;

import java.util.*;
import java.util.function.Predicate;

import dev.itsmeow.imdlib.entity.interfaces.IVariantTypes.AgeableTypeData;
import net.minecraft.entity.AgeableEntity.AgeableData;

public class EntityGoose extends EntityAnimalWithTypes {

    public int attacksLeft = 0;
    public int lastAttackTime = 0;
    protected final Set<UUID> dislikedPlayers = new HashSet<>();
    private int eatTicks;
    private static final Predicate<ItemEntity> ITEM_SELECTOR = (item) -> !item.hasPickUpDelay() && item.isAlive();
    public int timeUntilNextEgg;
    public static final String PICKUP_BLOCK_LIST_KEY = "pickup_blacklist";

    public EntityGoose(EntityType<? extends EntityGoose> entityType, World worldIn) {
        super(entityType, worldIn);
        this.setCanPickUpLoot(true);
        this.timeUntilNextEgg = this.random.nextInt(6000) + 6000;
        this.setPathfindingMalus(PathNodeType.WATER, 0.0F);
    }

    @Override
    protected PathNavigator createNavigation(World worldIn) {
        return new WaterfowlNavigator(this, worldIn);
    }

    @Override
    protected float getWaterSlowDown() {
        return 0.95F;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(2, new PanicGoal(this, 1.4D) {
            @Override
            public boolean canUse() {
                return this.mob.getTarget() == null && super.canUse();
            }
        });
        this.goalSelector.addGoal(3, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new TemptGoal(this, 1.0D, Ingredient.of(Items.PUMPKIN_SEEDS, Items.WHEAT_SEEDS, Items.BEETROOT_SEEDS, Items.MELON_SEEDS, Items.BREAD), false));
        this.goalSelector.addGoal(5, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(6, new RandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new EntityGoose.FindItemsGoal());
        this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 6.0F));

        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.1D, false) {
            @Override
            public void start() {
                attacksLeft = this.mob.getRandom().nextInt(4) + 1;
                super.start();
            }

            @Override
            public boolean canUse() {
                return super.canUse() && this.mob.tickCount - lastAttackTime > 150 && !EntityGoose.this.isPassive();
            }

            @Override
            public boolean canContinueToUse() {
                return attacksLeft > 0 && super.canContinueToUse();
            }

            @Override
            protected void checkAndPerformAttack(LivingEntity p_190102_1_, double p_190102_2_) {
                if(attacksLeft > 0) {
                    super.checkAndPerformAttack(p_190102_1_, p_190102_2_);
                } else {
                    this.stop();
                }
            }

            @Override
            public void stop() {
                super.stop();
                if(attacksLeft <= 0) {
                    this.mob.setTarget(null);
                }
            }
        });
        this.targetSelector.addGoal(0, new HurtByTargetGoal(this) {
            @Override
            public boolean canUse() {
                return super.canUse() && !EntityGoose.this.isPassive();
            }
        }.setAlertOthers(EntityGoose.class));
        this.targetSelector.addGoal(1, new DislikeTargetGoal(this) {
            @Override
            public boolean canUse() {
                return super.canUse() && !EntityGoose.this.isPassive();
            }
        });
    }

    @Override
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return sizeIn.height;
    }

    protected boolean isPassive() {
        return this.getVariantString().equals("1") || level.getDifficulty() == Difficulty.PEACEFUL;
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if(!this.level.isClientSide && this.isAlive() && this.isEffectiveAi()) {
            ItemStack itemstack = this.getItemBySlot(EquipmentSlotType.MAINHAND);
            if(itemstack.getItem().isEdible() && this.getTarget() == null) {
                ++this.eatTicks;
                if(this.eatTicks > 200) {
                    if(itemstack.getItem() == Items.BREAD) {
                        this.addEffect(new EffectInstance(Effects.POISON, 900));
                    }
                    ItemStack itemstack1 = itemstack.finishUsingItem(this.level, this);

                    if(!itemstack1.isEmpty()) {
                        this.setItemSlot(EquipmentSlotType.MAINHAND, itemstack1);
                    }
                    this.eatTicks = 0;
                } else if(this.eatTicks > 160 && this.random.nextFloat() < 0.1F) {
                    this.playSound(this.getEatingSound(itemstack), 1.0F, 1.0F);
                    this.level.broadcastEntityEvent(this, (byte) 45); // calls handleStatusUpdate((byte) 45);
                }
            }
        }
        if(!this.level.isClientSide && !this.isBaby() && --this.timeUntilNextEgg <= 0) {
            this.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
            this.spawnAtLocation(this.getRandom().nextInt(128) == 0 ? ModItems.GOLDEN_GOOSE_EGG.get() : ModItems.GOOSE_EGG.get(), 1);
            this.timeUntilNextEgg = this.random.nextInt(6000) + 6000;
        }
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void handleEntityEvent(byte id) {
        if(id == 45) {
            ItemStack stack = this.getItemBySlot(EquipmentSlotType.MAINHAND);
            if(!stack.isEmpty()) {
                for(int i = 0; i < 8; ++i) {
                    Vector3d vec3d = (new Vector3d(((double) this.random.nextFloat() - 0.5D) * 0.1D, Math.random() * 0.1D + 0.1D, 0.0D)).xRot(-this.xRot * ((float) Math.PI / 180F)).yRot(-this.yRot * ((float) Math.PI / 180F));
                    this.level.addParticle(new ItemParticleData(ParticleTypes.ITEM, stack), this.getX() + this.getLookAngle().x / 2.0D, this.getY(), this.getZ() + this.getLookAngle().z / 2.0D, vec3d.x, vec3d.y + 0.05D, vec3d.z);
                }
            }
        } else {
            super.handleEntityEvent(id);
        }
    }

    @Override
    public void setTarget(LivingEntity entity) {
        super.setTarget(entity);
        if(entity instanceof PlayerEntity) {
            UUID uuid = ((PlayerEntity) entity).getGameProfile().getId();
            dislikedPlayers.add(uuid);
        }
    }

    @Override
    public boolean doHurtTarget(Entity entityIn) {
        if(attacksLeft > 0) {
            attacksLeft--;
        }
        this.lastAttackTime = this.tickCount;
        return super.doHurtTarget(entityIn);
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if(source.getEntity() != null && source.getEntity() != null && source.getEntity() == this.getTarget()) {
            this.lastAttackTime = 0; // allow instant retaliation
        }
        return super.hurt(source, amount);
    }

    @Override
    protected void dropAllDeathLoot(DamageSource damageSourceIn) {
        ItemStack itemstack = this.getItemBySlot(EquipmentSlotType.MAINHAND);
        if (!itemstack.isEmpty()) {
            this.spawnAtLocation(itemstack);
            this.setItemSlot(EquipmentSlotType.MAINHAND, ItemStack.EMPTY);
        }

        super.dropAllDeathLoot(damageSourceIn);
    }

    @Override
    public boolean canTakeItem(ItemStack stack) {
        EquipmentSlotType type = MobEntity.getEquipmentSlotForItem(stack);
        if (!this.getItemBySlot(type).isEmpty()) {
            return false;
        } else {
            return type == EquipmentSlotType.MAINHAND && super.canTakeItem(stack);
        }
    }

    @Override
    public boolean canHoldItem(ItemStack newStack) {
        ItemStack oldStack = this.getItemBySlot(EquipmentSlotType.MAINHAND);
        return !isPickupBlacklisted(newStack.getItem()) && (oldStack.isEmpty() || this.eatTicks == 0 && newStack.getItem().isEdible() && !oldStack.getItem().isEdible());
    }
    
    public boolean isPickupBlacklisted(Item item) {
        String id = item.getRegistryName().toString();
        for(String itemsId : getContainer().getCustomConfiguration().getStringListHolder(PICKUP_BLOCK_LIST_KEY).get()) {
            if (itemsId.startsWith("#")) {
                if (item.getTags().contains(new ResourceLocation(itemsId.substring(1)))) {
                    return true;
                }
            } else if(id.equals(itemsId)) {
                return true;
            }
        }
        return false;
    }

    private void dropItem(ItemStack stack) {
        if (!stack.isEmpty() && !this.level.isClientSide) {
            ItemEntity itementity = new ItemEntity(this.level, this.getX() + this.getLookAngle().x, this.getY() + 1.0D, this.getZ() + this.getLookAngle().z, stack);
            itementity.setPickUpDelay(40);
            itementity.setThrower(this.getUUID());
            this.playSound(SoundEvents.FOX_SPIT, 1.0F, 1.0F);
            this.level.addFreshEntity(itementity);
        }
    }

    private void spawnItem(ItemStack stack) {
        ItemEntity entity = new ItemEntity(this.level, this.getX(), this.getY(), this.getZ(), stack);
        this.level.addFreshEntity(entity);
    }

    @Override
    public SoundEvent getAmbientSound() {
        return ModSoundEvents.GOOSE_AMBIENT.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSoundEvents.GOOSE_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSoundEvents.GOOSE_DEATH.get();
    }

    @Override
    protected void pickUpItem(ItemEntity itemEntity) {
        ItemStack stack = itemEntity.getItem();
        if (this.canHoldItem(stack)) {
            int i = stack.getCount();
            if (i > 1) {
                this.spawnItem(stack.split(i - 1));
            }
            this.dropItem(this.getItemBySlot(EquipmentSlotType.MAINHAND));
            this.setItemSlot(EquipmentSlotType.MAINHAND, stack.split(1));
            this.handDropChances[EquipmentSlotType.MAINHAND.getIndex()] = 2.0F;
            this.take(itemEntity, stack.getCount());
            itemEntity.remove();
            this.eatTicks = 0;
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundNBT compound) {
        super.addAdditionalSaveData(compound);
        ListNBT list = new ListNBT();
        for(UUID uuid : dislikedPlayers) {
            list.add(StringNBT.valueOf(uuid.toString()));
        }
        compound.put("disliked_players", list);
    }

    @Override
    public void readAdditionalSaveData(CompoundNBT compound) {
        super.readAdditionalSaveData(compound);
        compound.getList("disliked_players", Constants.NBT.TAG_STRING).forEach(nbt -> dislikedPlayers.add(UUID.fromString(nbt.getAsString())));
    }

    @Override
    public ILivingEntityData finalizeSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason, ILivingEntityData livingdata, CompoundNBT compound) {
        // getRandomType() should really pass in some more information...
        String[] types;
        switch (reason) {
        case NATURAL:
            types = new String[] {"2","3"};
            break;
        case CHUNK_GENERATION:
            types = new String[] {"2","3"};
            break;
        case STRUCTURE:
            types = new String[] {"2","3"};
            break;
        case BREEDING:
            types = new String[] {"1"};
            break;
        default:
            types = new String[] {"1","2","3"};
            break;
        }
        livingdata = EntityUtil.childChance(this, reason, livingdata, 0.25F);
        IVariant variant = this.getContainer().getVariantForName(types[this.getRandom().nextInt(types.length)]);
        if (livingdata instanceof AgeableTypeData) {
            variant = ((AgeableTypeData) livingdata).typeData;
        } else if (livingdata instanceof AgeableData) {
            livingdata = new AgeableTypeData((AgeableData) livingdata, variant);
        } else {
            livingdata = new AgeableTypeData(variant);
        }
        this.setType(variant);
        return livingdata;
    }

    public static boolean canGooseSpawn(EntityType<EntityGoose> type, IWorld world, SpawnReason reason, BlockPos pos, Random rand) {
        Block downBlock = world.getBlockState(pos.below()).getBlock();
        return ((downBlock == Blocks.GRASS_BLOCK && nearWater(world, pos)) || downBlock == Blocks.WATER) && world.getRawBrightness(pos, 0) > 8 && world.isEmptyBlock(pos);
    }

    protected static boolean nearWater(IWorld world, BlockPos pos) {
        int i = 12;
        int j = 2;
        BlockPos.Mutable newpos = new BlockPos.Mutable();
        for(int k = 0; k <= j; k = k > 0 ? -k : 1 - k) {
            for(int l = 0; l < i; ++l) {
                for(int i1 = 0; i1 <= l; i1 = i1 > 0 ? -i1 : 1 - i1) {
                    for(int j1 = i1 < l && i1 > -l ? l : 0; j1 <= l; j1 = j1 > 0 ? -j1 : 1 - j1) {
                        newpos.set(pos).move(i1, k - 1, j1);
                        if(newpos.getX() >> 4 == pos.getX() >> 4 && newpos.getZ() >> 4 == pos.getZ() >> 4 && world.getBlockState(newpos).getBlock() == Blocks.WATER) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    protected EntityGoose getBaseChild() {
        return getContainer().getEntityType().create(level);
    }

    @Override
    public EntityTypeContainer<EntityGoose> getContainer() {
        return ModEntities.GOOSE;
    }

    public class FindItemsGoal extends Goal {
        public FindItemsGoal() {
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            if (!EntityGoose.this.getItemBySlot(EquipmentSlotType.MAINHAND).isEmpty()) {
                return false;
            } else if (EntityGoose.this.getTarget() == null && EntityGoose.this.getLastHurtByMob() == null) {
                if (EntityGoose.this.getRandom().nextInt(10) != 0) {
                    return false;
                } else {
                    List<ItemEntity> list = EntityGoose.this.level.getEntitiesOfClass(ItemEntity.class, EntityGoose.this.getBoundingBox().inflate(8.0D, 8.0D, 8.0D), EntityGoose.ITEM_SELECTOR);
                    return !list.isEmpty() && EntityGoose.this.getItemBySlot(EquipmentSlotType.MAINHAND).isEmpty();
                }
            } else {
                return false;
            }
        }

        @Override
        public void tick() {
            List<ItemEntity> list = EntityGoose.this.level.getEntitiesOfClass(ItemEntity.class, EntityGoose.this.getBoundingBox().inflate(8.0D, 8.0D, 8.0D), EntityGoose.ITEM_SELECTOR);
            ItemStack itemstack = EntityGoose.this.getItemBySlot(EquipmentSlotType.MAINHAND);
            if (itemstack.isEmpty() && !list.isEmpty()) {
                EntityGoose.this.getNavigation().moveTo(list.get(0), 1.2F);
            }

        }

        @Override
        public void start() {
            List<ItemEntity> list = EntityGoose.this.level.getEntitiesOfClass(ItemEntity.class, EntityGoose.this.getBoundingBox().inflate(8.0D, 8.0D, 8.0D), EntityGoose.ITEM_SELECTOR);
            if (!list.isEmpty()) {
                EntityGoose.this.getNavigation().moveTo(list.get(0), 1.2F);
            }

        }
    }

    public class DislikeTargetGoal extends TargetGoal {

        protected EntityGoose goose;

        public DislikeTargetGoal(EntityGoose goose) {
            super(goose, true);
            this.goose = goose;
        }

        @Override
        public boolean canUse() {
            return goose.dislikedPlayers.size() > 0 && goose.getTarget() == null && this.goose.tickCount - goose.lastAttackTime > 150;
        }

        @Override
        protected boolean canAttack(LivingEntity potentialTarget, EntityPredicate targetPredicate) {
            return potentialTarget instanceof PlayerEntity && super.canAttack(potentialTarget, targetPredicate) && dislikedPlayers.contains(((PlayerEntity)potentialTarget).getGameProfile().getId());
        }

    }

}
