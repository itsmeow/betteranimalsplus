package its_meow.betteranimalsplus.common.item;

import baubles.api.BaubleType;
import baubles.api.BaublesApi;
import baubles.api.IBauble;
import baubles.api.render.IRenderBauble;
import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.client.model.ModelWolfCape;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemWolfCapeBaubles extends ItemWolfCape implements IBauble, IRenderBauble {

    public ItemWolfCapeBaubles(int variant) {
        super(variant);
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemstack) {
        return BaubleType.BODY;
    }

    @Override
    public boolean isValidArmor(ItemStack stack, EntityEquipmentSlot armorType, Entity entity) {
        if(entity instanceof EntityPlayer) {
            return !(BaublesApi.getBaublesHandler((EntityPlayer) entity).getStackInSlot(BaubleType.BODY.ordinal()).getItem() instanceof ItemWolfCape);
        }
        return super.isValidArmor(stack, armorType, entity);
    }

    @Override
    public boolean canEquip(ItemStack itemstack, EntityLivingBase player) {
        return !(player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() instanceof ItemWolfCape);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void onPlayerBaubleRender(ItemStack stack, EntityPlayer living, RenderType type, float partialTicks) {
        if(type == RenderType.BODY) {
            TextureManager texturemanager = Minecraft.getMinecraft().getRenderManager().renderEngine;
            if(texturemanager != null) {
                texturemanager.bindTexture(getTexture(variant));
            }
            ModelBiped model = ModelWolfCape.INSTANCE_BAUBLE;
            model.bipedHead.showModel = false;
            model.bipedHeadwear.showModel = false;
            model.bipedBody.showModel = true;
            model.bipedRightArm.showModel = false;
            model.bipedLeftArm.showModel = false;
            model.bipedRightLeg.showModel = false;
            model.bipedLeftLeg.showModel = false;

            model.isSneak = living.isSneaking();
            model.isRiding = living.isRiding();
            model.isChild = living.isChild();

            GlStateManager.pushMatrix();
            {
                GlStateManager.rotate(180, 1, 0, 0);
                if(model.isSneak) {
                    GlStateManager.translate(0, -0.2, 0);
                }
                GlStateManager.scale(0.12, 0.12, 0.12);
                Helper.translateToChest();
                Helper.defaultTransforms();
                model.render(living, living.limbSwing, living.limbSwingAmount, living.ticksExisted, living.prevRotationYaw, living.rotationPitch, 1);
            }
            GlStateManager.popMatrix();
        }
    }

    private static final ResourceLocation WOLF_CAPE_1 = new ResourceLocation(Ref.MOD_ID, "textures/models/armor/wolfcape1_layer_1.png");
    private static final ResourceLocation WOLF_CAPE_2 = new ResourceLocation(Ref.MOD_ID, "textures/models/armor/wolfcape2_layer_1.png");
    private static final ResourceLocation WOLF_CAPE_3 = new ResourceLocation(Ref.MOD_ID, "textures/models/armor/wolfcape3_layer_1.png");

    private static ResourceLocation getTexture(int variant) {
        switch(variant) {
        case 1: return WOLF_CAPE_1;
        case 2: return WOLF_CAPE_2;
        case 3: return WOLF_CAPE_3;
        default: return WOLF_CAPE_1;
        }
    }

}
