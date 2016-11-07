package cs356minitwitter.user.analysis;

import cs356minitwitter.user.TwitterUser;
import cs356minitwitter.user.analysis.util.TwitterUserHashMap;

import java.util.Iterator;
import java.util.Map;

/**
 * Visitor that counts the total number of Tweets in a TwitterUserHashMap
 *
 * @author Connor
 */
public class CountTweetsVisitor implements TwittorUserHashMapVisitor{
    
    /**
     * Constructor
     */
    public CountTweetsVisitor(){
    }

    /**
     * Returns the number of tweets in the TwitterUserHashmap
     * @param twitterUsers
     * @return 
     */
    @Override
    public int visitHashMap(TwitterUserHashMap twitterUsers) {
        int numTweets = 0;
        // use an Iterator to go through each pair in the HashMap
        for (Map.Entry pair : twitterUsers.entrySet()) {
            // get the TwitterUser from the value of the current pair
            TwitterUser currentUser = (TwitterUser)pair.getValue();
            // add current user's tweets to total count number
            numTweets += currentUser.getTweets().size();
        }
        return numTweets;
    }
}
