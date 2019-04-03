/*
* connect to Ms Server
 */
package abc.database;
import java.sql.*;

/**
 * @author ckm
 */
public class Database2msserver {
    public static void main(String[] args) throws Exception{
    
    //This for MSServer2012 - sqkhdbc42.jar
    //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    //Connection connect = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=Room;user=tiger;password=1234"); 
    //OR
    
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    //In case using "integratedSecurity=true" you must copy "sqljdbc_auth.dll" file from jdbc dirctory To windows\systme32
    Connection connect = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;integratedSecurity=true;");
    PreparedStatement ps = connect.prepareStatement("select * from Room.dbo.User1");
    ResultSet result = ps.executeQuery();
    
        while (result.next()) {
            System.out.println("ID :" + result.getString("UserId"));
            System.out.println("Name :" + result.getString("UserFname"));
            System.out.println("-----------------");
        }//while
        ps.close();
        connect.close();
    }//void
}//main
