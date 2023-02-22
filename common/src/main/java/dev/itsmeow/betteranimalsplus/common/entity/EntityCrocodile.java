package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityCrocidilian;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityWaterMobPathing;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.interfaces.ISelectiveVariantTypes;
import dev.itsmeow.imdlib.entity.util.BiomeTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;

import java.util.Set;

public class EntityCrocodile extends EntityCrocidilian implements ISelectiveVariantTypes<EntityWaterMobPathing> {

    private static final String[] ALL_TYPE = {"american", "nile"};
    private static final String[] SAVANNA_TYPE = {"nile"};

    public EntityCrocodile(EntityType<? extends EntityCrocidilian> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public EntityTypeContainer<? extends EntityWaterMobPathing> getContainer() {
        return ModEntities.CROCODILE;
    }

    @Override
    public String[] getTypesFor(ResourceKey<Biome> biomeKey, Biome biome, Set<BiomeTypes.Type> types, MobSpawnType reason) {
        if (types.contains(BiomeTypes.SAVANNA)) {
            return SAVANNA_TYPE;
        } else if (types.contains(BiomeTypes.SWAMP)) {
            return ALL_TYPE;
        }
        return ALL_TYPE;
    }
}
