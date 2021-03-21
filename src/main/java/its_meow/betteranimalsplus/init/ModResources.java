package its_meow.betteranimalsplus.init;

import its_meow.betteranimalsplus.Ref;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

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
            public static final BlockTags.Wrapper BUTTERFLY_GROWABLES = new BlockTags.Wrapper(new ResourceLocation(Ref.MOD_ID, "butterfly_growables"));
        }
        public static final class Items {
            public static final ItemTags.Wrapper PELTS = new ItemTags.Wrapper(new ResourceLocation(Ref.MOD_ID, "pelts"));
            public static final ItemTags.Wrapper FERAL_WOLF_TAME_ARMOR = new ItemTags.Wrapper(new ResourceLocation(Ref.MOD_ID, "feral_wolf_tame_armor"));
        }
    }

    private static ResourceLocation t(String tex) {
        return new ResourceLocation(Ref.MOD_ID, "textures/entity/" + tex + ".png");
    }
}
