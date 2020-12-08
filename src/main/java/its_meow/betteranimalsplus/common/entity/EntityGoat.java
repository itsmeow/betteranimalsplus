package its_meow.betteranimalsplus.common.entity;

import com.google.common.collect.Sets;
import dev.itsmeow.imdlib.entity.util.EntityTypeContainer;
import its_meow.betteranimalsplus.common.entity.util.EntityUtil;
import its_meow.betteranimalsplus.common.entity.util.abstracts.EntityAnimalEatsGrassWithTypes;
import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.init.ModItems;
import its_meow.betteranimalsplus.init.ModLootTables;
import its_meow.betteranimalsplus.init.ModTriggers;
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

import javax.annotation.Nullable;
import java.util.Set;
import java.util.UUID;

public class EntityGoat extends EntityAnimalEatsGrassWithTypes {

    protected static final DataParameter<Boolean> ATTACKING = EntityDataManager.<Boolean>createKey(EntityGoat.class, DataSerializers.BOOLEAN);
    public UUID friend = null;
    private static final Set<Item> TEMPT_ITEMS = Sets.newHashSet(Items.WHEAT, Items.POTATO, Items.CARROT, Items.BEETROOT);
    public static boolean VANILLA_MILK = false;

    public EntityGoat(World worldIn) {
        super(ModEntities.GOAT.entityType, worldIn, 5);
    }

    @Override
    public void livingTick() {
        super.livingTick();
        if (!this.world.isRemote && (this.getAttackTarget() == null || !this.getAttackTarget().isAlive())) {
            this.setAttackingOnClient(false);
        }
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        Vector3d pos = this.getPositionVec();
        Vector3d targetPos = entityIn.getPositionVec();
        ((LivingEntity) entityIn).applyKnockback(0.8F, pos.x - targetPos.x, pos.z - targetPos.z);
        float f = (float) this.getAttribute(Attributes.ATTACK_DAMAGE).getValue();
        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), f);
        if(flag) {
            if(entityIn instanceof PlayerEntity) {
                PlayerEntity entityplayer = (PlayerEntity) entityIn;
                ItemStack itemstack = this.getHeldItemMainhand();
                ItemStack itemstack1 = entityplayer.isHandActive() ? entityplayer.getActiveItemStack() : ItemStack.EMPTY;
                if(!itemstack.isEmpty() && !itemstack1.isEmpty() && itemstack.getItem().canDisableShield(itemstack, itemstack1, entityplayer, this) && itemstack1.getItem().isShield(itemstack1, entityplayer)) {
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
    public void setAttackTarget(LivingEntity entitylivingbaseIn) {
        this.setAttackingOnClient(entitylivingbaseIn != null);
        super.setAttackTarget(entitylivingbaseIn);
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.ENTITY_SHEEP_STEP, 0.15F, 1.0F);
    }

    public boolean isAttackingFromServer() {
        return this.dataManager.get(EntityGoat.ATTACKING).booleanValue();
    }

    public void setAttackingOnClient(boolean in) {
        this.dataManager.set(EntityGoat.ATTACKING, Boolean.valueOf(in));
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
        this.goalSelector.addGoal(3, new TemptGoal(this, 0.6D, false, Ingredient.fromItems(TEMPT_ITEMS.toArray(new Item[TEMPT_ITEMS.size()]))));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 0.6D));
        // Eats grass at priority 5
        this.goalSelector.addGoal(5, new RandomWalkingGoal(this, 0.6D));
        this.targetSelector.addGoal(1, new GoatAIAttackForFriend(this));
        this.targetSelector.addGoal(1, new AIHurtByTarget());
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_SHEEP_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_SHEEP_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SHEEP_DEATH;
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return TEMPT_ITEMS.contains(stack.getItem());
    }

    @Override
    public ActionResultType func_230254_b_(PlayerEntity player, Hand hand) {
        ItemStack stack = player.getHeldItem(hand);

        if(stack.getItem() == Items.BUCKET && !player.isCreative() && !this.isChild()) {
            player.playSound(SoundEvents.ENTITY_COW_MILK, 1.0F, 1.0F);
            stack.shrink(1);

            Item milk = VANILLA_MILK ? Items.MILK_BUCKET : ModItems.GOAT_MILK.get();

            if(stack.isEmpty()) {
                player.setHeldItem(hand, new ItemStack(milk));
            } else if(!player.inventory.addItemStackToInventory(new ItemStack(milk))) {
                player.dropItem(new ItemStack(milk), false);
            }
            return ActionResultType.SUCCESS;
        } else if(this.isBreedingItem(stack) && !this.isChild()) {
            this.friend = player.getGameProfile().getId();
        }
        return super.func_230254_b_(player, hand);
    }

    @Override
    @Nullable
    protected ResourceLocation getLootTable() {
        return ModLootTables.goat;
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(EntityGoat.ATTACKING, Boolean.valueOf(false));
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putBoolean("AttackSync", this.isAttackingFromServer());
        if(friend != null) {
            compound.putUniqueId("Friend", friend);
        }
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.setAttackingOnClient(compound.getBoolean("AttackSync"));
        this.friend = compound.getUniqueId("Friend");
    }

    public static class GoatAIAttackForFriend extends Goal {

        EntityGoat goat = null;

        public GoatAIAttackForFriend(EntityGoat entity) {
            this.goat = entity;
        }

        @Override
        public boolean shouldExecute() {
            if(this.goat.friend == null) {
                return false;
            }
            PlayerEntity p = goat.world.getPlayerByUuid(goat.friend);
            return p != null && p.getAttackingEntity() != null;
        }

        @Override
        public void startExecuting() {
            PlayerEntity p = goat.world.getPlayerByUuid(goat.friend);
            this.goat.setAttackTarget(p.getAttackingEntity());
            if(p instanceof ServerPlayerEntity) {
                ModTriggers.GOAT_FIGHT_FRIEND.trigger((ServerPlayerEntity) p);
            }
        }

        @Override
        public boolean shouldContinueExecuting() {
            return false;
        }

    }

    class AIHurtByTarget extends HurtByTargetGoal {

        public AIHurtByTarget() {
            super(EntityGoat.this, new Class[0]);
        }

        @Override
        public boolean shouldExecute() {
            return EntityGoat.this.world.getDifficulty() != Difficulty.PEACEFUL && super.shouldExecute();
        }

        @Override
        public void startExecuting() {
            super.startExecuting();

            if(EntityGoat.this.isChild()) {
                this.alertOthers();
                this.resetTask();
            }
        }

        @Override
        protected void setAttackTarget(MobEntity e, LivingEntity target) {
            if(e instanceof EntityGoat && !e.isChild()) {
                super.setAttackTarget(e, target);
            }
        }
    }

    @Override
    protected EntityGoat getBaseChild() {
        return new EntityGoat(this.world);
    }

    @Override
    public ILivingEntityData onInitialSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason, ILivingEntityData livingdata, CompoundNBT compound) {
        return EntityUtil.childChance(this, reason, super.onInitialSpawn(world, difficulty, reason, livingdata, compound), 0.25F);
    }

    @Override
    public EntityTypeContainer<EntityGoat> getContainer() {
        return ModEntities.GOAT;
    }

}
