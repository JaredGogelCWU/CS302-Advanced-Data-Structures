
package package1;
/**
 * Project: Project1
 * Completion time: 6 hours (fill in the time it took you to write the program) 
 *                                                              
 * Honor Code: “I pledge that I have neither given nor received help from anyone
 * other than the instructor or the TAs for all program components included here.”
 */
import java.io.*;
public class DriverClass { 
    
    public static void main(String[] args) {
        
        //creating the empty array
        String[] str = new String[8];
        //Creating the BinaryTree object, making it a String array type, and giving it the empty array
        BinaryTree <String[]> t =  new BinaryTree <>(str);
        
        //Building the Binary Tree
        t.Root("A");
        t.attachLeft("B",0);
        t.attachRight("C", 0);
        t.attachLeft("D", 1);
        t.attachRight("E", 1);
        t.attachLeft("F", 2);
        t.attachRight("G", 2);
        
        
        //Serlizaing the finished Binary Tree
        try {
         FileOutputStream fileOut = new FileOutputStream("Project1/BinaryTree.docx");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(t);
         out.close();
         fileOut.close();
         System.out.printf("Serialized data is saved in /Project1/BinaryTree.docx");
      } catch (IOException i) {
         i.printStackTrace();
      }
        
        //Desealrizing the Binary Tree
        try {
         FileInputStream fileIn = new FileInputStream("/Project1/BinaryTree.docx");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         t = (BinaryTree <String[]>) in.readObject();
         in.close();
         fileIn.close();
      } catch (IOException i) {
         i.printStackTrace();
         return;
      } catch (ClassNotFoundException c) {
         System.out.println("BinaryTree class not found");
         c.printStackTrace();
         return;
      }
        //Running preOrder, postOrder, and inOrder traversal   
        t.preOrder(t);
        System.out.println(t);
        t.postOrder(t);
        System.out.println(t);
        t.inOrder(t);
        System.out.println(t);
    }
}
