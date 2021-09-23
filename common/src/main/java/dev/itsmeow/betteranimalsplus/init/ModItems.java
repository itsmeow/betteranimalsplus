package dev.itsmeow.betteranimalsplus.init;

import dev.itsmeow.betteranimalsplus.BetterAnimalsPlusMod;
import dev.itsmeow.betteranimalsplus.Ref;
import dev.itsmeow.betteranimalsplus.common.entity.projectile.EntityGoldenGooseEgg;
import dev.itsmeow.betteranimalsplus.common.entity.projectile.EntityGooseEgg;
import dev.itsmeow.betteranimalsplus.common.entity.projectile.EntityPheasantEgg;
import dev.itsmeow.betteranimalsplus.common.entity.projectile.EntityTurkeyEgg;
import dev.itsmeow.betteranimalsplus.common.item.*;
import me.shedaniel.architectury.registry.DeferredRegister;
import me.shedaniel.architectury.registry.RegistrySupplier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class ModItems {

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Ref.MOD_ID, Registry.ITEM_REGISTRY);

    public static final RegistrySupplier<Item> ADVANCEMENT_ICON_JELLYFISH = rH("advancement_icon_jellyfish");
    public static final RegistrySupplier<Item> ADVANCEMENT_ICON_JELLYFISH_CROSS = rH("advancement_icon_jellyfish_cross");
    public static final RegistrySupplier<Item> ADVANCEMENT_ICON_GOAT = rH("advancement_icon_goat");
    public static final RegistrySupplier<Item> ADVANCEMENT_ICON_SHARK = rH("advancement_icon_shark");
    public static final RegistrySupplier<Item> ADVANCEMENT_ICON_LAMPREY = rH("advancement_icon_lamprey");
    public static final RegistrySupplier<Item> ADVANCEMENT_ICON_SQUIRREL = rH("advancement_icon_squirrel");
    public static final RegistrySupplier<Item> ADVANCEMENT_ICON_BADGER = rH("advancement_icon_badger");
    public static final RegistrySupplier<Item> ADVANCEMENT_ICON_SUCCENING = rH("advancement_icon_succening");
    public static final RegistrySupplier<Item> ADVANCEMENT_ICON_OCTOPUS = rH("advancement_icon_octopus");

    public static final RegistrySupplier<ItemBetterFood> VENISON_RAW = r("venisonraw", () -> new ItemBetterFood(4, 0, 32, true));
    public static final RegistrySupplier<ItemBetterFood> VENISON_COOKED = r("venisoncooked", () -> new ItemBetterFood(8, 1.2F, 32, true));
    public static final RegistrySupplier<Item> ANTLER = r("antler");
    public static final RegistrySupplier<Item> BLUBBER = r("blubber", () -> new ItemBetterFood(1, 2.0F, 32, false)); // TODO burn time 800 ticks
    public static final RegistrySupplier<Item> GOAT_MILK = r("goatmilk", () -> new MilkBucketItem(new Item.Properties().craftRemainder(Items.BUCKET).tab(BetterAnimalsPlusMod.TAB).stacksTo(1)));
    public static final RegistrySupplier<ItemBetterFood> GOAT_CHEESE = r("goatcheese", () -> new ItemBetterFood(3, 1, 15, false));
    public static final RegistrySupplier<ItemBetterFood> PHEASANT_RAW = r("pheasantraw", () -> new ItemBetterFood(3, 0, 32, true));
    public static final RegistrySupplier<ItemBetterFood> PHEASANT_COOKED = r("pheasantcooked", () -> new ItemBetterFood(7, 1.2F, 32, true));

    public static final RegistrySupplier<ItemBetterFood> CRAB_MEAT_RAW = r("crab_meat_raw", () -> new ItemBetterFood(2, 1, 16, true));
    public static final RegistrySupplier<ItemBetterFood> CRAB_MEAT_COOKED = r("crab_meat_cooked", () -> new ItemBetterFood(5, 1.2F, 16, true));

    public static final RegistrySupplier<Item> WOLF_PELT_SNOWY = r("wolf_pelt_snowy");
    public static final RegistrySupplier<Item> WOLF_PELT_TIMBER = r("wolf_pelt_timber");
    public static final RegistrySupplier<Item> WOLF_PELT_BLACK = r("wolf_pelt_black");

    public static final RegistrySupplier<Item> WOLF_PELT_ARCTIC = r("wolf_pelt_arctic");
    public static final RegistrySupplier<Item> WOLF_PELT_BROWN = r("wolf_pelt_brown");
    public static final RegistrySupplier<Item> WOLF_PELT_RED = r("wolf_pelt_red");

    public static final RegistrySupplier<ItemWolfCape> WOLF_CAPE_CLASSIC = varArg("wolf_cape_", "classic", s -> new ItemWolfCape(s, WOLF_PELT_SNOWY.get()));
    public static final RegistrySupplier<ItemWolfCape> WOLF_CAPE_TIMBER = varArg("wolf_cape_", "timber", s -> new ItemWolfCape(s, WOLF_PELT_TIMBER.get()));
    public static final RegistrySupplier<ItemWolfCape> WOLF_CAPE_BLACK = varArg("wolf_cape_", "black", s -> new ItemWolfCape(s, WOLF_PELT_BLACK.get()));

    public static final RegistrySupplier<ItemWolfCape> WOLF_CAPE_ARCTIC = varArg("wolf_cape_", "arctic", s -> new ItemWolfCape(s, WOLF_PELT_ARCTIC.get()));
    public static final RegistrySupplier<ItemWolfCape> WOLF_CAPE_BROWN = varArg("wolf_cape_", "brown", s -> new ItemWolfCape(s, WOLF_PELT_BROWN.get()));
    public static final RegistrySupplier<ItemWolfCape> WOLF_CAPE_RED = varArg("wolf_cape_", "red", s -> new ItemWolfCape(s, WOLF_PELT_RED.get()));

    public static final RegistrySupplier<Item> BEAR_SKIN_BROWN = r("bear_skin_brown");
    public static final RegistrySupplier<Item> BEAR_SKIN_BLACK = r("bear_skin_black");
    public static final RegistrySupplier<Item> BEAR_SKIN_KERMODE = r("bear_skin_kermode");

    public static RegistrySupplier<ItemBearCape> BEAR_CAPE_BROWN = varArg("bear_cape_", "brown", s -> new ItemBearCape(s, BEAR_SKIN_BROWN.get()));
    public static RegistrySupplier<ItemBearCape> BEAR_CAPE_BLACK = varArg("bear_cape_", "black", s -> new ItemBearCape(s, BEAR_SKIN_BLACK.get()));
    public static RegistrySupplier<ItemBearCape> BEAR_CAPE_KERMODE = varArg("bear_cape_", "kermode", s -> new ItemBearCape(s, BEAR_SKIN_KERMODE.get()));

    public static final RegistrySupplier<ItemModMusicDisc> RECORD_CRAB_RAVE = r("record_crab_rave", () -> new ItemModMusicDisc(ModSoundEvents.CRAB_RAVE.get()));

    public static final RegistrySupplier<ItemModMusicDisc> RECORD_WALRUS = r("record_walrus", () -> new ItemModMusicDisc(ModSoundEvents.WALRUS.get()));

    public static final RegistrySupplier<ItemThrowableCustomEgg> PHEASANT_EGG = r("pheasant_egg", () -> new ItemThrowableCustomEgg(EntityPheasantEgg::new, EntityPheasantEgg::new));
    public static final RegistrySupplier<ItemThrowableCustomEgg> TURKEY_EGG = r("turkey_egg", () -> new ItemThrowableCustomEgg(EntityTurkeyEgg::new, EntityTurkeyEgg::new));
    public static final RegistrySupplier<ItemThrowableCustomEgg> GOOSE_EGG = r("goose_egg", () -> new ItemThrowableCustomEgg(EntityGooseEgg::new, EntityGooseEgg::new));
    public static final RegistrySupplier<ItemThrowableCustomEgg> GOLDEN_GOOSE_EGG = r("golden_goose_egg", () -> new ItemThrowableCustomEgg(EntityGoldenGooseEgg::new, EntityGoldenGooseEgg::new) {
        @Environment(EnvType.CLIENT)
        @Override
        public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
            tooltip.add(new TextComponent("Golden! Maybe you can melt this down for resources?").withStyle(ChatFormatting.YELLOW).withStyle(ChatFormatting.BOLD));
        }
    });

    public static final RegistrySupplier<ItemBetterFood> TURKEY_LEG_RAW = r("turkey_leg_raw", () -> new ItemBetterFood(2, 0F, 16, true));
    public static final RegistrySupplier<ItemBetterFood> TURKEY_LEG_COOKED = r("turkey_leg_cooked", () -> new ItemBetterFood(4, 1.2F, 16, true));

    public static final RegistrySupplier<ItemBetterFood> EEL_MEAT_RAW = r("eel_meat_raw", () -> new ItemBetterFood(1, 0F, 32, true));
    public static final RegistrySupplier<ItemBetterFood> EEL_MEAT_COOKED = r("eel_meat_cooked", () -> new ItemBetterFood(4, 0.7F, 32, true));

    public static final RegistrySupplier<ItemBetterFood> FRIED_EGG = r("fried_egg", () -> new ItemBetterFood(5, 1.5F, 16, true));

    public static final RegistrySupplier<ItemBetterFood> CALAMARI_RAW = r("calamari_raw", () -> new ItemBetterFood(2, 0.25F, 32, true));
    public static final RegistrySupplier<ItemBetterFood> CALAMARI_COOKED = r("calamari_cooked", () -> new ItemBetterFood(7, 0.65F, 32, true));

    public static final RegistrySupplier<ItemHorseshoeCrabBlood> HORSESHOE_CRAB_BLOOD = r("horseshoe_crab_blood", ItemHorseshoeCrabBlood::new);

    public static final RegistrySupplier<BlockItem> TURKEY_RAW = rIB(ModBlocks.TURKEY_RAW);
    public static final RegistrySupplier<BlockItem> TURKEY_COOKED = rIB(ModBlocks.TURKEY_COOKED);
    public static final RegistrySupplier<BlockItem> TRILLIUM = rIB(ModBlocks.TRILLIUM);

    private static RegistrySupplier<Item> r(String name) {
        return ITEMS.register(name, () -> new Item(new Item.Properties().tab(BetterAnimalsPlusMod.TAB)));
    }

    private static RegistrySupplier<Item> rH(String name) {
        return ITEMS.register(name, () -> new Item(new Item.Properties()));
    }

    private static <T extends Item> RegistrySupplier<T> r(String name, Supplier<T> b) {
        return ITEMS.register(name, b);
    }

    private static <T extends Item> RegistrySupplier<T> varArg(String nameBase, String nameExt, Function<String, T> b) {
        return ITEMS.register(nameBase + nameExt, () -> b.apply(nameExt));
    }

    private static RegistrySupplier<BlockItem> rIB(RegistrySupplier<? extends Block> parent) {
        return ITEMS.register(parent.getId().getPath(), () -> new BlockItem(parent.get(), new Item.Properties().tab(BetterAnimalsPlusMod.TAB)));
    }

    public static void init() {
        ITEMS.register();
    }

}
