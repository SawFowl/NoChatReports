package sawfowl.nochatreports.mixins.forge;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.server.dedicated.DedicatedServer;

@Mixin(DedicatedServer.class)
public class MixinDedicatedServer {

	@Inject(method = "enforceSecureProfile", at = @At("RETURN"), cancellable = true)
	private void onEnforceSecureProfile(CallbackInfoReturnable<Boolean> cir) {
		cir.setReturnValue(false);
	}

}