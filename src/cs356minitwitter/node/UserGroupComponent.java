package cs356minitwitter.node;

import java.util.List;

/**
 * Foundation class for creating a composite tree
 *
 * @author Connor
 */
public abstract class UserGroupComponent {
    
    // String used to identify component
    protected String componentID;
    
    /**
     * Every UserGroupComponent must be initialized with a specified component ID
     * @param id 
     */
    public UserGroupComponent(String id){
        this.componentID = id;
    }
    
    /**
     * Get component's ID
     * @return 
     */
    public String getID(){
        return componentID;
    }
    
    /**
     * Override of Object's toString() function. Allows for the UserGroupComponent
     * to be easily written to GUIs
     * @return the component's ID String
     */
    @Override
    public String toString() {
        return this.componentID;
    }
    
    /*
     * Abstract functions to be implemented in inherited classes
     */
    public abstract void add(UserGroupComponent c);
    public abstract void remove(UserGroupComponent c);
    public abstract UserGroupComponent getChild(int i);
    public abstract List<UserGroupComponent> getChildren();
    public abstract int getNumChildren();
}
