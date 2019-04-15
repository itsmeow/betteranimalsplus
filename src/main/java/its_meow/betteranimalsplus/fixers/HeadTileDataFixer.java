package its_meow.betteranimalsplus.fixers;

import java.util.HashSet;
import java.util.Set;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.datafix.IFixableData;

public class HeadTileDataFixer implements IFixableData {
	
	private static Set<String> headIDs = new HashSet<String>();

	static {
		headIDs.add("betteranimalsplus:foxheadtileentity");
		headIDs.add("betteranimalsplus:boarheadtileentity");
		headIDs.add("betteranimalsplus:deerheadtileentity");
		headIDs.add("betteranimalsplus:hirschgeistskulltileentity");
		headIDs.add("betteranimalsplus:wolfheadtileentity");
		headIDs.add("betteranimalsplus:reindeerheadtileentity");
	}

	@Override
	public int getFixVersion() {
		return 1;
	}

	@Override
	public NBTTagCompound fixTagCompound(NBTTagCompound compound) {
		String id = compound.getString("id");
		if(headIDs.contains(id)) {
			BetterAnimalsPlusMod.logger.debug("Fixed head tile entity {} to betteranimalsplus:head", id);
			compound.setString("id", "betteranimalsplus:head");
		}
		return compound;
	}
	
}
