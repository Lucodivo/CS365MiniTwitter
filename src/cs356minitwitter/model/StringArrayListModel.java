package cs356minitwitter.model;

import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.AbstractListModel;

/**
 * A model for ListView (JList) GUI components
 * Simply modifies an ArrayList<String> to work as a viewable model in a JList
 *
 * @author Connor
 */
public class StringArrayListModel extends AbstractListModel<String> {

    // data to be displayed
    ArrayList<String> strings;
    
    // Constructors
    /**
     * Create a model with an empty ArrayList
     */
    public StringArrayListModel() {
        strings = new ArrayList<String>();
    }
    
    /**
     * Create a model with strings from a HashSet
     * @param strings initial data to be displayed
     */
    public StringArrayListModel(HashSet<String> strings) {
        this(new ArrayList<String>(strings));
    }
    
    /**
     * Create a model with strings from an ArrayList
     * @param strings initial data to be displayed
     */
    public StringArrayListModel(ArrayList<String> strings) {
        this.strings = strings;
    }

    /**
     * Add a string to the model
     * @param s
     */
    public void addString(String s) {
        strings.add(s);
    }

    // AbstractListModel<String> overrides
    /**
     * Get number of elements in model
     * @return 
     */
    @Override
    public int getSize() {
        return strings.size();
    }

    /**
     * Get the index element in the model (from 0 to n-1)
     * @param index
     * @return String at specified index
     */
    @Override
    public String getElementAt(int index) {
        return strings.get(index);
    }
}
