package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class CreatingConnection {
 
    public static Connection connect(){
	Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loading success!");
            
            String url = "jdbc:mysql://localhost/tweetscollection";
            String name = "root";
            String password = "hctib1280EVOM";
            //System.out.print("¬ведите пароль: ");
	    //Scanner scan = new Scanner(System.in);
	    //String password = scan.nextLine();
	    //scan.close();
            try {
                con = DriverManager.getConnection(url, name, password);
                System.out.println("Connected.");
               // con.close();
               // System.out.println("Disconnected.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        return con;
    }
}