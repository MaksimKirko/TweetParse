package Reports;

/**
 * Interface for getting report
 * @author Max
 *
 * @param <T>
 */
public interface IReport<T> {
	public T getReport(ReportParams params);
}
