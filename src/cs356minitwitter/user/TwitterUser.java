/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs356minitwitter.user;

import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

/**
 *
 * @author Connor
 */
public class TwitterUser extends Subject implements Observer {
    
    private String userID;
    private ArrayList<String> tweets;
    private ArrayList<String> followedUsers;
    
    private Observer userWindow;
    
    public TwitterUser(String userID){
        super();
        
        this.userID = userID;
        tweets = new ArrayList<String>();
        followedUsers = new ArrayList<String>();
    }

    @Override
    public void update(Subject subject) {
        if(subject instanceof TwitterUser) {
            String latestTweet = ((TwitterUser)subject).getLastTweet();
            tweets.add(latestTweet);
            if(userWindow != null){
                userWindow.update(this);
            }
        }
    }
    
    public void postTweet(String tweet){
        tweets.add(tweet);
        notifyObservers();
    }
    
    public String getLastTweet(){
        return tweets.get(tweets.size() - 1);
    }
    
    public void addFollowingUser(String followingUserID) {
        this.followedUsers.add(followingUserID);
    }
    
    @Override
    public String toString(){
        return this.userID;
    }
    
    // getters
    public String getUserID(){
        return this.userID;
    }
    
    public ArrayList<String> getTweets() {
        return this.tweets;
    }
    
    public ArrayList<String> getFollowedUsers() {
        return this.followedUsers;
    }
    
    public void setUserWindow(Observer userWindow){
        this.userWindow = userWindow;
    }
}
