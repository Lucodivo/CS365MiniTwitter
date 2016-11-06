/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analysis;

import cs356minitwitter.nodes.GroupComposite;
import cs356minitwitter.nodes.RootComposite;
import cs356minitwitter.nodes.UserGroupComponent;
import cs356minitwitter.nodes.UserLeaf;
import cs356minitwitter.ui.InfoPopUpWindow;

/**
 *
 * @author Connor
 */
public class CountUsersVisitor implements GroupVisitor{
    
    public CountUsersVisitor(){
        
    }

    @Override
    public void visitRoot(GroupComposite root) {
        int numUsers = countUserDescendents(root);
        
        new InfoPopUpWindow("Total Number of Users: " + numUsers);
    }
    
    public int countUserDescendents(GroupComposite root){
        int numUserLeaves = 0;
        for(int i = 0; i < root.getNumChildren(); i++) {
            UserGroupComponent currentChild = root.getChild(i);
            if(currentChild instanceof GroupComposite){
                numUserLeaves += countUserDescendents((GroupComposite)currentChild);
            } else {
                numUserLeaves++;
            }
        }
        return numUserLeaves;
    }
}
