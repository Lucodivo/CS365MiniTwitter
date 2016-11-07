package cs356minitwitter.user.analysis;

import cs356minitwitter.user.analysis.util.TwitterUserHashMap;

/**
 * Interface for visitor that want to visit a TwitterUserHashMap 
 * and return an integer
 * 
 * @author Connor
 */
public interface TwittorUserHashMapVisitor {
    public int visitHashMap(TwitterUserHashMap twitterUsers);
}
