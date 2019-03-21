package its_meow.betteranimalsplus.init;

import java.util.HashSet;
import java.util.Set;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.common.item.ItemBetterFood;
import its_meow.betteranimalsplus.common.item.ItemHirschgeistSkull;
import its_meow.betteranimalsplus.common.item.ItemHirschgeistSkullWearable;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBucketMilk;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class ItemRegistry {

    public static final ItemBetterFood venisonRaw = new ItemBetterFood("venisonraw", 4, 0, 32, true);
    public static final ItemBetterFood venisonCooked = new ItemBetterFood("venisoncooked", 8, 1.2F, 32, true);
    public static final ItemHirschgeistSkullWearable itemHirschgeistSkullWearable = new ItemHirschgeistSkullWearable();
    public static final Item antler = new Item().setRegistryName("antler").setCreativeTab(BetterAnimalsPlusMod.tab);
    public static final Item goatMilk = new ItemBucketMilk().setRegistryName("goatmilk").setCreativeTab(BetterAnimalsPlusMod.tab).setUnlocalizedName(Ref.MOD_ID + "." + "goatmilk");
    public static final ItemBetterFood goatCheese = new ItemBetterFood("goatcheese", 3, 1, 15, false);
    public static final ItemBetterFood pheasantRaw = new ItemBetterFood("pheasantraw", 3, 0, 32, true);
    public static final ItemBetterFood pheasantCooked = new ItemBetterFood("pheasantcooked", 7, 1.2F, 32, true);

    // These are not registered
    public static final ItemHirschgeistSkull itemHirschgeistSkull = new ItemHirschgeistSkull(BlockRegistry.hirschgeistskull);
    public static final ItemBlock itemHandOfFate = new ItemBlock(BlockRegistry.handoffate);

    @Mod.EventBusSubscriber
    public static class RegistrationHandler {
        public static final Set<Item> ITEMS = new HashSet<>();

        /**
         * Register this mod's {@link Item}s.
         *
         * @param event The event
         */
        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event) {
            Item[] items = { venisonRaw, venisonCooked, itemHirschgeistSkullWearable, antler, goatMilk, goatCheese, pheasantRaw, pheasantCooked,
            };
            final IForgeRegistry<Item> registry = event.getRegistry();

            for (final Item item : items) {
                registry.register(item);
                ITEMS.add(item);
            }
        }
    }

}
