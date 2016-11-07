package cs356minitwitter.user;

import java.sql.Timestamp;
import java.util.Date;

/**
 * A class that is simply a pairing of a Timestamp, which is set to the time
 * of construction, and the actual tweet String
 *
 * @author Connor
 */
public class Tweet {
    private String tweetString;
    private Timestamp timeStamp;
    
    /**
     * Constructor
     * Sets the Tweet's TimeStamp to current time and the tweetString as the
     * Tweet's body string
     * @param tweetString 
     */
    public Tweet(String tweetString) {
        // get current time
        Date date = new Date();
        timeStamp = new Timestamp(date.getTime());
        this.tweetString = tweetString;
    }

    // getters
    /**
     * Get Timestamp of Tweet
     * @return 
     */
    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    /**
     * Get the body of the tweet
     * @return 
     */
    public String getTweetString() {
        return tweetString;
    }
}
