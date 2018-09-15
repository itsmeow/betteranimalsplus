package its_meow.betteranimalsplus.entity;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityTrillium extends Entity {
	
	protected static final DataParameter<Integer> TYPE_NUMBER = EntityDataManager.<Integer>createKey(EntityTrillium.class, DataSerializers.VARINT);
	
	public EntityTrillium(World worldIn) {
		super(worldIn);
	}
	
	
	
	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		if(super.attackEntityFrom(source, amount)) {
			this.setDead();
			//this.dropItem(new ItemTrilliumSpawner(this.getTypeNumber()), 1);
			return true;
		} else {
			return false;
		}
 	}
	
	@Override
	public boolean canBePushed()
	{
		return false;
	}

	@Override
	public void onCollideWithPlayer(EntityPlayer entityIn) {

	}
	
	protected void entityInit()
	{
		this.dataManager.register(TYPE_NUMBER, Integer.valueOf(0));
	}

	public int getTypeNumber() {
		return ((Integer)this.dataManager.get(TYPE_NUMBER)).intValue();
	}

	public void setType(int typeId)
	{
		this.dataManager.set(TYPE_NUMBER, Integer.valueOf(typeId));
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound compound)
	{
		compound.setInteger("TypeNumber", this.getTypeNumber());
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readEntityFromNBT(NBTTagCompound compound)
	{
		this.setType(compound.getInteger("TypeNumber"));
	}
	
	
	
	/**
	 * Called only once on an entity when first time spawned, via egg, mob spawner, natural spawning etc, but not called
	 * when entity is reloaded from nbt. Mainly used for initializing attributes and inventory
	 */
	@Nullable
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata)
	{
		int i = (new Random()).nextInt(8) + 1;

		if (livingdata instanceof EntityTrillium.TypeData)
		{
			i = ((EntityTrillium.TypeData)livingdata).typeData;
		}
		else
		{
			livingdata = new EntityTrillium.TypeData(i);
		}

		this.setType(i);

		return livingdata;
	}

	public static class TypeData implements IEntityLivingData
	{
		public int typeData;

		public TypeData(int type)
		{
			this.typeData = type;
		}
	}

}
