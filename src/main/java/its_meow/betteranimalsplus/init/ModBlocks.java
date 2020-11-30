package its_meow.betteranimalsplus.init;

import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.common.block.BlockTrillium;
import its_meow.betteranimalsplus.common.block.BlockTurkey;
import its_meow.betteranimalsplus.common.block.BlockTurkeyRaw;
import net.minecraft.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Collection;
import java.util.function.Supplier;

public class ModBlocks {

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Ref.MOD_ID);

    public static final RegistryObject<BlockTrillium> TRILLIUM = r("trillium", BlockTrillium::new);
    public static final RegistryObject<BlockTurkeyRaw> TURKEY_RAW = r("turkey_raw", BlockTurkeyRaw::new);
    public static final RegistryObject<Block> TURKEY_COOKED = r("turkey_cooked", BlockTurkey::new);

    private static <T extends Block> RegistryObject<T> r(String name, Supplier<T> b) {
        return BLOCKS.register(name, b);
    }

    public static void subscribe(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }

    public static Collection<RegistryObject<Block>> getBlocks() {
        return BLOCKS.getEntries();
    }
}
