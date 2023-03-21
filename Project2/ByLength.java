package package1;

import java.util.*;
import java.util.Arrays;
//Comparartor class to sort by name length
public class ByLength implements Comparator<Student> {
    
    //overriding method that compares two names in the list
    @Override
    public int compare(Student a, Student b) {
        
        return a.name.length() - b.name.length();
    }
}