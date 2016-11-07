/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs356minitwitter.nodes.analysis;

import cs356minitwitter.nodes.GroupComposite;

/**
 *
 * @author Connor
 */
public interface GroupVisitor {
    public int visitRoot(GroupComposite root);
}
