package its_meow.betteranimalsplus.fixers;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.datafix.IFixableData;

public class CoyoteHeadItemDataFixer implements IFixableData {

    @Override
    public int getFixVersion() {
        return 4;
    }

    @Override
    public NBTTagCompound fixTagCompound(NBTTagCompound compound) {
        String id = compound.getString("id");
        if(id.equals("betteranimalsplus:wolfhead_4")) {
            String newId = "betteranimalsplus:coyotehead_1";
            compound.setString("id", newId);
            BetterAnimalsPlusMod.logger.debug("Fixed head ItemStack {} to {}", id, newId);
        }
        return compound;
    }

}
