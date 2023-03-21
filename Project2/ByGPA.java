
package package1;

import java.util.*;
//comparator that sorts the array by GPA
public class ByGPA implements Comparator<Student> {
    //overriding method that compares two gpa fields
    @Override
    public int compare(Student a, Student b) {
        
        return Double.compare(a.gpa , b.gpa);
    }
}
