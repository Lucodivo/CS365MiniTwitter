package cs356minitwitter.user.analysis.util;

/**
 * Interface for a dictionary. Sets framework to return number of words
 * and the ability to iterate through all words
 *
 * @author Connor
 */
public interface Dictionary {
    public String getWord(int i);
    public int getSize();
}
