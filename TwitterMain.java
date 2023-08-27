//Stan Shabanov
//2/22/2023
//Twitter Trends
import java.util.*;
import java.io.*;
//Twitter main It reads in a file of tweets using a Scanner, creates a TweetBot object with a 
//list of tweets, and creates a TwitterTrends object that uses the TweetBot object. It then 
//calls the getMostFrequentWord method of the TwitterTrends object to find the most frequent 
//word in the tweets, and the analyzeTweets method to perform some analysis on the tweets.
public class TwitterMain {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("tweets.txt")); // Make Scanner over tweet file
        List<String> tweets = new ArrayList<>();
        while (input.hasNextLine()) { // Add each tweet in file to List
            tweets.add(input.nextLine());
        }

        TweetBot bot = new TweetBot(tweets); // Create TweetBot object with list of tweets
        TwitterTrends trends = new TwitterTrends(bot); // Create TwitterTrends object

        // Call getMostFrequentWord method and display result
        String mostFrequentWord = trends.getMostFrequentWord();
        System.out.println("The most frequent word in the tweets is: " + mostFrequentWord);

        // Call creative method and display result
        trends.wordsUsingCovid();
    }
}
