package lab1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Read {
	private int number;
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public ArrayList<String> Read(String filename) {
		ArrayList<String> textList = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
	        String line;
	        int begin = 0;
	        int i = 0;
	        while ((line = reader.readLine()) != null && i != begin + number) {
	        	if(i >= begin && i < begin + number) {
	        		//System.out.println(line);
	        		textList.add(line);
	        	}
	        	i++;
	        }
	        reader.close();
		}
		catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
		return textList;
	}
}