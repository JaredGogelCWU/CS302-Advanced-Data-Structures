
package package1;

import java.util.*;
public class Event {
  //private fields 
  private boolean eventTorF;
  private Customer customerDeparture;
  
  public Event(int currentTick, PriorityQueue<Customer> customerQueue){
      //random number generator for the two event types
      Random r = new Random();
      int ran = r.nextInt(2);
      
      if(ran == 0) {
          //arrival event
          Customer customer = new Customer(currentTick);
          
          customerQueue.add(customer);
          //setting the event boolen to false to identify what event was used
          this.eventTorF = false;
      }else{
          //departure event
          customerDeparture = customerQueue.poll();
          //setting the event boolen to true to identify what event was used
          this.eventTorF = true;
      }
      
  }
  //getter for customer departure
   public Customer getCustomerDeparture(){
       
          return this.customerDeparture;
      }
   //getter for what kind of event was used
   public boolean getEventTorF(){
       
       return this.eventTorF;
   }
}