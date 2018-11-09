package its_meow.betteranimalsplus.common.tileentity;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.model.ModelBase;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityHead extends TileEntitySkull {
	
	private Class<? extends ModelBase> modelT = null;
	private ModelBase model = null;
	
	public ResourceLocation texture;
	
	public TileEntityHead(Class<? extends ModelBase> modelType, ResourceLocation textureIn) {
		modelT = modelType;
		this.texture = textureIn;
	}
	
	public ModelBase getModel() {
		if(model == null) {
			try {
				model = modelT.newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return model;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getRenderBoundingBox() {
		return new AxisAlignedBB(getPos().add(-1, -1, -1), getPos().add(2, 2, 2));
	}
	

}
