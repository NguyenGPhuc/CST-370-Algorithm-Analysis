/*
 * INSTRUCTION:
 *     This is a Java staring code for hw4_1.
 *     When you finish the development, download this file.
 *     Note that the current filename is "Main.java".
 *     But rename it to "Main_hw4_1.java".
 *     After that, upload the renamed file on Canvas.
 */

// Finish the head comment with Abstract, ID, Name, and Date.
/*
 * Title: Main_hw4_1.java
 * Abstract: Take user's graph data and create an adjacency list from it.
 * ID: 1337
 * Name: Paul Nguyen
 * Date: 02/24/2022
 */

import java.util.*;
  
class Main 
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int vertices = input.nextInt();
        int edges = input.nextInt();
        int[][] adjacency = new int[vertices][vertices];

        StringBuilder adjList = new StringBuilder();
        ArrayList<Integer> graph = new ArrayList<Integer>();
        
        for (int i = 0; i < edges*2; i++){
          graph.add(input.nextInt());
        }

        for (int i = 0; i < edges; i++){
          adjacency[graph.get(2*i)][graph.get(2*i + 1)] = 1;
        }

        for (int i = 0; i < vertices; i++){
          adjList.append(i);
          for (int j = 0; j < vertices; j++){
            if (adjacency[i][j] == 1){
              adjList.append("->" + j);
            }
          }
          if (i != vertices-1){
            adjList.append('\n');
          }
        }

      // System.out.println(graph);
      System.out.println(adjList);
        
    }
}

