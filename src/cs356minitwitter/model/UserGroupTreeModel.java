/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs356minitwitter.model;

import cs356minitwitter.node.GroupComposite;
import cs356minitwitter.node.RootComposite;
import cs356minitwitter.node.UserGroupComponent;
import cs356minitwitter.node.UserLeaf;

import java.util.List;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 * A model for JTree GUI components
 * Uses UserGroupComponents to work as a viewable model in a JTree
 *
 * @author Connor
 */
public class UserGroupTreeModel implements TreeModel {
    
    // the root of the UserGroupComponent model
    RootComposite root;
    
    /**
     * Constructor
     * Initialize the TreeModel with a specified RootComposite
     * @param root 
     */
    public UserGroupTreeModel(RootComposite root){
        this.root = root;
    }

    // Getters
    /**
     * Get the root Object (RootComposite, in this case)
     * @return 
     */
    @Override
    public Object getRoot() {
        return root;
    }

    /**
     * Get child of Object (Must be GroupComposite, in this case) at the
     * specified index
     * @param parent a GroupComposite object
     * @param index
     * @return UserGroupComponent child at specified index. Returns null if
     * index is out of bounds
     */
    @Override
    public Object getChild(Object parent, int index) {
        if(parent instanceof GroupComposite){
            return ((GroupComposite) parent).getChild(index);
        } else {
            return null;
        }
    }

    /**
     * Get number of children of a UserGroupComposite
     * @param parent GroupComposite object
     * @return number of UserGroupComponent children
     */
    @Override
    public int getChildCount(Object parent) {
        if(parent instanceof GroupComposite) {
            return ((GroupComposite)parent).getChildren().size();
        } else {
            return 0;
        }
    }

    /**
     * Returns true if the passed object is a instance of UserLeaf
     * @param node
     * @return
     */
    @Override
    public boolean isLeaf(Object node) {
        if(node instanceof UserLeaf) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get the index of a UserGroupComponent in respect to it's parent
     * @param parent UserGroupComponent object
     * @param child UserGroupComponent object
     * @return index of UserGroupComponent child in respect to parent. 
     *      returns -1 if child and parent do not have child/parent relationship
     */
    @Override
    public int getIndexOfChild(Object parent, Object child) {
        List<UserGroupComponent> components = ((UserGroupComponent) parent).getChildren();
        if (components != null) {
            for (int i = 0; i < components.size(); i++) {
                if (components.get(i) == child) {
                    return i;
                }
            }
        }

        return -1;
    }

    /**
     * unimplemented interface functions
     */
    /**
     * Does nothing
     * @param l 
     */
    @Override
    public void addTreeModelListener(TreeModelListener l) {
        // No current need for implementation
    }

    /**
     * Does nothing
     * @param path
     * @param newValue 
     */
    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {
        // No current need for implementation
    }

    /**
     * Does nothing
     * @param l 
     */
    @Override
    public void removeTreeModelListener(TreeModelListener l) {
        // No current need for implementation
    }
}
