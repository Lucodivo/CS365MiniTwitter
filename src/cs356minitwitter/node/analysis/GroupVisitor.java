package cs356minitwitter.node.analysis;

import cs356minitwitter.node.GroupComposite;

/**
 * Interface for visitor that want to visit a GroupComposite and return an integer
 *
 * @author Connor
 */
public interface GroupVisitor {
    public int visitRoot(GroupComposite root);
}
