package billboard;

import java.util.ArrayList;

/**
 * @author asteinbr
 * @date 11/7/11
 */
public class BillBoardImpl
{
    private ArrayList<BillBoard> billBoardList = new ArrayList<BillBoard>();
    private BillBoard billBoard = null;

    private static BillBoardImpl ourInstance = new BillBoardImpl();

    public static BillBoardImpl getInstance() {
        return ourInstance;
    }

    public BillBoard getBillBoard() {
        return billBoard;
    }

    public ArrayList<BillBoard> getBillBoardList() {
		 return this.billBoardList;
	}

    private BillBoardImpl() {
        this.billBoard = new BillBoard();
    }
}
