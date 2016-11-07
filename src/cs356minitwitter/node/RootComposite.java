package cs356minitwitter.node;

import cs356minitwitter.node.analysis.GroupElement;
import cs356minitwitter.node.analysis.GroupVisitor;

/**
 * A special GroupComposite that allows a visitor to use it's data
 *
 * @author Connor
 */
public class RootComposite extends GroupComposite implements GroupElement{
    
    /**
     * Initialized as a GroupComposite object
     * @param id 
     */
    public RootComposite(String id) {
        super(id);
    }

    /**
     * Gives a GroupVisitor a Reference to self and returns the integer at the
     * visitor returns
     * @param v
     * @return returned visitor value
     */
    @Override
    public int accept(GroupVisitor v) {
        return v.visitRoot(this);
    }
}
