package its_meow.betteranimalsplus.proxy;

import its_meow.betteranimalsplus.client.model.ModelHirschgeistHelmet;
import net.minecraft.client.renderer.entity.model.ModelBiped;

public class ClientProxy implements ISidedProxy {

	public static final ModelHirschgeistHelmet armorModel = new ModelHirschgeistHelmet();


	@Override
	public void setup() {
		
	}

	public static ModelBiped getArmorModel() {
		return ClientProxy.armorModel;
	}

}
