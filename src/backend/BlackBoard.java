package backend;

/**
 * @author asteinbr
 * @date 11/14/11
 */
public class BlackBoard implements IBlackBoard {
    /**
     * @param userId
     * @param content
     * @param category
     */
    @Override
    public void insertNote(int userId, String content, int category)
    {
    }

    /**
     * @param id
     */
    @Override
    public void setStatus(int id)
    {
    }

    /**
     * @param id
     */
    @Override
    public void deleteNote(int id)
    {
    }

    /**
     * @param id
     */
    @Override
    public BlackBoardEntry getNote(int id)
    {
        return null;
    }

    /**
     *
     */
    @Override
    public int getNotesCount()
    {
        return 0;
    }
}
