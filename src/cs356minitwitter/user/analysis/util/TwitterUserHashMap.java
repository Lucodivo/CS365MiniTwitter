/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs356minitwitter.user.analysis.util;

import cs356minitwitter.user.TwitterUser;
import cs356minitwitter.user.analysis.HashMapElement;
import cs356minitwitter.user.analysis.HashMapVisitor;

import java.util.HashMap;

/**
 *
 * @author Connor
 */
public class TwitterUserHashMap extends HashMap<String, TwitterUser> implements HashMapElement {

    @Override
    public void accept(HashMapVisitor v) {
        v.visitHashMap(this);
    }
}
