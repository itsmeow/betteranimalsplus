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
    public static void registerBlocks(final RegistryEvent.Register<Block> event) {
        final IForgeRegistry<Block> registry = event.getRegistry();

        for (HeadType type : HeadType.values()) {
            registry.registerAll(type.getBlockSet().toArray(new Block[0]));
        }
    }

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry();

        // Heads
        for (HeadType type : HeadType.values()) {
            registry.registerAll(type.getItemSet().toArray(new Item[0]));
        }

        // Containers & eggs
        for(EntityTypeContainer<?> container : ModEntities.getEntities().values()) {
            if (container instanceof EntityTypeContainerContainable<?, ?>) {
                EntityTypeContainerContainable<?, ?> c = (EntityTypeContainerContainable<?, ?>) container;
                if (!ForgeRegistries.ITEMS.containsValue(c.getContainerItem()) && c.getContainerItem().getRegistryName().getNamespace().equals(Ref.MOD_ID)) {
                    registry.register(c.getContainerItem());
                }
                if (!ForgeRegistries.ITEMS.containsValue(c.getEmptyContainerItem()) && c.getEmptyContainerItem().getRegistryName().getNamespace().equals(Ref.MOD_ID)) {
                    registry.register(c.getEmptyContainerItem());
                }
            }
            if(container.hasEgg) {
                registry.register(container.egg);
            }
        }
    }

    @SubscribeEvent
    public static void registerTileEntities(final RegistryEvent.Register<TileEntityType<?>> event) {
        TileEntityHead.registerType(event, Ref.MOD_ID);
    }

    @SubscribeEvent
    public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) {
        final IForgeRegistry<EntityType<?>> registry = event.getRegistry();

        registry.registerAll(EntityTarantulaHair.HAIR_TYPE, EntityBadgerDirt.DIRT_TYPE, EntityPheasantEgg.PHEASANT_EGG_TYPE, EntityTurkeyEgg.TURKEY_EGG_TYPE, EntityGooseEgg.GOOSE_EGG_TYPE, EntityGoldenGooseEgg.GOLDEN_GOOSE_EGG_TYPE);

        for(EntityTypeContainer<?> container : ModEntities.getEntities().values()) {
            registry.register(container.entityType);
            container.registerAttributes();
        }
    }
}
