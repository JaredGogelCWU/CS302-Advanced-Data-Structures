
package package1;


public class Student {
    
    //protected varibles of student object
    double gpa;
    String name;
    
    //method to get the GPA field
    public double getGPA() {
        return gpa;
    }
    
    //method to get the Name field
    public String getName() {
        return name;
    }
    
    //constructor to make the student object 
    public Student (String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }
    
    //overriding string to print the 
    @Override
    public String toString(){
        return this.name + " " + this.gpa;
    }
    
}
