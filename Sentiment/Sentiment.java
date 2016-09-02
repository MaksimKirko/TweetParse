package Sentiment;

public class Sentiment {
	public String word;
	public double weight;
	
	public Sentiment() {
		word = "";
		weight = 0;
	}
	
	@Override
	public String toString() {
		return word + " " + weight;
	}
}
