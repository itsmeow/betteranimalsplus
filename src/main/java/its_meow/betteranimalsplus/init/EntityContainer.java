package its_meow.betteranimalsplus.init;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

public class EntityContainer {

	public Class<? extends EntityLiving> entityClazz;
	public String entityName;
	public EnumCreatureType type;
	public int eggColorSolid;
	public int eggColorSpot;
	public int weight;
	public int minGroup;
	public int maxGroup;
	public Biome[] spawnBiomes = {};
	public boolean doRegister = true;
	public boolean doSpawning = true;
	public BiomeDictionary.Type[] types = {};

	@SafeVarargs
	public EntityContainer(Class<? extends EntityLiving> EntityClass, String entityNameIn, EnumCreatureType type, int solidColorIn, int spotColorIn, int prob, int min, int max, BiomeDictionary.Type... types) {
		this.entityClazz = EntityClass;
		this.entityName = entityNameIn;
		this.eggColorSolid = solidColorIn;
		this.eggColorSpot = spotColorIn;
		this.weight = prob;
		this.minGroup = min;
		this.maxGroup = max;
		this.type = type;

		this.types = types;
	}

	public void populateBiomes() {
		Set<Biome> biomesetAdd = new HashSet<>();
		for(Type type : types) {
			biomesetAdd.addAll(BiomeDictionary.getBiomes(type));
		}
		try {
			this.spawnBiomes = biomesetAdd.toArray(this.spawnBiomes);
		} catch(NullPointerException e) {
			this.spawnBiomes = new Biome[0];
		}
	}

}
