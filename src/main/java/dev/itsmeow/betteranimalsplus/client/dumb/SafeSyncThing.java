package dev.itsmeow.betteranimalsplus.client.dumb;

import dev.itsmeow.betteranimalsplus.BetterAnimalsPlusMod;
import dev.itsmeow.betteranimalsplus.network.StupidDevPacket;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SafeSyncThing {
    private static final Map<UUID, DumbOptions> CLIENT_ENABLED_MAP = new HashMap<>();

    public static void put(UUID uuid, StupidDevPacket val) {
        put(uuid, new DumbOptions(val));
    }

    public static void put(UUID uuid, DumbOptions val) {
        if(BetterAnimalsPlusMod.isDev(uuid)) {
            CLIENT_ENABLED_MAP.put(uuid, val);
        }
    }

    public static DumbOptions get(UUID uuid) {
        return CLIENT_ENABLED_MAP.getOrDefault(uuid, DumbOptions.OFF);
    }

    public static void clear() {
        CLIENT_ENABLED_MAP.clear();
    }
    
    public static class DumbOptions {
        public static final DumbOptions OFF = new DumbOptions(false, false, "");
        public final boolean on;
        public final boolean nametag;
        public final String variant;

        public DumbOptions(StupidDevPacket pkt) {
            this(pkt.on, pkt.nametag, pkt.variant);
        }
        private DumbOptions(boolean on, boolean nametag, String variant) {
            this.on = on;
            this.nametag = nametag;
            this.variant = variant;
        }
    }
}