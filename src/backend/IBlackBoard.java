package backend;

/**
 * @author asteinbr
 * @date 11/14/11
 */
public interface IBlackBoard {
    /**
     * @param userId
     * @param content
     * @param category
     */
    public void insertNote(int userId, String content, int category);

    /**
     * @param id
     */
    public void setStatus(int id);

    /**
     * @param id
     */
    public void deleteNote(int id);

    /**
     * @param id
     */
    public BlackBoardEntry getNote(int id);

    /**
     *
     */
    public int getNotesCount();
}
