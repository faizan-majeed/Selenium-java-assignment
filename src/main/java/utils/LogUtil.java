package utils;

import org.testng.log4testng.Logger;

public class LogUtil {
	public static Logger logger;

	private LogUtil() {
	}

	public synchronized static Logger getLoggerInstance() {
		if (logger == null) {
			logger = Logger.getLogger(LogUtil.class);
		}
		return logger;
	}
}
