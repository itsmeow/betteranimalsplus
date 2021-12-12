package dev.itsmeow.betteranimalsplus.compat.curios;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.common.item.ItemCape;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.type.capability.ICurio;

import java.util.HashMap;
import java.util.Map;

public class CurioCape implements ICurio {

    protected static final Map<String, HumanoidModel<LivingEntity>> models = new HashMap<>();
    protected final ItemStack stack;
    protected final String modelKey;

    public CurioCape(String modelKey, ItemStack stack) {
        this.stack = stack;
        this.modelKey = modelKey;
    }

    @Override
    public boolean canEquip(String identifier, LivingEntity livingEntity) {
        ItemStack chest = livingEntity.getItemBySlot(EquipmentSlot.CHEST);
        return (chest.isEmpty() || !(chest.getItem() instanceof ItemCape)) && !CuriosApi.getCuriosHelper().findEquippedCurio(stack -> stack.getItem() instanceof ItemCape, livingEntity).isPresent();
    }

    @Override
    public boolean canRender(String identifier, int index, LivingEntity livingEntity) {
        return true;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void render(String identifier, int index, PoseStack matrixStack, MultiBufferSource renderTypeBuffer, int light, LivingEntity livingEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if(stack.getItem() instanceof ArmorItem) {
            HumanoidModel<LivingEntity> model;
            if(!models.containsKey(modelKey)) {
                model = stack.getItem().getArmorModel(livingEntity, stack, EquipmentSlot.CHEST, null);
                models.put(modelKey, model);
            } else {
                model = models.get(modelKey);
            }
            ICurio.RenderHelper.translateIfSneaking(matrixStack, livingEntity);
            ICurio.RenderHelper.rotateIfSneaking(matrixStack, livingEntity);
            ICurio.RenderHelper.followBodyRotations(livingEntity, model);
            String texture = ((ArmorItem) stack.getItem()).getMaterial().getName();
            String domain = "minecraft";
            int idx = texture.indexOf(':');
            if (idx != -1)
            {
                domain = texture.substring(0, idx);
                texture = texture.substring(idx + 1);
            }
            String tex = String.format("%s:textures/models/armor/%s_layer_%d.png", domain, texture, 1);
            VertexConsumer ivertexbuilder = renderTypeBuffer.getBuffer(RenderType.entityTranslucent(new ResourceLocation(tex)));
            model.setupAnim(livingEntity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            model.renderToBuffer(matrixStack, ivertexbuilder, light, LivingEntityRenderer.getOverlayCoords(livingEntity, 0.0F), 1F, 1F, 1F, 1F);
        }
    }

}
