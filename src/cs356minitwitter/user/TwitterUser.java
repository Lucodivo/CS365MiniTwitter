package cs356minitwitter.user;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Connor
 */
public class TwitterUser extends Subject implements Observer {
    
    // string to identify user
    private String userID;
    // user's tweets
    private ArrayList<Tweet> tweets;
    // strings representing the userID's of the users being followed
    private HashSet<String> followedUsers;
    // strings of this user's and followed user's tweets
    private ArrayList<String> newsFeed;
    
    // userWindow that the TwitterUser currently populates
    private Observer userWindow;
    
    /**
     * All twitter user's must be instantiated with an identifiable String
     * @param userID 
     */
    public TwitterUser(String userID){
        super();
        
        // initiailze member variables
        this.userID = userID;
        tweets = new ArrayList<Tweet>();
        followedUsers = new HashSet<String>();
        newsFeed = new ArrayList<String>();
    }

    /**
     * When a followed user (Subject) tweets, they will call our function to
     * update our news feed.
     * @param subject 
     */
    @Override
    public void update(Subject subject) {
        if(subject instanceof TwitterUser) {
            this.addLatestTweetToNewsFeed((TwitterUser)subject);
            // if there is a window observer, update it
            if(userWindow != null){
                userWindow.update(this);
            }
        }
    }
    
    /**
     * Create a tweet, add it to this user's newsFeed and notify all followers
     * @param tweetString body of tweet to be posted
     */
    public void postTweet(String tweetString){
        tweets.add(new Tweet(tweetString));
        this.addLatestTweetToNewsFeed(this);
        notifyObservers();
    }
    
    /**
     * add the latest tweet of a TwitterUser to news feed
     * @param twitterUser 
     */
    public void addLatestTweetToNewsFeed(TwitterUser twitterUser){
        // get latest tweet
        Tweet latestTweet = twitterUser.getLastTweet();
        // get hour, minutes, and seconds from Tweet's Timestamp
        String ts = latestTweet.getTimeStamp().toString();
        ts = ts.substring(11, 19);
        // post reader friendly tweet to news feed
        this.newsFeed.add((ts + " | " + twitterUser.getUserID() 
                    + ": " + latestTweet.getTweetString()));
    }
    
     /**
      * Attach to followUser and store followed user's ID
      * @param followUser 
      */
    public void addFollowedUser(TwitterUser followUser) {
        followUser.attach(this);
        this.followedUsers.add(followUser.getUserID());
    }
    
    //setters
    /**
     * Sets the current window observer
     * Also used to set to null, so the UserWindow can be garbage collected
     * @param userWindow 
     */
    public void setUserWindow(Observer userWindow){
        this.userWindow = userWindow;
    }
    
    // getters
    /**
     * Get string to identify user
     * @return 
     */
    public String getUserID(){
        return this.userID;
    }
    
    /**
     * Get all of this user's posted Tweets
     * @return 
     */
    public ArrayList<Tweet> getTweets() {
        return this.tweets;
    }
    
    /**
     * Get all user IDs of the users this user is following
     * @return 
     */
    public HashSet<String> getFollowedUsers() {
        return this.followedUsers;
    }

    /**
     * Returns a user's newsFeed. Currently used to display in UserWindow.
     * @return 
     */
    public ArrayList<String> getNewsFeed() {
        return newsFeed;
    }
    
    /**
     * Return true if this user is following a user with specified user id String
     * @param followedUserID
     * @return 
     */
    public boolean isFollowingUser(String followedUserID) {
        return followedUsers.contains(followedUserID);
    }
    
    /**
     * Returns the last Tweet posted by this user
     * @return 
     */
    public Tweet getLastTweet(){
        return tweets.get(tweets.size() - 1);
    }
}
