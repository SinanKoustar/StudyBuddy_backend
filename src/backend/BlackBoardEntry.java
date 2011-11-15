package backend;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author asteinbr
 * @date 11/14/11
 */
public class BlackBoardEntry {
    int id;
    String title;
    String content;
    String author;
    Date date;
    boolean state;

    public BlackBoardEntry(int nId, String nTitle, String nContent, String nAuthor, Date nDate, boolean nState)
    {
        this.id = nId;
        this.title = nTitle;
        this.content = nContent;
        this.author = nAuthor;
        this.date = nDate;
        this.state = nState;
    }

    public BlackBoardEntry()
    {
    }

    @Override
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(id);
        stringBuilder.append(", ");
        stringBuilder.append(title.toString());
        stringBuilder.append(", ");
        stringBuilder.append(content.toString());
        stringBuilder.append(", ");
        stringBuilder.append(author.toString());
        stringBuilder.append(", ");
        stringBuilder.append("07.11.11 - 21:41");
        stringBuilder.append(", ");
        if (this.isState())
            stringBuilder.append("actived");
        else
            stringBuilder.append("deactivated");
        stringBuilder.append(";");

        return stringBuilder.toString();
    }

    public static Date getCurrentDate()
    {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yy - HH:mm:ss");
        try
        {
            date = dateFormat.parse("25.03.87 - 15:48:12");
        } catch (ParseException e)
        {
            //LOGGER.severe(e.getMessage());
        }

        return date;
    }

    public void addItem(int nId, String nTitle, String nContent, String nAuthor, Date nDate, boolean nState)
    {
        this.id = nId;
        this.title = nTitle;
        this.content = nContent;
        this.author = nAuthor;
        this.date = nDate;
        this.state = nState;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public boolean isState()
    {
        return state;
    }

    public void setState(boolean state)
    {
        this.state = state;
    }

}
