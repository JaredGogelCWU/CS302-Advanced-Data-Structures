
package package1;

public class BinaryTree<T> implements java.io.Serializable{
    private T data;    
    private BinaryTree left;    
    private BinaryTree right;  
    //variables needed for constructors
    static int root = 0;
    static String[] str = new String[8];
     //creating root node
     public void Root(String key) {
         str[0] = key;
     }
    
    public BinaryTree(T data) { 
        this.data = data; 
        left = null; 
        right = null; 
    }    
    public T getData() {
        return data; 
    }
    //creating left child of root
    public void attachLeft(String key, int root) {
       int t = (root*2) + 1;
       str[t] = key;       
    }
    //creating right child of root
    public void attachRight(String key, int root) {
        int t = (root*2) + 2;
        str[t] = key;
    }    
    public BinaryTree<T> detachLeft() {
        BinaryTree t = left; left = null; return t; 
    }     
    public BinaryTree<T> detachRight() {
        BinaryTree t = right; right = null; return t; 
    }     
    public boolean isEmpty() {
        return data == null; 
    }
    public void inOrder(BinaryTree<T> tree)    {
        if ( tree != null) {
            inOrder(tree.left);
            System.out.println(tree.getData());
            inOrder(tree.right); 
        }     
    }
    //preOder Traversal
    public void preOrder(BinaryTree<T> tree) {
        if ( tree != null) {
            System.out.println(tree.getData());
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }
    //postOder Traversal
    public void postOrder(BinaryTree<T> tree) {
        if ( tree != null) {
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.println(tree.getData());
        }
    }
}    
