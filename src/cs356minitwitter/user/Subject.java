package cs356minitwitter.user;

import java.util.List;
import java.util.ArrayList;

/**
 * Subject for Observer pattern
 *
 * @author Connor
 */
public class Subject {
    // list of Observers
    private List<Observer> observers;
    
    /**
     * Constructor
     */
    public Subject(){
        observers = new ArrayList<Observer>();
    }
    
    /**
     * Add an observer to list of Observers
     * @param observer 
     */
    public void attach(Observer observer) {
        observers.add(observer);
    }
    
    /**
     * Remove an observer from list of Observers
     * @param observer 
     */
    public void detach(Observer observer) {
        observers.remove(observer);
    }
    
    /**
     * Call all observers to update
     */
    public void notifyObservers(){
        for(Observer observer : observers){
            observer.update(this);
        }
    }
}
