package dev.itsmeow.betteranimalsplus.common.entity;

import com.google.common.collect.Sets;
import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.betteranimalsplus.common.entity.util.EntityUtil;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityAnimalEatsGrassWithTypes;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.betteranimalsplus.init.ModItems;
import dev.itsmeow.betteranimalsplus.init.ModLootTables;
import dev.itsmeow.betteranimalsplus.init.ModTriggers;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

import java.util.Set;
import java.util.UUID;

public class EntityGoat extends EntityAnimalEatsGrassWithTypes {

    protected static final DataParameter<Boolean> ATTACKING = EntityDataManager.defineId(EntityGoat.class, DataSerializers.BOOLEAN);
    public UUID friend = null;
    private static final Set<Item> TEMPT_ITEMS = Sets.newHashSet(Items.WHEAT, Items.POTATO, Items.CARROT, Items.BEETROOT);
    public static final String VANILLA_MILK_KEY = "use_vanilla_milk";

    public EntityGoat(EntityType<? extends EntityGoat> entityType, World worldIn) {
        super(entityType, worldIn, 5);
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (!this.level.isClientSide && (this.getTarget() == null || !this.getTarget().isAlive())) {
            this.setAttackingOnClient(false);
        }
    }

    @Override
    public boolean doHurtTarget(Entity entityIn) {
        Vector3d pos = this.position();
        Vector3d targetPos = entityIn.position();
        ((LivingEntity) entityIn).knockback(0.8F, pos.x - targetPos.x, pos.z - targetPos.z);
        float f = (float) this.getAttribute(Attributes.ATTACK_DAMAGE).getValue();
        boolean flag = entityIn.hurt(DamageSource.mobAttack(this), f);
        if(flag) {
            if(entityIn instanceof PlayerEntity) {
                PlayerEntity entityplayer = (PlayerEntity) entityIn;
                ItemStack itemstack = this.getMainHandItem();
                ItemStack itemstack1 = entityplayer.isUsingItem() ? entityplayer.getUseItem() : ItemStack.EMPTY;
                if(!itemstack.isEmpty() && !itemstack1.isEmpty() && itemstack.getItem().canDisableShield(itemstack, itemstack1, entityplayer, this) && itemstack1.getItem().isShield(itemstack1, entityplayer)) {
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
    public void setTarget(LivingEntity entitylivingbaseIn) {
        this.setAttackingOnClient(entitylivingbaseIn != null);
        super.setTarget(entitylivingbaseIn);
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.SHEEP_STEP, 0.15F, 1.0F);
    }

    public boolean isAttackingFromServer() {
        return this.entityData.get(EntityGoat.ATTACKING);
    }

    public void setAttackingOnClient(boolean in) {
        this.entityData.set(EntityGoat.ATTACKING, in);
    }

    public float getHeadPitch() {
        return this.isAttackingFromServer() ? 0.15F : -0.698F;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 0.8D));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 0.7D, true));
        this.goalSelector.addGoal(3, new TemptGoal(this, 0.6D, false, Ingredient.of(TEMPT_ITEMS.toArray(new Item[0]))));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 0.6D));
        // Eats grass at priority 5
        this.goalSelector.addGoal(5, new RandomWalkingGoal(this, 0.6D));
        this.targetSelector.addGoal(1, new GoatAIAttackForFriend(this));
        this.targetSelector.addGoal(1, new AIHurtByTarget());
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.SHEEP_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.SHEEP_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.SHEEP_DEATH;
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return TEMPT_ITEMS.contains(stack.getItem());
    }

    @Override
    public ActionResultType mobInteract(PlayerEntity player, Hand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if(stack.getItem() == Items.BUCKET && !player.isCreative() && !this.isBaby()) {
            player.playSound(SoundEvents.COW_MILK, 1.0F, 1.0F);
            stack.shrink(1);

            Item milk = getContainer().getCustomConfiguration().getBoolean(VANILLA_MILK_KEY) ? Items.MILK_BUCKET : ModItems.GOAT_MILK.get();

            if(stack.isEmpty()) {
                player.setItemInHand(hand, new ItemStack(milk));
            } else if(!player.inventory.add(new ItemStack(milk))) {
                player.drop(new ItemStack(milk), false);
            }
            return ActionResultType.SUCCESS;
        } else if(this.isFood(stack) && !this.isBaby()) {
            this.friend = player.getGameProfile().getId();
        }
        return super.mobInteract(player, hand);
    }

    @Override
    protected ResourceLocation getDefaultLootTable() {
        return ModLootTables.goat;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(EntityGoat.ATTACKING, Boolean.FALSE);
    }

    @Override
    public void addAdditionalSaveData(CompoundNBT compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("AttackSync", this.isAttackingFromServer());
        if(friend != null) {
            compound.putUUID("Friend", friend);
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundNBT compound) {
        super.readAdditionalSaveData(compound);
        if(compound.contains("AttackSync")) {
            this.setAttackingOnClient(compound.getBoolean("AttackSync"));
        }
        if(compound.contains("Friend")) {
            this.friend = compound.getUUID("Friend");
        }
    }

    public static class GoatAIAttackForFriend extends Goal {

        EntityGoat goat;

        public GoatAIAttackForFriend(EntityGoat entity) {
            this.goat = entity;
        }

        @Override
        public boolean canUse() {
            if(this.goat.friend == null) {
                return false;
            }
            PlayerEntity p = goat.level.getPlayerByUUID(goat.friend);
            return p != null && p.getKillCredit() != null;
        }

        @Override
        public void start() {
            PlayerEntity p = goat.level.getPlayerByUUID(goat.friend);
            this.goat.setTarget(p.getKillCredit());
            if(p instanceof ServerPlayerEntity) {
                ModTriggers.GOAT_FIGHT_FRIEND.trigger((ServerPlayerEntity) p);
            }
        }

        @Override
        public boolean canContinueToUse() {
            return false;
        }

    }

    class AIHurtByTarget extends HurtByTargetGoal {

        public AIHurtByTarget() {
            super(EntityGoat.this);
        }

        @Override
        public boolean canUse() {
            return EntityGoat.this.level.getDifficulty() != Difficulty.PEACEFUL && super.canUse();
        }

        @Override
        public void start() {
            super.start();

            if(EntityGoat.this.isBaby()) {
                this.alertOthers();
                this.stop();
            }
        }

        @Override
        protected void alertOther(MobEntity e, LivingEntity target) {
            if(e instanceof EntityGoat && !e.isBaby()) {
                super.alertOther(e, target);
            }
        }
    }

    @Override
    protected EntityGoat getBaseChild() {
        return getContainer().getEntityType().create(level);
    }

    @Override
    public ILivingEntityData finalizeSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason, ILivingEntityData livingdata, CompoundNBT compound) {
        return EntityUtil.childChance(this, reason, super.finalizeSpawn(world, difficulty, reason, livingdata, compound), 0.25F);
    }

    @Override
    public EntityTypeContainer<EntityGoat> getContainer() {
        return ModEntities.GOAT;
    }

}
