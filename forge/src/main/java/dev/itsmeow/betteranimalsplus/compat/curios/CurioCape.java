package dev.itsmeow.betteranimalsplus.compat.curios;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.common.item.ItemCape;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.ICurioRenderer;
import top.theillusivec4.curios.api.type.capability.ICurio;

import java.util.HashMap;
import java.util.Map;

public record CurioCape(ItemStack stack) implements ICurio {

    @Override
    public ItemStack getStack() {
        return stack;
    }

    @Override
    public boolean canEquip(SlotContext context) {
        ItemStack chest = context.entity().getItemBySlot(EquipmentSlot.CHEST);
        return (chest.isEmpty() || !(chest.getItem() instanceof ItemCape)) && !CuriosApi.getCuriosHelper().findEquippedCurio(stack -> stack.getItem() instanceof ItemCape, context.entity()).isPresent();
    }

    @OnlyIn(Dist.CLIENT)
    public static class Renderer implements ICurioRenderer {

        protected static final Map<String, HumanoidModel<LivingEntity>> models = new HashMap<>();
        private String modelKey;

        public Renderer(String modelKey) {
            this.modelKey = modelKey;
        }

        @Override
        public <T extends LivingEntity, M extends EntityModel<T>> void render(ItemStack stack, SlotContext slotContext, PoseStack matrixStack, RenderLayerParent<T, M> renderLayerParent, MultiBufferSource renderTypeBuffer, int light, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
            if (stack.getItem() instanceof ArmorItem) {
                HumanoidModel<LivingEntity> model;
                if (!models.containsKey(modelKey)) {
                    model = stack.getItem().getArmorModel(slotContext.entity(), stack, EquipmentSlot.CHEST, null);
                    models.put(modelKey, model);
                } else {
                    model = models.get(modelKey);
                }
                ICurioRenderer.translateIfSneaking(matrixStack, slotContext.entity());
                ICurioRenderer.rotateIfSneaking(matrixStack, slotContext.entity());
                ICurioRenderer.followBodyRotations(slotContext.entity(), model);
                String texture = ((ArmorItem) stack.getItem()).getMaterial().getName();
                String domain = "minecraft";
                int idx = texture.indexOf(':');
                if (idx != -1) {
                    domain = texture.substring(0, idx);
                    texture = texture.substring(idx + 1);
                }
                String tex = String.format("%s:textures/models/armor/%s_layer_%d.png", domain, texture, 1);
                VertexConsumer ivertexbuilder = renderTypeBuffer.getBuffer(RenderType.entityTranslucent(new ResourceLocation(tex)));
                model.setupAnim(slotContext.entity(), limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
                model.renderToBuffer(matrixStack, ivertexbuilder, light, LivingEntityRenderer.getOverlayCoords(slotContext.entity(), 0.0F), 1F, 1F, 1F, 1F);
            }
        }
    }
}
