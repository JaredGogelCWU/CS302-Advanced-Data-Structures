
/**
 * The graph is represented as an ArrayList of 
 * adjacency ArrayList Integer objects 
 * 
 */
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Graph {
    
    // A list of lists to represent an adjacency list
    List<List<Integer>> adj = new ArrayList<>();
 
    // Constructor to construct a graph
    // input parameter is an Array of Edge objects 
    public Graph(List<Edge> edges)
    {
        // find the maximum numbered vertex
        int n = 0;
        for (Edge e: edges) {
            n = Integer.max(n, Integer.max(e.src, e.dest));
        }
 
        // allocate memory for the adjacency list
        for (int i = 0; i <= n; i++) {
            adj.add(i, new ArrayList<>());
        }
 
        // add edges to the undirected graph
        for (Edge current: edges)
        {
            // allocate new node in adjacency list from src to dest
            adj.get(current.src).add(current.dest);
 
            // for undirected graph, uncomment and use the following line
            // adj.get(current.dest).add(current.src);
        }
    }
 
    // Function to print adjacency list representation of a graph
    public void printGraph(Graph graph)
    {
        int src = 0;
        int n = graph.adj.size();
 
        while (src < n)
        {
            // print current vertex and all its neighboring vertices
            for (int dest: graph.adj.get(src)) {
                System.out.print("(" + src + " —> " + dest + ")\t");
            }
            System.out.println();
            src++;
        }
    }
    
    //Helper function for Depth-first traversal
    public void DFShelp(int src, boolean visited[], Graph graph) {
        
        //marking the current node as visited and printing it
        visited[src] = true;
        System.out.print(src + " ");
        
        
        //recursivley doing this for the adjacent vertices
        Iterator<Integer> i = graph.adj.get(src).listIterator();    
        while (i.hasNext()){
                
            int x = i.next();
            if (!visited[x]){
                DFShelp(src, visited, graph);
            }
        }
    }
    
    //Method for Depth-first traversal from a given soruce vertex
    public void DFS(int src, Graph graph){
        
        //getting the total number of vertices
        int n = graph.adj.size();
        
        //marking all the vertices as not visited
        boolean visited[] = new boolean[n];
        DFShelp(src, visited, graph);
        
        
    }
    
    //Method for Bredth-first traversal from a given source vertex
    public void BFS(int src, Graph graph){
        //getting the total number of vertices
        int n = graph.adj.size();
        
        //marking all the vertices as not visited
        boolean visited[] = new boolean[n];
        
        //creating a queue
        LinkedList<Integer> queue = new LinkedList<>();
        
        //Marking the current node as visited and enquueing it
        visited[src] = true;
        queue.add(src);
        
        
        while(queue.size()!=0){
            
            //Dequeueing the vertex from the queue and printing it
            src = queue.poll();
            System.out.print(src + " ");
            
            //getting the adjacent vertices. If it has not been visited then it marks it
            //then visited is enqueued
            Iterator<Integer> i = graph.adj.get(src).listIterator();
            
            while (i.hasNext()){
                
                int x = i.next();
                if (!visited[x]){
                    
                    visited[x] = true;
                    queue.add(n);
                }
            }
            
        }
    }
    //Method the returns a reversed graph
    public Graph getTranspose(List<Edge> edges){
        
        Graph g = new Graph(edges);
        int size = g.adj.size();
        
        for (int i = 0; i < size; i++){
            Iterator<Integer> x = g.adj.get(i).listIterator();
            while (x.hasNext()){
                g.adj.get(x.next()).add(i);
            }
        }
        return g;
    }
    
    //Method for checking Strong Connectivity
    public boolean strongC(Graph graph, List<Edge> edges){
        
        //Marking all the vertices as not viisted
        int n = graph.adj.size();
        boolean visited[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            visited[i] = false;
        }
        
        //doing the first Depth-First traversal
        DFShelp(0, visited, graph);
        //checking if the traversal visits all of the vertices
        for (int i = 0; i < n; i++ ){
            if (visited[i] == false){
                return false;
            }
        }
        
        //creating a reversed graph
        Graph rg = getTranspose(edges);
        for (int i = 0; i < n; i++) {
            visited[i] = false;
        }
        
        //doing the second Depth-frist traversal on the reversed graph
        rg.DFShelp(0, visited, graph);
        
        //checking if the traversal visits all of the vertices
        for (int i = 0; i < n; i++ ){
            if (visited[i] == false){
                return false;
            }
        }
    //returns true if all the vertices are visited for both graphs    
    return true;    
    }
    //helper method for checking for a cycle in the graph
    public boolean cyclehelp(int i, boolean[] visited, boolean[] recStack){
        
        if (recStack[i]){
            return true;
        }
        
        if (visited[i]){
            return true;
        }
        
        visited[i] = true;
        recStack[i] = true;
        List<Integer> children = adj.get(i);
        
        for (Integer c: children) {
            if (cyclehelp(c, visited, recStack)) {
                return true;
            }    
        }
        recStack[i] = false;
        return false;
    }
    
    public boolean cycle(Graph graph){
        //marking all the vertices as not visited and not in the recursion stack
        int n = graph.adj.size();
        boolean visited[] = new boolean[n];
        boolean recStack[] = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            visited[i] = false;
        }
        
        for (int i = 0; i < n; i++) {
            recStack[i] = false;
        }
        
        //calling the helper method to find cycles
        for (int i = 0; i < n; i++) {
            if (cyclehelp(i, visited, recStack)){
                return true;
            }
        }
        
        return true;
    }
}
