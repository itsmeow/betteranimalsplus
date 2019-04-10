package its_meow.betteranimalsplus.common.entity;

import net.minecraft.world.World;

public interface ITimeOfDay {
	
	default boolean isDaytime(World world) {
        long time = world.getWorldTime() % 24000L; // Time can go over values of 24000, so divide and take the remainder
        return !(time >= 13000L && time <= 23000L);
	}
	
}
