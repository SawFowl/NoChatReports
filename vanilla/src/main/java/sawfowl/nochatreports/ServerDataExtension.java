package sawfowl.nochatreports;

import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.network.protocol.status.ServerStatus;
import sawfowl.nochatreports.mixins.vanilla.MixinServerStatus;

/**
 * Implemented by {@link MixinServerStatus} on {@link ServerStatus} class and {@link MixinServerData}
 * on {@link ServerData} class.
 *
 * @author fxmorin (original implementation)
 * @author Aizistral (current version)
 */

public interface ServerDataExtension {

	public boolean preventsChatReports();

	public void setPreventsChatReports(boolean prevents);

}