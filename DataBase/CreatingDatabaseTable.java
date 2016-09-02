package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreatingDatabaseTable {
    
    public static void createDbUserTable(Connection con,String str) throws SQLException {
	    Connection dbConnection = null;
	    Statement statement = null;
	 
	    String createTableSQL = "";
	    
	    if(str != "") {
	    	//createTableSQL = "CREATE TABLE " + str +  "(id int(11),X double(30),Y double(30),date varchar(30),info varchar(150))";
	    	createTableSQL = "CREATE TABLE " + str +
	                   "(id INTEGER not NULL, " +
	                   "X DOUBLE not NULL, " +
	                   "Y DOUBLE not NULL, " +
	                   "date VARCHAR(255), " +
	                   "info VARCHAR(255))"; 
	    }
	    
	    try {
	        dbConnection = con;
	        statement = dbConnection.createStatement();
	        statement.execute(createTableSQL);
	        
	        System.out.println("Table is created!");
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    } finally {
	        if (statement != null) {
	            statement.close();
	        }

	    }
    }
}
