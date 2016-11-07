/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs356minitwitter.nodes.analysis;

import cs356minitwitter.nodes.GroupComposite;
import cs356minitwitter.nodes.UserGroupComponent;

/**
 *
 * @author Connor
 */
public class CountUsersVisitor implements GroupVisitor{
    
    public CountUsersVisitor(){
        
    }

    @Override
    public int visitRoot(GroupComposite root) {
        return countUserDescendents(root);
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
