package cs356minitwitter.node.analysis;

import cs356minitwitter.node.GroupComposite;
import cs356minitwitter.node.UserGroupComponent;

/**
 * Visitor thats visits a GroupComposite and counts the descendants that are also
 * GroupComposites
 *
 * @author Connor
 */
public class CountGroupsVisitor implements GroupVisitor{
    
    /**
     * Constructor
     */
    public CountGroupsVisitor(){
    }

    /**
     * Returns number of descendants that are also groups
     * @param root visited GroupComposite
     * @return 
     */
    @Override
    public int visitRoot(GroupComposite root) {
        return countGroupDescendents(root);
    }
    
    /**
     * Recursive function that returns number of descendants that are instances 
     * of GroupComposite
     * @param root
     * @return number of GroupComposite descendant
     */
    public int countGroupDescendents(GroupComposite root){
        int numGroupDescendents = 0;
        // for each child
        for(int i = 0; i < root.getNumChildren(); i++) {
            UserGroupComponent currentChild = root.getChild(i);
            // if it's a group, add 1 and number of its group descendants to
            // the counter
            if(currentChild instanceof GroupComposite){
                numGroupDescendents++;
                numGroupDescendents += countGroupDescendents((GroupComposite)currentChild);
            }
        }
        return numGroupDescendents;
    }
}
