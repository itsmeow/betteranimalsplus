package dev.itsmeow.betteranimalsplus.init;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.itsmeow.betteranimalsplus.Ref;
import dev.itsmeow.betteranimalsplus.common.blockentity.BlockEntityTrillium;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class ModBlockEntities {
    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Ref.MOD_ID, Registries.BLOCK_ENTITY_TYPE);

    public static final RegistrySupplier<BlockEntityType<BlockEntityTrillium>> TRILLIUM_TYPE = r("trillium", () -> BlockEntityType.Builder.of(BlockEntityTrillium::new, ModBlocks.TRILLIUM.get()).build(null));

    private static <T extends BlockEntity> RegistrySupplier<BlockEntityType<T>> r(String name, Supplier<BlockEntityType<T>> b) {
        return BLOCK_ENTITIES.register(name, b);
    }

    public static void init() {
        BLOCK_ENTITIES.register();
    }
}