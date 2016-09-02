package State;

import java.awt.Polygon;
import java.util.ArrayList;

import Drawing.MyPolygon;
import Sentiment.Sentiment;
import Tweet.Tweet;
import lab1.Coords;

/** 
 * Class prevents type State with coordinates date and info of this tweets
 * @author Max
*/
public class State {
	public String name;
	public ArrayList<Coords> coords;
	public double mood;
	
	/**
	 * Make new empty object
	 */
	public State() {
		name = "";
		coords = new ArrayList<Coords>();
		mood = 0;
	}
	
	/**
	 * Returns String format of state object
	 */
	@Override
	public String toString() {
		String str = name;
		for(Coords coord : coords) {
			str += " " + coords.toString();
		}
		return str;
	}
	
	/**
	 * Returns State object by it's name
	 * @param name
	 * @param statesCollection
	 * @return state
	 */
	public static State getByName(String name, ArrayList<State> statesCollection) {
		for(State state : statesCollection) {
			if(name == state.name) {
				return state;
			}
		}
		return null;
	}
	
	/**
	 * Set property mood of State
	 * @param sentsCollection
	 * @param tweetsCollection
	 */
	public void emotionWeight(ArrayList<Sentiment> sentsCollection, ArrayList<Tweet> tweetsCollection) {
		int multiplier = 1000000;
		for(Tweet tweet : tweetsCollection) {
			MyPolygon myPol = new MyPolygon();
            Polygon polygon = myPol.buildPolygon(this);
            int x = (int)(tweet.coords.x * multiplier);
            int y = (int)(tweet.coords.y * multiplier); 
            if (polygon.contains(x, y)) {
                this.mood += tweet.emotionWeight(sentsCollection);
            }
		}
	}
}
