
package package1;

import java.util.*;

public class Customer {
    //private fields
    private int priority;
    private int tick;
    private int firstTick;
    private int lastTick;
    
    //constructor
    public Customer(int tick ){
        
        Random r = new Random();
        this.priority = r.nextInt(100) + 1;
        this.tick = tick;
        
    }
    
    //getter for priority
    public int getPriority(){
        
        return priority;
    }
    
    //time calculator
    public int calculateTime(int currentTick){
        
        this.lastTick = currentTick;
        int timePassed = this.lastTick - this.firstTick;
        
        return timePassed;
    }
}
