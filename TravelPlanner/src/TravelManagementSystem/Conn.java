package TravelManagementSystem;

import java.sql.*;

public class Conn {

    Connection c ;
    Statement s ;

    Conn()
    {
        
        try {
            //  Class.forName("com.mysql.cj.jdbc.Driver");   
             c = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelmanagementsystem","root","");
    
            if (c != null) {
                System.out.println("Connection Success");
            } else {
                System.out.println("Connection failed");
            };    
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}