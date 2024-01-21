package sawfowl.nochatreports.mixins.forge;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.network.chat.PlayerChatMessage;
import net.minecraft.server.players.PlayerList;

@Mixin(PlayerList.class)
public class MixinPlayerList {

	@Inject(method = "verifyChatTrusted", at = @At("HEAD"), cancellable = true)
	private void onVerifyChatTrusted(PlayerChatMessage playerChatMessage, CallbackInfoReturnable<Boolean> info) {
		info.setReturnValue(true);
	}

}
