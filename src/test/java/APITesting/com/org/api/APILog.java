package APITesting.com.org.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class APILog {

	private static Logger log = LogManager.getLogger(APILog.class.getName());

	public static void main(String args[])
	{
		log.error("error message");
		if (3<5)
			log.debug("debugging mesg");
		log.info("info mesg");

		log.fatal("Fatal msg");
	}

}
