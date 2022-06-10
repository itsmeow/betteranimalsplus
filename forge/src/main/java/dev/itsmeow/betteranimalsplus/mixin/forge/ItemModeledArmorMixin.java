package dev.itsmeow.betteranimalsplus.mixin.forge;

import dev.itsmeow.betteranimalsplus.common.item.ItemModeledArmor;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.IItemRenderProperties;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ItemModeledArmor.class)
public abstract class ItemModeledArmorMixin extends ArmorItem {

    public ItemModeledArmorMixin(ArmorMaterial arg, EquipmentSlot arg2, Properties arg3) {
        super(arg, arg2, arg3);
    }

    @Shadow(remap = false)
    public abstract <T extends LivingEntity, A extends HumanoidModel<T>> A getArmorModel(T entityLiving, ItemStack itemStack, EquipmentSlot armorSlot, A defaultModel);

    @Override
    public void initializeClient(java.util.function.Consumer<net.minecraftforge.client.IItemRenderProperties> consumer) {
        consumer.accept(new IItemRenderProperties() {
            @Override
            public HumanoidModel<?> getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlot armorSlot, HumanoidModel<?> defaultModel) {
                return ItemModeledArmorMixin.this.getArmorModel(entityLiving, itemStack, armorSlot, (HumanoidModel<? super LivingEntity>) defaultModel);
            }
        });
    }

}
