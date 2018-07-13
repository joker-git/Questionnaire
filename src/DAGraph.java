import java.io.File;
import java.io.IOException;
import java.util.*;


/**
 * Created by Saurav on 07/13/2018
 */

public class DAGraph {

    /**
     * A user-defined class for representing a Directed Graph with adjacency List.
     * The array 'inDegree' will have value 'True' if it has non-zero-in-degree and 'False' for zero-in-degree.
     *
     * @author Saurav
     *
     */
    private static class Graph {
        int V;
        boolean[] inDegree;
        LinkedList[] adjListArray;

        /**
         * Constructor for initialising the graph
         * @param V number of vertices
         */
        Graph(int V) {
            this.V = V;

            //initialising the array inDegree
            this.inDegree = new boolean[V];
            // defining the size of array as
            // number of vertices
            this.adjListArray = new LinkedList[V];

            // Creating a new list for each vertex
            for (int i = 0; i < V; i++) {
                this.adjListArray[i] = new LinkedList<>();
            }
        }

        /**
         * The helper funtion to print the path as mentioned in the problem 1
         *
         * @param v Represeting the present node
         * @param value Representing the path travelled till now
         */
        void PrintPathUtil(int v, String value)
        {

            //If reaching a dead-end print the path
            if(adjListArray[v].isEmpty()){
                System.out.println(value);
                return;
            }

            // Recur for all the vertices adjacent to this vertex
            Iterator<Integer> i = adjListArray[v].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                PrintPathUtil(n, value+"->"+n);

            }
        }


    }

    /**
     * Function to add Edge in a directed graph
     * @param graph the graph where edge is to be added
     * @param src   the source vertex
     * @param dest  the destination vertez
     */
    static void addEdge(Graph graph, int src, int dest) {
        // Add an edge from src to dest and mark dest as true for non-zero-in-degree.
        graph.adjListArray[src].addFirst(dest);
        graph.inDegree[dest] = true;


    }

    /**
     * A function to print the paths as mentioned in the problem 1
     *
     * @param graph the graph on which the operation is to be performed
     */
    static void printGraph(Graph graph) {
        for (int v = 0; v < graph.V; v++) {
            //Check if zero-in-degree or not.
            if(!graph.inDegree[v]){
                graph.PrintPathUtil(v,v+"");

            }

        }
    }

    // Driver program to test above functions
    public static void main(String args[]) {
        //the default file name
        String fileName = System.getProperty("user.dir") + File.separator+"resources"+File.separator+"input1.txt";
        Scanner sc;
        //V: vertices in the graph
        //src: variable for getting the source from input
        //dest: variable for getting the destination from input
        int V = 0,src,dest;
        Graph graph;
        //if args contains the file name
        if (args.length == 1)
            fileName = args[0];
        //try-catch block for reading the file
        try {
            //reading the file
            sc = new Scanner(new File(fileName));
            V = sc.nextInt();
            //constructing the graph
            graph = new Graph(V);
            while(sc.hasNext()){
                src = sc.nextInt();
                dest = sc.nextInt();
                addEdge(graph, src, dest);
            }
            //print the graph
            printGraph(graph);
        } catch (IOException e) {
            e.printStackTrace();
        }





    }
}
