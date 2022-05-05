/*
 * INSTRUCTION:
 *     This is a Java staring code for hw10_1.
 *     When you finish the development, download this file.
 *     Note that the current filename is "Main.java".
 *     But rename it to "Main_hw10_1.java".
 *     After that, upload the renamed file on Canvas.
 */

// Finish the head comment with Abstract, ID, Name, and Date.
/*
 * Title: Main_hw10_1.java
 * Abstract: Display the correct topological order of given nodes and vertices using Kahn's algorithm. Along with that, display the initial "in-degree" of the all nodes.
 * ID: 1337
 * Name: Paul Nguyen
 * Date: 04/22/2022
 */

import java.util.*;

// Kahn's algorithm original source code
// https://www.geeksforgeeks.org/topological-sorting-indegree-based-solution/

class Graph {
    // No. of vertices
    int V;
    // No. of nodes
    int N;
    // An Array of List which contains
    // references to the Adjacency List of
    // each vertex
    List<Integer> adj[];
    // Constructor
    public Graph(int V)
    {
        this.V = V;
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++)
            adj[i] = new ArrayList<Integer>();
    }
 
    // Function to add an edge to graph
    public void addEdge(int u, int v)
    {
        adj[u].add(v);
    }
    // prints a Topological Sort of the
    // complete graph
    public void topologicalSort()
    {
        // Create a array to store
        // indegrees of all
        // vertices. Initialize all
        // indegrees as 0.
        int indegree[] = new int[V];
 
        // Traverse adjacency lists
        // to fill indegrees of
        // vertices. This step takes
        // O(V+E) time
        for (int i = 0; i < V; i++) {
            ArrayList<Integer> temp = (ArrayList<Integer>)adj[i];
            for (int node : temp) {
                indegree[node]++;
            }
        }
 
        // Create a queue and enqueue
        // all vertices with indegree 0
        Queue<Integer> q
            = new LinkedList<Integer>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }
 
        // Initialize count of visited vertices
        int cnt = 0;
 
        // Create a vector to store result
        // (A topological ordering of the vertices)
        Vector<Integer> topOrder = new Vector<Integer>();
        while (!q.isEmpty()) {
            // Extract front of queue
            // (or perform dequeue)
            // and add it to topological order
            int u = q.poll();
            topOrder.add(u);
 
            // Iterate through all its
            // neighbouring nodes
            // of dequeued node u and
            // decrease their in-degree
            // by 1
            for (int node : adj[u]) {
                // If in-degree becomes zero,
                // add it to queue
                if (--indegree[node] == 0)
                    q.add(node);
            }
            cnt++;
        }
 
        // Check if there was a cycle
        if (cnt != V) {
            System.out.println(
                "There exists a cycle in the graph");
            return;
        }
 
        // Print topological order
        for (int i : topOrder) {
            if (i == topOrder.lastElement()){
              System.out.print(i);
            }
            else {
              System.out.print(i + "->");
            }
            
        }
    }
}


class Main 
{
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int nodes = input.nextInt();
      
        int vertex = input.nextInt();
      
        Graph g = new Graph(nodes);
        int[][] matrix = new int[nodes][nodes];
        
        for (int i = 0; i < vertex; i++){
          int start = input.nextInt();
          int end = input.nextInt();

          matrix[start][end] = 1;
          g.addEdge(start, end);
        }

        for (int col = 0; col < nodes; col++){
          int degree = 0;
          for (int row = 0; row < nodes; row++){
            degree += matrix[row][col];
          }
          System.out.println("In-degree[" + col + "]:" + degree);
        }

        System.out.print("Order:");
        g.topologicalSort();
        System.out.println();
    }
}

