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
public class CountGroupsVisitor implements GroupVisitor{
    
    public CountGroupsVisitor(){
        
    }

    @Override
    public int visitRoot(GroupComposite root) {
        return countGroupDescendents(root);
    }
    
    public int countGroupDescendents(GroupComposite root){
        int numGroupDescendents = 0;
        for(int i = 0; i < root.getNumChildren(); i++) {
            UserGroupComponent currentChild = root.getChild(i);
            if(currentChild instanceof GroupComposite){
                numGroupDescendents++;
                numGroupDescendents += countGroupDescendents((GroupComposite)currentChild);
            }
        }
        return numGroupDescendents;
    }
}
