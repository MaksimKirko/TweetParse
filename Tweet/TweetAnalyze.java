package Tweet;

import lab1.IGetter;
import lab1.IParse;
import lab1.IPrint;
import lab1.Read;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * Class for analyzing tweets
 * @author Max
 */
public class TweetAnalyze implements IGetter<Tweet> {
	public Read read;
	public IPrint<Tweet> print;
	private IParse<Tweet> parse;
	private ArrayList<String> text;
	
	/**
	 *  Make new object with set filename
	 * @param filename
	 */
	public TweetAnalyze(String filename) {
		read = new Read();
		read.setNumber(1000);
		text = read.Read(filename);
		parse = new TweetParse();
		print = new TweetPrint();
	}
	
	/**
	 *  Get items(tweets) from file
	 *  @param tweetList
    */
	public void getItems(ArrayList<Tweet> tweetList) {
		for (String line : text) {
            Tweet tweet = parse.parse(line);
            if (tweet != null) {
                tweetList.add(tweet);
                //System.out.println(tweet.toString());
            }
        }
	}
}
