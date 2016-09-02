package lab1;

import java.util.ArrayList;

/**
 * Interface for printing objects
 * @author Max
 *
 * @param <T>
 */
public interface IPrint<T> {
	public void consoleOutput(T t);
	public void consoleOutput(ArrayList<T> t);
}
