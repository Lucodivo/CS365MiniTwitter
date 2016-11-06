/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analysis;

import cs356minitwitter.nodes.GroupComposite;
import cs356minitwitter.ui.InfoPopUpWindow;
import cs356minitwitter.util.TwitterUserHMap;
import java.util.HashMap;

/**
 *
 * @author Connor
 */
public class FindPercentPositiveVisitor implements HashMapVisitor{
    
    public FindPercentPositiveVisitor(){
        
    }

    @Override
    public void visitHashMap(HashMap hMap) {
        if(hMap instanceof TwitterUserHMap) {
            new InfoPopUpWindow("Percent Positive");
        }
    }
}
