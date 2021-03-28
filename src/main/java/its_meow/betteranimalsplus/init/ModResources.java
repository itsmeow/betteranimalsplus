package its_meow.betteranimalsplus.init;

import its_meow.betteranimalsplus.Ref;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags.IOptionalNamedTag;

public class ModResources {
    public static final ResourceLocation wolf_eyes = t("feralwolf_eyes");

    public static final ResourceLocation coyote_eyes = t("coyote_hostile_eyes");

    public static final ResourceLocation trillium_base = t("flora/trillium_base");
    public static final ResourceLocation trillium_purple = t("flora/trillium_purple");
    public static final ResourceLocation trillium_yellow = t("flora/trillium_yellow");

    public static final ResourceLocation tarantula_hair = t("projectile/tarantula_hair");

    public static final ResourceLocation tarantula_eyes = t("tarantula_eyes");

    public static final class Tags {
        public static final class Blocks {
            public static final IOptionalNamedTag<Block> BUTTERFLY_GROWABLES = tag("butterfly_growables");

            public static void loadTags() {
                // This is a classloading dummy.
            }

            private static IOptionalNamedTag<Block> tag(String name) {
                return BlockTags.createOptional(new ResourceLocation(Ref.MOD_ID, name));
            }
        }
        public static final class Items {
            public static final IOptionalNamedTag<Item> PELTS = tag("pelts");
            public static final IOptionalNamedTag<Item> FERAL_WOLF_TAME_ARMOR = tag("feral_wolf_tame_armor");

            public static void loadTags() {
                // This is a classloading dummy.
            }

            private static IOptionalNamedTag<Item> tag(String name) {
                return ItemTags.createOptional(new ResourceLocation(Ref.MOD_ID, name));
            }
        }
    }

    private static ResourceLocation t(String tex) {
        return new ResourceLocation(Ref.MOD_ID, "textures/entity/" + tex + ".png");
    }
}
