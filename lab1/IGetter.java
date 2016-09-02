package lab1;

import java.util.ArrayList;

/**
 * Interface for get items from some source to ArrayList of objects
 * @author Max
 *
 * @param <T>
 */
public interface IGetter<T> {
	public void getItems(ArrayList<T> t);
}
