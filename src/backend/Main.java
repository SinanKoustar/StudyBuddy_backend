package backend;

import java.util.logging.Logger;

/**
 * @author alexander
 * @date: 11/3/11
 */
public class Main {
    private final static Logger LOGGER = Logger.getLogger(Main.class.getName());

    private static void getDemoData()
    {
        System.out.println("ID, Titel, Textinhalt, Author, Datum, ACTIVE");
    }

    public static void main(String[] args)
    {
        System.out.println("Main started...");
        getDemoData();

        LOGGER.info("Logger: Information...");
        LOGGER.severe("Logger: Fehler...");
    }
}
