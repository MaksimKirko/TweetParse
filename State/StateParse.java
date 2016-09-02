package State;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lab1.Coords;
import lab1.IParse;
import lab1.MyRegExpressions;

/**
 * Class for parse items(states) from String text
 * @author Max
 *
 */
public class StateParse implements IParse<State> {
	/**
	 * Returns an object of state from String
	 * @param line
	 */
	public State parse(String line) {
		State state = new State();
		String[] str = line.split("\"");
		state.name = str[1];
		String[] coord = str[2].split("\\[|\\]");
		for(int i = 0; i < coord.length; i++) {
			if(i % 2 != 0) {
				str = coord[i].split(", ");
				state.coords.add(new Coords(Double.parseDouble(str[0]), Double.parseDouble(str[1])));
			}
		}
		
		if(state.name == "\\s*") {
			return null;
		}
		return state;
	}
}
