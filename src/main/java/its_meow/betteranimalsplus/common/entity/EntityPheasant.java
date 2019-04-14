package its_meow.betteranimalsplus.common.entity;

import javax.annotation.Nullable;

import its_meow.betteranimalsplus.init.ModLootTables;
import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityPheasant extends EntityAnimalWithTypes {
    
    protected static final DataParameter<Integer> PECK_TIME = EntityDataManager.<Integer>createKey(EntityPheasant.class, DataSerializers.VARINT);
    public float wingRotation;
    public float destPos;
    public float oFlapSpeed;
    public float oFlap;
    public float wingRotDelta = 0.3F;

    public EntityPheasant(World worldIn) {
        super(worldIn);
        this.setPeckTime(this.getNewPeck());
        this.setPathPriority(PathNodeType.WATER, 0.0F);
        this.setSize(1F, this.isChild() ? 0.8F : 1F);
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 1.4D));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(3, new EntityAITempt(this, 1.0D, Items.PUMPKIN_SEEDS, false));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.1D));
        this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(4.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
    }

    private int getNewPeck() {
        return this.rand.nextInt(600) + 30;
    }

    @Override
    public float getEyeHeight() {
        return this.height;
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        this.oFlap = this.wingRotation;
        this.oFlapSpeed = this.destPos;
        this.destPos = (float) (this.destPos + (this.onGround ? -1 : 4) * 0.3D);
        this.destPos = MathHelper.clamp(this.destPos, 0.0F, 1.0F);

        if (!this.onGround && this.wingRotDelta < 1.0F) {
            this.wingRotDelta = 0.3F;
        }

        this.wingRotDelta = (float) (this.wingRotDelta * 0.9D);

        if (!this.onGround && this.motionY < 0.0D) {
            this.motionY *= 0.6D;
        }

        this.wingRotation += this.wingRotDelta * 2.0F;

        if (!this.onGround || this.getMoveHelper().isUpdating()) {
            if (this.getPeckTime() <= 61) {
                this.setPeckTime(80);
            }
        }

        if (!this.world.isRemote && this.setPeckTime(this.getPeckTime() - 1) <= 0) {
            this.setPeckTime(this.getNewPeck());
        }
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        ItemStack itemstack = player.getHeldItem(hand);

        if (itemstack.getItem() == Items.PUMPKIN_SEEDS && !this.isChild()) {
            this.setInLove(player);
            if (!player.capabilities.isCreativeMode) {
                itemstack.shrink(1);
            }
            return true;
        } else {
            return super.processInteract(player, hand);
        }
    }

    @Override
    public void fall(float distance, float damageMultiplier) {
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_CHICKEN_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_CHICKEN_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, Block blockIn) {
        this.playSound(SoundEvents.ENTITY_CHICKEN_STEP, 0.15F, 1.0F);
    }

    @Override
    @Nullable
    protected ResourceLocation getLootTable() {
        return ModLootTables.pheasant;
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(PECK_TIME, Integer.valueOf(0));
    }

    public int getPeckTime() {
        return this.dataManager.get(PECK_TIME).intValue();
    }

    public int setPeckTime(int time) {
        this.dataManager.set(PECK_TIME, Integer.valueOf(time));
        return time;
    }

    @Override
    public int getVariantMax() {
        return 2;
    }

    @Override
    protected IVariantTypes getBaseChild() {
        return new EntityPheasant(this.world);
    }

}
