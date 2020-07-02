package its_meow.betteranimalsplus.init;

import java.util.HashMap;
import java.util.Map;

import dev.itsmeow.imdlib.util.ModSoundEvent;
import its_meow.betteranimalsplus.Ref;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class ModSoundEvents {

    public static final Map<ResourceLocation, SoundEvent> SOUNDS = new HashMap<ResourceLocation, SoundEvent>();

    public static final SoundEvent CRAB_RAVE = sound("record.crabrave");

    public static final SoundEvent GOOSE_DEATH = sound("entity.goose.death");
    public static final SoundEvent GOOSE_HURT = sound("entity.goose.hurt");
    public static final SoundEvent GOOSE_AMBIENT = sound("entity.goose.ambient");

    public static final SoundEvent WALRUS = sound("record.walrus");

    private static SoundEvent sound(String id) {
        ModSoundEvent event = new ModSoundEvent(Ref.MOD_ID, id);
        SOUNDS.put(event.getRegistryName(), event);
        return event;
    }

}
