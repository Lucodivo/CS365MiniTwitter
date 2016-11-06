/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs356minitwitter.util;

import cs356minitwitter.nodes.GroupComposite;
import cs356minitwitter.nodes.RootComposite;
import cs356minitwitter.nodes.UserGroupComponent;
import cs356minitwitter.nodes.UserLeaf;
import java.util.List;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author Connor
 */
public class UserGroupTreeModel implements TreeModel {
    
    RootComposite root;
    
    public UserGroupTreeModel(RootComposite root){
        this.root = root;
    }

    @Override
    public Object getRoot() {
        return root;
    }

    @Override
    public Object getChild(Object parent, int index) {
        if(parent instanceof GroupComposite){
            return ((GroupComposite) parent).getChild(index);
        } else {
            return null;
        }
    }

    @Override
    public int getChildCount(Object parent) {
        if(parent instanceof GroupComposite) {
            return ((GroupComposite)parent).getChildren().size();
        } else {
            return 0;
        }
    }

    @Override
    public boolean isLeaf(Object node) {
        if(node instanceof UserLeaf) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {
        // No current need for implementation
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        if(parent instanceof GroupComposite) {
            List<UserGroupComponent> components = ((GroupComposite)parent).getChildren();
            if(components != null) {
                for (int i = 0; i < components.size(); i++) {
                    if(components.get(i) == child) {
                        return i;
                    }
                }
            }
        }
        
        return -1;
    }

    @Override
    public void addTreeModelListener(TreeModelListener l) {
        // No current need for implementation
    }

    @Override
    public void removeTreeModelListener(TreeModelListener l) {
        // No current need for implementation
    }
}
