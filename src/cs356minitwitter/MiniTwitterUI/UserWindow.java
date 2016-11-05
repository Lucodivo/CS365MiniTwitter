/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs356minitwitter.MiniTwitterUI;

import cs356minitwitter.util.StringArrayListModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.AbstractListModel;

/**
 *
 * @author Connor
 */
public class UserWindow extends UserUI {
    
    String userName;
    StringArrayListModel followedUsers;
    StringArrayListModel tweets;
    
    public UserWindow(String userName) {
        super();
        
        this.userName = userName;
        followedUsers = new StringArrayListModel();
        tweets = new StringArrayListModel();
        
        setNimbusLookAndFeel();
        initializeViews();
    }
    
    private void initializeViews(){
        this.setTitle("Twitter User: " + this.userName);
        this.setVisible(true);
        
        this.currentFollowingListView.setModel(followedUsers);
        this.newsFeedListView.setModel(tweets);
        
        this.followUserButton.addActionListener(new ActionListener() {  
            @Override      
            public void actionPerformed(ActionEvent e) {
                followUser();
            }
        });
        
        this.postTweetButton.addActionListener(new ActionListener() {  
            @Override      
            public void actionPerformed(ActionEvent e) {
                postTweet();
            }
        });
    }
    
    private void followUser() {
        String userToFollow = this.followUserIDTextArea.getText();
        if(!userToFollow.isEmpty()){
            followedUsers.addString(userToFollow);
            this.currentFollowingListView.updateUI();
        }
    }
    
    private void postTweet() {
        String newTweet = this.tweetMessageTextArea.getText();
        if(!newTweet.isEmpty()){
            Date date = new Date();
            String ts = (new Timestamp(date.getTime())).toString();
            ts = ts.substring(11, 19);
            tweets.addString(ts + " | " + this.userName + ": " + newTweet);
            this.newsFeedListView.updateUI();
        }
    }
}
