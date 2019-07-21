package its_meow.betteranimalsplus.common.item;

import baubles.api.BaubleType;
import baubles.api.BaublesApi;
import baubles.api.IBauble;
import baubles.api.render.IRenderBauble;
import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.client.model.ModelBearCape;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBearCapeBaubles extends ItemBearCape implements IBauble, IRenderBauble {

    public ItemBearCapeBaubles(String variant, Item repairItem) {
        super(variant, repairItem);
    }
    
    @Override
    public BaubleType getBaubleType(ItemStack itemstack) {
        return BaubleType.BODY;
    }

    @Override
    public boolean isValidArmor(ItemStack stack, EntityEquipmentSlot armorType, Entity entity) {
        if(entity instanceof EntityPlayer) {
            return !(BaublesApi.getBaublesHandler((EntityPlayer) entity).getStackInSlot(BaubleType.BODY.ordinal()).getItem() instanceof ItemCape);
        }
        return super.isValidArmor(stack, armorType, entity);
    }

    @Override
    public boolean canEquip(ItemStack itemstack, EntityLivingBase player) {
        return !(player.getItemStackFromSlot(this.slot).getItem() instanceof ItemCape);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void onPlayerBaubleRender(ItemStack stack, EntityPlayer living, RenderType type, float partialTicks) {
        if(type == RenderType.BODY) {
            TextureManager texturemanager = Minecraft.getMinecraft().getRenderManager().renderEngine;
            if(texturemanager != null) {
                texturemanager.bindTexture(getTexture(variant));
            }
            ModelBiped model = ModelBearCape.INSTANCE_BAUBLE;
            this.displays(model, slot);

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

    private static final ResourceLocation BEAR_CAPE_BROWN = new ResourceLocation(Ref.MOD_ID, "textures/models/armor/bear_cape_brown_layer_1.png");
    private static final ResourceLocation BEAR_CAPE_BLACK = new ResourceLocation(Ref.MOD_ID, "textures/models/armor/bear_cape_black_layer_1.png");
    private static final ResourceLocation BEAR_CAPE_KERMODE = new ResourceLocation(Ref.MOD_ID, "textures/models/armor/bear_cape_kermode_layer_1.png");

    private static ResourceLocation getTexture(String variant) {
        switch(variant) {
        case "brown": return BEAR_CAPE_BROWN;
        case "black": return BEAR_CAPE_BLACK;
        case "kermode": return BEAR_CAPE_KERMODE;
        default: return BEAR_CAPE_BROWN;
        }
    }

}
