package cs356minitwitter;

import cs356minitwitter.form.AdminUI;

import cs356minitwitter.user.TwitterUser;
import cs356minitwitter.user.analysis.CountTweetsVisitor;
import cs356minitwitter.user.analysis.FindPercentPositiveVisitor;
import cs356minitwitter.user.analysis.util.TwitterUserHashMap;

import cs356minitwitter.node.GroupComposite;
import cs356minitwitter.node.RootComposite;
import cs356minitwitter.node.UserGroupComponent;
import cs356minitwitter.node.UserLeaf;
import cs356minitwitter.node.analysis.CountGroupsVisitor;
import cs356minitwitter.node.analysis.CountUsersVisitor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.SwingUtilities;

/**
 * The singleton main window of the MiniTwitter project
 * - Sets up an interface to 
 *      - Add MiniTwitter groups and users
 *      - Open UserWindows for specific users
 *      - Open pop-ups with analysis of the current environment
 *          - number of users and groups
 *          - number of tweets and percentage of positive tweets
 * This class holds all of the data for the entire MiniTwitter project
 * 
 * @author Connor
 */
public class AdminWindow extends AdminUI {
    
    // static self Reference for singleton
    private static AdminWindow adminWindow;
    // the twitter users
    private TwitterUserHashMap twitterUsers;
    // root to the user/group tree
    private UserGroupComponent root;
    // References to all nodes in the user/group tree
    private HashMap<String, UserGroupComponent> nodes;
    
    // visitors to access data and do work
    private CountUsersVisitor countUsersVisitor;
    private CountGroupsVisitor countGroupsVisitor;
    private CountTweetsVisitor countTweetsVisitor;
    private FindPercentPositiveVisitor findPercentPositiveVisitor;
    
    /**
     * private constructor for Singleton class
     * Initializes data and sets up the UI
     */
    private AdminWindow() {
        super();
        
        // initialize visitors
        countUsersVisitor = new CountUsersVisitor();
        countGroupsVisitor = new CountGroupsVisitor();
        countTweetsVisitor = new CountTweetsVisitor();
        findPercentPositiveVisitor = new FindPercentPositiveVisitor();
        
        // initialize data
        twitterUsers = new TwitterUserHashMap();
        nodes = new HashMap<String, UserGroupComponent>();
        
        // accessing the current root and saving a Reference
        root = (RootComposite) this.userGroupTreePane.getModel().getRoot();
        nodes.put("root", root);
        
        // initialize UI and set up button functionality
        this.initializeViews();
    }
    
    /**
     * Accessor for singleton AdminWindow
     * @return singleton AdminWindow instance
     */
    public static AdminWindow getAdminWindow() {
        /* Create and display the form */
        if(adminWindow == null){
            adminWindow = new AdminWindow();
        }
        
        return adminWindow;
    }
    
