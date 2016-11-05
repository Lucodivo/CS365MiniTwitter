/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs356minitwitter.util;

import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author Connor
 */
public class StringArrayListModel extends AbstractListModel<String> {

    ArrayList<String> strings = new ArrayList<String>();

    public void addString(String s) {
        strings.add(s);
    }

    @Override
    public int getSize() {
        return strings.size();
    }

    @Override
    public String getElementAt(int index) {
        return strings.get(index);
    }
}
