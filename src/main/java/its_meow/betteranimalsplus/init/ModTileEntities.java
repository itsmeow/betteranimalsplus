package its_meow.betteranimalsplus.init;

import com.mojang.datafixers.DSL;

import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.common.tileentity.TileEntityHandOfFate;
import its_meow.betteranimalsplus.common.tileentity.TileEntityHead;
import its_meow.betteranimalsplus.common.tileentity.TileEntityTrillium;
import net.minecraft.tileentity.TileEntityType;

public class ModTileEntities {

    /*
     * Tile Entities
     */
	public static final TileEntityType<?> HEAD_TYPE = TileEntityType.Builder.create(TileEntityHead::new)
            .build(DSL.remainderType()).setRegistryName(Ref.MOD_ID, "head");
    public static final TileEntityType<?> TRILLIUM_TYPE = TileEntityType.Builder.create(TileEntityTrillium::new)
            .build(DSL.remainderType()).setRegistryName(Ref.MOD_ID, "trilliumtileentity");
    public static final TileEntityType<?> HAND_OF_FATE_TYPE = TileEntityType.Builder.create(TileEntityHandOfFate::new)
            .build(DSL.remainderType()).setRegistryName(Ref.MOD_ID, "handoffatetileentity");

}
