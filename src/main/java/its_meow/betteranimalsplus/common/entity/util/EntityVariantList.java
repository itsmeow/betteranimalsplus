package its_meow.betteranimalsplus.common.entity.util;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.common.collect.ImmutableList;

import net.minecraft.util.ResourceLocation;

public class EntityVariantList {

    private final ArrayList<IVariant> variantList;
    private final HashMap<String, IVariant> nameMap;

    public EntityVariantList(int size) {
        this.variantList = new ArrayList<IVariant>(size);
        this.nameMap = new HashMap<String, IVariant>(size);
    }

    public IVariant getVariant(int index) {
        return variantList.get(index);
    }

    public int getVariantIndex(String variant) {
        return variantList.indexOf(getVariant(variant));
    }

    public int getVariantIndex(IVariant variant) {
        return variantList.indexOf(variant);
    }

    public IVariant getVariant(String name) {
        return nameMap.get(name);
    }

    public ResourceLocation getTexture(String name) {
        return getVariant(name).getTexture();
    }

    public String getName(String name) {
        return getVariant(name).getName();
    }

    public ImmutableList<IVariant> getVariantList() {
        return ImmutableList.copyOf(this.variantList);
    }

    public void add(IVariant... variants) {
        for(IVariant variant : variants) {
            variantList.add(variant);
            nameMap.put(variant.getName(), variant);
        }
    }

}
