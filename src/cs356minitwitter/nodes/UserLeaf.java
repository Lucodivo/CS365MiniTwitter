/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs356minitwitter.nodes;

import java.util.List;

/**
 *
 * @author Connor
 */
public class UserLeaf extends UserGroupComponent {

    public UserLeaf(String id) {
        super(id);
    }

    @Override
    public void add(UserGroupComponent c) {
        //
    }

    @Override
    public void remove(UserGroupComponent c) {
        //
    }

    @Override
    public UserGroupComponent getChild(int i) {
        return null;
    }

    @Override
    public List<UserGroupComponent> getChildren() {
        return null;
    }
}
