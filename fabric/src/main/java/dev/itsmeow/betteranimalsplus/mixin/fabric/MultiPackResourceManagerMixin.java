package dev.itsmeow.betteranimalsplus.mixin.fabric;

import net.minecraft.server.packs.resources.MultiPackResourceManager;
import net.minecraft.server.packs.resources.ResourceManager;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(MultiPackResourceManager.class)
public abstract class MultiPackResourceManagerMixin implements ResourceManager {

    /*@Inject(method = "listResources(Ljava/lang/String;Ljava/util/function/Predicate;)Ljava/util/Map;", at = @At("RETURN"), locals = LocalCapture.CAPTURE_FAILSOFT)
    private void listResources(String parent, Predicate<String> loadFilter, CallbackInfoReturnable<Collection<ResourceLocation>> callback, Set<ResourceLocation> foundResources, List<ResourceLocation> sortedResources) {
        for (ResourceLocation id : new ArrayList<>(sortedResources)) {
            if(Ref.MOD_ID.equals(id.getNamespace())) {
                if(("advancements/ultimate_succening.json".equals(id.getPath()) && !FabricLoader.getInstance().isModLoaded("whisperwoods")) || (id.getPath().startsWith("trinkets") && !FabricLoader.getInstance().isModLoaded("trinkets"))) {
                    sortedResources.remove(id);
                }
            }
        }
    }*/

}
