package backend;

import billboard.BillBoard;
import billboard.BillBoardImpl;
import webservice.server.SOAPServer;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * @author asteinbr
 * @date 11/3/11
 */
public class Main
{
    private final static Logger LOGGER = Logger.getLogger(Main.class.getName());

    private static ArrayList<BillBoard> billBoardList = BillBoardImpl.getInstance().getBillBoardList();
    //private static BillBoard billBoard = BillBoardImpl.getInstance().getBillBoard();

    private static void createDemoSet()
    {
        billBoardList.add(new BillBoard(1, "Suche Wohnung im Nordend", "Hallo ich Suche eine Wohnung zum 1.1.2012 im Nordend.", "Dirk K.", BillBoard.getCurrentDate(), true));
        billBoardList.add(new BillBoard(2,"Suche Wohnung im Westend", "Hallo ich Suche ein Loft zum 1.1.2012 im Westend.", "Wolfgang P.", BillBoard.getCurrentDate(), true));
    }

    public static void main(String[] args)
    {
        createDemoSet();

        try
        {
            SOAPServer soapServer = new SOAPServer();
            LOGGER.info("SOAPServer is running...");
        }
        catch (NullPointerException npe)
        {
            LOGGER.severe(npe.getMessage());
        }
    }
}
