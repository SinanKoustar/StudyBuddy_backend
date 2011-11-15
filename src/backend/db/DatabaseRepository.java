package backend.db;

import java.sql.*;

/**
 * @author asteinbr , mernst
 * @date 11/15/11
 */
public class DatabaseRepository implements IRepository {
    private ResultSet rs;
    private Connection con;
    private String driver;
    private String hostname;
    private String user;
    private String password;
    private PreparedStatement pstmt;

    /**
     *
     */
    DatabaseRepository()
    {
        this.driver = "com.mysql.jdbc.Driver";
        this.hostname = "jdbc:mysql://localhost:3306/mysql";
        this.user = "root";
        this.password = "root";
    }

    /**
     * @param hostname
     * @param username
     * @param password
     */
    DatabaseRepository(String hostname, String username, String password)
    {
        this.driver = "com.mysql.jdbc.Driver";
        this.hostname = hostname;
        this.user = username;
        this.password = password;
    }

    /**
     * Initialize / open connection to database
     */
    public void initialize()
    {
        try
        {
            Class.forName(driver);
            this.con = DriverManager.getConnection(hostname, user, password);
            System.out.println("connection opened");
        } catch (Exception e)
        {
            e.printStackTrace();
        }//end catch
    }

    /**
     * Shutdown / close connection to database
     */
    public void shutdown()
    {
        try
        {
            con.close();
            System.out.println("connection closed");
        } catch (Exception e)
        {
            e.printStackTrace();
        }//end catch
    }

    /**
     * access database to retrieve userID of a user
     *
     * @param username needed to retrieve userID
     * @return <b>userID</b> as int
     */
    public int getUID(String username)
    {
        int userID = 0;
        String getUser = "SELECT b.id, b.benutzername "
                + "FROM mydb.User b ";

        try
        {
            pstmt = con.prepareStatement(getUser);
            rs = pstmt.executeQuery();

            while (rs.next())
            {
                int theID = rs.getInt("id");
                String benutzername = rs.getString("benutzername");

                if (username.equalsIgnoreCase(benutzername))
                {
                    userID = theID;
                }
            }
            rs.close();
            pstmt.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        if (userID == 0)
        {
            throw new SecurityException("Den namen " + username + " gibt es nicht in der Datenbank und liefert keinen wert");
        } else
        {
            return userID;
        }
    }

    /**
     * @param bName -> user name, needed to add new user
     */
    public void insertUserNotes(String bName)
    {
        String insertUserString = "INSERT INTO mydb.User(Benutzername) VALUES (?)";
        try
        {
            pstmt = con.prepareStatement(insertUserString);
            pstmt.setString(1, bName);
            pstmt.executeUpdate();
            pstmt.close();
            System.out.println("Insert ok!");
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * @param userid needed to retrieve amount of notes of that user
     * @return <b>erg</b> has amount of notes written by user
     */
    public int getAnzNotes(int userid)
    {
        int erg = 0;
        String anzNotes = "SELECT COUNT(Notes)"
                + "FROM mydb.Notes "
                + "WHERE UserID = ? ";
        try
        {
            pstmt = con.prepareStatement(anzNotes);
            pstmt.setInt(1, userid);
            pstmt.addBatch();
            rs = pstmt.executeQuery();

            while (rs.next())
            {
                erg = rs.getInt(1);
            }
            rs.close();
            pstmt.close();

        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return erg;
    }

    /**
     * @param userid needed to retrieve notes
     * @return Array of Notes: Array contains all notes written by user.
     */
    public Object[] getNotes(int userid)
    {
        String[] erg = new String[getAnzNotes(userid)];
        String getNotes = "SELECT Notes "
                + "FROM mydb.Notes "
                + "WHERE benutzer_id = ? ; ";

        int count = 0;
        try
        {
            pstmt = con.prepareStatement(getNotes);
            pstmt.setInt(1, userid);
            pstmt.addBatch();
            rs = pstmt.executeQuery();

            while (rs.next())
            {
                erg[count] = rs.getString(1);
                count++;
            }
            rs.close();
            pstmt.close();

        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return erg;
    }
}
