package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreatingDatabase {

    private final static String createDatabaseQyery = "CREATE DATABASE tweetsCollection CHARACTER SET utf8 COLLATE utf8_general_ci";

    public static void creatDatabase(Connection con) {

	Connection connection = con;
	Statement statement = null;

	try {
	    statement = connection.createStatement();
	    statement.executeUpdate(createDatabaseQyery);
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	   if (statement != null) {
		try {
		    statement.close();
		} catch (SQLException e) {
		    e.printStackTrace();
		}
	    }
	    if (connection != null) {
		try {
		    connection.close();
		} catch (SQLException e) {
		    e.printStackTrace();
		}
	    }
	}
    }
}