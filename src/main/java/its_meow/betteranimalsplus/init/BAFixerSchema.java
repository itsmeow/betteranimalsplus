package its_meow.betteranimalsplus.init;

import java.util.Map;
import java.util.function.Supplier;

import com.mojang.datafixers.schemas.Schema;
import com.mojang.datafixers.types.templates.TypeTemplate;

import net.minecraft.util.datafix.NamespacedSchema;

public class BAFixerSchema extends NamespacedSchema {

    public BAFixerSchema(int versionKey, Schema schema) {
        super(versionKey, schema);
    }

    @Override
    public Map<String, Supplier<TypeTemplate>> registerBlockEntities(Schema schema) {
        Map<String, Supplier<TypeTemplate>> map = super.registerBlockEntities(schema);
        schema.registerSimple(map, "betteranimalsplus:head");
        schema.registerSimple(map, "betteranimalsplus:trilliumtileentity");
        schema.registerSimple(map, "betteranimalsplus:handoffatetileentity");
        return map;
    }
    
    

}
