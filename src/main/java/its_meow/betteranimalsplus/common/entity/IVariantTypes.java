package its_meow.betteranimalsplus.common.entity;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.entity.IEntityLivingData;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.EntityDataManager;

public interface IVariantTypes {
	
	/* Methods from superclass */
	
	boolean isChildI();
	
	Random getRNGI();
	
	EntityDataManager getDataManagerI();
	
	/* Implemented */
	
	int getVariantMax();
	
	DataParameter<Integer> getDataKey();
	
	/* Default Methods */
	
	default void registerTypeKey() {
		this.getDataManagerI().register(getDataKey(), Integer.valueOf(0));
	}

	default int getTypeNumber() {
		return ((Integer)this.getDataManagerI().get(this.getDataKey())).intValue();
	}

	default void setType(int typeId)
	{
		this.getDataManagerI().set(this.getDataKey(), Integer.valueOf(typeId));
	}

	default void writeType(NBTTagCompound compound)
	{
		compound.setInt("TypeNumber", this.getTypeNumber());
	}

	default void readType(NBTTagCompound compound)
	{
		this.setType(compound.getInt("TypeNumber"));
	}

	public static class TypeData implements IEntityLivingData
	{
		public int typeData;

		public TypeData(int type)
		{
			this.typeData = type;
		}
	}

	@Nullable
	default IEntityLivingData initData(IEntityLivingData livingdata)
	{

		if(!this.isChildI()) {
			int i = this.getRNGI().nextInt(getVariantMax()) + 1;

			if (livingdata instanceof TypeData)
			{
				i = ((TypeData)livingdata).typeData;
			}
			else
			{
				livingdata = new TypeData(i);
			}

			this.setType(i);

		}

		return livingdata;
	}

}
