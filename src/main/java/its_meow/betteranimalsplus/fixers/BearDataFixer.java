package its_meow.betteranimalsplus.fixers;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.datafix.IFixableData;

public class BearDataFixer implements IFixableData {

    @Override
    public int getFixVersion() {
        return 2;
    }

    @Override
    public NBTTagCompound fixTagCompound(NBTTagCompound compound) {
        if(compound.hasKey("id")) {
            String id = compound.getString("id");
            if(id.equals("brownbear")) {
                compound.setString("id", "bear");
                compound.setInteger("TypeNumber", 1);
            } else if(id.equals("blackbear")) {
                compound.setString("id", "bear");
                compound.setInteger("TypeNumber", 2);
            } else if(id.equals("kermodebear")) {
                compound.setString("id", "bear");
                compound.setInteger("TypeNumber", 3);
            }
        }
        return compound;
    }

}
