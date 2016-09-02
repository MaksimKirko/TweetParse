package Reports;

import Tweet.Tweet;
import lab1.Coords;

import java.awt.Polygon;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import Sentiment.Sentiment;
import State.State;
import Drawing.MyPolygon;

/**
 * Class for report #1
 * @author Max
 *
 */
public class HashtagReport implements IReport<ArrayList<Tweet>>{
	/**
	 * Returns tweets with set hastag
	 * @param params
	 */
	public ArrayList<Tweet> getReport(ReportParams params) {
		ArrayList<Tweet> results = new ArrayList<Tweet>();
		
		for(Tweet t : params.getTweets()) {
			if(t.info.contains(params.getHashtag())) {
				results.add(t);
			}
		}
		
		return results;
	}
}
