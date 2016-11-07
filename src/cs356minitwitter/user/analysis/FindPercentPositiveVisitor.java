package cs356minitwitter.user.analysis;

import cs356minitwitter.user.Tweet;
import cs356minitwitter.user.TwitterUser;
import cs356minitwitter.user.analysis.util.TwitterUserHashMap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Visitor that processes all tweets from TwuitterUserHashMap and outputs the 
 * percentage of tweets that contain positive words from GoodWordDictionary
 *
 * @author Connor
 */
public class FindPercentPositiveVisitor implements TwittorUserHashMapVisitor{
    
    // Reference to GoodWordDictionary singleton
    private GoodWordDictionary gwDict;
    
    /**
     * Constructor
     * sets Reference to GoodWordDictionary singleton
     */
    public FindPercentPositiveVisitor(){
        gwDict = GoodWordDictionary.getDictionary();
    }

    /**
     * Returns the percentage of positive Tweets from all TwitterUsers in
     * a TwitterUserHashMap. Positive tweets are dictated by the GoodWordDictionary
     * class.
     * @param twitterUsers
     * @return percentage of positive Tweets, returns integers in range [0%,100%]
     */
    @Override
    public int visitHashMap(TwitterUserHashMap twitterUsers) {
        // number of tweets
        int numTweets = 0;
        // number of positive tweets
        int numPositiveTweets = 0;
        
        // number of words in the dictionary
        int dictSize = gwDict.getSize();
        
        // For every pair in TwitterUserHashMap
        for (Map.Entry pair : twitterUsers.entrySet()) {
            // get user from pair
            TwitterUser currentUser = (TwitterUser)pair.getValue();
            // get tweets from user
            ArrayList<Tweet> tweets = currentUser.getTweets();
            // update number of tweets recorded
            int iNumTweets = tweets.size();
            numTweets += iNumTweets;
            // For every tweet from current user
            for(int i = 0; i < iNumTweets; i++){
                String tweetContent = tweets.get(i).getTweetString();
                // for every word in the dictionary
                for(int j = 0; j < dictSize; j++){
                    // if tweet has a good word, increment pos tweets count
                    String word = gwDict.get(j);
                    // case insensitive function to see if tweet contains substring
                    // found on StackOverflow
                    // http://stackoverflow.com/questions/86780/how-to-check-if-a-string-contains-another-string-in-a-case-insensitive-manner-in
                    if(Pattern.compile(Pattern.quote(word),
                            Pattern.CASE_INSENSITIVE).matcher(tweetContent).find()){
                        // once a tweet is positive, it is counted only once
                        numPositiveTweets++;
                        break;
                    }
                }
            }
        }
        
        // Get the percentage value using the number of positive tweets and 
        // the total number of tweets
        double percent;
        if(numTweets > 0){
            percent = ((double)numPositiveTweets/(double)numTweets) * 100;
        } else {
            percent = 0.0;
        }
        
        // truncate, cast, and return percent as int
        return (int)percent;
    }
}
