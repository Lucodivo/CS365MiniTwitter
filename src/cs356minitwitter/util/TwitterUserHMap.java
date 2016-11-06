/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs356minitwitter.util;

import analysis.HashMapElement;
import analysis.HashMapVisitor;
import cs356minitwitter.user.TwitterUser;
import java.util.HashMap;

/**
 *
 * @author Connor
 */
public class TwitterUserHMap extends HashMap<String, TwitterUser> implements HashMapElement {

    @Override
    public void accept(HashMapVisitor v) {
        v.visitHashMap(this);
    }
}
