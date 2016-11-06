/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analysis;

import cs356minitwitter.nodes.RootComposite;
import cs356minitwitter.ui.InfoPopUpWindow;

/**
 *
 * @author Connor
 */
public class CountTweetsVisitor implements Visitor{
    
    public CountTweetsVisitor(){
        
    }

    @Override
    public void visitRoot(RootComposite root) {
        new InfoPopUpWindow("<html><div style='text-align: center;'>" + "Count Tweets" + "</div></html>");
    }
}
