package Reports;

import java.util.ArrayList;
import java.util.Date;

import Sentiment.Sentiment;
import State.State;
import Tweet.Tweet;

/**
 * Class prevents parameters for report
 * @author Max
 *
 */
public class ReportParams {
	private String hashtag;
	private Date startDate;
	private Date endDate;
	private ArrayList<Sentiment> sentsCollection;
	private ArrayList<Tweet> tweetsCollection;
	private ArrayList<State> statesCollection;
	
	/**
	 * Returns new object with set properties
	 * @param hashtag
	 * @param startDate
	 * @param endDate
	 * @param tweetsCollection
	 * @param sentsCollection
	 * @param statesCollection
	 */
	public ReportParams(String hashtag, Date startDate, Date endDate, ArrayList<Tweet> tweetsCollection,
			ArrayList<Sentiment> sentsCollection, ArrayList<State> statesCollection) {
		this.hashtag = hashtag;
		this.startDate = startDate;
		this.endDate = endDate;
		this.sentsCollection = sentsCollection;
		this.tweetsCollection = tweetsCollection;
		this.statesCollection = statesCollection;
	}
	
	/**
	 * @return hashtag
	 */
	public String getHashtag() {
		return this.hashtag;
	}
	
	/**
	 * @return startDate
	 */
	public Date getStartDate() {
		return this.startDate;
	}
	
	/**
	 * @return endDate
	 */
	public Date getEndDate() {
		return this.endDate;
	}
	
	/**
	 * @return sentsCollection
	 */
	public ArrayList<Sentiment> getSentiments() {
		return this.sentsCollection;
	}
	
	/**
	 * @return tweetsCollection
	 */
	public ArrayList<Tweet> getTweets() {
		return this.tweetsCollection;
	}
	
	/**
	 * @return statesCollection
	 */
	public ArrayList<State> getStates() {
		return this.statesCollection;
	}
}
