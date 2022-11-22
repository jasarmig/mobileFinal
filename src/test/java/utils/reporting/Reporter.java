package utils.reporting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Reporter {

    public Reporter() {}

    public static Logger getLogger() {
        return LoggerFactory.getLogger(Reporter.class);
    }

    public static void info(String text) {
        getLogger().info(text);
    }

    @SuppressWarnings("unused")
    public static void error(String text) {
        getLogger().error(text);
    }
}
