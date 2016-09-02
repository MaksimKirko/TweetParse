package State;

import java.util.ArrayList;

import Tweet.Tweet;
import lab1.IParse;
import lab1.IPrint;
import lab1.Read;

/**
 * Class for analyzing states
 * @author Max
 *
 */
public class StateAnalyze {
	public Read read;
	public IPrint<State> print;
	private IParse<State> parse;
	private ArrayList<String> text;
	
	/**
	 * Make new object with set filename
	 * @param filename
	 */
	public StateAnalyze(String filename) {
		read = new Read();
		read.setNumber(100);
		text = read.Read(filename);
		parse = new StateParse();
		print = new StatePrint();
	}
	
	/**
	 * Get items(states) from file
	 * @param states
	 */
	public void getItems(ArrayList<State> states) {
		for (String line : text) {
            State state = parse.parse(line);
            if (state != null) {
                states.add(state);
                //System.out.println(state.toString());
            }
        }
	}
}
