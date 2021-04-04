package its_meow.betteranimalsplus.init;

import dev.itsmeow.imdlib.entity.util.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.util.EntityTypeContainerContainable;
import dev.itsmeow.imdlib.tileentity.TileEntityHead;
import dev.itsmeow.imdlib.util.HeadType;
import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.common.entity.projectile.*;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = Ref.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BetterAnimalsPlusRegistrar {

    @SubscribeEvent
    public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) {
        event.getRegistry().registerAll(EntityTarantulaHair.HAIR_TYPE, EntityBadgerDirt.DIRT_TYPE, EntityPheasantEgg.PHEASANT_EGG_TYPE, EntityTurkeyEgg.TURKEY_EGG_TYPE, EntityGooseEgg.GOOSE_EGG_TYPE, EntityGoldenGooseEgg.GOLDEN_GOOSE_EGG_TYPE);
    }
}
