/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs356minitwitter.nodes;

/**
 *
 * @author Connor
 */
public abstract class UserGroupComponent {
    
    protected String componentID;
    
    public UserGroupComponent(String id){
        this.componentID = id;
    }
    
    public String getID(){
        return componentID;
    }
    
    @Override
    public abstract String toString();
    
    public abstract void Add(UserGroupComponent c);
    public abstract void Remove(UserGroupComponent c);
    public abstract UserGroupComponent GetChild(int i);
}
