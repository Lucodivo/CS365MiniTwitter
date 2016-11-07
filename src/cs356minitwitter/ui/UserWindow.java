/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs356minitwitter.ui;

import cs356minitwitter.user.Observer;
import cs356minitwitter.user.Subject;
import cs356minitwitter.user.Tweet;
import cs356minitwitter.user.TwitterUser;
import cs356minitwitter.util.StringArrayListModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.Date;
import javax.swing.JList;
import javax.swing.SwingUtilities;

/**
 *
 * @author Connor
 */
public class UserWindow extends UserUI implements Observer {
    
    TwitterUser user;
    StringArrayListModel followedUsers;
    StringArrayListModel newsFeed;
    
    AdminWindow adminWindow;
    
    public UserWindow(TwitterUser user) {
        super();
        
        this.user = user;
        this.user.setUserWindow(this);
        followedUsers = new StringArrayListModel(this.user.getFollowedUsers());
        newsFeed = new StringArrayListModel(this.user.getNewsFeed());
        adminWindow = AdminWindow.getAdminWindow();
        
        setNimbusLookAndFeel();
        initializeViews();
    }
    
    private void initializeViews(){
        this.setTitle("Twitter User: " + this.user.getUserID());
        this.setVisible(true);
        
        this.currentFollowingListView.setModel(followedUsers);
        this.newsFeedListView.setModel(newsFeed);
        updateJListUI(this.currentFollowingListView);
        updateJListUI(this.newsFeedListView);
        
        this.followUserButton.addActionListener(new ActionListener() {  
            @Override      
            public void actionPerformed(ActionEvent e) {
                followUser(followUserIDTextArea.getText());
                followUserIDTextArea.setText("");
            }
        });
        
        this.postTweetButton.addActionListener(new ActionListener() {  
            @Override      
            public void actionPerformed(ActionEvent e) {
                postTweet(tweetMessageTextArea.getText());
                tweetMessageTextArea.setText("");
            }
        });
        
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
    }
    
    private void followUser(String followUserID) {
        if(!followUserID.isEmpty()){
            TwitterUser followUser = adminWindow.getTwitterUser(followUserID);
            if (followUser != null && followUser != this.user 
                    && !this.user.isFollowingUser(followUserID)) {
                followUser.attach(this.user);
                this.user.addFollowingUser(followUserID);
                followedUsers.addString(followUserID);
                updateJListUI(this.currentFollowingListView);
            }
        }
    }
    
    private void postTweet(String newTweetString) {
        if(!newTweetString.isEmpty()){
            user.postTweet(newTweetString);
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

    private void formWindowClosing(java.awt.event.WindowEvent evt) {                                   
        // TODO add your handling code here:
        this.user.setUserWindow(null);
    }
}