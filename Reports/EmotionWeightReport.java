package Reports;

import java.util.ArrayList;
import java.util.Date;

import Sentiment.Sentiment;
import Tweet.Tweet;

/**
 * Class for report #2
 * @author Max
 *
 */
public class EmotionWeightReport implements IReport<Double> {
	/**
	 * Returns emotinal weight on some timespan
	 * @param params
	 */
	public Double getReport(ReportParams params) {
		double weight = 0;
		for(Tweet t : params.getTweets()) {
			if(t.date.getTime() >= params.getStartDate().getTime() && t.date.getTime() >= params.getEndDate().getTime()) {
				weight += t.emotionWeight(params.getSentiments());
			}
		}
		return weight;
	}
}
