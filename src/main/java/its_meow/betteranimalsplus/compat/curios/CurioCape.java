package its_meow.betteranimalsplus.compat.curios;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import its_meow.betteranimalsplus.common.item.ItemCape;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.type.capability.ICurio;

import java.util.HashMap;
import java.util.Map;

public class CurioCape implements ICurio {

    protected static final Map<String, BipedModel<LivingEntity>> models = new HashMap<>();
    protected final ItemStack stack;
    protected final String modelKey;

    public CurioCape(String modelKey, ItemStack stack) {
        this.stack = stack;
        this.modelKey = modelKey;
    }

    @Override
    public boolean canEquip(String identifier, LivingEntity livingEntity) {
        ItemStack chest = livingEntity.getItemStackFromSlot(EquipmentSlotType.CHEST);
        return chest.isEmpty() || (!(chest.getItem() instanceof ItemCape) && !CuriosApi.getCuriosHelper().findEquippedCurio(stack -> stack.getItem() instanceof ItemCape, livingEntity).isPresent());
    }

    @Override
    public boolean canRender(String identifier, int index, LivingEntity livingEntity) {
        return true;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void render(String identifier, int index, MatrixStack matrixStack, IRenderTypeBuffer renderTypeBuffer, int light, LivingEntity livingEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if(stack.getItem() instanceof ArmorItem) {
            BipedModel<LivingEntity> model;
            if(!models.containsKey(modelKey)) {
                model = stack.getItem().getArmorModel(livingEntity, stack, EquipmentSlotType.CHEST, null);
                models.put(modelKey, model);
            } else {
                model = models.get(modelKey);
            }
            ICurio.RenderHelper.translateIfSneaking(matrixStack, livingEntity);
            ICurio.RenderHelper.rotateIfSneaking(matrixStack, livingEntity);
            ICurio.RenderHelper.followBodyRotations(livingEntity, model);
            String texture = ((ArmorItem) stack.getItem()).getArmorMaterial().getName();
            String domain = "minecraft";
            int idx = texture.indexOf(':');
            if (idx != -1)
            {
                domain = texture.substring(0, idx);
                texture = texture.substring(idx + 1);
            }
            String tex = String.format("%s:textures/models/armor/%s_layer_%d.png", domain, texture, 1);
            IVertexBuilder ivertexbuilder = renderTypeBuffer.getBuffer(RenderType.getEntityTranslucent(new ResourceLocation(tex)));
            model.setRotationAngles(livingEntity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            model.render(matrixStack, ivertexbuilder, light, LivingRenderer.getPackedOverlay(livingEntity, 0.0F), 1F, 1F, 1F, 1F);
        }
    }

}
