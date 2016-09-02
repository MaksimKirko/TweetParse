package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Sentiment.Sentiment;
import State.State;
import Tweet.Tweet;
import lab1.Coords;
import lab1.MyRegExpressions;

public class DatabaseGet {

    Connection connection;
    String query = "SELECT * from tweets";
    String querySentiments = "SELECT * from sentiments";
    String queryStates = "SELECT * from states";

    public DatabaseGet() {
    }

    public DatabaseGet(Connection connection) {
	this.connection = connection;
    }

    public DatabaseGet(Connection connection, String query) {
	this.connection = connection;
	this.query = query;
    }

    public ArrayList<Tweet> getAllTweets() {
    	ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	PreparedStatement preparedStatement = null;
	try {
	    preparedStatement = connection.prepareStatement(query);
	    ResultSet result = preparedStatement.executeQuery();

	    while (result.next()) {
	    	Tweet tw = new Tweet();
	    	tw.coords = new Coords(result.getDouble("X"), result.getDouble("Y"));
	    	try {
	    		tw.date = MyRegExpressions.getDateFromDB(result.getString("date"));
	    	}
	    	catch(Exception ex) {}
	    	tw.info = result.getString("info");
	    	tweets.add(tw);
	    	}
	    } 
	catch (SQLException e) {
		e.printStackTrace();
		}
	return tweets;
	}
    
    public ArrayList<Sentiment> getAllSentiments() {
    	ArrayList<Sentiment> sentiments = new ArrayList<Sentiment>();
	PreparedStatement preparedStatement = null;
	try {
	    preparedStatement = connection.prepareStatement(querySentiments);
	    ResultSet result = preparedStatement.executeQuery();

	    while (result.next()) {
	    	Sentiment st = new Sentiment();
	    	st.weight = result.getDouble("weight");
	    	st.word = result.getString("word");
	    	sentiments.add(st);
	    	}
	    }
	catch (SQLException e) {
		e.printStackTrace();
		}
	return sentiments;
	}
    
    public ArrayList<State> getAllStates() {
    	ArrayList<State> states = new ArrayList<State>();
    	PreparedStatement preparedStatement = null;
    	try {
    		preparedStatement = connection.prepareStatement(queryStates);
    		ResultSet result = preparedStatement.executeQuery();
    		while (result.next()) {
    			State st = new State();
    			st.name = result.getString("word");
    			states.add(st);
    			}
    		}
    	catch (SQLException e) {
    		e.printStackTrace();
    		}
    	return states;
    	}
    }

