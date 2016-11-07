/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs356minitwitter.user;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Connor
 */
public class TwitterUser extends Subject implements Observer {
    
    private String userID;
    private ArrayList<Tweet> tweets;
    private HashSet<String> followedUsers;
    private ArrayList<String> newsFeed;
    
    private Observer userWindow;
    
    public TwitterUser(String userID){
        super();
        
        this.userID = userID;
        tweets = new ArrayList<Tweet>();
        followedUsers = new HashSet<String>();
        newsFeed = new ArrayList<String>();
    }

    @Override
    public void update(Subject subject) {
        if(subject instanceof TwitterUser) {
            this.addLatestTweetToNewsFeed((TwitterUser)subject);
            if(userWindow != null){
                userWindow.update(this);
            }
        }
    }
    
    public void postTweet(String tweetString){
        tweets.add(new Tweet(tweetString));
        this.addLatestTweetToNewsFeed(this);
        notifyObservers();
    }
    
    public void addLatestTweetToNewsFeed(TwitterUser twitterUser){
        Tweet latestTweet = twitterUser.getLastTweet();
        String ts = latestTweet.getTimeStamp().toString();
        ts = ts.substring(11, 19);
        this.newsFeed.add((ts + " | " + twitterUser.getUserID() 
                    + ": " + latestTweet.getTweetString()));
    }
    
    public Tweet getLastTweet(){
        return tweets.get(tweets.size() - 1);
    }
    
    public void addFollowingUser(String followingUserID) {
        this.followedUsers.add(followingUserID);
    }
    
    public boolean isFollowingUser(String followingUserID) {
        return followedUsers.contains(followingUserID);
    }
    
    @Override
    public String toString(){
        return this.userID;
    }
    
    // getters
    public String getUserID(){
        return this.userID;
    }
    
    public ArrayList<Tweet> getTweets() {
        return this.tweets;
    }
    
    public HashSet<String> getFollowedUsers() {
        return this.followedUsers;
    }
    
    public void setUserWindow(Observer userWindow){
        this.userWindow = userWindow;
    }

    public ArrayList<String> getNewsFeed() {
        return newsFeed;
    }
}
