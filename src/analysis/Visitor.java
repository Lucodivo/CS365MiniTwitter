/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analysis;

import cs356minitwitter.nodes.RootComposite;

/**
 *
 * @author Connor
 */
public interface Visitor {
    public void visitRoot(RootComposite root);
}
