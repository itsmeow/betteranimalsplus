package its_meow.betteranimalsplus.common.tileentity;

import java.util.Random;

import its_meow.betteranimalsplus.common.entity.miniboss.hirschgeist.EntityHirschgeist;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class TileEntityHandOfFate extends TileEntity {

	private boolean onFire;
	private final String keyOnFire = "OnFire";

	private boolean hasNetherWart;
	private final String keyNetherWart = "HasNetherWart";

	private boolean hasAntler;
	private final String keyAntler = "HasAntler";

	private boolean hasVenison;
	private final String keyVenison = "HasVenison";

	public TileEntityHandOfFate() {}

	public TileEntityHandOfFate(World worldIn) {
		this.world = worldIn;
	}


	public void setOnFire(boolean b) {
		this.onFire = b;
		if(world.isRemote) {
			world.scheduleUpdate(this.pos, this.getBlockType(), 0);
			world.notifyBlockUpdate(pos, world.getBlockState(pos), world.getBlockState(pos), 0);
			world.markBlockRangeForRenderUpdate(getPos().down(5).west(5).north(5), getPos().up(5).east(5).south(5));
		}
		this.markDirty();
	}

	public boolean isOnFire() {
		return onFire;
	}

	public boolean hasNetherWart() {
		return hasNetherWart;
	}


	public void setHasNetherWart(boolean hasNetherWart) {
		this.hasNetherWart = hasNetherWart;
		this.markDirty();
		this.checkHasAllThree();
	}

	public boolean hasAntler() {
		return hasAntler;
	}


	public void setHasAntler(boolean hasAntler) {
		this.hasAntler = hasAntler;
		this.markDirty();
		this.checkHasAllThree();
	}


	public boolean hasVenison() {
		return hasVenison;
	}


	public void setHasVenison(boolean hasVenison) {
		this.hasVenison = hasVenison;
		this.markDirty();
		this.checkHasAllThree();
	}



	private void checkHasAllThree() {
		if(hasVenison && hasAntler && hasNetherWart && this.isOnFire()) {
			this.setHasVenison(false);
			this.setHasAntler(false);
			this.setHasNetherWart(false);
			this.fireBurst();
			this.spawnHirschgeist();
		}
	}




	private void spawnHirschgeist() {
		if(!world.isRemote) {
			EntityHirschgeist hg = new EntityHirschgeist(world);
			hg.setLocationAndAngles(this.pos.getX(), this.pos.getY() + 1F, this.pos.getZ(), 0, 0);
			hg.setNoAI(false);
			world.spawnEntity(hg);
		}
	}


	private void fireBurst() {
		Random rand = new Random();
		for(int i = 0; i < 100; i++) {
			world.spawnParticle(EnumParticleTypes.SPELL_INSTANT, this.getPos().getX() + ((rand.nextFloat() + 0.5F) / 2), this.getPos().getY() + 1.5F, this.getPos().getZ() + ((rand.nextFloat() + 0.5F) / 2), 0, 0.5F, 0);
		}
	}


	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		if(compound.hasKey(keyOnFire)) {
			this.onFire = compound.getBoolean(keyOnFire);
		}
		if(compound.hasKey(keyNetherWart)) {
			this.hasNetherWart = compound.getBoolean(keyNetherWart);
		}
		if(compound.hasKey(keyAntler)) {
			this.hasAntler = compound.getBoolean(keyAntler);
		}
		if(compound.hasKey(keyVenison)) {
			this.hasVenison = compound.getBoolean(keyVenison);
		}
	}



	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setBoolean(keyOnFire, this.onFire);
		compound.setBoolean(keyAntler, hasAntler);
		compound.setBoolean(keyNetherWart, hasNetherWart);
		compound.setBoolean(keyVenison, hasVenison);
		return compound;
	}

	@Override
	public SPacketUpdateTileEntity getUpdatePacket() {
		NBTTagCompound tag = new NBTTagCompound();
		this.writeToNBT(tag);
		return new SPacketUpdateTileEntity(pos, 1, tag);
	}


	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet) {
		readFromNBT(packet.getNbtCompound());
		world.scheduleUpdate(this.pos, this.blockType, 100);
	}





	@Override
	public NBTTagCompound getUpdateTag() {
		NBTTagCompound tag = new NBTTagCompound();
		this.writeToNBT(tag);
		return tag;
	}


	@Override
	public void handleUpdateTag(NBTTagCompound tag) {
		this.readFromNBT(tag);
	}


	public float getRotation() {
		IBlockState state = world.getBlockState(this.pos);
		EnumFacing facing = state.getValue(BlockHorizontal.FACING).getOpposite();
		if(facing == EnumFacing.NORTH) {
			return 0F;
		}
		if(facing == EnumFacing.EAST) {
			return 90F;
		}
		if(facing == EnumFacing.SOUTH) {
			return 180F;
		}
		if(facing == EnumFacing.WEST) {
			return 270F;
		}
		return 0F;
	}

}
