package dev.itsmeow.betteranimalsplus.common.entity;

import com.google.common.collect.Sets;
import dev.itsmeow.betteranimalsplus.common.entity.util.EntityUtil;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityAnimalEatsGrassWithTypes;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.betteranimalsplus.init.ModItems;
import dev.itsmeow.betteranimalsplus.init.ModLootTables;
import dev.itsmeow.betteranimalsplus.init.ModTriggers;
import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import java.util.Set;
import java.util.UUID;

public class EntityGoat extends EntityAnimalEatsGrassWithTypes {

    protected static final EntityDataAccessor<Boolean> ATTACKING = SynchedEntityData.defineId(EntityGoat.class, EntityDataSerializers.BOOLEAN);
    public UUID friend = null;
    private static final Set<Item> TEMPT_ITEMS = Sets.newHashSet(Items.WHEAT, Items.POTATO, Items.CARROT, Items.BEETROOT);
    public static final String VANILLA_MILK_KEY = "use_vanilla_milk";

    public EntityGoat(EntityType<? extends EntityGoat> entityType, Level worldIn) {
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
        Vec3 pos = this.position();
        Vec3 targetPos = entityIn.position();
        ((LivingEntity) entityIn).knockback(0.8F, pos.x - targetPos.x, pos.z - targetPos.z);
        return super.doHurtTarget(entityIn);
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
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 0.8D));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 0.7D, true));
        this.goalSelector.addGoal(3, new TemptGoal(this, 0.6D, false, Ingredient.of(TEMPT_ITEMS.toArray(new Item[0]))));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 0.6D));
        // Eats grass at priority 5
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 0.6D));
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
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
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
            return InteractionResult.SUCCESS;
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
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("AttackSync", this.isAttackingFromServer());
        if(friend != null) {
            compound.putUUID("Friend", friend);
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
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
            Player p = goat.level.getPlayerByUUID(goat.friend);
            return p != null && p.getKillCredit() != null;
        }

        @Override
        public void start() {
            Player p = goat.level.getPlayerByUUID(goat.friend);
            this.goat.setTarget(p.getKillCredit());
            if(p instanceof ServerPlayer) {
                ModTriggers.GOAT_FIGHT_FRIEND.trigger((ServerPlayer) p);
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
        protected void alertOther(Mob e, LivingEntity target) {
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
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, SpawnGroupData livingdata, CompoundTag compound) {
        return EntityUtil.childChance(this, reason, super.finalizeSpawn(world, difficulty, reason, livingdata, compound), 0.25F);
    }

    @Override
    public EntityTypeContainer<EntityGoat> getContainer() {
        return ModEntities.GOAT;
    }

}
