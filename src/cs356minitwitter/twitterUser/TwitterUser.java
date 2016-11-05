/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs356minitwitter.twitterUser;

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
    
    public TwitterUser(String userID){
        this.userID = userID;
        tweets = new ArrayList<String>();
    }

    @Override
    public void update(Subject subject) {
        if(subject instanceof TwitterUser) {
            String latestTweet = ((TwitterUser)subject).getLastTweet();
        }
    }
    
    public void postTweet(String tweet){
        tweets.add(tweet);
        notifyObservers();
    }
    
    public String getLastTweet(){
        return tweets.get(tweets.size() - 1);
    }
    
    // getters
    public String getUserID(){
        return this.userID;
    }
    
    @Override
    public String toString(){
        return this.userID;
    }
}
