package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Sentiment.Sentiment;
import State.State;
import Tweet.Tweet;
import lab1.MyRegExpressions;

public class DatabaseInsert {

    private Connection connection;
    private String query = "INSERT INTO tweets VALUES(?, ?, ?, ?, ?)";
    private String querySentiment = "INSERT INTO sentiments VALUES(?, ?, ?)";
    private String queryState = "INSERT INTO states VALUES(?, ?)";

    public DatabaseInsert() {

    }

    public DatabaseInsert(Connection connection) {
	this.connection = connection;
    }

    public DatabaseInsert(Connection connection, String query) {
	this.connection = connection;
	this.query = query;
    }

    public void insertTweet(Tweet tweet, int id) {
	PreparedStatement preparedStatement = null;

	try {
	    //java.sql.Date sqlDate = new java.sql.Date(tweet.date.getTime());

	    preparedStatement = connection.prepareStatement(query);
	    preparedStatement.setInt(1, id);
	    preparedStatement.setDouble(2, tweet.coords.x);
	    preparedStatement.setDouble(3, tweet.coords.y);
	    preparedStatement.setString(4, MyRegExpressions.dateToString(tweet.date));
	    preparedStatement.setString(5, tweet.info);

	    preparedStatement.execute();

	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
    
    public void insertSentiment(Sentiment sentiment, int id) {
	PreparedStatement preparedStatement = null;

	try {
	    preparedStatement = connection.prepareStatement(querySentiment);
	    preparedStatement.setInt(1, id);
	    preparedStatement.setString(2, sentiment.word);
	    preparedStatement.setDouble(3, sentiment.weight);
	    preparedStatement.execute();

	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
    
    
    public void insertState(State state, int id) {
	PreparedStatement preparedStatement = null;
	ArrayList<Double> a = new ArrayList<Double>();
	a.add(state.coords.get(0).x);
	a.add(state.coords.get(0).y);
	try {
	    preparedStatement = connection.prepareStatement(queryState);
	    preparedStatement.setInt(1, id);
	    preparedStatement.setString(2, state.name);

	    preparedStatement.execute();

	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
    
    

}
