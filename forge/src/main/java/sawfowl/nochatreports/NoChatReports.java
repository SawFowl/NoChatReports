package sawfowl.nochatreports;

import org.apache.logging.log4j.Logger;

public abstract class NoChatReports {

	public static NoChatReports getInstance() {
		return null;
	}

	public abstract Config getConfig();

	public abstract Logger getLogger();

}
