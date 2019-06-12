package its_meow.betteranimalsplus.util;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

public class EntityContainer<T extends LivingEntity> {

    public Class<T> entityClazz;
    public Function<World, T> entityFunction;
    public String entityName;
    public EntityClassification type;
    public int eggColorSolid;
    public int eggColorSpot;
    public int weight;
    public int minGroup;
    public int maxGroup;
    public Biome[] spawnBiomes = {};
    public boolean doSpawning = true;
    public float width;
    public float height;

    @SafeVarargs
    public EntityContainer(Class<T> EntityClass, Function<World, T> func,
                           String entityNameIn, EntityClassification type, int solidColorIn, int spotColorIn, int prob, int min, int max, float width, float height, 
                           Set<Biome>... biomes) {
        this.entityClazz = EntityClass;
        this.entityFunction = func;
        this.entityName = entityNameIn;
        this.eggColorSolid = solidColorIn;
        this.eggColorSpot = spotColorIn;
        this.weight = prob;
        this.minGroup = min;
        this.maxGroup = max;
        this.type = type;
        this.width = width;
        this.height = height;

        // Convert biomes to single array

        Set<Biome> biomesetAdd = new HashSet<>();
        for (Set<Biome> biomeset : biomes) {
            biomesetAdd.addAll(biomeset);
        }
        try {
            this.spawnBiomes = biomesetAdd.toArray(this.spawnBiomes);
        } catch (NullPointerException e) {
            this.spawnBiomes = new Biome[0];
        }
    }

}
