/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analysis;

import cs356minitwitter.nodes.GroupComposite;

/**
 *
 * @author Connor
 */
public interface GroupVisitor {
    public void visitRoot(GroupComposite root);
}
