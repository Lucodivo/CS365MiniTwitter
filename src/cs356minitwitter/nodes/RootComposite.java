/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs356minitwitter.nodes;

import analysis.GroupElement;
import analysis.GroupVisitor;

/**
 *
 * @author Connor
 */
public class RootComposite extends GroupComposite implements GroupElement{
    
    public RootComposite(String id) {
        super(id);
    }

    @Override
    public void accept(GroupVisitor v) {
        v.visitRoot(this);
    }
}
