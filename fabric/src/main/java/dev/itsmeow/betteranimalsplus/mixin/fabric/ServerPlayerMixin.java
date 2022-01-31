package dev.itsmeow.betteranimalsplus.mixin.fabric;

import dev.architectury.utils.NbtType;
import dev.itsmeow.betteranimalsplus.Ref;
import dev.itsmeow.betteranimalsplus.util.ISquirrelData;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Function;

@Mixin(ServerPlayer.class)
public class ServerPlayerMixin implements ISquirrelData {

    @Unique
    private int betteranimalsplus_squirrelKills;

    @Inject(at = @At("RETURN"), method = "readAdditionalSaveData(Lnet/minecraft/nbt/CompoundTag;)V")
    public void readAdditionalSaveData(CompoundTag tag, CallbackInfo c) {
        CompoundTag data = tag.getCompound(Ref.MOD_ID);
        if(data.contains("squirrel_kills", NbtType.INT)) {
            betteranimalsplus_squirrelKills = data.getInt("squirrel_kills");
        }
    }

    @Inject(at = @At("RETURN"), method = "addAdditionalSaveData(Lnet/minecraft/nbt/CompoundTag;)V")
    public void addAdditionalSaveData(CompoundTag tag, CallbackInfo c) {
        CompoundTag data = tag.getCompound(Ref.MOD_ID);
        data.putInt("squirrel_kills", betteranimalsplus_squirrelKills);
        tag.put(Ref.MOD_ID, data);
    }

    @Inject(at = @At("RETURN"), method = "restoreFrom(Lnet/minecraft/server/level/ServerPlayer;Z)V")
    public void restoreFrom(ServerPlayer serverPlayer, boolean bl, CallbackInfo c) {
        ServerPlayerMixin playerMixin = (ServerPlayerMixin) (Object) serverPlayer;
        betteranimalsplus_squirrelKills = playerMixin.betteranimalsplus_squirrelKills;
    }

    @Override
    public void setSquirrelKills(int kills) {
        this.betteranimalsplus_squirrelKills = kills;
    }

    @Override
    public void setSquirrelKills(Function<Integer, Integer> mutator) {
        this.betteranimalsplus_squirrelKills = mutator.apply(this.betteranimalsplus_squirrelKills);
    }

    @Override
    public int getSquirrelKills() {
        return this.betteranimalsplus_squirrelKills;
    }
}
