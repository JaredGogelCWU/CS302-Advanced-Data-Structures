
package package1;

/**
* Project: Project2                                                     
* Completion time: 8 hours (fill in the time it took you to write the program)                                        
*                                                              
* Honor Code: “I pledge that I have neither given nor received help from anyone
* other than the instructor or the TAs for all program components included here.”
*/
import java.util.*;
import java.util.Arrays;

public class DriverClass {
    public static void main(String args[]) {
        
        //This creates the empty linked list
        LinkedList<Student> students = new LinkedList<>();
       
        // adding the student objects to the linked list
        students.add(new Student("Jared", 3.5));
        students.add(new Student("Ben", 4.0));
        students.add(new Student("Jackson", 2.2));
        students.add(new Student("Danika", 2.5));
        students.add(new Student("Beth", 3.4));
        
        //cloning the students linked list so we aren't doing successive sorts
        LinkedList<Student> studentsClone1;
        studentsClone1 = (LinkedList<Student>) students.clone();
        
        //cloning the sutdents linked list so we aren't doing successive sorts
        LinkedList<Student> studentsClone2;
        studentsClone2 = (LinkedList<Student>) students.clone();
        
        //Sorting the linked list with a comparator by name length and then printing out the new list
        Collections.sort(students, new ByLength());
        System.out.println("Sorted by name length");
        for(int i = 0; i < students.size(); i++){
            System.out.println(students.get(i));
        }
        
        //Sorting the linked list with a comparator by GPA number and then printing out the new list
        Collections.sort(studentsClone1, new ByGPA());
        System.out.println("");
        System.out.println("Sorted by GPA");
        for(int i = 0; i < studentsClone1.size(); i++){
            System.out.println(studentsClone1.get(i));
        }
        
        Student[] studentArray = studentsClone2.toArray(new Student[0]);
        //Sorting the array by name length using a comparator and then printing out the array
        Arrays.sort(studentArray, new ByLength());
        System.out.println("");
        System.out.println("Sorted by Name Length in an Array");
        for(Student c : studentArray) {
            System.out.println(c);
        }
      
        
    }
}
