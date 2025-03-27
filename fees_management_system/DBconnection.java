/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fees_management_system;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author N AKSHAYA
 */
public class DBconnection {
    public static Connection getConnection(){
        Connection con=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/feemanagementsystem?zeroDateTimeBehavior=CONVERT_TO_NULL","root","Ram@1014");
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        return con;
    }
}
    
    

