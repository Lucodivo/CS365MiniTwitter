/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs356minitwitter.ui;

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
    private DefaultMutableTreeNode root;
    private HashMap<String, DefaultMutableTreeNode> nodes;
    
    private AdminWindow() {
        super();
        
        twitterUsers = new HashMap<String, TwitterUser>();
        nodes = new HashMap<String, DefaultMutableTreeNode>();
        root = (DefaultMutableTreeNode) this.userGroupTreePane.getModel().getRoot();
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
        DefaultMutableTreeNode node = 
                (DefaultMutableTreeNode) this.userGroupTreePane.getLastSelectedPathComponent();
        if(node != null && !node.getAllowsChildren()){
            String userName = node.toString();
            if(twitterUsers.containsKey(userName)){
                new UserWindow(twitterUsers.get(userName));
            } else {
                new UserWindow(twitterUsers.get(userName));
            }
        }
    }
    
    public void addGroupNode(Object newGroupNodeObject, String groupNodeID) {
        addNode(newGroupNodeObject, true, groupNodeID);
    }
    
    public void addLeafNode(Object newLeafNodeObject, String groupNodeID) {
        addNode(newLeafNodeObject, false, groupNodeID);
    }
    
    private void addNode(Object newNodeObject, boolean isGroup, String groupNodeID) {
        DefaultMutableTreeNode groupNode = nodes.get(groupNodeID);
        addNodeToGroupNode(newNodeObject, isGroup, groupNode);
    }
    
    private void addLeafToSelectedNode(Object newLeafNodeObject) {
        addNodeToSelectedNode(newLeafNodeObject, false);
    }
    
    private void addGroupToSelectedNode(Object newGroupNodeObject) {
        addNodeToSelectedNode(newGroupNodeObject, true);
    }
    
    private void addNodeToSelectedNode(Object newNodeObject, boolean isGroup){
        DefaultMutableTreeNode selectedGroupNode = 
                (DefaultMutableTreeNode) this.userGroupTreePane.getLastSelectedPathComponent();
        addNodeToGroupNode(newNodeObject, isGroup, selectedGroupNode);
    }
    
    private void addNodeToGroupNode(Object newNodeObject, boolean isGroup, DefaultMutableTreeNode groupNode){
        if(groupNode == null){
            groupNode = (DefaultMutableTreeNode) this.userGroupTreePane.getModel().getRoot();
        }
        if(groupNode.getAllowsChildren() && !newNodeObject.toString().isEmpty()){
            DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(newNodeObject);
            newNode.setAllowsChildren(isGroup);
            groupNode.add(newNode);
            String userName = newNodeObject.toString();
            nodes.put(userName, newNode);
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
