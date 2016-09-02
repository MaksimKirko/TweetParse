package Tweet;

import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

import lab1.IParse;
import lab1.MyRegExpressions;

/**
 * Class for parse items(tweets) from String text
 * @author Max
 *
 */
public class TweetParse implements IParse<Tweet> {
	/**
	 * Returns an object of tweet from String
	 * @param line
	 */
	public Tweet parse(String line) {
		try {
        	Tweet tw = new Tweet();
            Pattern pat = Pattern.compile("\\t");
            String[] mas = pat.split(line);
            tw.coords = MyRegExpressions.getCoords(mas[0]);
            tw.date = MyRegExpressions.getDate(mas[2]);
            tw.info = mas[3];
            return tw;
        }
        catch (Exception e)
        {

        }
        return null;
	}
}