package dev.itsmeow.betteranimalsplus.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import dev.emi.trinkets.api.Trinket;
import dev.emi.trinkets.api.TrinketsApi;
import dev.itsmeow.betteranimalsplus.Ref;
import dev.itsmeow.betteranimalsplus.common.item.ItemCape;
import dev.itsmeow.betteranimalsplus.common.item.ItemModeledArmor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ItemCape.class)
public abstract class ItemCapeClientMixin extends ItemModeledArmor implements Trinket {

    protected HumanoidModel<LivingEntity> model = null;

    public ItemCapeClientMixin(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
        super(material, slot, properties);
    }

    @Override
    public void render(String slot, PoseStack matrixStack, MultiBufferSource multiBufferSource, int light, PlayerModel<AbstractClientPlayer> model2, AbstractClientPlayer player, float headYaw, float headPitch) {
        if (model == null) {
            model = this.getArmorModel(player, TrinketsApi.getTrinketComponent(player).getStack(slot), EquipmentSlot.CHEST, null);
        }
        if (player.isCrouching()) {
            matrixStack.translate(0.0F, 0.2F, 0.0F);
            matrixStack.mulPose(Vector3f.XP.rotationDegrees(90.0F / (float) Math.PI));
        }
        EntityRenderer<? super LivingEntity> render = Minecraft.getInstance().getEntityRenderDispatcher().getRenderer(player);
        if (render instanceof LivingEntityRenderer) {
            EntityModel<LivingEntity> entityModel = ((LivingEntityRenderer<LivingEntity, EntityModel<LivingEntity>>) render).getModel();
            if (entityModel instanceof HumanoidModel) {
                HumanoidModel<LivingEntity> bipedModel = (HumanoidModel<LivingEntity>) entityModel;
                bipedModel.copyPropertiesTo(model);
            }
        }
        String texture = this.getMaterial().getName();
        String tex = String.format("%s:textures/models/armor/%s_layer_%d.png", Ref.MOD_ID, texture, 1);
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(RenderType.entityTranslucent(new ResourceLocation(tex)));
        model.setupAnim(player, 0F, 0F, player.tickCount, headYaw, headPitch);
        model.renderToBuffer(matrixStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(player, 0.0F), 1F, 1F, 1F, 1F);
    }

}
