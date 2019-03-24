package its_meow.betteranimalsplus.common.entity;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.annotation.Nullable;

import its_meow.betteranimalsplus.init.ModBlocks;
import its_meow.betteranimalsplus.init.ModLootTables;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityDeer extends EntityAnimal implements IVariantTypes {
    
    private static final DataParameter<Integer> EAT_TIME = EntityDataManager.<Integer>createKey(EntityDeer.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> TYPE_NUMBER = EntityDataManager.<Integer>createKey(EntityDeer.class, DataSerializers.VARINT);
    
    public EntityDeer(World worldIn) {
        super(worldIn);
        this.setSize(1.2F, 1.6F);
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.registerTypeKey();
        this.dataManager.register(EAT_TIME, 0);
    }
    
    public int getEatTime() {
        return this.dataManager.get(EAT_TIME).intValue();
    }

    public int setEatTime(int time) {
        this.dataManager.set(EAT_TIME, Integer.valueOf(time));
        return time;
    }
    
    private int getNewEat() {
        return this.rand.nextInt(600) + 30;
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        ItemStack stack = player.getHeldItem(hand);
        boolean isEmpty = stack.isEmpty();
        if (!isEmpty) {
            if (stack.getItem() == Items.WHEAT || stack.getItem() == Items.CARROT) {
                this.setInLove(player);
            }
        }

        return super.processInteract(player, hand);
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 4;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        this.writeType(compound);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        this.readType(compound);
    }

    @Override
    @Nullable
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
        return this.initData(super.onInitialSpawn(difficulty, livingdata));
    }

    @Override
    protected void playStepSound(BlockPos pos, Block blockIn) {
        this.playSound(SoundEvents.ENTITY_SHEEP_STEP, 0.15F, 1.0F);
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIMate(this, 0.45D));
        this.tasks.addTask(2, new EntityAIPanic(this, 0.65D));
        Set<Item> temptItems = new HashSet<Item>();
        temptItems.add(Items.APPLE);
        temptItems.add(Items.GOLDEN_APPLE);
        temptItems.add(Items.CARROT);
        temptItems.add(Items.CARROT_ON_A_STICK);
        temptItems.add(Items.GOLDEN_CARROT);
        this.tasks.addTask(3, new EntityAITempt(this, 0.45D, false, temptItems));
        this.tasks.addTask(4, new EntityAIAvoidEntity<EntityPlayer>(this, EntityPlayer.class, 20, 0.55D, 0.7D));
        this.tasks.addTask(5, new EntityAIWander(this, 0.45D));
        this.tasks.addTask(6, new EntityAILookIdle(this));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.45D);
    }

    @Override
    public void onDeath(DamageSource cause) {
        super.onDeath(cause);
        if (!world.isRemote && !this.isChild()) {
            if (this.rand.nextInt(12) == 0) {
                ItemStack stack = new ItemStack(ModBlocks.deerhead.getItemBlock());
                stack.setTagCompound(new NBTTagCompound());
                stack.getTagCompound().setInteger("TYPENUM", this.getTypeNumber());
                this.entityDropItem(stack, 0.5F);
            }
        }
    }
    
    

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (!this.onGround || this.getMoveHelper().isUpdating()) {
            if (this.getEatTime() <= 61) {
                this.setEatTime(80);
            }
        }

        if (!this.world.isRemote && this.setEatTime(this.getEatTime() - 1) <= 0) {
            this.setEatTime(this.getNewEat());
        }
    }

    @Override
    @Nullable
    protected ResourceLocation getLootTable() {
        return ModLootTables.deer;
    }

    @Override
    public EntityAgeable createChild(EntityAgeable ageable) {
        if(!(ageable instanceof IVariantTypes)) return null;
        return (EntityAgeable) new EntityDeer(this.world).setType(this.getOffspringType(this, (IVariantTypes) ageable));
    }

    @Override
    public DataParameter<Integer> getDataKey() {
        return TYPE_NUMBER;
    }

    @Override
    public int getVariantMax() {
        return 2;
    }

    @Override
    public boolean isChildI() {
        return this.isChild();
    }

    @Override
    public Random getRNGI() {
        return this.getRNG();
    }

    @Override
    public EntityDataManager getDataManagerI() {
        return this.getDataManager();
    }

}
