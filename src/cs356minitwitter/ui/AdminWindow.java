/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs356minitwitter.ui;

import cs356minitwitter.nodes.GroupComposite;
import cs356minitwitter.nodes.UserGroupComponent;
import cs356minitwitter.nodes.UserLeaf;
import cs356minitwitter.user.TwitterUser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Connor
 */
public class AdminWindow extends AdminUI {
    
    private static AdminWindow adminWindow;
    private HashMap<String, TwitterUser> twitterUsers;
    private UserGroupComponent root;
    private HashMap<String, UserGroupComponent> nodes;
    
    private AdminWindow() {
        super();
        
        twitterUsers = new HashMap<String, TwitterUser>();
        nodes = new HashMap<String, UserGroupComponent>();
        root = (UserGroupComponent) this.userGroupTreePane.getModel().getRoot();
        nodes.put("root", root);
        this.initializeViews();
    }
    
    public static AdminWindow getAdminWindow() {
        setNimbusLookAndFeel();
        
        /* Create and display the form */
        if(adminWindow == null){
            adminWindow = new AdminWindow();
        }
        
        return adminWindow;
    }
    
    private void initializeViews(){
        this.setTitle("Mini Twitter Admin");
        this.setVisible(true);
        
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
        addNode(newGroupNodeObject, true, groupNodeID);
    }
    
    public void addLeafNode(UserGroupComponent newLeafNodeObject, String groupNodeID) {
        addNode(newLeafNodeObject, false, groupNodeID);
    }
    
    private void addNode(UserGroupComponent newNodeObject, boolean isGroup, String groupNodeID) {
        UserGroupComponent groupNode = nodes.get(groupNodeID);
        addNodeToGroupNode(newNodeObject, isGroup, groupNode);
    }
    
    private void addLeafToSelectedNode(String newLeafNodeString) {
        addNodeToSelectedNode(new UserLeaf(newLeafNodeString), false);
    }
    
    private void addGroupToSelectedNode(String newGroupNodeString) {
        addNodeToSelectedNode(new GroupComposite(newGroupNodeString), true);
    }
    
    private void addLeafToSelectedNode(UserGroupComponent newLeafNodeObject) {
        addNodeToSelectedNode(newLeafNodeObject, false);
    }
    
    private void addGroupToSelectedNode(UserGroupComponent newGroupNodeObject) {
        addNodeToSelectedNode(newGroupNodeObject, true);
    }
    
    private void addNodeToSelectedNode(UserGroupComponent newNodeObject, boolean isGroup){
        UserGroupComponent selectedGroupNode = 
                (UserGroupComponent) this.userGroupTreePane.getLastSelectedPathComponent();
        addNodeToGroupNode(newNodeObject, isGroup, selectedGroupNode);
    }
    
    private void addNodeToGroupNode(UserGroupComponent newNodeObject, boolean isGroup, UserGroupComponent groupNode){
        if(groupNode == null){
            groupNode = root;
        }
        if(groupNode instanceof GroupComposite && newNodeObject != null){
            groupNode.add(newNodeObject);
            String userName = newNodeObject.toString();
            nodes.put(userName, newNodeObject);
            twitterUsers.put(userName, new TwitterUser(userName));
            // newNode.getUserObject();
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
}
