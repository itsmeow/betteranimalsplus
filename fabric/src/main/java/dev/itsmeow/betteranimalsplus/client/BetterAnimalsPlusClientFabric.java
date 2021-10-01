package dev.itsmeow.betteranimalsplus.client;

import dev.itsmeow.betteranimalsplus.Ref;
import dev.itsmeow.betteranimalsplus.common.item.ItemModeledArmor;
import dev.itsmeow.betteranimalsplus.init.ModItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderingRegistry;
import net.minecraft.resources.ResourceLocation;

public class BetterAnimalsPlusClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientLifecycleHandler.clientInit();
        ModItems.getModeledArmor().values().forEach(registrySupplier -> {
            ItemModeledArmor armor = registrySupplier.get();
            ArmorRenderingRegistry.registerModel(armor::getArmorModel, armor);
            ArmorRenderingRegistry.registerSimpleTexture(new ResourceLocation(Ref.MOD_ID, armor.getMaterial().getName()), armor);
        });
    }
}
