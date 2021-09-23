package dev.itsmeow.betteranimalsplus.init;

import dev.itsmeow.betteranimalsplus.Ref;
import dev.itsmeow.betteranimalsplus.common.tileentity.TileEntityTrillium;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModTileEntities {
    private static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Ref.MOD_ID);

    public static final RegistryObject<TileEntityType<TileEntityTrillium>> TRILLIUM_TYPE = r("trilliumtileentity", () -> TileEntityType.Builder.create(TileEntityTrillium::new, ModBlocks.TRILLIUM.get()).build(null));

    private static <T extends TileEntity> RegistryObject<TileEntityType<T>> r(String name, Supplier<TileEntityType<T>> b) {
        return TILE_ENTITIES.register(name, b);
    }

    public static void subscribe(IEventBus modEventBus) {
        TILE_ENTITIES.register(modEventBus);
    }
}