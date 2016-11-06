/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs356minitwitter.ui;

import cs356minitwitter.user.Observer;
import cs356minitwitter.user.Subject;
import cs356minitwitter.user.TwitterUser;
import cs356minitwitter.util.StringArrayListModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.AbstractListModel;
import javax.swing.JList;
import javax.swing.SwingUtilities;

/**
 *
 * @author Connor
 */
public class UserWindow extends UserUI implements Observer {
    
    TwitterUser user;
    StringArrayListModel followedUsers;
    StringArrayListModel tweets;
    
    AdminWindow adminWindow;
    
    public UserWindow(TwitterUser user) {
        super();
        
        this.user = user;
        this.user.setUserWindow(this);
        followedUsers = new StringArrayListModel(this.user.getFollowedUsers());
        tweets = new StringArrayListModel(this.user.getTweets());
        adminWindow = AdminWindow.getAdminWindow();
        
        setNimbusLookAndFeel();
        initializeViews();
    }
    
    private void initializeViews(){
        this.setTitle("Twitter User: " + this.user.getUserID());
        this.setVisible(true);
        
        this.currentFollowingListView.setModel(followedUsers);
        this.newsFeedListView.setModel(tweets);
        updateJListUI(this.currentFollowingListView);
        updateJListUI(this.newsFeedListView);
        
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
        String followUserID = this.followUserIDTextArea.getText();
        if(!followUserID.isEmpty()){
            TwitterUser followUser = adminWindow.getTwitterUser(followUserID);
            if (followUser != null && followUser != this.user) {
                followUser.attach(this.user);
                followedUsers.addString(followUserID);
                updateJListUI(this.currentFollowingListView);
            }
        }
    }
    
    private void postTweet() {
        String newTweet = this.tweetMessageTextArea.getText();
        if(!newTweet.isEmpty()){
            Date date = new Date();
            String ts = (new Timestamp(date.getTime())).toString();
            ts = ts.substring(11, 19);
            user.postTweet(ts + " | " + this.user.getUserID() + ": " + newTweet);
            updateJListUI(this.newsFeedListView);
        }
    }
    
    private void updateJListUI(JList jlist){
            
        // updating the tree. Calling updateUI alone may cause NullPointerException.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                jlist.updateUI();
            }
        });
    }

    @Override
    public void update(Subject subject){
        updateJListUI(this.newsFeedListView);
    }
}