package Sentiment;

import lab1.IParse;

public class SentimentParse implements IParse<Sentiment> {
	public Sentiment parse(String line) {
		Sentiment sent = new Sentiment();
		String[] str = line.split("\\,");
		sent.word = str[0];
		sent.weight = Double.parseDouble(str[1]);
		
		return sent;
	}
}
