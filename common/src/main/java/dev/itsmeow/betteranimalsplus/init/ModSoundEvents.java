package dev.itsmeow.betteranimalsplus.init;

import dev.itsmeow.betteranimalsplus.Ref;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModSoundEvents {

    private static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Ref.MOD_ID);

    public static final RegistryObject<SoundEvent> CRAB_RAVE = r("record_crabrave");
    public static final RegistryObject<SoundEvent> GOOSE_DEATH = r("entity_goose_death");
    public static final RegistryObject<SoundEvent> GOOSE_HURT = r("entity_goose_hurt");
    public static final RegistryObject<SoundEvent> GOOSE_AMBIENT = r("entity_goose_ambient");
    public static final RegistryObject<SoundEvent> WALRUS = r("record_walrus");

    private static RegistryObject<SoundEvent> r(String name) {
        return SOUNDS.register(name, () -> new SoundEvent(new ResourceLocation(Ref.MOD_ID, name.replaceAll("_", "."))));
    }

    public static void subscribe(IEventBus modEventBus) {
        SOUNDS.register(modEventBus);
    }
}
