package dev.itsmeow.betteranimalsplus.api;

import dev.itsmeow.betteranimalsplus.common.entity.projectile.EntityModEgg;
import net.minecraft.world.entity.LivingEntity;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class ModEventBus {

    /**
     * Called when an egg-laying entity ticks its egg laying logic. Cancel to prevent the tick.
     */
    public static class LayEggTickEvent extends BAPEvent {

        protected static Set<Consumer<LayEggTickEvent>> SUBSCRIBERS = new HashSet<>();

        public static boolean subscribe(Consumer<LayEggTickEvent> listener) {
            return SUBSCRIBERS.add(listener);
        }

        public static boolean unsubscribe(Consumer<LayEggTickEvent> listener) {
            return SUBSCRIBERS.remove(listener);
        }

        public static boolean emit(LivingEntity entity) {
            LayEggTickEvent event = new LayEggTickEvent(entity);
            SUBSCRIBERS.forEach(c -> c.accept(event));
            return !event.isCancelled();
        }

        private final LivingEntity entity;

        private LayEggTickEvent(LivingEntity entity) {
            this.entity = entity;
        }

        public LivingEntity getEntity() {
            return entity;
        }
    }

    /**
     * Cancelling will spawn 0 entities. Otherwise, spawns getSpawnCount entities. Use setSpawnCount to change the amount.
     */
    public static class EggThrowSpawnCountEvent extends BAPEvent {

        protected static Set<Consumer<EggThrowSpawnCountEvent>> SUBSCRIBERS = new HashSet<>();

        public static boolean subscribe(Consumer<EggThrowSpawnCountEvent> listener) {
            return SUBSCRIBERS.add(listener);
        }

        public static boolean unsubscribe(Consumer<EggThrowSpawnCountEvent> listener) {
            return SUBSCRIBERS.remove(listener);
        }

        public static int emit(EntityModEgg entity, int spawnCount) {
            EggThrowSpawnCountEvent event = new EggThrowSpawnCountEvent(entity, spawnCount);
            SUBSCRIBERS.forEach(c -> c.accept(event));
            return event.isCancelled() ? 0 : event.getSpawnCount();
        }

        private final EntityModEgg entity;
        private int spawnCount;

        private EggThrowSpawnCountEvent(EntityModEgg entity, int spawnCount) {
            this.entity = entity;
            this.spawnCount = spawnCount;
        }

        /**
         * The egg entity
         */
        public EntityModEgg getEntity() {
            return entity;
        }

        /**
         * Change the amount of entities to spawn from egg
         */
        public void setSpawnCount(int spawnCount) {
            this.spawnCount = spawnCount;
        }

        /**
         * Default value is what would normally occur
         */
        public int getSpawnCount() {
            return this.spawnCount;
        }
    }

    /**
     * Cancelling will prevent spawning. Otherwise, see shouldSpawnEntities. Use setShouldSpawnEntities to force a spawn.
     */
    public static class ShouldEggSpawnEntitiesEvent extends BAPEvent {

        protected static Set<Consumer<ShouldEggSpawnEntitiesEvent>> SUBSCRIBERS = new HashSet<>();

        public static boolean subscribe(Consumer<ShouldEggSpawnEntitiesEvent> listener) {
            return SUBSCRIBERS.add(listener);
        }

        public static boolean unsubscribe(Consumer<ShouldEggSpawnEntitiesEvent> listener) {
            return SUBSCRIBERS.remove(listener);
        }

        public static boolean emit(EntityModEgg entity, boolean shouldSpawnEntities) {
            ShouldEggSpawnEntitiesEvent event = new ShouldEggSpawnEntitiesEvent(entity, shouldSpawnEntities);
            SUBSCRIBERS.forEach(c -> c.accept(event));
            return event.isCancelled() ? false : event.shouldSpawnEntities();
        }

        private final EntityModEgg entity;
        private boolean shouldSpawnEntities;

        private ShouldEggSpawnEntitiesEvent(EntityModEgg entity, boolean shouldSpawnEntities) {
            this.entity = entity;
            this.shouldSpawnEntities = shouldSpawnEntities;
        }

        /**
         * The egg entity
         */
        public EntityModEgg getEntity() {
            return entity;
        }

        /**
         * Set if entities should spawn from the egg or not
         */
        public void setShouldSpawnEntities(boolean shouldSpawnEntities) {
            this.shouldSpawnEntities = shouldSpawnEntities;
        }

        /**
         * Default value is what would normally occur
         */
        public boolean shouldSpawnEntities() {
            return this.shouldSpawnEntities;
        }
    }

    public static abstract class BAPEvent {

        private boolean canceled = false;

        public void setCanceled(boolean canceled) {
            this.canceled = canceled;
        }

        public boolean isCancelled() {
            return this.canceled;
        }

    }
}
