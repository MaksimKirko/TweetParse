package lab1;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyRegExpressions {
	public static String dateToString(Date date) {
		String line = "";
		line += date.toLocaleString();
		return line;
	}
	
	public static Date getDateFromDB(String line) {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
		try {
			date = format.parse(line);
		}
		catch(Exception ex){
            System.out.println(ex.getMessage());
        }
		return date;
	}
	
	public static Date getDate(String line) {	
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			date = format.parse(line);
		}
		catch(Exception ex){
            System.out.println(ex.getMessage());
        }
		return date;
    }
    
    public static Coords getCoords(String line)
    {
        line = line.replaceAll("\\[|\\]","");
        String[] mas = line.split(",");
        Coords coords = new Coords(Double.parseDouble(mas[0]), Double.parseDouble(mas[1]));
        return coords;
    }
    
    public static ArrayList<Coords> getCoordsList(String line)
    {
        ArrayList<Coords> coords = new ArrayList<>();
        Pattern pat1 = Pattern.compile("\\[(.*?),(.*?)\\]");
        Matcher matcher = pat1.matcher(line);
        while(matcher.find())
        {
            String temp = matcher.group().toString();
            Coords c = getCoords(temp);
            coords.add(c);
        }
        return coords;
    }
}
