package DataBase;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseDelete {

    Connection connection;
    String delete = "DELETE FROM ";
    
    public DatabaseDelete() {

    }

    public DatabaseDelete(Connection connection) {
	this.connection = connection;
    }

    public void delete(String tablename, String condition) {
	Statement statement;
	try {
	    statement = connection.createStatement();
	    statement.execute(delete + tablename + condition);
	    System.out.println("Delete complete!");
	} catch (SQLException e) {
	    System.out.println(e.getMessage());
	}
    }
    
}
