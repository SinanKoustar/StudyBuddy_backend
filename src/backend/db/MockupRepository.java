package backend.db;

import backend.BlackBoardEntry;

import java.util.ArrayList;

/**
 * @author asteinbr
 * @date 11/15/11
 */
public class MockupRepository implements IRepository {
    private static ArrayList<BlackBoardEntry> blackBoardListTemp = new ArrayList<BlackBoardEntry>();
    private int id = 0;

    /**
     * Initialize / open connection to database
     */
    public void initialize()
    {
    }

    /**
     * Shutdown / close connection to database
     */
    public void shutdown()
    {
    }

    /**
     * access database to retrieve userID of a user
     *
     * @param username needed to retrieve userID
     * @return <b>userID</b> as int
     */
    public int getUID(String username)
    {
        return 0;
    }

    /**
     * @param bName -> user name, needed to add new user
     */
    public void insertUserNotes(String bName)
    {
        blackBoardListTemp.add(new BlackBoardEntry());
    }

    /**
     * @param userid needed to retrieve amount of notes of that user
     * @return <b>erg</b> has amount of notes written by user
     */
    public int getAnzNotes(int userid)
    {
        return id;
    }

    /**
     * @param userid needed to retrieve notes
     * @return Array of Notes: Array contains all notes written by user.
     */
    public Object[] getNotes(int userid)
    {
        int n = 0;
        String[] entries = new String[0];
        for (BlackBoardEntry bbe : blackBoardListTemp)
        {
            entries[n] = bbe.toString();
            n++;
        }

        return entries;
    }
}
