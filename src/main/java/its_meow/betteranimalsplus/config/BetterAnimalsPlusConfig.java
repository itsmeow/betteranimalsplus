package its_meow.betteranimalsplus.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.tuple.Pair;

import dev.itsmeow.imdlib.entity.EntityRegistrarHandler.ClientEntityConfiguration;
import dev.itsmeow.imdlib.entity.EntityRegistrarHandler.ServerEntityConfiguration;
import dev.itsmeow.imdlib.entity.util.EntityTypeContainer;
import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.common.entity.util.EntityTypeContainerBAPTameable;
import its_meow.betteranimalsplus.init.ModEntities;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.config.ModConfig;

@Mod.EventBusSubscriber(modid = Ref.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class BetterAnimalsPlusConfig {

    private static ServerEntityConfiguration SERVER_CONFIG = null;
    public static ForgeConfigSpec SERVER_CONFIG_SPEC = null;

    private static ClientEntityConfiguration CLIENT_CONFIG = null;
    public static ForgeConfigSpec CLIENT_CONFIG_SPEC = null;

    public static ForgeConfigSpec getClientSpec() {
        final Pair<ClientEntityConfiguration, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(ModEntities.H::clientConfig);
        CLIENT_CONFIG_SPEC = specPair.getRight();
        CLIENT_CONFIG = specPair.getLeft();
        return CLIENT_CONFIG_SPEC;
    }

    public static ForgeConfigSpec getServerSpec() {
        final Pair<ServerEntityConfiguration, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(ModEntities.H::serverConfig);
        SERVER_CONFIG_SPEC = specPair.getRight();
        SERVER_CONFIG = specPair.getLeft();
        return SERVER_CONFIG_SPEC;
    }

    @SubscribeEvent
    public static void onLoad(final ModConfig.Loading configEvent) {
        BetterAnimalsPlusMod.logger.debug("Loading {} {}", Ref.MOD_ID, configEvent.getConfig().getFileName());
        if(configEvent.getConfig().getSpec() == SERVER_CONFIG_SPEC) {
            SERVER_CONFIG.onWorldLoad();
        } else if(configEvent.getConfig().getSpec() == CLIENT_CONFIG_SPEC) {
            CLIENT_CONFIG.onLoad();
        }
    }

    @SubscribeEvent
    public static void onLoad(final ModConfig.ConfigReloading configEvent) {
        BetterAnimalsPlusMod.logger.debug("Reloading {} {}", Ref.MOD_ID, configEvent.getConfig().getFileName());
        if(configEvent.getConfig().getSpec() == SERVER_CONFIG_SPEC) {
            SERVER_CONFIG.onLoad();
        } else if(configEvent.getConfig().getSpec() == CLIENT_CONFIG_SPEC) {
            CLIENT_CONFIG.onLoad();
        }
    }

    public static Map<String, String[]> getTameItemsMap() {
        Map<String, String[]> map = new HashMap<String, String[]>();
        for(EntityTypeContainer<?> cont : ModEntities.getEntities().values()) {
            if(cont instanceof EntityTypeContainerBAPTameable) {
                EntityTypeContainerBAPTameable<?> c = (EntityTypeContainerBAPTameable<?>) cont;
                map.put(c.entityName, c.getTameItems());
            }
        }
        return map;
    }

}
