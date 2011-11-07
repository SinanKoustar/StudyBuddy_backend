package webservice.service;

import billboard.BillBoard;
import billboard.BillBoardImpl;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)

/**
 * @author asteinbr
 * @date 11/7/11
 */
public class SOAPService
{
    private final static Logger LOGGER = Logger.getLogger(SOAPService.class.getName());
    private static ArrayList<BillBoard> billBoardList = BillBoardImpl.getInstance().getBillBoardList();

    public String getItem(int id)
    {
        return billBoardList.get(id).toString();
    }

    public void addItem(int nId, String nTitle, String nContent, String nAuthor, Date nDate, boolean nState)
    {
        billBoardList.add(new BillBoard(nId, nTitle, nContent, nAuthor, nDate, nState));
        LOGGER.info("new BillBoard-Item: " + nId + ", " + nTitle + "," + nContent + "," + nAuthor + "," + nDate + "," + nState);
    }
}
