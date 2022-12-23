package dev.itsmeow.betteranimalsplus.init;

import dev.architectury.registry.level.biome.BiomeModifications;
import dev.itsmeow.betteranimalsplus.Ref;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.function.Consumer;

public class ModWorldGen {

    public static final ResourceKey<PlacedFeature> TRILLIUM = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Ref.MOD_ID, "trillium"));
    public static final ResourceKey<PlacedFeature> TRILLIUM_DENSE = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Ref.MOD_ID, "trillium_dense"));

    public static void init(Consumer<Runnable> enqueue) {
        BiomeModifications.addProperties(
                ctx -> isSwamp(ctx) && !isDenseSwamp(ctx),
                (ctx, mutable) -> mutable.getGenerationProperties().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TRILLIUM)
        );
        BiomeModifications.addProperties(
                ctx -> isSwamp(ctx) && isDenseSwamp(ctx),
                (ctx, mutable) -> mutable.getGenerationProperties().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TRILLIUM_DENSE)
        );
    }

    private static boolean isSwamp(BiomeModifications.BiomeContext ctx) {
        return ctx.getKey().get().getPath().contains("swamp") || ctx.hasTag(key("c", "swamp")) || ctx.hasTag(key("forge", "is_swamp")) || ctx.hasTag(key(ctx.getKey().get().getNamespace(), "is_swamp"));
    }

    private static boolean isDenseSwamp(BiomeModifications.BiomeContext ctx) {
        return "mangrove_swamp".equals(ctx.getKey().get().getPath()) || ctx.hasTag(key("c", "vegetation_dense")) || ctx.hasTag(key("forge", "is_dense")) || ctx.hasTag(key(ctx.getKey().get().getNamespace(), "is_dense"));
    }

    private static TagKey<Biome> key(String space, String key) {
        return TagKey.create(Registries.BIOME, new ResourceLocation(space, key));
    }
}
