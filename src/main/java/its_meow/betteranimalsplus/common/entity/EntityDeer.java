package its_meow.betteranimalsplus.common.entity;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Nullable;

import its_meow.betteranimalsplus.init.ModBlocks;
import its_meow.betteranimalsplus.init.ModLootTables;
import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIEatGrass;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityDeer extends EntityAnimalWithTypes {
    
    private EntityAIEatGrass eatTask = null;
    public int eatTimer;

    public EntityDeer(World worldIn) {
        super(worldIn);
        this.setSize(1.2F, 1.6F);
    }

    public int getEatTime() {
        return eatTimer;
    }
    
    @SideOnly(Side.CLIENT)
    public void handleStatusUpdate(byte id)
    {
        if (id == 10)
        {
            this.eatTimer = 40;
        }
        else
        {
            super.handleStatusUpdate(id);
        }
    }
    
    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.world.isRemote) {
            this.eatTimer = Math.max(0, this.eatTimer - 1);
        }
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
        this.tasks.addTask(5, this.eatTask = new EntityAIEatGrass(this));
        this.tasks.addTask(5, new EntityAIWander(this, 0.45D));
        this.tasks.addTask(6, new EntityAILookIdle(this));
    }
    
    

    @Override
    public void eatGrassBonus() {
        super.eatGrassBonus();
        this.addGrowth(60);
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
    public void updateAITasks() {
        if(this.eatTask != null) {
            this.eatTimer = this.eatTask.getEatingGrassTimer();
        }
        super.updateAITasks();
    }

    @Override
    @Nullable
    protected ResourceLocation getLootTable() {
        return ModLootTables.deer;
    }

    @Override
    public int getVariantMax() {
        return 2;
    }

    @Override
    protected IVariantTypes getBaseChild() {
        return new EntityDeer(this.world);
    }

}
