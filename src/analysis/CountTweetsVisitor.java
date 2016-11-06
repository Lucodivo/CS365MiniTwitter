/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analysis;

import cs356minitwitter.nodes.GroupComposite;
import cs356minitwitter.nodes.RootComposite;
import cs356minitwitter.nodes.UserGroupComponent;
import cs356minitwitter.ui.InfoPopUpWindow;
import cs356minitwitter.user.TwitterUser;
import cs356minitwitter.util.TwitterUserHMap;
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
        if(hMap instanceof TwitterUserHMap) {
            int numTweets = countTweets((TwitterUserHMap)hMap);
            
            new InfoPopUpWindow("Total Tweets: " + numTweets);
        }
    }
    
    public int countTweets(TwitterUserHMap twitterUsers){
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
