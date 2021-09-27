package dev.itsmeow.betteranimalsplus.common.advancements;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonObject;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.advancements.critereon.AbstractCriterionTriggerInstance;
import net.minecraft.advancements.critereon.DeserializationContext;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.PlayerAdvancements;
import net.minecraft.server.level.ServerPlayer;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class CustomTrigger implements CriterionTrigger<CustomTrigger.Instance> {
    private final ResourceLocation id;
    private final Map<PlayerAdvancements, Listeners> listeners = Maps.newHashMap();

    public CustomTrigger(String id) {
        this.id = new ResourceLocation(id);
    }

    public CustomTrigger(ResourceLocation id) {
        this.id = id;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public void addPlayerListener(PlayerAdvancements playerAdvancementsIn, Listener<Instance> listener) {
        Listeners playerListeners = listeners.get(playerAdvancementsIn);

        if(playerListeners == null) {
            playerListeners = new Listeners(playerAdvancementsIn);
            listeners.put(playerAdvancementsIn, playerListeners);
        }

        playerListeners.add(listener);
    }

    @Override
    public void removePlayerListener(PlayerAdvancements playerAdvancementsIn, Listener<Instance> listener) {
        Listeners playerListeners = listeners.get(playerAdvancementsIn);

        if(playerListeners != null) {
            playerListeners.remove(listener);

            if(playerListeners.isEmpty()) {
                listeners.remove(playerAdvancementsIn);
            }
        }
    }

    @Override
    public void removePlayerListeners(PlayerAdvancements playerAdvancementsIn) {
        listeners.remove(playerAdvancementsIn);
    }

    @Override
    public Instance createInstance(JsonObject json, DeserializationContext context) {
        return new Instance(getId(), EntityPredicate.Composite.ANY);
    }

    public void trigger(ServerPlayer player) {
        Listeners playerListeners = listeners.get(player.getAdvancements());

        if(playerListeners != null) {
            playerListeners.trigger(player);
        }
    }

    public static class Instance extends AbstractCriterionTriggerInstance {

        public Instance(ResourceLocation parRL, EntityPredicate.Composite predicate) {
            super(parRL, predicate);
        }

        public boolean test() {
            return true;
        }
    }

    static class Listeners {
        private final PlayerAdvancements playerAdvancements;
        private final Set<Listener<Instance>> listeners = Sets.newHashSet();

        public Listeners(PlayerAdvancements playerAdvancementsIn) {
            playerAdvancements = playerAdvancementsIn;
        }

        public boolean isEmpty() {
            return listeners.isEmpty();
        }

        public void add(Listener<Instance> listener) {
            listeners.add(listener);
        }

        public void remove(Listener<Instance> listener) {
            listeners.remove(listener);
        }

        public void trigger(ServerPlayer player) {
            ArrayList<Listener<Instance>> list = null;

            for(Listener<Instance> listener : listeners) {
                if(listener.getTriggerInstance().test()) {
                    if(list == null) {
                        list = Lists.newArrayList();
                    }

                    list.add(listener);
                }
            }

            if(list != null) {
                for(Listener<Instance> listener1 : list) {
                    listener1.run(playerAdvancements);
                }
            }
        }
    }
}