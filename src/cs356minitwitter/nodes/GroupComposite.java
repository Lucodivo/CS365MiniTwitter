/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs356minitwitter.nodes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Connor
 */
public class GroupComposite extends UserGroupComponent {
    
    List<UserGroupComponent> components;

    public GroupComposite(String id) {
        super(id);
        
        components = new ArrayList<UserGroupComponent>();
    }

    @Override
    public void add(UserGroupComponent c) {
        components.add(c);
    }

    @Override
    public void remove(UserGroupComponent c) {
        components.remove(c);
    }

    @Override
    public UserGroupComponent getChild(int i) {
        if(components.size() > i){
            return components.get(i);
        } else {
            return null;
        }
    }
    @Override
    public List<UserGroupComponent> getChildren() {
        return this.components;
    }
}
