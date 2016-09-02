package lab1;

import java.awt.Polygon;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import DataBase.CreatingConnection;
import DataBase.CreatingDatabase;
import DataBase.CreatingDatabaseTable;
import DataBase.DatabaseGet;
import DataBase.DatabaseInsert;
import Drawing.MyFrame;
import Drawing.MyPolygon;

import java.util.ArrayList;

import Sentiment.Sentiment;
import Sentiment.SentimentAnalyze;
import State.State;
import State.StateAnalyze;
import Tweet.Tweet;
import Tweet.TweetPrint;
import Tweet.TweetAnalyze;
import Reports.EmotionWeightReport;
import Reports.HashtagReport;
import Reports.MostHotStateReport;
import Reports.ReportParams;

//ONE-THREAD RUN - 55 sec
//MULTI THREADING RUN - 52 sec
public class Program {
	/*
	 D:\\studies\\Java\\trends\\trends\\data\\all_tweets.txt
D:\\studies\\Java\\trends\\trends\\data\\sentiments.csv
D:\\studies\\Java\\trends\\trends\\data\\states.json
	 */
	
	public static ArrayList<Tweet> tweetsCollection;
	public static TweetAnalyze tweetAnlz;
	
	public static ArrayList<Sentiment> sentsCollection;
	public static SentimentAnalyze sentAnlz;
	
	public static ArrayList<State> statesCollection;
	public static StateAnalyze stateAnlz;
	
	public static HashtagReport report1;
	public static ArrayList<Tweet> tweetsReport;
	
	public static EmotionWeightReport report2;
	public static double mood;
	
	public static MostHotStateReport report3;
	public static State mostHotState;
	
