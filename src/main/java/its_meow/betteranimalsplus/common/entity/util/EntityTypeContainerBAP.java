package its_meow.betteranimalsplus.common.entity.util;

import java.util.function.Function;

import dev.itsmeow.imdlib.entity.util.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.util.builder.AbstractEntityBuilder;
import dev.itsmeow.imdlib.entity.util.builder.EntityTypeDefinition;
import dev.itsmeow.imdlib.entity.util.builder.IEntityTypeDefinition;
import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.util.HeadType;
import net.minecraft.entity.MobEntity;
import net.minecraft.world.World;

public class EntityTypeContainerBAP<T extends MobEntity> extends EntityTypeContainer<T> {

    protected HeadType headType;

    protected EntityTypeContainerBAP(IEntityTypeDefinition<T> parentDef) {
        super(parentDef);
    }

    public static abstract class AbstractEntityBuilderBAP<T extends MobEntity, C extends EntityTypeContainerBAP<T>, B extends AbstractEntityBuilderBAP<T, C, B>> extends AbstractEntityBuilder<T, C, B> {
        protected Function<C, HeadType> headTypeBuilder;

        protected AbstractEntityBuilderBAP(Class<T> EntityClass, Function<World, T> func, String entityNameIn) {
            super(EntityClass, func, entityNameIn, Ref.MOD_ID);
        }

        public HeadType.Builder<T, C, B> head(String headName) {
            return new HeadType.Builder<T, C, B>(getImplementation(), headName);
        }

        public HeadType.Builder<T, C, B> head() {
            return head(this.entityName + "head");
        }

        @Override
        public void postBuild(C container) {
            if(this.headTypeBuilder != null) {
                container.headType = headTypeBuilder.apply(container);
            }
        }

        public void setHeadBuild(Function<C, HeadType> builder) {
            this.headTypeBuilder = builder;
        }
    }

    public static class Builder<T extends MobEntity> extends AbstractEntityBuilderBAP<T, EntityTypeContainerBAP<T>, Builder<T>> {

        protected Builder(Class<T> EntityClass, Function<World, T> func, String entityNameIn) {
            super(EntityClass, func, entityNameIn);
        }

        @Override
        public EntityTypeContainerBAP<T> rawBuild() {
            return new EntityTypeContainerBAP<T>(new EntityTypeDefinition<T>(this));
        }

        @Override
        public Builder<T> getImplementation() {
            return this;
        }

        public static <T extends MobEntity> Builder<T> create(Class<T> EntityClass, Function<World, T> func, String entityNameIn) {
            return new Builder<T>(EntityClass, func, entityNameIn);
        }

    }

    public HeadType getHeadType() {
        return this.headType;
    }

}