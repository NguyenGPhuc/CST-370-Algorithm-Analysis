/*
 * INSTRUCTION:
 *     This is a Java starting code for hw12_2.
 *     When you finish the development, download this file.
 *     Note that the current filename is "Main.java".
 *     But rename it to "Main_hw12_2.java".
 *     After that, upload the renamed file on Canvas.
 */

// Finish the head comment with Abstract, ID, Name, and Date.
/*
 * Title: Main_hw12_2.java
 * Abstract: This program find the shortest paths in a directed weighted graph using Floyd's Algorithm.
 * ID: 1337
 * Name: Paul Nguyen
 * Date: 05/12/2022
 */

import java.util.*;

 
class Main 
{    
      public static void floyd(int[][] graph, int size){
        for (int k = 0; k < size; k++){
          for (int i = 0; i < size; i++){
            for (int j  = 0; j < size; j++){
              if (graph[i][k] == -1 || graph[k][j] == -1){
              }
              else if (graph[i][j] == -1){
                graph[i][j] = graph[i][k] + graph[k][j];
              }
              else if (graph[i][j] > graph[i][k] + graph[k][j]){
                graph[i][j] = graph[i][k] + graph[k][j];
              }
              else{
              }
            }
          }
        }
      }
  
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int size = input.nextInt();

        int[][] graph = new int[size][size];

        for (int i = 0; i < size; i++){
          for (int j = 0; j < size; j++){
            graph[i][j] = input.nextInt();
          }
        }
      
        floyd(graph, size);
      
        for (int i = 0; i < size; i++){
          for (int j = 0; j < size; j++){
            if (j != size-1)
              System.out.print(graph[i][j] + " ");
            else
              System.out.print(graph[i][j]);
          }
          System.out.println();
        }
        
        // System.out.println();
    }
}

