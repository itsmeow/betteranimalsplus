package dev.itsmeow.betteranimalsplus.util;

import dev.onyxstudios.cca.api.v3.entity.PlayerComponent;
import net.minecraft.nbt.CompoundTag;

import java.util.function.Function;

public class SquirrelKillsComponent implements PlayerComponent<SquirrelKillsComponent> {
    private int kills = 0;

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public void setKills(Function<Integer, Integer> mutator) {
        this.kills = mutator.apply(this.kills);
    }

    @Override
    public void readFromNbt(CompoundTag tag) {
        this.kills = tag.getInt("kills");
    }

    @Override
    public void writeToNbt(CompoundTag tag) {
        tag.putInt("kills", kills);
    }
}
