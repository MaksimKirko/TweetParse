package State;

import lab1.IPrint;

import java.util.ArrayList;

import lab1.Coords;

/**
 * Class for printing states
 * @author Max
 *
 */
public class StatePrint implements IPrint<State> {
	/**
	 * Print state object to console
	 * @param state
	 */
	public void consoleOutput(State state) {
		System.out.println("Name: " + state.name);
		for(Coords coords : state.coords) {
			System.out.println(coords.x + " " + coords.y);
		}
	}
	
	/**
	 * Print ArrayList of states to console
	 * @param states
	 */
	public void consoleOutput(ArrayList<State> states) {
		for(State state : states) {
			System.out.println("Name: " + state.name);
			for(Coords coords : state.coords) {
				System.out.println(coords.x + " " + coords.y);
			}
		}
	}
}
