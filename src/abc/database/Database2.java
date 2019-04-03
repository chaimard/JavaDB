/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc.database;
import java.sql.*;
/**
 *
 * @author ckm
 */
public class Database2 {
    
    public void connection() throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection connect = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;integratedSecurity=true;");
        PreparedStatement ps = connect.prepareStatement("select * from Room.dbo.User1");
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()){
            System.out.println("ID :" + rs.getString("UserId"));
            System.out.println("Name :" + rs.getString("UserFname"));
            System.out.println("-----------------");
        }//while
         ps.close();
        connect.close();
    
    }//connection
    
}//main
