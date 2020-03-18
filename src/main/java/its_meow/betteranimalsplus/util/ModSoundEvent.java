package its_meow.betteranimalsplus.util;

import its_meow.betteranimalsplus.Ref;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class ModSoundEvent extends SoundEvent {

    public ModSoundEvent(String name) {
        super(new ResourceLocation(Ref.MOD_ID, name));
        this.setRegistryName(new ResourceLocation(Ref.MOD_ID, name.replaceAll("\\.", "_")));
    }
    
    public ModSoundEvent(String name, String regName) {
        super(new ResourceLocation(Ref.MOD_ID, name));
        this.setRegistryName(new ResourceLocation(Ref.MOD_ID, regName.replaceAll("\\.", "_")));
    }

}
