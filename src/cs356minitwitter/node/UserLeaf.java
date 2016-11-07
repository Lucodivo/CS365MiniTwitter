package cs356minitwitter.node;

import java.util.List;

/**
 * Leaf component in a UserGroupComponent composite tree
 * only functionality is holding and returning a string
 * 
 * @author Connor
 */
public class UserLeaf extends UserGroupComponent {
    
    /**
     * All UserGroupComponents must be initialized with an ID String
     * @param id 
     */
    public UserLeaf(String id) {
        super(id);
    }

    /**
     * returns null, since a leaf has no children
     * @param i
     * @return 
     */
    @Override
    public UserGroupComponent getChild(int i) {
        return null;
    }

    /**
     * return null, since a leaf has no children
     * @return 
     */
    @Override
    public List<UserGroupComponent> getChildren() {
        return null;
    }

    /**
     * returns 0, since a leaf has no children
     * @return 
     */
    @Override
    public int getNumChildren() {
        return 0;
    }
    
    /**
     * Does nothing
     * @param c 
     */
    @Override
    public void add(UserGroupComponent c) {
        //
    }

    /**
     * Does nothing
     * @param c 
     */
    @Override
    public void remove(UserGroupComponent c) {
        //
    }
}
