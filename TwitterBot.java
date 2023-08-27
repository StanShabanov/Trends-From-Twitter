import java.util.*;
import java.io.*;

//TweetBot is a class that represents a collection of tweets,
//it allows for adding new tweets and iterating through all tweets in the collection.

public class TweetBot {
    private List<String> tweetsList;
    private int index;
    //Constructor for the TweetBot class. Takes in a List of tweets and initializes the TweetBot object.
    //Throws an IllegalArgumentException if the List of tweets is empty.
    //paramater: tweets A List of Strings representing the tweets.
    //returns: none
    public TweetBot(List<String> tweets) {
        tweetsList = new LinkedList<String>();
        if(tweets.size() < 1){
            throw new IllegalArgumentException();
        }

        for(int i = 0; i < tweets.size(); i++){
            tweetsList.add(tweets.get(i));
        }
        index = 0;
    }
    //Returns the number of tweets managed by the TweetBot.
    //Parameters: none
    //returns: tweets, An integer representing the number of tweets managed by the TweetBot.
    public int numTweets() {
        return tweetsList.size();
    }
    //Adds a tweet to the List of tweets managed by the TweetBot.
    //parameter: tweet A String representing the tweet to be added.
    //returns: none
    public void addTweet(String tweet) {
        tweetsList.add(tweet);
    }
    //Returns the next tweet in the List of tweets managed by the TweetBot.
    //If the end of the List is reached, the Iterator is reset to the beginning of the List.
    //paramaters: none
    //returns: A String representing the next tweet in the List of tweets managed by the TweetBot.
    public String nextTweet() {
        if(index < tweetsList.size()){
            String tweet = tweetsList.get(index);
            index++;
            return tweet;
        }else{
            index = 1;
            return tweetsList.get(0);
        }
    }
    //Removes a tweet from the List of tweets managed by the TweetBot. If the tweet is not found in the List, no action is taken.
    //If the tweet is found, it is removed and the Iterator is reset to the tweet immediately after the removed tweet.
    //parameters: tweet A String representing the tweet to be removed.
    //returns: none
    public void removeTweet(String tweet) {
        if (!tweetsList.contains(tweet)) {
            return;
        }
        if(index > tweetsList.indexOf(tweet)){
            index -= 1;
        }
        
        
        tweetsList.remove(tweetsList.indexOf(tweet)); 
    }

    //Resets the Iterator to the beginning of the List of tweets managed by the TweetBot.
    //paramaters: none
    //returns: none
    public void reset() {
        index = 0;
    }
}   
