package its_meow.betteranimalsplus.common.entity;

import net.minecraft.entity.Entity;

public class NullPredicate implements com.google.common.base.Predicate<Entity> {

	@Override
	public boolean apply(Entity input) {
		return true;
	}

}
