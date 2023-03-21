
package package1;

/**
* Project: Project4                                                     
* Completion time: 8 hours (fill in the time it took you to write the program)                                        
*                                                              
* Honor Code: “I pledge that I have neither given nor received help from anyone
* other than the instructor or the TAs for all program components included here.”
*/
import java.util.*;
public class MainDriver {
    //static fields
    static double waitTime;
    static Customer currentCustomer;
    static int customerTotal;
    
    public static void main(String args[]) {
        //tick counter
        int currentTick = 0;
        //inital Priority queue
        PriorityQueue<Customer> customerQueue = new PriorityQueue<>(6);
        
        //first event call
        Event event1 = new Event(currentTick, customerQueue);
        //adding to the tick counter
        currentTick++;
        //checking if the event is the arrival or departure with a boolean
        
        if(event1.getEventTorF()){
            //incrementing the total number of customers
            customerTotal++;
            currentCustomer = event1.getCustomerDeparture();
            //calulating the wait time
            waitTime += currentCustomer.calculateTime(currentTick);
            //dividing with a double as int would break on division
            double aveWaitTime = (double)(waitTime/(double)customerTotal);
            //giving the current custoemr count and average wait time 
            System.out.println("The average waiting time for " + customerTotal + " customers was " + aveWaitTime);
        }
        
        //repeat for the next event
        Event event2 = new Event(currentTick, customerQueue);
        currentTick++;
        
        if(event2.getEventTorF()){
            
            customerTotal++;
            currentCustomer = event1.getCustomerDeparture();
            waitTime += currentCustomer.calculateTime(currentTick);
            double aveWaitTime = (double)(waitTime/(double)customerTotal);
            System.out.println("The average waiting time for " + customerTotal + " customers was " + aveWaitTime);
        }
        
        //repeat for the next event
        Event event3 = new Event(currentTick, customerQueue);
        currentTick++;
        
        if(event3.getEventTorF()){
            
            customerTotal++;
            currentCustomer = event1.getCustomerDeparture();
            waitTime += currentCustomer.calculateTime(currentTick);
            double aveWaitTime = (double)(waitTime/(double)customerTotal);
            System.out.println("The average waiting time for " + customerTotal + " customers was " + aveWaitTime);
        }
        
        //repeat for the next event
        Event event4 = new Event(currentTick, customerQueue);
        currentTick++;
        
        if(event4.getEventTorF()){
            
            customerTotal++;
            currentCustomer = event1.getCustomerDeparture();
            waitTime += currentCustomer.calculateTime(currentTick);
            double aveWaitTime = (double)(waitTime/(double)customerTotal);
            System.out.println("The average waiting time for " + customerTotal + " customers was " + aveWaitTime);
        }
        
        //repeat for the next event
        Event event5 = new Event(currentTick, customerQueue);
        currentTick++;
        
        if(event5.getEventTorF()){
            
            customerTotal++;
            currentCustomer = event1.getCustomerDeparture();
            waitTime += currentCustomer.calculateTime(currentTick);
            double aveWaitTime = (double)(waitTime/(double)customerTotal);
            System.out.println("The average waiting time for " + customerTotal + " customers was " + aveWaitTime);
        }
        
        //repeat for the next event
        Event event6 = new Event(currentTick, customerQueue);
        currentTick++;
        
        if(event6.getEventTorF()){
            
            customerTotal++;
            currentCustomer = event1.getCustomerDeparture();
            waitTime += currentCustomer.calculateTime(currentTick);
            double aveWaitTime = (double)(waitTime/(double)customerTotal);
            System.out.println("The average waiting time for " + customerTotal + " customers was " + aveWaitTime);
        }
        
    }
    
}
