package dev.itsmeow.betteranimalsplus.init;

import dev.architectury.registry.fuel.FuelRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.itsmeow.betteranimalsplus.BetterAnimalsPlusMod;
import dev.itsmeow.betteranimalsplus.Ref;
import dev.itsmeow.betteranimalsplus.common.entity.projectile.EntityGoldenGooseEgg;
import dev.itsmeow.betteranimalsplus.common.entity.projectile.EntityGooseEgg;
import dev.itsmeow.betteranimalsplus.common.entity.projectile.EntityPheasantEgg;
import dev.itsmeow.betteranimalsplus.common.entity.projectile.EntityTurkeyEgg;
import dev.itsmeow.betteranimalsplus.common.item.*;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.function.Function;
import java.util.function.Supplier;

public class ModItems {

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Ref.MOD_ID, Registry.ITEM_REGISTRY);

    private static final Map<ResourceLocation, RegistrySupplier<? extends ItemModeledArmor>> MODELED_ARMOR = new WeakHashMap<>();

    public static final RegistrySupplier<Item> ADVANCEMENT_ICON_JELLYFISH = rH("advancement_icon_jellyfish");
    public static final RegistrySupplier<Item> ADVANCEMENT_ICON_JELLYFISH_CROSS = rH("advancement_icon_jellyfish_cross");
    public static final RegistrySupplier<Item> ADVANCEMENT_ICON_SHARK = rH("advancement_icon_shark");
    public static final RegistrySupplier<Item> ADVANCEMENT_ICON_LAMPREY = rH("advancement_icon_lamprey");
    public static final RegistrySupplier<Item> ADVANCEMENT_ICON_SQUIRREL = rH("advancement_icon_squirrel");
    public static final RegistrySupplier<Item> ADVANCEMENT_ICON_BADGER = rH("advancement_icon_badger");
    public static final RegistrySupplier<Item> ADVANCEMENT_ICON_SUCCENING = rH("advancement_icon_succening");
    public static final RegistrySupplier<Item> ADVANCEMENT_ICON_OCTOPUS = rH("advancement_icon_octopus");

    public static final RegistrySupplier<ItemBetterFood> VENISON_RAW = r("venisonraw", () -> new ItemBetterFood(4, 0, 32, true));
    public static final RegistrySupplier<ItemBetterFood> VENISON_COOKED = r("venisoncooked", () -> new ItemBetterFood(8, 1.2F, 32, true));
    public static final RegistrySupplier<Item> ANTLER = r("antler");
    public static final RegistrySupplier<Item> BLUBBER = r("blubber", () -> {
        ItemBetterFood i = new ItemBetterFood(1, 2.0F, 32, false);
        FuelRegistry.register(800, i);
        return i;
    });
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

    public static final RegistrySupplier<ItemWolfCape> WOLF_CAPE_CLASSIC = modelArmor(varArg("wolf_cape_", "classic", s -> new ItemWolfCape(s, WOLF_PELT_SNOWY.get())));
    public static final RegistrySupplier<ItemWolfCape> WOLF_CAPE_TIMBER = modelArmor(varArg("wolf_cape_", "timber", s -> new ItemWolfCape(s, WOLF_PELT_TIMBER.get())));
    public static final RegistrySupplier<ItemWolfCape> WOLF_CAPE_BLACK = modelArmor(varArg("wolf_cape_", "black", s -> new ItemWolfCape(s, WOLF_PELT_BLACK.get())));

    public static final RegistrySupplier<ItemWolfCape> WOLF_CAPE_ARCTIC = modelArmor(varArg("wolf_cape_", "arctic", s -> new ItemWolfCape(s, WOLF_PELT_ARCTIC.get())));
    public static final RegistrySupplier<ItemWolfCape> WOLF_CAPE_BROWN = modelArmor(varArg("wolf_cape_", "brown", s -> new ItemWolfCape(s, WOLF_PELT_BROWN.get())));
    public static final RegistrySupplier<ItemWolfCape> WOLF_CAPE_RED = modelArmor(varArg("wolf_cape_", "red", s -> new ItemWolfCape(s, WOLF_PELT_RED.get())));

    public static final RegistrySupplier<Item> BEAR_SKIN_BROWN = r("bear_skin_brown");
    public static final RegistrySupplier<Item> BEAR_SKIN_BLACK = r("bear_skin_black");
    public static final RegistrySupplier<Item> BEAR_SKIN_KERMODE = r("bear_skin_kermode");

    public static RegistrySupplier<ItemBearCape> BEAR_CAPE_BROWN = modelArmor(varArg("bear_cape_", "brown", s -> new ItemBearCape(s, BEAR_SKIN_BROWN.get())));
    public static RegistrySupplier<ItemBearCape> BEAR_CAPE_BLACK = modelArmor(varArg("bear_cape_", "black", s -> new ItemBearCape(s, BEAR_SKIN_BLACK.get())));
    public static RegistrySupplier<ItemBearCape> BEAR_CAPE_KERMODE = modelArmor(varArg("bear_cape_", "kermode", s -> new ItemBearCape(s, BEAR_SKIN_KERMODE.get())));

    public static final RegistrySupplier<ItemThrowableCustomEgg<EntityPheasantEgg>> PHEASANT_EGG = r("pheasant_egg", () -> new ItemThrowableCustomEgg(ModEntities.PROJECTILE_PHEASANT_EGG::get, EntityPheasantEgg::new, EntityPheasantEgg::new));
    public static final RegistrySupplier<ItemThrowableCustomEgg<EntityTurkeyEgg>> TURKEY_EGG = r("turkey_egg", () -> new ItemThrowableCustomEgg(ModEntities.PROJECTILE_TURKEY_EGG::get, EntityTurkeyEgg::new, EntityTurkeyEgg::new));
    public static final RegistrySupplier<ItemThrowableCustomEgg<EntityGooseEgg>> GOOSE_EGG = r("goose_egg", () -> new ItemThrowableCustomEgg(ModEntities.PROJECTILE_GOOSE_EGG::get, EntityGooseEgg::new, EntityGooseEgg::new));
    public static final RegistrySupplier<ItemThrowableCustomEgg<EntityGoldenGooseEgg>> GOLDEN_GOOSE_EGG = r("golden_goose_egg", () -> new ItemThrowableCustomEgg(ModEntities.PROJECTILE_GOLDEN_GOOSE_EGG::get, EntityGoldenGooseEgg::new, EntityGoldenGooseEgg::new) {
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

    protected static RegistrySupplier<Item> r(String name) {
        return ITEMS.register(name, () -> new Item(new Item.Properties().tab(BetterAnimalsPlusMod.TAB)));
    }

    protected static RegistrySupplier<Item> rH(String name) {
        return ITEMS.register(name, () -> new Item(new Item.Properties()));
    }

    protected static <T extends Item> RegistrySupplier<T> r(String name, Supplier<T> b) {
        return ITEMS.register(name, b);
    }

    protected static <T extends Item> RegistrySupplier<T> varArg(String nameBase, String nameExt, Function<String, T> b) {
        return ITEMS.register(nameBase + nameExt, () -> b.apply(nameExt));
    }

    protected static RegistrySupplier<BlockItem> rIB(RegistrySupplier<? extends Block> parent) {
        return ITEMS.register(parent.getId().getPath(), () -> new BlockItem(parent.get(), new Item.Properties().tab(BetterAnimalsPlusMod.TAB)));
    }

    protected static <T extends ItemModeledArmor> RegistrySupplier<T> modelArmor(RegistrySupplier<T> armor) {
        MODELED_ARMOR.put(armor.getId(), armor);
        return armor;
    }

    public static Map<ResourceLocation, RegistrySupplier<? extends ItemModeledArmor>> getModeledArmor() {
        return MODELED_ARMOR;
    }

    public static void init() {
        ITEMS.register();
    }

}
