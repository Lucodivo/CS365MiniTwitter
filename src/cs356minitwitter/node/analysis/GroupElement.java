package cs356minitwitter.node.analysis;

/**
 * Interface for a GroupComposite element that needs to accept visitors
 *
 * @author Connor
 */
public interface GroupElement {
    public int accept(GroupVisitor v);
}