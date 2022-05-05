/*
 * INSTRUCTION:
 *     This is a Java staring code for hw6_2.
 *     When you finish the development, download this file.
 *     Note that the current filename is "Main.java".
 *     But rename it to "Main_hw6_2.java".
 *     After that, upload the renamed file on Canvas.
 */

// Finish the head comment with Abstract, ID, Name, and Date.
/*
 * Title: Main_hw6_2.java
 * Abstract: Program uses DFS to display ascending vertices in the correct order it was checked.
 * ID: 1337
 * Name: Paul Nguyen
 * Date: 03/12/2022
 */

import java.util.*;
class Main 
{
    static int count = 0;
  
    public static void dfs(int v, int[][] matrix, int vertices, int[] marked){
      // Mark current vertices as being checked.
      count = count + 1;
      marked[v] = count;

      // Check every edges for current vertex. If found, call dfs() on the adjacent vertex. 
      for (int i = v; i < vertices; i++){
        if (matrix[v][i] == 1 && marked[i] == 0){
          dfs(i, matrix, vertices, marked);
        }
      }
    }

  
    public static void main(String[] args) {

      Scanner input = new Scanner(System.in);
      StringBuilder sb = new StringBuilder();

      int vertices = input.nextInt();
      int[] marked = new int[vertices];

      int[][] matrix = new int[vertices][vertices];
      int edges = input.nextInt();
      int v1 = 0;
      int v2 = 0;

      for (int i = 0; i < edges; i++){
        v1 = input.nextInt();
        v2 = input.nextInt();

        matrix[v1][v2] = 1;
      }

      // Only pass vertices that has not been visited.
      for (int i = 0; i < vertices; i++){
        if (marked[i] == 0){
          dfs(i, matrix, vertices, marked);
        }
      }

      for (int i = 0; i < vertices; i++){
        if (i == vertices-1){
          sb.append("Mark" + "[" + i + "]:" + marked[i]);
        }
        else{
           sb.append("Mark" + "[" + i + "]:" + marked[i] + "\n");
        }
      }

      System.out.println(sb);     
      
    }
}

