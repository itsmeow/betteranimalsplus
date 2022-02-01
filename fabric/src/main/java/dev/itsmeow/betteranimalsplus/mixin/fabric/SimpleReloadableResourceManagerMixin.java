package dev.itsmeow.betteranimalsplus.mixin.fabric;

import dev.itsmeow.betteranimalsplus.Ref;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ReloadableResourceManager;
import net.minecraft.server.packs.resources.SimpleReloadableResourceManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

@Mixin(SimpleReloadableResourceManager.class)
public abstract class SimpleReloadableResourceManagerMixin implements ReloadableResourceManager {

    @Inject(method = "listResources(Ljava/lang/String;Ljava/util/function/Predicate;)Ljava/util/Collection;", at = @At("RETURN"), locals = LocalCapture.CAPTURE_FAILSOFT)
    private void listResources(String parent, Predicate<String> loadFilter, CallbackInfoReturnable<Collection<ResourceLocation>> callback, Set<ResourceLocation> foundResources, List<ResourceLocation> sortedResources) {
        for (ResourceLocation id : new ArrayList<>(sortedResources)) {
            if(Ref.MOD_ID.equals(id.getNamespace())) {
                if(("advancements/ultimate_succening.json".equals(id.getPath()) && !FabricLoader.getInstance().isModLoaded("whisperwoods")) || (id.getPath().startsWith("trinkets") && !FabricLoader.getInstance().isModLoaded("trinkets"))) {
                    sortedResources.remove(id);
                }
            }
        }
    }

}
