package Tweet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Sentiment.Sentiment;
import lab1.Coords;

/** 
 * Class prevents type Tweet with coordinates< date and info of this tweets
 * @author Max
*/
public class Tweet {
	public Coords coords;
	public Date date;
	public String info;
	
	/**
	 *  Make new empty object.
    */
	public Tweet() {
		coords = new Coords();
		coords.x = 0.00;
		coords.y = 0.00;
		date = new Date(); 
		info = "";
	}
	
	/** 
	 * Returns string format of Tweet object 
    */
	@Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return coords.toString() + " " + format.format(date.getTime()) + " " + info;
    }
	
	/** 
	 * Returns an emotional weight of Tweet object
	 * @param sentsCollection
    */
	public double emotionWeight(ArrayList<Sentiment> sentsCollection) {
		double weight = 0;
		for(Sentiment sent : sentsCollection) {
			if(this.info.contains(sent.word)) {
				weight += sent.weight;
			}
		}
		return weight;
	}
}