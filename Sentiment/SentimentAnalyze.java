package Sentiment;

import java.util.ArrayList;

import lab1.IGetter;
import lab1.IParse;
import lab1.IPrint;
import lab1.Read;

public class SentimentAnalyze implements IGetter<Sentiment> {
	public Read read;
	public IPrint<Sentiment> print;
	private IParse<Sentiment> parse;
	private ArrayList<String> text;
	
	public SentimentAnalyze(String filename) {
		read = new Read();
		read.setNumber(1000);
		text = read.Read(filename);
		parse = new SentimentParse();
		print = new SentimentPrint();
	}
	
	public void getItems(ArrayList<Sentiment> sents) {
		for(String line : text) {
			Sentiment sent = new Sentiment();
			sent = parse.parse(line);
			if(sent != null) {
				sents.add(sent);
				//System.out.println(sent.toString());
			}
		}
	}
}
