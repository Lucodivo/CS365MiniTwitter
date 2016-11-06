/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analysis;

import cs356minitwitter.nodes.GroupComposite;
import cs356minitwitter.nodes.RootComposite;
import cs356minitwitter.nodes.UserGroupComponent;
import cs356minitwitter.ui.InfoPopUpWindow;

/**
 *
 * @author Connor
 */
public class CountGroupsVisitor implements Visitor{
    
    public CountGroupsVisitor(){
        
    }

    @Override
    public void visitRoot(RootComposite root) {
        int numGroups = countGroupDescendents(root);
        
        new InfoPopUpWindow("Total Number of Groups: " + numGroups);
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
