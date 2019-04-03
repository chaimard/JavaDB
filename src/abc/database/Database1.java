/*
 * Connect mySQL
 */
package abc.database;
import java.sql.*;
/**
 * @author ckm
 */
public class Database1 {
    public static void main(String[] args) throws Exception{
    Class.forName("com.mysql.jdbc.Driver");
    Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/example?useUnicode=true&characterEncoding=UTF-8","tiger","scott");
    PreparedStatement ps = connect.prepareStatement("select * from content");
    ResultSet result = ps.executeQuery();
    
        while (result.next()) {
            System.out.println("ID :" + result.getString("ID"));
            System.out.println("Comment :" + result.getString("comment"));
            System.out.println("-----------------");
        }//while
        ps.close();
        connect.close();
    }//void
}//main
