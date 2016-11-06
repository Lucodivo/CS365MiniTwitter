/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs356minitwitter.nodes;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author Connor
 */
public class UserGroupTreeModel implements TreeModel {
    
    UserGroupComponent root;
    
    public UserGroupTreeModel(UserGroupComponent root){
        this.root = root;
    }

    @Override
    public Object getRoot() {
        return root;
    }

    @Override
    public Object getChild(Object parent, int index) {
        if(parent instanceof GroupComposite){
            return ((GroupComposite) parent).GetChild(index);
        } else {
            return null;
        }
    }

    @Override
    public int getChildCount(Object parent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        if(parent instanceof GroupComposite) {
            return 0;
        }
        
        return 0;
    }

    @Override
    public void addTreeModelListener(TreeModelListener l) {
    }

    @Override
    public void removeTreeModelListener(TreeModelListener l) {
    }
}
