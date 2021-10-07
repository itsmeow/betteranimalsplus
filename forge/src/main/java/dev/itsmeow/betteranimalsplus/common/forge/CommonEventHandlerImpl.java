package dev.itsmeow.betteranimalsplus.common.forge;

import dev.itsmeow.betteranimalsplus.Ref;
import dev.itsmeow.betteranimalsplus.common.CommonEventHandler;
import me.shedaniel.architectury.utils.NbtType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.storage.loot.ConstantIntValue;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.LootTableLoadEvent;

import java.util.function.Function;

public class CommonEventHandlerImpl {

    public static void registerPlatformEvents() {
        MinecraftForge.EVENT_BUS.addListener(CommonEventHandlerImpl::lootLoad);
    }

    public static void lootLoad(LootTableLoadEvent event) {
        for (ResourceLocation rl : CommonEventHandler.LOOT_TABLE_INJECTIONS.keys()) {
            if (event.getName().equals(rl)) {
                for (ResourceLocation ref : CommonEventHandler.LOOT_TABLE_INJECTIONS.get(rl)) {
                    event.getTable().addPool(LootPool.lootPool().setRolls(ConstantIntValue.exactly(1)).add(LootTableReference.lootTableReference(ref)).build());
                }
                break;
            }
        }
    }

    public static void setSquirrelKills(Player player, int kills) {
        CompoundTag pTag = player.getPersistentData();
        if (!pTag.contains(Ref.MOD_ID, NbtType.COMPOUND)) {
            pTag.put(Ref.MOD_ID, new CompoundTag());
        }
        CompoundTag bTag = pTag.getCompound("betteranimalsplus");
        bTag.putInt("squirrel_kills", kills);
    }

    public static void setSquirrelKills(Player player, Function<Integer, Integer> mutator) {
        CompoundTag pTag = player.getPersistentData();
        if (!pTag.contains(Ref.MOD_ID, NbtType.COMPOUND)) {
            pTag.put(Ref.MOD_ID, new CompoundTag());
        }
        CompoundTag bTag = pTag.getCompound("betteranimalsplus");
        bTag.putInt("squirrel_kills", mutator.apply(bTag.contains("squirrel_kills", NbtType.INT) ? bTag.getInt("squirrel_kills") : 0));
    }

    public static int getSquirrelKills(Player player) {
        if (player.getPersistentData().contains(Ref.MOD_ID, NbtType.COMPOUND) && player.getPersistentData().getCompound(Ref.MOD_ID).contains("squirrel_kills", NbtType.INT)) {
            return player.getPersistentData().getCompound(Ref.MOD_ID).getInt("squirrel_kills");
        }
        return 0;
    }

}
