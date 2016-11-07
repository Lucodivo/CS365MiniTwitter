package cs356minitwitter.user.analysis;

import cs356minitwitter.user.analysis.util.Dictionary;

import java.util.ArrayList;

/**
 * A Dictionary that holds all words considered good. Words will all be lower-case.
 * 
 * @author Connor
 */
public class GoodWordDictionary extends ArrayList<String> implements Dictionary {
    
    // GoodWordDictionary singleton instance
    private static GoodWordDictionary dwDict;
    
    /**
     * Constructor
     * Private singleton constructor, initialized with ArrayList of good words
     * @param goodWords 
     */
    private GoodWordDictionary(ArrayList<String> goodWords) {
        super(goodWords);
        dwDict = this;
    }
    
    /**
     * Returns an instance of GoodWordDictionary
     * @return 
     */
    public static GoodWordDictionary getDictionary() {
        // if instance is null, create new instance
        if(dwDict == null){
            // create an array list of good words (Can be edited to add other words)
            ArrayList<String> goodWords = new ArrayList<String>();
            goodWords.add("good");
            goodWords.add("nice");
            goodWords.add("kind");
            goodWords.add("great");
            goodWords.add("excellent");
            goodWords.add("cool");
            goodWords.add("sweet");
            goodWords.add("beautiful");
            goodWords.add("cute");
            goodWords.add("pretty");
            goodWords.add(":)");
            
            // initialize instance with array of words
            return new GoodWordDictionary(goodWords);
        }
        // otherwise, return the current instance
        return dwDict;
    }

    /**
     * Returns the word at specified index
     * @param index
     * @return 
     */
    @Override
    public String getWord(int index) {
        return this.get(index);
    }

    /**
     * Returns the amount of words in the dictionary
     * @return 
     */
    @Override
    public int getSize() {
        return this.size();
    }
}
