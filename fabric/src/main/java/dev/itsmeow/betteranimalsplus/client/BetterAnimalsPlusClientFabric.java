package dev.itsmeow.betteranimalsplus.client;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.itsmeow.betteranimalsplus.Ref;
import dev.itsmeow.betteranimalsplus.common.item.ItemModeledArmor;
import dev.itsmeow.betteranimalsplus.init.ModItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.item.ItemStack;

public class BetterAnimalsPlusClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientLifecycleHandler.clientInit();
        ModItems.getModeledArmor().values().forEach(registrySupplier -> {
            ItemModeledArmor armor = registrySupplier.get();
            ResourceLocation tex =  new ResourceLocation(Ref.MOD_ID, armor.getMaterial().getName());
            ArmorRenderer.register((PoseStack matrices, MultiBufferSource vertexConsumers, ItemStack stack, LivingEntity entity, EquipmentSlot slot, int light, HumanoidModel<LivingEntity> defaultModel) -> {
                HumanoidModel<LivingEntity> model = armor.getArmorModel(entity, stack, slot, defaultModel);
                if(!Minecraft.getInstance().isPaused()) {
                    float g = Minecraft.getInstance().getFrameTime();
                    float h = Mth.rotLerp(g, entity.yBodyRotO, entity.yBodyRot);
                    float j = Mth.rotLerp(g, entity.yHeadRotO, entity.yHeadRot);
                    float k = j - h;
                    float o;
                    if (entity.isPassenger() && entity.getVehicle() instanceof LivingEntity) {
                        LivingEntity livingEntity2 = (LivingEntity) entity.getVehicle();
                        h = Mth.rotLerp(g, livingEntity2.yBodyRotO, livingEntity2.yBodyRot);
                        k = j - h;
                        o = Mth.wrapDegrees(k);
                        if (o < -85.0F) {
                            o = -85.0F;
                        }

                        if (o >= 85.0F) {
                            o = 85.0F;
                        }

                        h = j - o;
                        if (o * o > 2500.0F) {
                            h += o * 0.2F;
                        }

                        k = j - h;
                    }

                    float m = Mth.lerp(g, entity.xRotO, entity.getXRot());
                    float p;
                    if (entity.getPose() == Pose.SLEEPING) {
                        Direction direction = entity.getBedOrientation();
                        if (direction != null) {
                            p = entity.getEyeHeight(Pose.STANDING) - 0.1F;
                        }
                    }

                    o = (float) entity.tickCount + g;
                    p = 0.0F;
                    float q = 0.0F;
                    if (!entity.isPassenger() && entity.isAlive()) {
                        p = Mth.lerp(g, entity.animationSpeedOld, entity.animationSpeed);
                        q = entity.animationPosition - entity.animationSpeed * (1.0F - g);
                        if (entity.isBaby()) {
                            q *= 3.0F;
                        }

                        if (p > 1.0F) {
                            p = 1.0F;
                        }
                    }
                    model.setupAnim(entity, q, p, o, k, m);
                }
                model.renderToBuffer(matrices, vertexConsumers.getBuffer(RenderType.entityCutoutNoCull(tex)), light, LivingEntityRenderer.getOverlayCoords(entity, 0.0F), 1F, 1F, 1F, 1F);
            }, armor);
        });
    }
}
