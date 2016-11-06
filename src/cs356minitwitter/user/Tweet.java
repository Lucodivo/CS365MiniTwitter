/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs356minitwitter.user;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Connor
 */
public class Tweet {
    private String tweetString;
    private Timestamp timeStamp;
    
    public Tweet(String tweetString) {
        this.tweetString = tweetString;
        Date date = new Date();
        timeStamp = new Timestamp(date.getTime());
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public String getTweetString() {
        return tweetString;
    }
}
