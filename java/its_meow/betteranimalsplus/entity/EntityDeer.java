package its_meow.betteranimalsplus.entity;

import javax.annotation.Nullable;

import its_meow.betteranimalsplus.registry.LootTableRegistry;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIEatGrass;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityDeer extends EntityAnimal {


	public int eatTime2 = 0;
	private World world = null;
	public EntityAIEatGrass eatGrassAI;
	private int sheepTimer;

	public EntityDeer(World worldIn) {
		super(worldIn);
		this.world = worldIn;
		this.setSize(1F, 2.5F);
	}

	protected void initEntityAI()
	{
		super.initEntityAI();
		this.eatGrassAI = new EntityAIEatGrass(this);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIPanic(this, 0.65D));
		this.tasks.addTask(3, new EntityAIAvoidEntity<EntityPlayer>(this, EntityPlayer.class, 20, 0.55D, 0.7D));
		this.tasks.addTask(4, new EntityAIWander(this, 0.45D));
		this.tasks.addTask(5, this.eatGrassAI);
		this.tasks.addTask(6, new EntityAILookIdle(this));
	}

	protected void updateAITasks()
	{
		if(this.eatGrassAI != null) {
			this.sheepTimer = this.eatGrassAI.getEatingGrassTimer();
		}
		super.updateAITasks();
	}

	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.45D);
	}



	@Override
	public void onLivingUpdate() {
		if (this.world.isRemote)
		{
			this.sheepTimer = Math.max(0, this.sheepTimer - 1);
		}
		super.onLivingUpdate();
	}

	@SideOnly(Side.CLIENT)
	public float getHeadRotationPointY(float p_70894_1_)
	{
		if (this.sheepTimer <= 0)
		{
			return 0.0F;
		}
		else if (this.sheepTimer >= 4 && this.sheepTimer <= 36)
		{
			return 1.0F;
		}
		else
		{
			return this.sheepTimer < 4 ? ((float)this.sheepTimer - p_70894_1_) / 4.0F : -((float)(this.sheepTimer - 40) - p_70894_1_) / 4.0F;
		}
	}

	@SideOnly(Side.CLIENT)
	public float getHeadRotationAngleX(float p_70890_1_)
	{
		if (this.sheepTimer > 4 && this.sheepTimer <= 36)
		{
			float f = ((float)(this.sheepTimer - 4) - p_70890_1_) / 32.0F;
			return ((float)Math.PI / 5F) + ((float)Math.PI * 7F / 100F) * MathHelper.sin(f * 28.7F);
		}
		else
		{
			return this.sheepTimer > 0 ? ((float)Math.PI / 5F) : this.rotationPitch * 0.017453292F;
		}
	}

	@Override
	@Nullable
	protected ResourceLocation getLootTable()
	{
		return LootTableRegistry.deer;
	}

	@Override
	public EntityAgeable createChild(EntityAgeable ageable) {
		return null;
	}

}
