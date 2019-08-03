package its_meow.betteranimalsplus.fixers;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.datafix.IFixableData;

public class SnowyCapeDataFixer implements IFixableData {

    @Override
    public int getFixVersion() {
        return 4;
    }

    @Override
    public NBTTagCompound fixTagCompound(NBTTagCompound compound) {
        String id = compound.getString("id");
        if(id.equals("wolf_cape_snowy")) {
            compound.setString("id", "wolf_cape_classic");
            BetterAnimalsPlusMod.logger.debug("Fixed snowy/classic cape ItemStack ID from wolf_cape_snowy to wolf_cape_classic");
        }

        return compound;
    }

}
