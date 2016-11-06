/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs356minitwitter.user;

import java.util.ArrayList;

/**
 *
 * @author Connor
 */
public class Subject {
    private ArrayList<Observer> observers;
    
    public Subject(){
        observers = new ArrayList<Observer>();
    }
    
    public void attach(Observer observer) {
        observers.add(observer);
    }
    
    public void detach(Observer observer) {
        observers.remove(observer);
    }
    
    public void notifyObservers(){
        for(Observer observer : observers){
            observer.update(this);
        }
    }
}
