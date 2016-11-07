package cs356minitwitter.node.analysis;

import cs356minitwitter.node.GroupComposite;
import cs356minitwitter.node.UserGroupComponent;

/**
 * Visitor thats visits a GroupComposite and counts the descendants that are 
 * LeafUsers
 *
 * @author Connor
 */
public class CountUsersVisitor implements GroupVisitor{
    
    /**
     * Constructor
     */
    public CountUsersVisitor(){
    }

    /**
     * Returns the number of descendants that are leaves
     * @param root visited GroupComposite
     * @return 
     */
    @Override
    public int visitRoot(GroupComposite root) {
        return countUserDescendents(root);
    }
    
    /**
     * Returns number of descendants that are instances of LeafComposite
     * @param root visited GroupComposite
     * @return number of GroupComposite descendant
     */
    public int countUserDescendents(GroupComposite root){
        int numUserLeaves = 0;
        // for each child of the GroupComposite
        for(int i = 0; i < root.getNumChildren(); i++) {
            UserGroupComponent currentChild = root.getChild(i);
            // if it's a group, count all of it's children and add it to counter
            if(currentChild instanceof GroupComposite){
                numUserLeaves += countUserDescendents((GroupComposite)currentChild);
            } else { // else, we found a leaf increment by 1
                numUserLeaves++;
            }
        }
        return numUserLeaves;
    }
}
