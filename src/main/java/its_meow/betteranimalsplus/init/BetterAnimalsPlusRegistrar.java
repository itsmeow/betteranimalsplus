package its_meow.betteranimalsplus.init;

import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.common.entity.projectile.*;
import net.minecraft.entity.EntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Ref.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BetterAnimalsPlusRegistrar {

    @SubscribeEvent
    public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) {
        event.getRegistry().registerAll(EntityTarantulaHair.HAIR_TYPE, EntityBadgerDirt.DIRT_TYPE, EntityPheasantEgg.PHEASANT_EGG_TYPE, EntityTurkeyEgg.TURKEY_EGG_TYPE, EntityGooseEgg.GOOSE_EGG_TYPE, EntityGoldenGooseEgg.GOLDEN_GOOSE_EGG_TYPE);
    }
}
