package cs356minitwitter.user.analysis;

/**
 * Interface for TwitterUserHashMaps to accept visitors
 *
 * @author Connor
 */
public interface TwitterUserHashMapElement {
    public int accept(TwittorUserHashMapVisitor v);
}