    /**
     * Set title, visibility, and button functionality
     */
    private void initializeViews(){
        
        // safely setting window title and visibility
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                setTitle("Mini Twitter Admin");
                setVisible(true);
            }
        });
        
        /*
        * Setting button functionalities
        */
        // Set openUserViewButton to open user view
        this.openUserViewButton.addActionListener(new ActionListener() {  
            @Override      
            public void actionPerformed(ActionEvent e) {
                openUserView();
            }
        }); 
        
        // set addUserButton to add user to selected group and clear textarea 
        this.addUserButton.addActionListener(new ActionListener() {  
            @Override      
            public void actionPerformed(ActionEvent e) {
                UserLeaf newUser = new UserLeaf(userIDTextArea.getText());
                addNodeToSelectedNode(newUser);
                userIDTextArea.setText("");
            }
        });
        
        // set addGroupButton to add group to selected group and clear textarea
        this.addGroupButton.addActionListener(new ActionListener() {  
            @Override      
            public void actionPerformed(ActionEvent e) {
                GroupComposite newGroup = new GroupComposite(groupIDTextArea.getText());
                addNodeToSelectedNode(newGroup);
                groupIDTextArea.setText("");
            }
        });
        
        // set showUserTotalButton to use countUsersVisitor to get number of
        // users and display the information in a info pop-up window
        this.showUserTotalButton.addActionListener(new ActionListener() {  
            @Override      
            public void actionPerformed(ActionEvent e) {
                int numUsers = ((RootComposite)root).accept(countUsersVisitor);
                new InfoPopUpWindow("Total Number of Users: " + numUsers);
            }
        });
        
        // set showGroupTotalButton to use countGroupsVisitor to get number of
        // groups and display the information in a pop-up window
        this.showGroupTotalButton.addActionListener(new ActionListener() {  
            @Override      
            public void actionPerformed(ActionEvent e) {
                int numGroups = ((RootComposite)root).accept(countGroupsVisitor);
                new InfoPopUpWindow("Total Number of Groups: " + numGroups);
            }
        });
        
        // set showMessagesTotalButton to use countTweetsVisitor to get number of
        // tweets and display the information in a pop-up window
        this.showMessagesTotalButton.addActionListener(new ActionListener() {  
            @Override      
            public void actionPerformed(ActionEvent e) {
                int numTweets = twitterUsers.accept(countTweetsVisitor);
                new InfoPopUpWindow("Number of Tweets: " + numTweets);
            }
        });
        
        // set showPositivePercentageButton to user findePercentPositiveVisitor to get
        // precent of positive tweets and display info in pop-up window
        this.showPositivePercentageButton.addActionListener(new ActionListener() {  
            @Override      
            public void actionPerformed(ActionEvent e) {
                int percent = twitterUsers.accept(findPercentPositiveVisitor);
                new InfoPopUpWindow("Percent Positive Tweets: " + percent + "%");
            }
        });
    }
    
    /**
     * open a UserWindow for the user selected in the JTree
     */
    private void openUserView() {
        // get the currently selected node
        UserGroupComponent node = 
                (UserGroupComponent) this.userGroupTreePane.getLastSelectedPathComponent();
        // if the node exists and is a leaf
        if(node != null && (node instanceof UserLeaf)){
            // get username
            String userName = node.toString();
            // open a user window if the twitter user exists
            if(twitterUsers.containsKey(userName)){
                new UserWindow(twitterUsers.get(userName));
            }
        }
    }
    
    /**
     * Add new user or group to the JTree
     * @param newNode a new user or group to add to JTree
     * @param groupNodeID the group in which to add the user or group
     */
    public void addNode(UserGroupComponent newNode, String groupNodeID) {
        UserGroupComponent groupNode = nodes.get(groupNodeID);
        addNodeToGroupNode(newNode, groupNode);
    }
    
    /**
     * add a user or group to the JTree in the selected group
     * @param newNodeObject user or group node to be added
     */
    private void addNodeToSelectedNode(UserGroupComponent newNodeObject){
        UserGroupComponent selectedGroupNode = 
                (UserGroupComponent) this.userGroupTreePane.getLastSelectedPathComponent();
        addNodeToGroupNode(newNodeObject, selectedGroupNode);
    }
    
    /**
     * Add user or group node to JTree
     * @param newNodeObject new user or group node to add to JTree
     * @param groupNode group node that the user or group node is being added to
     */
    private void addNodeToGroupNode(UserGroupComponent newNodeObject, UserGroupComponent groupNode){
        if(groupNode == null){
            groupNode = root;
        }
        if(groupNode instanceof GroupComposite 
                && newNodeObject != null 
                && !nodes.containsKey(newNodeObject.toString())){
            groupNode.add(newNodeObject);
            String userName = newNodeObject.toString();
            nodes.put(userName, newNodeObject);
            if(newNodeObject instanceof UserLeaf) {
                twitterUsers.put(userName, new TwitterUser(userName));
            }
            this.updateGroupTreePaneUI();
        }
    }
    
    /**
     * safely update the JTree UI
     */
    private void updateGroupTreePaneUI(){
            
        // updating the tree. Calling updateUI alone may cause NullPointerException.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                userGroupTreePane.updateUI();
            }
        });
    }
    
    /*
     * getters
     */ 
    
    public TwitterUser getTwitterUser(String userID) {
        return twitterUsers.get(userID);
    }

    public HashMap<String, TwitterUser> getTwitterUsers() {
        return twitterUsers;
    }

    public UserGroupComponent getRoot() {
        return root;
    }
}