	public static void main(final String[] args) throws InterruptedException, SQLException{
		tweetsCollection  = new ArrayList<Tweet>();
		// = new TweetAnalyze(args[0]);
		
		Thread tweetReadThread = new Thread() {
			public void run() {
				try {
					tweetAnlz = new TweetAnalyze(args[0]);
				}
				catch (Exception ex) { }
	            }
	        };
	        Thread tweetParseThread = new Thread() {
				public void run() {
					try {
						tweetAnlz.getItems(tweetsCollection);
					}
					catch (Exception ex) { }
		            }
		        };
	        //Thread thread = new Thread(runnable);
	        
		//tweetAnlz.print.consoleOutput(tweetsCollection);
	    sentsCollection = new ArrayList<Sentiment>();
	        Thread sentReadThread = new Thread() {
				public void run() {
					try {
						sentAnlz = new SentimentAnalyze(args[1]);
					}
					catch (Exception ex) { }
		            }
		        };
		        Thread sentParseThread = new Thread() {
					public void run() {
						try {
							sentAnlz.getItems(sentsCollection);
						}
						catch (Exception ex) { }
			            }
			        };

		//sentAnlz.print.consoleOutput(sentsCollection);
		statesCollection = new ArrayList<State>();
		     Thread stateReadThread = new Thread() {
		    	 public void run() {
		    		 try {
		    			 
		    			 stateAnlz = new StateAnalyze(args[2]);
		    			 }
		    		 catch (Exception ex) { }
		    		 }
		    	 };
		    	 Thread stateParseThread = new Thread() {
			    	 public void run() {
			    		 try {
			    			 
			    			 stateAnlz.getItems(statesCollection);
			    			 }
			    		 catch (Exception ex) { }
			    		 }
			    	 };
			    	 Thread stateMoodThread = new Thread() {
				    	 public void run() {
				    		 try {
				    			 for(int i = 0; i < statesCollection.size(); i++) {
				    					statesCollection.get(i).emotionWeight(sentsCollection, tweetsCollection);
				    					//System.out.println(state.mood);
				    				}
				    			 }
				    		 catch (Exception ex) { }
				    		 }
				    	 };
		        
		//stateAnlz.print.consoleOutput(statesCollection);
		//System.out.println(statesCollection.size());
				    	 
	    //REPORTS THREADS
		String hashtag = "#WINNING";
		Date startDate = MyRegExpressions.getDate("2011-08-20 07:00:00");
		Date endDate = MyRegExpressions.getDate("2011-08-20 13:00:00");
		
		final ReportParams params = new ReportParams(hashtag, startDate, endDate, tweetsCollection, sentsCollection, statesCollection);
			 		
		Thread hashtagReportThread = new Thread() {
			public void run() {
				try {
					report1 = new HashtagReport();
					tweetsReport = new ArrayList<Tweet>();
					tweetsReport = report1.getReport(params);
					}
				catch (Exception ex) { }
				}
			};
		
			Thread emotionWeightReportThread = new Thread() {
				public void run() {
					try {
						report2 = new EmotionWeightReport();
						mood = report2.getReport(params);
						}
					catch (Exception ex) { }
					}
				};
				
				Thread mostHotStateReportThread = new Thread() {
					public void run() {
						try {
							MostHotStateReport report3 = new MostHotStateReport();
							mostHotState = report3.getReport(params);
							}
						catch (Exception ex) { }
						}
					};

					
		Thread drawMapThread = new Thread() {
			public void run() {
				try {
					MyFrame.drawMap(statesCollection);
					}
				catch (Exception ex) { }
				}
			};
			
		tweetReadThread.start();
		sentReadThread.start();
		stateReadThread.start();
		
		tweetReadThread.join();
		sentReadThread.join();
		stateReadThread.join();
		
		tweetParseThread.start();
		sentParseThread.start();
		stateParseThread.start();
		
		tweetParseThread.join();
		sentParseThread.join();
		stateParseThread.join();
		
		stateMoodThread.start();
		stateMoodThread.join();
		
		hashtagReportThread.start();		
		emotionWeightReportThread.start();
		mostHotStateReportThread.start();
		
		hashtagReportThread.join();
		emotionWeightReportThread.join();
		mostHotStateReportThread.join();
		
		//System.out.println(MyRegExpressions.dateToString(tweetsCollection.get(0).date));
		
//		drawMapThread.start();
//		drawMapThread.join();
		
//		tweetAnlz.print.consoleOutput(tweetsCollection);
//		sentAnlz.print.consoleOutput(sentsCollection);
//		stateAnlz.print.consoleOutput(statesCollection);
//			
//		tweetAnlz.print.consoleOutput(tweetsReport);
//		System.out.println(mood);
//		System.out.println(mostHotState.toString());	
//		
		
		Connection con = CreatingConnection.connect();
//		CreatingDatabase.creatDatabase(con);
//		CreatingDatabaseTable.createDbUserTable(con, "tweets");

//		DatabaseInsert d = new DatabaseInsert(con);
//		
//		int i = 1; 
//		for (Tweet tw : tweetsCollection) { 
//			d.insertTweet(tw, i);
//			i++;
//			}
//		
//		 int j = 1;
//		 for (Sentiment s : sentsCollection) {
//			 d.insertSentiment(s, j); 
//			 j++;
//			 }
//
//		 int k = 1; for (State st : statesCollection) { 
//			 d.insertState(st, k);
//			 k++;
//			 }
		 
//		DatabaseGet DBget = new DatabaseGet(con);
//		Tweets tweetsFromDB = DBget.getAllTweets();
//		tweetsFromDB.Print();
//
//		Sentiments sentimentsFromDB = DBget.getAllSentiments();
//		sentimentsFromDB.Print();
//
//		 States statesFromDB = DBget.getAllStates();
//		 statesFromDB.Print();

//		 DatabaseUpdate update = new DatabaseUpdate(con);
//		 update.update("tweetstable", " SET tweet = 'qwe' WHERE id = 1");
//		 update.update("sentiments", " SET price = 123 WHERE id = 1");
//		 update.update("states", " SET Statename = 'QAZ' WHERE id = 1");

//		DatabaseDelete del = new DatabaseDelete(con);
//		del.delete("tweetstable", " WHERE id = 5");
//		del.delete("sentiments", " WHERE id = 5");
//		del.delete("states", " WHERE id = 5");
		
		DatabaseGet get = new DatabaseGet(con);
		ArrayList<Tweet> tweets = new ArrayList<Tweet>();
		tweets = get.getAllTweets();
		System.out.println(tweets.get(0).toString());
	}
}
