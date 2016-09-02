package Tweet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import lab1.IPrint;

/**
 * Class for printing tweets
 * @author Max
 *
 */
public class TweetPrint implements IPrint<Tweet> {
	/**
	 * Output tweet object to console
	 * @param tweet
	 */
	public void consoleOutput(Tweet tweet) {
		if(tweet != null) {		
			System.out.println("Coords: " + tweet.coords.x + " " + tweet.coords.y);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			System.out.println("Date: " + format.format(tweet.date));
			System.out.println("Info: " + tweet.info);
		}
	}
	
	/**
	 * Output Arraylist of tweets to console
	 * @param tweetList
	 */
	public void consoleOutput(ArrayList<Tweet> tweetList) {
		for(Tweet tweet : tweetList) {
			if(tweet != null) {
				System.out.println("Coords: " + tweet.coords.x + " " + tweet.coords.y);
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				System.out.println("Date: " + format.format(tweet.date));
				System.out.println("Info: " + tweet.info);
			}
		}
	}
}
