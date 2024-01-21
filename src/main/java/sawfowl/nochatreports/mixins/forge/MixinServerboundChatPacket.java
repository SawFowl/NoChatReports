package sawfowl.nochatreports.mixins.forge;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.network.chat.MessageSignature;
import net.minecraft.network.protocol.game.ServerboundChatPacket;

@Mixin(ServerboundChatPacket.class)
public class MixinServerboundChatPacket {

	@Inject(method = "signature", at = @At("RETURN"), cancellable = true)
	private void onGetSignature(CallbackInfoReturnable<MessageSignature> info) {
		info.setReturnValue(null);
	}

}
