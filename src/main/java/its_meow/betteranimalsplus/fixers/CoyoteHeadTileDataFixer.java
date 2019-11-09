package its_meow.betteranimalsplus.fixers;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.util.HeadTypes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.datafix.IFixableData;

public class CoyoteHeadTileDataFixer implements IFixableData {

    @Override
    public int getFixVersion() {
        return 4;
    }

    @Override
    public NBTTagCompound fixTagCompound(NBTTagCompound compound) {
        String id = compound.getString("id");
        if(id.equals("betteranimalsplus:head")) {
            HeadTypes type = HeadTypes.valueOf(compound.getString("GENERIC_TYPE"));
            int typeNum = compound.getInteger("TYPENUM");
            if(type == HeadTypes.WOLFHEAD && typeNum == 4) {
                BetterAnimalsPlusMod.logger.debug("Fixed wolf head tile entity (type 4) to coyote head tile entity with type of 1");
                compound.setString("GENERIC_TYPE", HeadTypes.COYOTEHEAD.name());
                compound.setInteger("TYPENUM", 1);
            }
        }
        return compound;
    }

}
