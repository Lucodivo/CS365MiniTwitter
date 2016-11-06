/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs356minitwitter.nodes;

import analysis.TwitterElement;
import analysis.Visitor;

/**
 *
 * @author Connor
 */
public class RootComposite extends GroupComposite implements TwitterElement{
    
    public RootComposite(String id) {
        super(id);
    }

    @Override
    public void accept(Visitor v) {
        v.visitRoot(this);
    }
}
