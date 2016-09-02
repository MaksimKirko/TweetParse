package lab1;

/**
 * Interface for parsing objects
 * @author Max
 *
 * @param <T>
 */
public interface IParse<T> {
	public T parse(String line);
}
