package its_meow.betteranimalsplus.init;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.common.entity.projectile.EntityGoldenGooseEgg;
import its_meow.betteranimalsplus.common.entity.projectile.EntityGooseEgg;
import its_meow.betteranimalsplus.common.entity.projectile.EntityPheasantEgg;
import its_meow.betteranimalsplus.common.entity.projectile.EntityTurkeyEgg;
import its_meow.betteranimalsplus.common.item.*;
import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.*;
import net.minecraft.item.Item.Properties;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public class ModItems {

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ref.MOD_ID);

    public static final RegistryObject<Item> ADVANCEMENT_ICON_JELLYFISH = rH("advancement_icon_jellyfish");
    public static final RegistryObject<Item> ADVANCEMENT_ICON_JELLYFISH_CROSS = rH("advancement_icon_jellyfish_cross");
    public static final RegistryObject<Item> ADVANCEMENT_ICON_GOAT = rH("advancement_icon_goat");
    public static final RegistryObject<Item> ADVANCEMENT_ICON_SHARK = rH("advancement_icon_shark");
    public static final RegistryObject<Item> ADVANCEMENT_ICON_LAMPREY = rH("advancement_icon_lamprey");
    public static final RegistryObject<Item> ADVANCEMENT_ICON_SQUIRREL = rH("advancement_icon_squirrel");
    public static final RegistryObject<Item> ADVANCEMENT_ICON_BADGER = rH("advancement_icon_badger");
    public static final RegistryObject<Item> ADVANCEMENT_ICON_SUCCENING = rH("advancement_icon_succening");
    public static final RegistryObject<Item> ADVANCEMENT_ICON_OCTOPUS = rH("advancement_icon_octopus");

    public static final RegistryObject<ItemBetterFood> VENISON_RAW = r("venisonraw", () -> new ItemBetterFood(4, 0, 32, true));
    public static final RegistryObject<ItemBetterFood> VENISON_COOKED = r("venisoncooked", () -> new ItemBetterFood(8, 1.2F, 32, true));
    public static final RegistryObject<Item> ANTLER = r("antler");
    public static final RegistryObject<Item> BLUBBER = r("blubber", () -> new ItemBetterFood(1, 2.0F, 32, false) {
        @Override
        public int getBurnTime(ItemStack itemStack) {
            return 800; // half of coal
        }
    });
    public static final RegistryObject<Item> GOAT_MILK = r("goatmilk", () -> new MilkBucketItem(new Properties().containerItem(Items.BUCKET).group(BetterAnimalsPlusMod.group).maxStackSize(1)));
    public static final RegistryObject<ItemBetterFood> GOAT_CHEESE = r("goatcheese", () -> new ItemBetterFood(3, 1, 15, false));
    public static final RegistryObject<ItemBetterFood> PHEASANT_RAW = r("pheasantraw", () -> new ItemBetterFood(3, 0, 32, true));
    public static final RegistryObject<ItemBetterFood> PHEASANT_COOKED = r("pheasantcooked", () -> new ItemBetterFood(7, 1.2F, 32, true));

    public static final RegistryObject<ItemBetterFood> CRAB_MEAT_RAW = r("crab_meat_raw", () -> new ItemBetterFood(2, 1, 16, true));
    public static final RegistryObject<ItemBetterFood> CRAB_MEAT_COOKED = r("crab_meat_cooked", () -> new ItemBetterFood(5, 1.2F, 16, true));

    public static final RegistryObject<Item> WOLF_PELT_SNOWY = r("wolf_pelt_snowy");
    public static final RegistryObject<Item> WOLF_PELT_TIMBER = r("wolf_pelt_timber");
    public static final RegistryObject<Item> WOLF_PELT_BLACK = r("wolf_pelt_black");

    public static final RegistryObject<Item> WOLF_PELT_ARCTIC = r("wolf_pelt_arctic");
    public static final RegistryObject<Item> WOLF_PELT_BROWN = r("wolf_pelt_brown");
    public static final RegistryObject<Item> WOLF_PELT_RED = r("wolf_pelt_red");

    public static final RegistryObject<ItemWolfCape> WOLF_CAPE_CLASSIC = varArg("wolf_cape_", "classic", s -> new ItemWolfCape(s, WOLF_PELT_SNOWY.get()));
    public static final RegistryObject<ItemWolfCape> WOLF_CAPE_TIMBER = varArg("wolf_cape_", "timber", s -> new ItemWolfCape(s, WOLF_PELT_TIMBER.get()));
    public static final RegistryObject<ItemWolfCape> WOLF_CAPE_BLACK = varArg("wolf_cape_", "black", s -> new ItemWolfCape(s, WOLF_PELT_BLACK.get()));

    public static final RegistryObject<ItemWolfCape> WOLF_CAPE_ARCTIC = varArg("wolf_cape_", "arctic", s -> new ItemWolfCape(s, WOLF_PELT_ARCTIC.get()));
    public static final RegistryObject<ItemWolfCape> WOLF_CAPE_BROWN = varArg("wolf_cape_", "brown", s -> new ItemWolfCape(s, WOLF_PELT_BROWN.get()));
    public static final RegistryObject<ItemWolfCape> WOLF_CAPE_RED = varArg("wolf_cape_", "red", s -> new ItemWolfCape(s, WOLF_PELT_RED.get()));

    public static final RegistryObject<Item> BEAR_SKIN_BROWN = r("bear_skin_brown");
    public static final RegistryObject<Item> BEAR_SKIN_BLACK = r("bear_skin_black");
    public static final RegistryObject<Item> BEAR_SKIN_KERMODE = r("bear_skin_kermode");

    public static RegistryObject<ItemBearCape> BEAR_CAPE_BROWN = varArg("bear_cape_", "brown", s -> new ItemBearCape(s, BEAR_SKIN_BROWN.get()));
    public static RegistryObject<ItemBearCape> BEAR_CAPE_BLACK = varArg("bear_cape_", "black", s -> new ItemBearCape(s, BEAR_SKIN_BLACK.get()));
    public static RegistryObject<ItemBearCape> BEAR_CAPE_KERMODE = varArg("bear_cape_", "kermode", s -> new ItemBearCape(s, BEAR_SKIN_KERMODE.get()));

    public static final RegistryObject<ItemModMusicDisc> RECORD_CRAB_RAVE = r("record_crab_rave", () -> new ItemModMusicDisc(() -> ModSoundEvents.CRAB_RAVE.get()));

    public static final RegistryObject<ItemModMusicDisc> RECORD_WALRUS = r("record_walrus", () -> new ItemModMusicDisc(() -> ModSoundEvents.WALRUS.get()));

    public static final RegistryObject<ItemThrowableCustomEgg> PHEASANT_EGG = r("pheasant_egg", () -> new ItemThrowableCustomEgg(EntityPheasantEgg::new, EntityPheasantEgg::new));
    public static final RegistryObject<ItemThrowableCustomEgg> TURKEY_EGG = r("turkey_egg", () -> new ItemThrowableCustomEgg(EntityTurkeyEgg::new, EntityTurkeyEgg::new));
    public static final RegistryObject<ItemThrowableCustomEgg> GOOSE_EGG = r("goose_egg", () -> new ItemThrowableCustomEgg(EntityGooseEgg::new, EntityGooseEgg::new));
    public static final RegistryObject<ItemThrowableCustomEgg> GOLDEN_GOOSE_EGG = r("golden_goose_egg", () -> new ItemThrowableCustomEgg(EntityGoldenGooseEgg::new, EntityGoldenGooseEgg::new) {
        @OnlyIn(Dist.CLIENT)
        @Override
        public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
            tooltip.add(new StringTextComponent("Golden! Maybe you can melt this down for resources?").setStyle(new Style().setBold(true).setColor(TextFormatting.YELLOW)));
        }
    });

    public static final RegistryObject<ItemBetterFood> TURKEY_LEG_RAW = r("turkey_leg_raw", () -> new ItemBetterFood(2, 0F, 16, true));
    public static final RegistryObject<ItemBetterFood> TURKEY_LEG_COOKED = r("turkey_leg_cooked", () -> new ItemBetterFood(4, 1.2F, 16, true));

    public static final RegistryObject<ItemBetterFood> EEL_MEAT_RAW = r("eel_meat_raw", () -> new ItemBetterFood(1, 0F, 32, true));
    public static final RegistryObject<ItemBetterFood> EEL_MEAT_COOKED = r("eel_meat_cooked", () -> new ItemBetterFood(4, 0.7F, 32, true));

    public static final RegistryObject<ItemBetterFood> FRIED_EGG = r("fried_egg", () -> new ItemBetterFood(5, 1.5F, 16, true));

    public static final RegistryObject<ItemBetterFood> CALAMARI_RAW = r("calamari_raw", () -> new ItemBetterFood(2, 0.25F, 32, true));
    public static final RegistryObject<ItemBetterFood> CALAMARI_COOKED = r("calamari_cooked", () -> new ItemBetterFood(7, 0.65F, 32, true));

    public static final RegistryObject<ItemHorseshoeCrabBlood> HORSESHOE_CRAB_BLOOD = r("horseshoe_crab_blood", ItemHorseshoeCrabBlood::new);

    public static final RegistryObject<BlockItem> TURKEY_RAW = rIB(ModBlocks.TURKEY_RAW);
    public static final RegistryObject<BlockItem> TURKEY_COOKED = rIB(ModBlocks.TURKEY_COOKED);
    public static final RegistryObject<BlockItem> TRILLIUM = rIB(ModBlocks.TRILLIUM);

    private static RegistryObject<Item> r(String name) {
        return ITEMS.register(name, () -> new Item(new Item.Properties().group(BetterAnimalsPlusMod.group)));
    }

    private static RegistryObject<Item> rH(String name) {
        return ITEMS.register(name, () -> new Item(new Item.Properties()));
    }

    private static <T extends Item> RegistryObject<T> r(String name, Supplier<T> b) {
        return ITEMS.register(name, b);
    }

    private static <T extends Item> RegistryObject<T> varArg(String nameBase, String nameExt, Function<String, T> b) {
        return ITEMS.register(nameBase + nameExt, () -> b.apply(nameExt));
    }

    private static RegistryObject<BlockItem> rIB(RegistryObject<? extends Block> parent) {
        return ITEMS.register(parent.getId().getPath(), () -> new BlockItem(parent.get(), new Item.Properties().group(BetterAnimalsPlusMod.group)));
    }

    public static void subscribe(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }

    public static Collection<RegistryObject<Item>> getItems() {
        return ITEMS.getEntries();
    }
}
