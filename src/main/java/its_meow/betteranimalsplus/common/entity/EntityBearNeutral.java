package its_meow.betteranimalsplus.common.entity;

import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.base.Predicates;

import its_meow.betteranimalsplus.init.ModLootTables;
import its_meow.betteranimalsplus.util.HeadTypes;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityBearNeutral extends EntityBear implements IVariantTypes {

    protected static final DataParameter<Integer> TYPE_NUMBER = EntityDataManager.<Integer>createKey(EntityBearNeutral.class, DataSerializers.VARINT);

    public EntityBearNeutral(World world) {
        super(world);
        this.setSize(2F, 1.5F);
    }

    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityBear.AIMeleeAttack());
        this.targetTasks.addTask(1, new EntityBear.AIHurtByTarget());
        this.tasks.addTask(5, new EntityAIWander(this, 0.5D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<EntityChicken>(this, EntityChicken.class, true));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget<EntityRabbit>(this, EntityRabbit.class, true));
        this.targetTasks.addTask(4, new EntityAINearestAttackableTarget<EntityPheasant>(this, EntityPheasant.class, 90, true, true, Predicates.alwaysTrue()));
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

    @Override
    public int getVariantMax() {
        return 2;
    }

    @Override
    public DataParameter<Integer> getDataKey() {
        return TYPE_NUMBER;
    }

    @Override
    @Nullable
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
        int validTypes[] = {1, 2};
        return this.initData(super.onInitialSpawn(difficulty, livingdata), getBiasedRandomType(validTypes));
    }

    private int getBiasedRandomType(int[] validTypes) { // Double bias against kermode spawn
        int r = validTypes[this.getRNG().nextInt(validTypes.length)];
        if(validTypes.length > 1) { // No point if only a single possibility
            if(r == 2) {
                r = validTypes[this.getRNG().nextInt(validTypes.length)];
            }
            if(r == 2) {
                r = validTypes[this.getRNG().nextInt(validTypes.length)];
            }
        }
        return r;
    }

    protected void entityInit() {
        super.entityInit();
        this.registerTypeKey();
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        this.writeType(compound);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        this.readType(compound);
    }

    @Override
    public void doDropHead() {
        if (!world.isRemote && !this.isChild()) {
            if (this.rand.nextInt(12) == 0) {
                int type = this.getTypeNumber();
                ItemStack stack = new ItemStack(HeadTypes.BEARHEAD.getItem(this.getTypeNumber() + 1));
                this.entityDropItem(stack, 0.5F);
            }
        }
    }
    
    @Override
    protected ResourceLocation getLootTable() {
        switch(this.getTypeNumber()) {
        case 1: return ModLootTables.BEAR_BLACK;
        case 2: return ModLootTables.BEAR_KERMODE;
        default: return ModLootTables.BEAR_BLACK;
        }
    }

}
