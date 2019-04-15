package its_meow.betteranimalsplus.fixers;

import java.util.HashSet;
import java.util.Set;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.datafix.IFixableData;

public class HeadItemDataFixer implements IFixableData {

	private static Set<String> headIDs = new HashSet<String>();

	static {
		headIDs.add("betteranimalsplus:foxhead");
		headIDs.add("betteranimalsplus:boarhead");
		headIDs.add("betteranimalsplus:deerhead");
		headIDs.add("betteranimalsplus:hirschgeistskull");
		headIDs.add("betteranimalsplus:wolfhead");
		headIDs.add("betteranimalsplus:reindeerhead");
	}

	@Override
	public int getFixVersion() {
		return 1;
	}

	@Override
	public NBTTagCompound fixTagCompound(NBTTagCompound compound) {
		String id = compound.getString("id");
		if(headIDs.contains(id)) {
			int type = 1;
			if(compound.hasKey("tag")) {
				NBTTagCompound subcompound = compound.getCompoundTag("tag");
				if(subcompound.hasKey("TYPENUM")) {
					type = subcompound.getInteger("TYPENUM");
					subcompound.removeTag("TYPENUM");
					BetterAnimalsPlusMod.logger.debug("Found type number {} in {}", type, id);
				}
			}
			compound.setString("id", id + "_" + type);
			BetterAnimalsPlusMod.logger.debug("Fixed head ItemStack {} to {}", id, id + "_" + type);
		}

		return compound;
	}

}
