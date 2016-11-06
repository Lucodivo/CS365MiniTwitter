/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs356minitwitter.ui;

import analysis.CountUsersVisitor;
import cs356minitwitter.nodes.GroupComposite;
import cs356minitwitter.nodes.RootComposite;
import cs356minitwitter.nodes.UserGroupComponent;
import cs356minitwitter.nodes.UserLeaf;
import cs356minitwitter.user.TwitterUser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.SwingUtilities;

/**
 *
 * @author Connor
 */
public class AdminWindow extends AdminUI {
    
    private static AdminWindow adminWindow;
    private HashMap<String, TwitterUser> twitterUsers;
    private UserGroupComponent root;
    private HashMap<String, UserGroupComponent> nodes;
    
    private CountUsersVisitor countUsersVisitor;
    
    private AdminWindow() {
        super();
        
        countUsersVisitor = new CountUsersVisitor();
        
        twitterUsers = new HashMap<String, TwitterUser>();
        root = (RootComposite) this.userGroupTreePane.getModel().getRoot();
        nodes = new HashMap<String, UserGroupComponent>();
        nodes.put("root", root);
        this.initializeViews();
    }
    
    public static AdminWindow getAdminWindow() {
        /* Create and display the form */
        if(adminWindow == null){
            adminWindow = new AdminWindow();
        }
        
        return adminWindow;
    }
    
    private void initializeViews(){
        setNimbusLookAndFeel();
        
        // setting window features and visibility
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                setTitle("Mini Twitter Admin");
                setVisible(true);
            }
        });
        
        this.openUserViewButton.addActionListener(new ActionListener() {  
            @Override      
            public void actionPerformed(ActionEvent e) {
                openUserView();
            }
        }); 
        
        this.addUserButton.addActionListener(new ActionListener() {  
            @Override      
            public void actionPerformed(ActionEvent e) {
                addLeafToSelectedNode(userIDTextArea.getText());
            }
        });
        
        this.addGroupButton.addActionListener(new ActionListener() {  
            @Override      
            public void actionPerformed(ActionEvent e) {
                addGroupToSelectedNode(groupIDTextArea.getText());
            }
        });
        
        this.showUserTotalButton.addActionListener(new ActionListener() {  
            @Override      
            public void actionPerformed(ActionEvent e) {
                ((RootComposite)root).accept(countUsersVisitor);
            }
        });
        
        this.showGroupTotalButton.addActionListener(new ActionListener() {  
            @Override      
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        this.showMessagesTotalButton.addActionListener(new ActionListener() {  
            @Override      
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        this.showPositivePercentageButton.addActionListener(new ActionListener() {  
            @Override      
            public void actionPerformed(ActionEvent e) {
                
            }
        });
    }
    
    private void openUserView() {
        UserGroupComponent node = 
                (UserGroupComponent) this.userGroupTreePane.getLastSelectedPathComponent();
        if(node != null && (node instanceof UserLeaf)){
            String userName = node.toString();
            if(twitterUsers.containsKey(userName)){
                new UserWindow(twitterUsers.get(userName));
            } else {
                new UserWindow(twitterUsers.get(userName));
            }
        }
    }
    
    
    
    public void addGroupNode(UserGroupComponent newGroupNodeObject, String groupNodeID) {
        addNode(newGroupNodeObject, groupNodeID);
    }
    
    public void addLeafNode(UserGroupComponent newLeafNodeObject, String groupNodeID) {
        addNode(newLeafNodeObject, groupNodeID);
    }
    
    private void addNode(UserGroupComponent newNodeObject, String groupNodeID) {
        UserGroupComponent groupNode = nodes.get(groupNodeID);
        addNodeToGroupNode(newNodeObject, groupNode);
    }
    
    private void addLeafToSelectedNode(String newLeafNodeString) {
        addNodeToSelectedNode(new UserLeaf(newLeafNodeString));
    }
    
    private void addGroupToSelectedNode(String newGroupNodeString) {
        addNodeToSelectedNode(new GroupComposite(newGroupNodeString));
    }
    
    private void addLeafToSelectedNode(UserGroupComponent newLeafNodeObject) {
        addNodeToSelectedNode(newLeafNodeObject);
    }
    
    private void addGroupToSelectedNode(UserGroupComponent newGroupNodeObject) {
        addNodeToSelectedNode(newGroupNodeObject);
    }
    
    private void addNodeToSelectedNode(UserGroupComponent newNodeObject){
        UserGroupComponent selectedGroupNode = 
                (UserGroupComponent) this.userGroupTreePane.getLastSelectedPathComponent();
        addNodeToGroupNode(newNodeObject, selectedGroupNode);
    }
    
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
    
    private void updateGroupTreePaneUI(){
            
        // updating the tree. Calling updateUI alone may cause NullPointerException.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                userGroupTreePane.updateUI();
            }
        });
    }
    
    // getters
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
