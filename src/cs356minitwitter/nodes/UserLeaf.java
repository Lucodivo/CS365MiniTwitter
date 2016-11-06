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
public class UserLeaf extends UserGroupComponent {

    public UserLeaf(String id) {
        super(id);
    }

    @Override
    public void Add(UserGroupComponent c) {
        //
    }

    @Override
    public void Remove(UserGroupComponent c) {
        //
    }

    @Override
    public UserGroupComponent GetChild(int i) {
        return null;
    }

    @Override
    public String toString() {
        return this.componentID;
    }
}
