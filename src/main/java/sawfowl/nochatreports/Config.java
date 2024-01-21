package sawfowl.nochatreports;

import org.spongepowered.configurate.objectmapping.ConfigSerializable;
import org.spongepowered.configurate.objectmapping.meta.Setting;

@ConfigSerializable
public final class Config {

	@Setting("ConvertToGameMessage")
	private boolean convertToGameMessage = true;
	@Setting("AddQueryData")
	private boolean addQueryData = true;
	@Setting("EnableDebugLog")
	private boolean enableDebugLog = false;

	/**
	 * @return True if server should convert all player messages to system messages. System messages
	 * do not feature signatures and look completely identical in the chat, with exception of gray line
	 * next to them added in pre-release 3. They are also unselectable for chat reporting.<br><br>
	 *
	 * This is false by default.
	 */

	public boolean convertToGameMessage() {
		return this.convertToGameMessage;
	}

	/**
	 * @return True if mod should log some additional information about its activity and message
	 * signatures. Generally only useful for debugging.<br><br>
	 *
	 * This is false by default.
	 */

	public boolean enableDebugLog() {
		return this.enableDebugLog;
	}

	/**
	 * @return True if server should include extra query data to help clients know that your server
	 * is secure.<br><br>
	 *
	 * This is true by default.
	 */

	public boolean addQueryData() {
		return this.addQueryData;
	}

}
