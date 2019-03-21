package its_meow.betteranimalsplus.init;

import java.util.HashMap;
import java.util.Map;

import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.common.tileentity.TileEntityHandOfFate;
import its_meow.betteranimalsplus.common.tileentity.TileEntityTrillium;
import its_meow.betteranimalsplus.util.HeadTypes;
import net.minecraft.tileentity.TileEntityType;

public class ModTileEntities {

    /*
     * Tile Entities
     */
    static Map<HeadTypes, TileEntityType<?>> skulltetypes = new HashMap<>();

    public static final TileEntityType<?> TRILLIUM_TYPE = TileEntityType.Builder.create(TileEntityTrillium::new)
            .build(null).setRegistryName(Ref.MOD_ID, "trilliumtilentity");
    public static final TileEntityType<?> HAND_OF_FATE_TYPE = TileEntityType.Builder.create(TileEntityHandOfFate::new)
            .build(null).setRegistryName(Ref.MOD_ID, "handoffatetilentity");

    public static TileEntityType<?> getSkullTileEntityType(HeadTypes type) {
        return ModTileEntities.skulltetypes.get(type);
    }

}
