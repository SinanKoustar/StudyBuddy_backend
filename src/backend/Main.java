package backend;

import webservice.server.SOAPServer;

import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;

/**
 * @author asteinbr
 * @date 11/3/11
 */
public class Main {
    private final static Logger LOGGER = Logger.getLogger(Main.class.getName());

    private static ArrayList<BlackBoardEntry> blackBoardList = new ArrayList<BlackBoardEntry>();

    private static void createDemoData()
    {
        blackBoardList.add(
                new BlackBoardEntry(1, "Suche Villa im Taunus", "Zum 1.3.2012 suche ich eine Villa mit min. 500qm Wohnflaeche im Taunus.", "Murat D.", new Date(), Boolean.TRUE));
        blackBoardList.add(
                new BlackBoardEntry(2, "Suche Wohnung im Westend", "Hallo ich Suche ein Loft zum 1.1.2012 im Westend.", "Wolfgang P.", new Date(), Boolean.TRUE));
    }

    private static void printData()
    {
        for (BlackBoardEntry bbe : blackBoardList)
            LOGGER.info(bbe.toString());
    }

    public static void main(String[] args)
    {
        createDemoData();
        printData();

        try
        {
            SOAPServer soapServer = new SOAPServer();
            LOGGER.info("SOAPServer is running...");
        } catch (NullPointerException npe)
        {
            LOGGER.severe(npe.getMessage());
        }
    }
}
