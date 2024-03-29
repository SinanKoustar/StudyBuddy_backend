package backend.utils;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Initialize bullet-in logger
 * <p/>
 * Howto use:
 * LOGGER.info("Logger: Information...");
 * LOGGER.severe("Logger: Fehler...");
 *
 * @author asteinbr
 * @date 11/3/11
 */
public class MyLogger {
    public static void setup() throws IOException
    {
        Logger logger;
        logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);

        FileHandler loggerOutput = new FileHandler("MyLoggerOutput.txt");
        SimpleFormatter formatOutput = new SimpleFormatter();

        loggerOutput.setFormatter(formatOutput);
        logger.addHandler(loggerOutput);
    }
}