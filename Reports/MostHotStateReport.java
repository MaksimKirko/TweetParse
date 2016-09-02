package Reports;

import java.awt.Polygon;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import Drawing.MyPolygon;
import State.State;
import Tweet.Tweet;

/**
 * Class for report #3
 * @author Max
 *
 */
public class MostHotStateReport implements IReport<State> {
	/**
	 * Returns state with the biggest mood on some timespan
	 * @param params
	 */
	public State getReport(ReportParams params) {
        Map<String, Integer> numberOfReiterations = new HashMap<String, Integer>();
        int multiplier = 1000000;
        for (State state : params.getStates()) {
            int count = 0;
            for (Tweet tweet : params.getTweets()) {
                if (tweet.date.getTime() >= params.getStartDate().getTime() && tweet.date.getTime() >= params.getEndDate().getTime()) {
                	MyPolygon myPol = new MyPolygon();
                    Polygon polygon = myPol.buildPolygon(state);
                    int x = (int)(tweet.coords.x * multiplier);
                    int y = (int)(tweet.coords.y * multiplier);
                    if (polygon.contains(x, y)) {
                        count++;
                    }
                }
            }
            numberOfReiterations.put(state.name, count);
        }
        
        Map.Entry<String,Integer> maxEntry = null;
        for (Map.Entry<String,Integer> temp : numberOfReiterations.entrySet()){
            if(maxEntry == null || temp.getValue() > maxEntry.getValue())
            {
                maxEntry = temp;
            }
        }
        
        return State.getByName(maxEntry.getKey(), params.getStates());
    }
}
