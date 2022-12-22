package dev.itsmeow.betteranimalsplus.init;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.itsmeow.betteranimalsplus.Ref;
import dev.itsmeow.betteranimalsplus.common.block.BlockTrillium;
import dev.itsmeow.betteranimalsplus.common.block.BlockTurkey;
import dev.itsmeow.betteranimalsplus.common.block.BlockTurkeyRaw;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class ModBlocks {

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Ref.MOD_ID, Registries.BLOCK);

    public static final RegistrySupplier<BlockTrillium> TRILLIUM = r("trillium", BlockTrillium::new);
    public static final RegistrySupplier<BlockTurkeyRaw> TURKEY_RAW = r("turkey_raw", BlockTurkeyRaw::new);
    public static final RegistrySupplier<Block> TURKEY_COOKED = r("turkey_cooked", BlockTurkey::new);

    private static <T extends Block> RegistrySupplier<T> r(String name, Supplier<T> b) {
        return BLOCKS.register(name, b);
    }

    public static void init() {
        BLOCKS.register();
    }

}
