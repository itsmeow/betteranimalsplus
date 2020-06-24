package its_meow.betteranimalsplus.init;

import its_meow.betteranimalsplus.Ref;
import net.minecraft.util.ResourceLocation;

public class ModTextures {
    // Feral Wolf
    public static final ResourceLocation wolf_eyes = t("feralwolf_eyes");

    // Coyote
    public static final ResourceLocation coyote_eyes = t("coyote_hostile_eyes");

    // Trillium Variants
    public static final ResourceLocation trillium_base = t("flora/trillium_base");
    public static final ResourceLocation trillium_purple = t("flora/trillium_purple");
    public static final ResourceLocation trillium_yellow = t("flora/trillium_yellow");

    // Tarantula Hair
    public static final ResourceLocation tarantula_hair = t("projectile/tarantula_hair");

    // Tarantula Eyes
    public static final ResourceLocation tarantula_eyes = t("tarantula_eyes");

    // Hirschgeist
    public static final ResourceLocation hirschgeist = t("hirschgeist");

    // Hand Of Fate
    public static final ResourceLocation handoffate = new ResourceLocation(Ref.MOD_ID + ":textures/blocks/handoffate.png");

    // Zotzpyre
    public static final ResourceLocation zotzpyre_eyes = t("zotzpyre_eyes");

    private static ResourceLocation t(String tex) {
        return new ResourceLocation(Ref.MOD_ID, "textures/entity/" + tex + ".png");
    }
}
