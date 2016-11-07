package cs356minitwitter.user.analysis.util;

import cs356minitwitter.user.TwitterUser;

import java.util.HashMap;
import cs356minitwitter.user.analysis.TwittorUserHashMapVisitor;
import cs356minitwitter.user.analysis.TwitterUserHashMapElement;

/**
 * HashMap to user TwitterUserID's as hash input to get the corresponding TwitterUser.
 * Also implements HashMapElement to provide visitors a self Reference
 *
 * @author Connor
 */
public class TwitterUserHashMap extends HashMap<String, TwitterUser> implements TwitterUserHashMapElement {

    /**
     * return a visitors return value
     * @param v
     * @return 
     */
    @Override
    public int accept(TwittorUserHashMapVisitor v) {
        return v.visitHashMap(this);
    }
}
