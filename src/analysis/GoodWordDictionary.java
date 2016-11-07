/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analysis;

import java.util.ArrayList;

/**
 *
 * @author Connor
 */
public class GoodWordDictionary extends ArrayList<String> implements Dictionary {
    private static GoodWordDictionary dwDict;
    
    private GoodWordDictionary(ArrayList<String> goodWords) {
        super(goodWords);
        dwDict = this;
    }
    
    public static GoodWordDictionary getDictionary() {
        if(dwDict == null){
            ArrayList<String> goodWords = new ArrayList<String>();
            goodWords.add("good");
            goodWords.add("nice");
            goodWords.add("kind");
            goodWords.add("great");
            goodWords.add("excellent");
            goodWords.add("cool");
            return new GoodWordDictionary(goodWords);
        }
        return dwDict;
    }

    @Override
    public String getWord(int i) {
        return this.get(i);
    }

    @Override
    public int getSize() {
        return this.size();
    }
}