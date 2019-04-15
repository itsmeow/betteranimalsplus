package its_meow.betteranimalsplus.fixers;

import java.util.HashMap;
import java.util.Map;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.util.HeadTypes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.datafix.IFixableData;

public class HeadTileDataFixer implements IFixableData {
	
	private static Map<String, HeadTypes> headIDs = new HashMap<String, HeadTypes>();

	static {
		headIDs.put("betteranimalsplus:foxheadtileentity", HeadTypes.FOXHEAD);
		headIDs.put("betteranimalsplus:boarheadtileentity", HeadTypes.BOARHEAD);
		headIDs.put("betteranimalsplus:deerheadtileentity", HeadTypes.DEERHEAD);
		headIDs.put("betteranimalsplus:hirschgeistskulltileentity", HeadTypes.HIRSCHGEIST);
		headIDs.put("betteranimalsplus:wolfheadtileentity", HeadTypes.WOLFHEAD);
		headIDs.put("betteranimalsplus:reindeerheadtileentity", HeadTypes.REINDEERHEAD);
	}
	
	@Override
	public int getFixVersion() {
		return 1;
	}
	
	@Override
	public NBTTagCompound fixTagCompound(NBTTagCompound compound) {
		String id = compound.getString("id");
		if(headIDs.keySet().contains(id)) {
			HeadTypes type = headIDs.get(id);
			BetterAnimalsPlusMod.logger.debug("Fixed head tile entity {} to betteranimalsplus:head with type of {}", id, type.name());
			compound.setString("id", "betteranimalsplus:head");
			compound.setString("GENERIC_TYPE", type.name());
			if(compound.hasKey("SkullType")) {
				compound.removeTag("SkullType");
			}
			if(compound.hasKey("Rot")) {
				byte rotB = compound.getByte("Rot");
				float rot = (float) ((int)rotB);
				int fixedRot = (int) Math.floor(rot / 4);
				fixedRot *= 90;
				compound.removeTag("Rot");
				compound.setInteger("rotation", fixedRot);
				BetterAnimalsPlusMod.logger.debug("Fixed rotation on skull above from {} to {}", rot, fixedRot);
			}
		}
		return compound;
	}
	
}
