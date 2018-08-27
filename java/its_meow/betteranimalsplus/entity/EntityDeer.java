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
import net.minecraft.world.World;

public class EntityDeer extends EntityAnimal {


	public int eatTime2 = 0;
	private World world = null;
	public EntityAIEatGrass eatGrassAI = null;

	public EntityDeer(World worldIn) {
		super(worldIn);
		this.world = worldIn;
		this.setSize(1F, 2.5F);
	}

	protected void initEntityAI()
	{
		super.initEntityAI();
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIPanic(this, 0.65D));
		this.tasks.addTask(3, new EntityAIAvoidEntity<EntityPlayer>(this, EntityPlayer.class, 20, 0.55D, 0.7D));
		this.tasks.addTask(4, new EntityAIWander(this, 0.45D));
		this.eatGrassAI = new EntityAIEatGrass(this);
		this.tasks.addTask(5, eatGrassAI);
		this.tasks.addTask(6, new EntityAILookIdle(this));
	}

	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.45D);
	}



	@Override
	public void onLivingUpdate() {
		if(eatGrassAI != null) {
			System.out.println(eatGrassAI.getEatingGrassTimer());
			if(eatGrassAI.getEatingGrassTimer() == 1) {
				eatTime2 = 80;
			}
			if(eatTime2 > 0) {
				eatTime2--;
			}
		}
		super.onLivingUpdate();
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
