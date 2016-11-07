package cs356minitwitter;

import cs356minitwitter.user.Observer;
import cs356minitwitter.user.Subject;
import cs356minitwitter.user.TwitterUser;

import cs356minitwitter.form.UserUI;
import cs356minitwitter.model.StringArrayListModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JList;
import javax.swing.SwingUtilities;

/**
 * Window that allows a user to:
 * - Post tweets
 * - follow other users
 * - view newsFeed from self and followed users
 * 
 * @author Connor
 */
public class UserWindow extends UserUI implements Observer {
    
    // twitter user of the window
    TwitterUser user;
    
    // models for the listview UI components
    StringArrayListModel followedUsers;
    StringArrayListModel newsFeed;
    
    // admin window to access other user's data
    AdminWindow adminWindow;
    
    /**
     * Constructor
     * Sets up the followers listview, newsfeed listview, initialize button
     * functionality, set title and visibility
     * 
     * @param user main user of the UserWindow
     */
    public UserWindow(TwitterUser user) {
        super();
        
        // initialize member variables
        this.user = user;
        this.user.setUserWindow(this);
        this.followedUsers = new StringArrayListModel(this.user.getFollowedUsers());
        this.newsFeed = new StringArrayListModel(this.user.getNewsFeed());
        this.adminWindow = AdminWindow.getAdminWindow();
        
        // initialize views and set button functionality
        initializeViews();
    }
    
    /**
     * Set title, visibility, and button functionality
     */
    private void initializeViews(){
        
        // safely setting window title and visibility
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                setTitle("Twitter User: " + user.getUserID());
                setVisible(true);
            }
        });
        
        // set ListViews to corresponding models and update the UI
        this.currentFollowingListView.setModel(this.followedUsers);
        this.newsFeedListView.setModel(this.newsFeed);
        updateJListUI(this.currentFollowingListView);
        updateJListUI(this.newsFeedListView);
        
        // set followUserButton to follow user with userID in the userIDTextArea
        // and clear userIDTextArea
        this.followUserButton.addActionListener(new ActionListener() {  
            @Override      
            public void actionPerformed(ActionEvent e) {
                followUser(followUserIDTextArea.getText());
                followUserIDTextArea.setText("");
            }
        });
        
        // post tweet with the body from the tweetMessageTextArea
        // and clear tweetMessageTextArea
        this.postTweetButton.addActionListener(new ActionListener() {  
            @Override      
            public void actionPerformed(ActionEvent e) {
                postTweet(tweetMessageTextArea.getText());
                tweetMessageTextArea.setText("");
            }
        });
        
        // set the user's window to null when the window closes
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                user.setUserWindow(null);
            }
        });
    }
    
    /**
     * Find user with userID passed and set as followedUser
     * 
     * @param followUserID userID of user to be followed
     */
    private void followUser(String followUserID) {
        if(!followUserID.isEmpty()){
            // get user with userID from adminWindow
            TwitterUser followUser = this.adminWindow.getTwitterUser(followUserID);
            // if the user exists, isn't current user, and user isn't already
            // following this user
            if (followUser != null && followUser != this.user 
                    && !this.user.isFollowingUser(followUserID)) {
                // tell this user to follow follow followUser
                this.user.addFollowedUser(followUser);
                this.followedUsers.addString(followUserID);
                // udpate UI
                updateJListUI(this.currentFollowingListView);
            }
        }
    }
    
    /**
     * Post Tweet and update newFeedListView
     * 
     * @param newTweetString 
     */
    private void postTweet(String newTweetString) {
        if(!newTweetString.isEmpty()){
            user.postTweet(newTweetString);
            updateJListUI(this.newsFeedListView);
        }
    }
    
    /**
     * Safely update a JList in the GUI
     * 
     * @param jlist JList object to update
     */
    private void updateJListUI(JList jlist){
            
        // updating the tree. Calling updateUI alone may cause NullPointerException.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                jlist.updateUI();
            }
        });
    }

    /**
     * UserWindow is an observer to the user member variable.
     * user updates the window when it receives updates from it's followed users.
     * When that happens, we simply update the UI
     * 
     * @param subject the user being observed by UserWindow
     */
    @Override
    public void update(Subject subject){
        updateJListUI(this.newsFeedListView);
    }
}