package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUpdate {

    Connection connection;
    String update = "UPDATE ";

    public DatabaseUpdate() {

    }

    public DatabaseUpdate(Connection connection) {
	this.connection = connection;
    }

    public void update(String tablename, String condition) {
	Statement statement;
	try {
	    statement = connection.createStatement();
	    statement.execute(update + tablename + condition);

	    System.out.println("Update complete!");
	} catch (SQLException e) {
	    System.out.println(e.getMessage());
	}
    }
}
