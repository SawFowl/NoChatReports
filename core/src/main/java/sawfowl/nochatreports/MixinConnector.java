package sawfowl.nochatreports;

import org.spongepowered.asm.mixin.Mixins;
import org.spongepowered.asm.mixin.connect.IMixinConnector;

public class MixinConnector implements IMixinConnector {

	@Override
	public void connect() {
		Mixins.addConfigurations(isForge() ? "nochatreports.mixins.forge.json" : "nochatreports.mixins.vanilla.json");
	}

	private boolean isForge() {
		try {
			Class.forName("net.minecraftforge.fml.javafmlmod.FMLModContainer");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
