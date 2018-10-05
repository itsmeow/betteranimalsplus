package its_meow.betteranimalsplus.common.tileentity;

import its_meow.betteranimalsplus.client.model.ModelHirschgeistSkull;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityHirschgeistSkull extends TileEntitySkull {
	
	private ModelHirschgeistSkull model = null;
	
	
	public ModelHirschgeistSkull getModel() {
		if(model == null) {
			model = new ModelHirschgeistSkull();
		}
		return model;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getRenderBoundingBox() {
		return new AxisAlignedBB(getPos().add(-1, -1, -1), getPos().add(2, 2, 2));
	}
	

}
