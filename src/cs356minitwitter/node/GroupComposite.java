package cs356minitwitter.node;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite node that is capable of having child UserGroupComponents
 *
 * @author Connor
 */
public class GroupComposite extends UserGroupComponent {
    
    // list of children
    List<UserGroupComponent> components;

    /**
     * All UserGroupComponents must be initialized with an ID String
     * @param id 
     */
    public GroupComposite(String id) {
        super(id);
        
        components = new ArrayList<UserGroupComponent>();
    }

    /**
     * Add a specified UserGroupComponent child as a child of this GroupComposite
     * @param c 
     */
    @Override
    public void add(UserGroupComponent c) {
        components.add(c);
    }

    /**
     * Remove a specified UserGroupComponent child from this GroupComposite
     * @param c 
     */
    @Override
    public void remove(UserGroupComponent c) {
        components.remove(c);
    }

    /**
     * Get UserGroupComponent at specified index
     * @param i
     * @return 
     */
    @Override
    public UserGroupComponent getChild(int i) {
        if(components.size() > i){
            return components.get(i);
        } else {
            return null;
        }
    }
    
    /**
     * Get all children of this GroupComposite
     * @return 
     */
    @Override
    public List<UserGroupComponent> getChildren() {
        return this.components;
    }

    /**
     * Get number of UserGroupComponent children of this GroupComposite
     * @return 
     */
    @Override
    public int getNumChildren() {
        return this.components.size();
    }
}
