package Sentiment;

import java.util.ArrayList;

import lab1.IPrint;

public class SentimentPrint implements IPrint<Sentiment> {
	public void consoleOutput(Sentiment sent) {
		System.out.println("Word: " + sent.word + "; weight: " + sent.weight);
	}
	
	public void consoleOutput(ArrayList<Sentiment> sentsList) {
		for(Sentiment sent : sentsList) {
			System.out.println("Word: " + sent.word + "; weight: " + sent.weight);
		}
	}
}
