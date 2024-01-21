package sawfowl.nochatreports;

import java.lang.reflect.Field;
import java.util.Optional;
import java.util.function.Function;

import com.google.gson.JsonElement;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.JsonOps;

import io.netty.handler.codec.EncoderException;
import net.minecraft.network.protocol.status.ServerStatus;

public class ForgeUtils {

	private Codec<ServerStatus> CODEC;

	@SuppressWarnings("unchecked")
	public Codec<ServerStatus> getCodec() {
		if(CODEC == null) {
			try {
				Field field = ServerStatus.class.getField("f_271163_");
				CODEC = (Codec<ServerStatus>) field.get(field.getType());
			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return CODEC;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DataResult<JsonElement> encodeStart(Object object) {
		return ((Codec) getCodec()).encodeStart(JsonOps.INSTANCE, object);
	}

	public JsonElement getOrThrow(Object object) {
		return getOrThrow(encodeStart(object), string -> new EncoderException("Failed to encode: " + string + " " + object));
	}

	public static <T, E extends Exception> T getOrThrow(DataResult<T> p_261812_, Function<String, E> p_261468_) throws E {
		Optional<DataResult.PartialResult<T>> optional = p_261812_.error();
		if (optional.isPresent()) {
			throw p_261468_.apply(optional.get().message());
		} else {
		return p_261812_.result().orElseThrow();
		}
	}

}
