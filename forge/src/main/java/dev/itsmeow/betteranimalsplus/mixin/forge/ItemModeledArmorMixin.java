package dev.itsmeow.betteranimalsplus.mixin.forge;

import dev.itsmeow.betteranimalsplus.common.item.ItemModeledArmor;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.function.Consumer;

@Mixin(ItemModeledArmor.class)
public abstract class ItemModeledArmorMixin extends ArmorItem {

    public ItemModeledArmorMixin(ArmorMaterial arg, EquipmentSlot arg2, Properties arg3) {
        super(arg, arg2, arg3);
    }

    @Shadow(remap = false)
    public abstract <T extends LivingEntity, A extends HumanoidModel<T>> A getArmorModel(T entityLiving, ItemStack itemStack, EquipmentSlot armorSlot, A defaultModel);

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            @Override
            public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                return ItemModeledArmorMixin.this.getArmorModel(livingEntity, itemStack, equipmentSlot, (HumanoidModel<? super LivingEntity>) original);
            }
        });
    }

}
