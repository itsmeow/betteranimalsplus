package its_meow.betteranimalsplus.util;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeListBuilder {
    
    private final Set<Biome> extras = new HashSet<Biome>();
    private final Set<BiomeDictionary.Type> list = new HashSet<BiomeDictionary.Type>();
    private final Set<BiomeDictionary.Type> blacklist = new HashSet<BiomeDictionary.Type>();
    private final Set<BiomeDictionary.Type> required = new HashSet<BiomeDictionary.Type>();
    
    private BiomeListBuilder() {
        
    }
    
    public static BiomeListBuilder create() {
        return new BiomeListBuilder();
    }
    
    public BiomeListBuilder extra(Biome... extraBiomes) {
        for(Biome biome : extraBiomes) {
            extras.add(biome);
        }
        return this;
    }
    
    public BiomeListBuilder extra(BiomeDictionary.Type... types) {
        for(BiomeDictionary.Type type : types) {
            list.add(type);
        }
        return this;
    }
    
    public BiomeListBuilder withoutTypes(BiomeDictionary.Type... types) {
        for(BiomeDictionary.Type type : types) {
            blacklist.add(type);
        }
        return this;
    }
    
    public BiomeListBuilder withTypes(BiomeDictionary.Type... types) {
        for(BiomeDictionary.Type type : types) {
            required.add(type);
        }
        return this;
    }
    
    public Biome[] collect() {
        Set<Biome> set = new HashSet<Biome>();
        set.addAll(extras);
        for(BiomeDictionary.Type extraT : list) {
            set.addAll(BiomeDictionary.getBiomes(extraT));
        }
        for(Biome biome : ForgeRegistries.BIOMES.getValues()) {
            Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(biome);
            if(types != null) {
                boolean pass = true;
                for(BiomeDictionary.Type type : required) {
                    if(!types.contains(type)) {
                        pass = false;
                    }
                }
                for(BiomeDictionary.Type type : blacklist) {
                    if(types.contains(type)) {
                        pass = false;
                    }
                }
                if(pass) {
                    set.add(biome);
                }
            }
        }
        return set.toArray(new Biome[0]);
    }

}
