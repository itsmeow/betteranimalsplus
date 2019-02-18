package its_meow.betteranimalsplus.common.tileentity;

import java.util.Random;

import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.common.entity.miniboss.hirschgeist.EntityHirschgeist;
import its_meow.betteranimalsplus.init.BlockRegistry;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Particles;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class TileEntityHandOfFate extends TileEntity {

	public static final TileEntityType<?> HAND_OF_FATE_TYPE = TileEntityType.Builder.create(TileEntityHandOfFate::new).build(null).setRegistryName(Ref.MOD_ID, "handoffatetilentity");
	private boolean onFire;
	private final String keyOnFire = "OnFire";

	private boolean hasNetherWart;
	private final String keyNetherWart = "HasNetherWart";

	private boolean hasAntler;
	private final String keyAntler = "HasAntler";

	private boolean hasVenison;
	private final String keyVenison = "HasVenison";

	public TileEntityHandOfFate() {
		super(HAND_OF_FATE_TYPE);
	}

	public TileEntityHandOfFate(World worldIn) {
		super(HAND_OF_FATE_TYPE);
		this.world = worldIn;
	}


	public void setOnFire(boolean b) {
		this.onFire = b;
		if(this.world.isRemote) {
			this.world.getPendingBlockTicks().scheduleTick(pos, this.getBlockState().getBlock(), 100);
			this.world.notifyBlockUpdate(this.pos, this.world.getBlockState(this.pos), this.world.getBlockState(this.pos), 0);
			this.world.markBlockRangeForRenderUpdate(getPos().down(5).west(5).north(5), getPos().up(5).east(5).south(5));
		}
		this.markDirty();
	}

	public boolean isOnFire() {
		return this.onFire;
	}

	public boolean hasNetherWart() {
		return this.hasNetherWart;
	}


	public void setHasNetherWart(boolean hasNetherWart) {
		this.hasNetherWart = hasNetherWart;
		this.markDirty();
		this.checkHasAllThree();
	}

	public boolean hasAntler() {
		return this.hasAntler;
	}


	public void setHasAntler(boolean hasAntler) {
		this.hasAntler = hasAntler;
		this.markDirty();
		this.checkHasAllThree();
	}


	public boolean hasVenison() {
		return this.hasVenison;
	}


	public void setHasVenison(boolean hasVenison) {
		this.hasVenison = hasVenison;
		this.markDirty();
		this.checkHasAllThree();
	}



	private void checkHasAllThree() {
		if(this.hasVenison && this.hasAntler && this.hasNetherWart && this.isOnFire()) {
			this.setHasVenison(false);
			this.setHasAntler(false);
			this.setHasNetherWart(false);
			this.fireBurst();
			this.spawnHirschgeist();
		}
	}




	private void spawnHirschgeist() {
		if(!this.world.isRemote) {
			EntityHirschgeist hg = new EntityHirschgeist(this.world);
			hg.setLocationAndAngles(this.pos.getX(), this.pos.getY() + 1F, this.pos.getZ(), 0, 0);
			hg.setNoAI(false);
			this.world.spawnEntity(hg);
		}
	}


	private void fireBurst() {
		Random rand = new Random();
		for(int i = 0; i < 100; i++) {
			this.world.spawnParticle(Particles.FLAME, this.getPos().getX() + ((rand.nextFloat() + 0.5F) / 2), this.getPos().getY() + 1.5F, this.getPos().getZ() + ((rand.nextFloat() + 0.5F) / 2), 0, 0.5F, 0);
		}
	}


	@Override
	public void read(NBTTagCompound compound) {
		super.read(compound);
		if(compound.hasKey(this.keyOnFire)) {
			this.onFire = compound.getBoolean(this.keyOnFire);
		}
		if(compound.hasKey(this.keyNetherWart)) {
			this.hasNetherWart = compound.getBoolean(this.keyNetherWart);
		}
		if(compound.hasKey(this.keyAntler)) {
			this.hasAntler = compound.getBoolean(this.keyAntler);
		}
		if(compound.hasKey(this.keyVenison)) {
			this.hasVenison = compound.getBoolean(this.keyVenison);
		}
	}



	@Override
	public NBTTagCompound write(NBTTagCompound compound) {
		super.write(compound);
		compound.setBoolean(this.keyOnFire, this.onFire);
		compound.setBoolean(this.keyAntler, this.hasAntler);
		compound.setBoolean(this.keyNetherWart, this.hasNetherWart);
		compound.setBoolean(this.keyVenison, this.hasVenison);
		return compound;
	}

	@Override
	public SPacketUpdateTileEntity getUpdatePacket() {
		NBTTagCompound tag = new NBTTagCompound();
		this.write(tag);
		return new SPacketUpdateTileEntity(this.pos, 1, tag);
	}


	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet) {
		read(packet.getNbtCompound());
		this.world.getPendingBlockTicks().scheduleTick(pos, this.getBlockState().getBlock(), 100);
	}





	@Override
	public NBTTagCompound getUpdateTag() {
		NBTTagCompound tag = new NBTTagCompound();
		this.write(tag);
		return tag;
	}


	@Override
	public void handleUpdateTag(NBTTagCompound tag) {
		this.read(tag);
	}

	@OnlyIn(Dist.CLIENT)
	public float getRotation() {
		IBlockState state = this.world.getBlockState(this.pos);
		if(state.getBlock() == BlockRegistry.handoffate) {
			EnumFacing facing = state.get(BlockHorizontal.HORIZONTAL_FACING).getOpposite();
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
		}
		return 0F;
	}

}
