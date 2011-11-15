package backend.db;

/**
 * @author asteinbr
 * @date 11/14/11
 */
public interface IRepository {
    /**
     * Initialize / open connection to database
     */
    public void initialize();

    /**
     * Shutdown / close connection to database
     */
    public void shutdown();

    /**
     * access database to retrieve userID of a user
     *
     * @param username needed to retrieve userID
     * @return <b>userID</b> as int
     */
    public int getUID(String username);

    /**
     * @param bName -> user name, needed to add new user
     */
    public void insertUserNotes(String bName);

    /**
     * @param userid needed to retrieve amount of notes of that user
     * @return <b>erg</b> has amount of notes written by user
     */
    public int getAnzNotes(int userid);

    /**
     * @param userid needed to retrieve notes
     * @return Array of Notes: Array contains all notes written by user.
     */
    public Object[] getNotes(int userid);
}
