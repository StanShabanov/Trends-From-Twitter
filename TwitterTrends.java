import java.util.*;
import java.io.*;

//The TwitterTrends class is responsible for analyzing tweets and finding the most frequently used word in the tweets.
//It requires an instance of TweetBot to work with, which contains a list of tweets.
public class TwitterTrends {
    private TweetBot TwitterTrends;
    private Scanner scan;
    //Constructor for the TwitterTrends class. Initializes a new instance with a given TweetBot object.
    //parameters: bot the TweetBot object to be used for analysis
    //returns: none
    public TwitterTrends(TweetBot bot){
        TwitterTrends = bot;
    }
    //Returns the most frequently used word in the list of tweets contained in the TweetBot object.
    //parameters: none
    //returns: a String representing the most frequently used word in the list of tweets
    public String getMostFrequentWord(){
        Map<String, Integer> wordCount = new HashMap<>();

        for(int i = 0; i < TwitterTrends.numTweets(); i++){
            scan = new Scanner(TwitterTrends.nextTweet());
            while(scan.hasNext()){
                String nextWord = scan.next().toLowerCase();
                if(!wordCount.containsKey(nextWord)){
                    wordCount.put(nextWord, 1);
                }
                else{
                    wordCount.put(nextWord, wordCount.get(nextWord) + 1);
                }
            }
        }
        String mostFrequentWord = max(wordCount);
        return mostFrequentWord;
    }
    //This method finds the max of each word that is passed through
    //Parameters: Map string to the amount of occurence represented as an int
    //Returns: a String representing the most frequently used word in the list of tweets
    public String max(Map<String, Integer> wordCount){
        int max = 0;
        String mostFrequentWord = "";
        for (String commonWord : wordCount.keySet()){
            int max1 = wordCount.get(commonWord);
            if(max1 > max){
                mostFrequentWord = commonWord;
                max = max1;
            }
        }
        return mostFrequentWord;
    }
    //This method finds flagged words related to covid and give a disclaimer
    //Parameters: none
    //Returns: none
    public void wordsUsingCovid(){
        boolean wordsUsingCovid = false;
        for(int i = 0; i < TwitterTrends.numTweets(); i++){
            scan = new Scanner(TwitterTrends.nextTweet());
            while(scan.hasNext()){
                String covid = scan.next();
                if(covid.equalsIgnoreCase("pandemic") || covid.equalsIgnoreCase("covid")){
                    wordsUsingCovid = true;
                }
            }
        }

        if(wordsUsingCovid == true){
            System.out.println("DISCLAIMER: This might contain misinformation");
            System.out.println("For more correct information, check out CDC at: https://www.cdc.gov/");
        }
    }
}
