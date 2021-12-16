package dev.itsmeow.betteranimalsplus.init;

import dev.architectury.hooks.tags.TagHooks;
import dev.itsmeow.betteranimalsplus.Ref;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModResources {
    public static final ResourceLocation wolf_eyes = t("feralwolf_eyes");

    public static final ResourceLocation coyote_eyes = t("coyote_hostile_eyes");

    public static final ResourceLocation trillium_base = t("flora/trillium_base");
    public static final ResourceLocation trillium_purple = t("flora/trillium_purple");
    public static final ResourceLocation trillium_yellow = t("flora/trillium_yellow");

    public static final ResourceLocation tarantula_hair = t("projectile/tarantula_hair");

    public static final ResourceLocation tarantula_eyes = t("tarantula_eyes");

    public static final ResourceLocation reindeer_christmas_glow = t("reindeer_christmas_glow");

    private static ResourceLocation t(String tex) {
        return new ResourceLocation(Ref.MOD_ID, "textures/entity/" + tex + ".png");
    }

    public static final class Tags {
        public static final class Blocks {
            public static final Tag.Named<Block> BUTTERFLY_GROWABLES = tag("butterfly_growables");

            public static void loadTags() {
                // This is a classloading dummy.
            }

            private static Tag.Named<Block> tag(String name) {
                return TagHooks.optionalBlock(new ResourceLocation(Ref.MOD_ID, name));
            }
        }

        public static final class Items {
            public static final Tag.Named<Item> PELTS = tag("pelts");
            public static final Tag.Named<Item> FERAL_WOLF_TAME_ARMOR = tag("feral_wolf_tame_armor");

            public static void loadTags() {
                // This is a classloading dummy.
            }

            private static Tag.Named<Item> tag(String name) {
                return TagHooks.optionalItem(new ResourceLocation(Ref.MOD_ID, name));
            }
        }
    }
}
