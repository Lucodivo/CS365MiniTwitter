/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs356minitwitter.user.analysis;

import cs356minitwitter.InfoPopUpWindow;
import cs356minitwitter.user.TwitterUser;
import cs356minitwitter.user.analysis.util.TwitterUserHashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Connor
 */
public class CountTweetsVisitor implements HashMapVisitor{
    
    public CountTweetsVisitor(){
        
    }

    @Override
    public void visitHashMap(HashMap hMap) {
        if(hMap instanceof TwitterUserHashMap) {
            int numTweets = countTweets((TwitterUserHashMap)hMap);
            
            new InfoPopUpWindow("Total Tweets: " + numTweets);
        }
    }
    
    public int countTweets(TwitterUserHashMap twitterUsers){
        int numTweets = 0;
        Iterator it = twitterUsers.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            TwitterUser currentUser = (TwitterUser)pair.getValue();
            numTweets += currentUser.getTweets().size();
        }
        return numTweets;
    }
}
