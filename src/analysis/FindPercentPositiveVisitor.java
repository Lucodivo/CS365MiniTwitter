/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analysis;

import cs356minitwitter.ui.InfoPopUpWindow;
import cs356minitwitter.user.Tweet;
import cs356minitwitter.user.TwitterUser;
import cs356minitwitter.util.TwitterUserHMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

/**
 *
 * @author Connor
 */
public class FindPercentPositiveVisitor implements HashMapVisitor{
    
    private int numTweets;
    private int numPositiveTweets;
    private static GoodWordDictionary gwDict;
    
    public FindPercentPositiveVisitor(){
        gwDict = GoodWordDictionary.getDictionary();
    }

    @Override
    public void visitHashMap(HashMap hMap) {
        this.numTweets = 0;
        this.numPositiveTweets = 0;
        if(hMap instanceof TwitterUserHMap) {
            setPercentPositive((TwitterUserHMap)hMap);
            double percent;
            if(numTweets > 0){
                percent = ((double)this.numPositiveTweets/(double)this.numTweets) * 100;
                percent = this.truncate(percent,2);
            } else {
                percent = 0.00;
            }
            new InfoPopUpWindow("Percent Positive Tweets: " + percent + "%");
        }
    }
    
    public void setPercentPositive(TwitterUserHMap twitterUsers){
        int dictSize = this.gwDict.getSize();
        Iterator it = twitterUsers.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            TwitterUser currentUser = (TwitterUser)pair.getValue();
            ArrayList<Tweet> tweets = currentUser.getTweets();
            int numTweets = tweets.size();
            this.numTweets += numTweets;
            for(int i = 0; i < numTweets; i++){
                String tweetContent = tweets.get(i).getTweetString();
                for(int j = 0; j < dictSize; j++){
                    boolean isPositive = Pattern.compile(Pattern.quote(tweetContent),
                            Pattern.CASE_INSENSITIVE).matcher(gwDict.get(j)).find();
                    if(isPositive){
                        this.numPositiveTweets++;
                        break;
                    }
                }
            }
        }
    }
    
    private double truncate(double num, int precision){
       int multiplier = 1;
       for(int i = 0; i < precision; i++){
           multiplier *= 10;
       }
       num *= multiplier;
       num = (int)num;
       num /= multiplier;
       return num;
    }
}
