/**
* Project: Project5                                                     
* Completion time: 6 hours (fill in the time it took you to write the program)                                        
*                                                              
* Honor Code: “I pledge that I have neither given nor received help from anyone
* other than the instructor or the TAs for all program components included here.”
*/
/**
 * directed graph implementation using Collections
 */
import java.util.Arrays;
import java.util.List;
 
// Java doesn't have a default implementation of the graph data structure.
// However, we can implement the graph using Java Collections. 
public class NewMain {

     public static void main (String[] args)
    {
        
        /*
         The asList() method of java.util.Arrays class is used to return 
         a fixed-size list backed by the specified array.
        
         asList () returns a type of ArrayList that is different
         from java. util. ArrayList. The main difference is that 
         the returned ArrayList only wraps an existing array — it doesn't
         implement the add and remove methods
        */        

        // Input: List of edges in a digraph (as per the above diagram)
        List<Edge> edges = Arrays.asList(new Edge(0, 1), new Edge(1, 2),
                new Edge(2, 0), new Edge(2, 1), new Edge(3, 2),
                new Edge(4, 5), new Edge(5, 4));
        //adding the other two sets of edges for the other two graphs
        List<Edge> edges2 = Arrays.asList(new Edge(1, 2), new Edge(2, 3),
                new Edge(2, 0), new Edge(0, 6), new Edge(2, 5),
                new Edge(7, 9), new Edge(0, 4));
        
        List<Edge> edges3 = Arrays.asList(new Edge(2, 1), new Edge(1, 2),
                new Edge(7, 9), new Edge(6, 8), new Edge(3, 2),
                new Edge(9, 3), new Edge(2, 6));
 
        // construct a graph from the given list of edges
        Graph graph = new Graph(edges);
        //making the other two graphs
        Graph graph1 = new Graph(edges2);
        Graph graph2 = new Graph(edges3);
        // print adjacency list representation of the graph
        graph.printGraph(graph);
        
        //running methods for graph 1
        graph.BFS(0, graph);
        graph.DFS(0, graph);
        graph.strongC(graph, edges);
        graph.cycle(graph);
        //running methods for graph 2
        graph1.BFS(1, graph1);
        graph1.DFS(1, graph1);
        graph1.strongC(graph1, edges2);
        graph1.cycle(graph1);
        //running methods for graph 3
        graph2.BFS(2, graph2);
        graph2.DFS(2, graph2);
        graph2.strongC(graph2, edges2);
        graph2.cycle(graph2);
    }   
}
