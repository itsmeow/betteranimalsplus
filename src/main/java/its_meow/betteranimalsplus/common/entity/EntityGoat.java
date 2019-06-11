package its_meow.betteranimalsplus.common.entity;

import java.util.ArrayList;

import javax.annotation.Nullable;

import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.init.ModItems;
import its_meow.betteranimalsplus.init.ModLootTables;
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
import net.minecraft.util.IItemProvider;
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
    private ArrayList<Item> temptItems = null;

    public EntityGoat(World worldIn) {
        super(ModEntities.getEntityType("goat"), worldIn, 5);
        this.world = worldIn;
        //this.setSize(1.2F, 1.2F);
        this.addTemptItems();
    }

    private void addTemptItems() {
        this.temptItems = new ArrayList<>();
        this.temptItems.add(Items.WHEAT);
        this.temptItems.add(Items.POTATO);
        this.temptItems.add(Items.CARROT);
        this.temptItems.add(Items.CARROT_ON_A_STICK);
        this.temptItems.add(Items.BEETROOT);
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
        if (this.temptItems == null) {
            this.addTemptItems();
        }
        IItemProvider[] tempts = new IItemProvider[this.temptItems.size()];
        for (int i = 0; i < this.temptItems.size(); i++) {
            tempts[i] = this.temptItems.get(i);
        }
        this.goalSelector.addGoal(3, new TemptGoal(this, 0.6D, false, Ingredient.fromItems(tempts)));
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
    public boolean processInteract(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getHeldItem(hand);

        if (itemstack.getItem() == Items.BUCKET && !player.isCreative() && !this.isChild()) {
            player.playSound(SoundEvents.ENTITY_COW_MILK, 1.0F, 1.0F);
            itemstack.shrink(1);

            if (itemstack.isEmpty()) {
                player.setHeldItem(hand, new ItemStack(ModItems.GOAT_MILK));
            } else if (!player.inventory.addItemStackToInventory(new ItemStack(ModItems.GOAT_MILK))) {
                player.dropItem(new ItemStack(ModItems.GOAT_MILK), false);
            }

            return true;
        } else if (this.temptItems.contains(itemstack.getItem()) && !this.isChild()) {
            this.hasBeenFed = true;
            this.friend = player;
            if (itemstack.getItem() == Items.WHEAT) {
                this.setInLove(player);
                if (!player.isCreative()) {
                    itemstack.shrink(1);
                }
            }
            return true;
        } else {
            return super.processInteract(player, hand);
        }
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
        protected void func_220793_a(MobEntity p_220793_1_, LivingEntity p_220793_2_) {
            if (p_220793_1_ instanceof EntityGoat && !p_220793_1_.isChild()) {
                super.func_220793_a(p_220793_1_, p_220793_2_);
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

}
