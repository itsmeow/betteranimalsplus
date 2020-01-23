package its_meow.betteranimalsplus.common.entity;

import java.util.Set;

import javax.annotation.Nullable;

import com.google.common.collect.Sets;

import its_meow.betteranimalsplus.config.BetterAnimalsPlusConfig;
import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.init.ModItems;
import its_meow.betteranimalsplus.init.ModLootTables;
import its_meow.betteranimalsplus.init.ModTriggers;
import its_meow.betteranimalsplus.util.EntityTypeContainer;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
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
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntityGoat extends EntityAnimalEatsGrassWithTypes {

    protected static final DataParameter<Boolean> ATTACKING = EntityDataManager.<Boolean>createKey(EntityGoat.class, DataSerializers.BOOLEAN);
    public PlayerEntity friend = null;
    public boolean hasBeenFed = false;
    private static final Set<Item> TEMPT_ITEMS = Sets.newHashSet(Items.WHEAT, Items.POTATO, Items.CARROT, Items.BEETROOT);

    public EntityGoat(World worldIn) {
        super(ModEntities.GOAT.entityType, worldIn, 5);
        this.world = worldIn;
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
        Vec3d pos = this.getPositionVector();
        Vec3d targetPos = entityIn.getPositionVector();
        ((LivingEntity) entityIn).knockBack(entityIn, 0.8F, pos.x - targetPos.x, pos.z - targetPos.z);

        // Vanilla attack code for mobs

        float f = (float) this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue();
        int i = 0;

        if (entityIn instanceof LivingEntity) {
            f += EnchantmentHelper.getModifierForCreature(this.getHeldItemMainhand(),
            ((LivingEntity) entityIn).getCreatureAttribute());
            i += EnchantmentHelper.getKnockbackModifier(this);
        }

        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), f);

        if (flag) {
            if (i > 0 && entityIn instanceof LivingEntity) {
                ((LivingEntity) entityIn).knockBack(this, i * 0.5F, MathHelper.sin(this.rotationYaw * 0.017453292F),
                -MathHelper.cos(this.rotationYaw * 0.017453292F));
                this.setMotion(this.getMotion().getX() * 0.6D, this.getMotion().getY(), this.getMotion().getZ() * 0.6D);
            }

            int j = EnchantmentHelper.getFireAspectModifier(this);

            if (j > 0) {
                entityIn.setFire(j * 4);
            }

            if (entityIn instanceof PlayerEntity) {
                PlayerEntity entityplayer = (PlayerEntity) entityIn;
                ItemStack itemstack = this.getHeldItemMainhand();
                ItemStack itemstack1 = entityplayer.isHandActive() ? entityplayer.getActiveItemStack()
                : ItemStack.EMPTY;

                if (!itemstack.isEmpty() && !itemstack1.isEmpty()
                && itemstack.getItem().canDisableShield(itemstack, itemstack1, entityplayer, this)
                && itemstack1.getItem().isShield(itemstack1, entityplayer)) {
                    float f1 = 0.25F + EnchantmentHelper.getEfficiencyModifier(this) * 0.05F;

                    if (this.rand.nextFloat() < f1) {
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
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(14.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
        this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0.8D);
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
    public boolean processInteract(PlayerEntity player, Hand hand) {
        ItemStack stack = player.getHeldItem(hand);

        if(stack.getItem() == Items.BUCKET && !player.isCreative() && !this.isChild()) {
            player.playSound(SoundEvents.ENTITY_COW_MILK, 1.0F, 1.0F);
            stack.shrink(1);

            Item milk = BetterAnimalsPlusConfig.goatVanillaMilk ? Items.MILK_BUCKET : ModItems.GOAT_MILK;

            if(stack.isEmpty()) {
                player.setHeldItem(hand, new ItemStack(milk));
            } else if(!player.inventory.addItemStackToInventory(new ItemStack(milk))) {
                player.dropItem(new ItemStack(milk), false);
            }
            return true;
        } else if(this.isBreedingItem(stack) && !this.isChild()) {
            this.hasBeenFed = true;
            this.friend = player;
        }
        return super.processInteract(player, hand);
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
    public boolean writeUnlessRemoved(CompoundNBT compound) {
        compound.putBoolean("AttackSync", this.isAttackingFromServer());
        return super.writeUnlessRemoved(compound);
    }

    @Override
    public void read(CompoundNBT compound) {
        super.read(compound);
        this.setAttackingOnClient(compound.getBoolean("AttackSync"));
    }

    public static class GoatAIAttackForFriend extends Goal {

        EntityGoat goat = null;

        public GoatAIAttackForFriend(EntityGoat entity) {
            this.goat = entity;
        }

        @Override
        public boolean shouldExecute() {
            return this.goat.hasBeenFed && this.goat.friend != null && this.goat.friend.getAttackingEntity() != null;
        }

        @Override
        public void startExecuting() {
            this.goat.setAttackTarget(this.goat.friend.getAttackingEntity());
            if(this.goat.friend instanceof ServerPlayerEntity) {
                ModTriggers.GOAT_FIGHT_FRIEND.trigger((ServerPlayerEntity) this.goat.friend);
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

        /**
         * Execute a one shot task or start executing a continuous task
         */
        @Override
        public void startExecuting() {
            super.startExecuting();

            if (EntityGoat.this.isChild()) {
                this.alertOthers();
                this.resetTask();
            }
        }

        @Override
        protected void setAttackTarget(MobEntity p_220793_1_, LivingEntity p_220793_2_) {
            if (p_220793_1_ instanceof EntityGoat && !p_220793_1_.isChild()) {
                super.setAttackTarget(p_220793_1_, p_220793_2_);
            }
        }
    }

    @Override
    public int getVariantMax() {
        return 7;
    }

    @Override
    protected IVariantTypes getBaseChild() {
        return new EntityGoat(this.world);
    }

    @Override
    protected EntityTypeContainer<? extends EntityAnimalWithTypes> getContainer() {
        return ModEntities.GOAT;
    }

}
