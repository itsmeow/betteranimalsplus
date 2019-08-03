package its_meow.betteranimalsplus.util;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

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
    public BiomeDictionary.Type[] types = {};
    public Biome[] spawnBiomes = {};
    public boolean doSpawning = true;
    public float width;
    public float height;
    public String[] tameItems;

    @SafeVarargs
    public EntityContainer(Class<T> EntityClass, Function<World, T> func,
                           String entityNameIn, EntityClassification type, int solidColorIn, int spotColorIn, int prob, int min, int max, float width, float height, 
                           String[] tameItems, BiomeDictionary.Type... biomeTypes) {
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
        
        if(tameItems == null) {
            this.tameItems = new String[0];
        } else {
            this.tameItems = tameItems;
        }
        this.types = biomeTypes;
    }
    
    public String[] getBiomeIDs() {
        Set<Biome> biomesetAdd = new HashSet<>();
        for(BiomeDictionary.Type type : types) {
            biomesetAdd.addAll(BiomeDictionary.getBiomes(type));
        }
        try {
            this.spawnBiomes = biomesetAdd.toArray(this.spawnBiomes);
        } catch(NullPointerException e) {
            this.spawnBiomes = new Biome[0];
        }
        String[] biomeStrings = new String[spawnBiomes.length];
        for(int i = 0; i < spawnBiomes.length; i++) {
            biomeStrings[i] = spawnBiomes[i].getRegistryName().toString();
        }
        return biomeStrings;
    }

}
