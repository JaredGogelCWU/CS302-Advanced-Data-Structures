
package package1;

import java.util.*;
public class CustomerCompare implements Comparator<Customer> {
    
    //Override method that compares customer's priority
    @Override
    public int compare(Customer a, Customer b) {
        
        if(a.getPriority() > b.getPriority()){
            
            return a.getPriority();
            
        }else{
            
            return b.getPriority();
            
        }
        
    }
    
}
