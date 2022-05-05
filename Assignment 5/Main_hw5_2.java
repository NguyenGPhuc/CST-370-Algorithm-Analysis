/*
 * INSTRUCTION:
 *     This is a Java staring code for hw5_2.
 *     When you finish the development, download this file.
 *     Note that the current filename is "Main.java".
 *     But rename it to "Main_hw5_2.java".
 *     After that, upload the renamed file on Canvas.
 */

// Finish the head comment with Abstract, ID, Name, and Date.
/*
 * Title: Main_hw5_2.java
 * Abstract: With given vertices and edges, build a graph that represents a TSP problem. Find and display the shortest route.
 * ID: 1337
 * Name: Paul Nguyen
 * Date: 03/04/2022
 */

import java.util.*;
class Main 
{
    public static int factorial(int n)
    {
        if (n == 0)
          return 1;
          
        return n*factorial(n-1);
    }
  
    public static void Permute(int[] input, int startindex, ArrayList<Integer> premutation) 
    {
        int size = input.length;
        
        if (size == startindex + 1) 
        {   
            // Assign current input premutation to 2d array.
            for (int j = 0; j < size; j++){
              // System.out.print(input[j] + "  ");
              premutation.add(input[j]);
            }
           
            // System.out.println();
          
        } 
        else 
        {
            for (int i = startindex; i < size; i++) 
            {
                int temp = input[i];
                input[i] = input[startindex];
                input[startindex] = temp;

                Permute(input, startindex + 1, premutation);
                temp = input[i];
                input[i] = input[startindex];
                input[startindex] = temp;
            }      
        } 
    }
  
    public static void main(String[] args) {

      Scanner input = new Scanner(System.in);
      StringBuilder path = new StringBuilder();
      Map<String, Integer> name = new HashMap<String, Integer>();
      Map<Integer, String> index = new HashMap<Integer, String>();
      ArrayList<Integer> premutation = new ArrayList<Integer>();
      String symbol;
      String city1;
      String city2;
      int weight;

      
  
      int vertecies = input.nextInt();
      int[][] matrix = new int[vertecies][vertecies];

      for (int i = 0; i < vertecies; i++){
        symbol = input.next();
        name.put(symbol, i);
        index.put(i, symbol);
      }

      int edges = input.nextInt();
      for (int i  = 0; i < edges; i++){
        city1 = input.next();
        city2 = input.next();
        weight = input.nextInt();

        matrix[name.get(city1)][name.get(city2)] = weight;
        // System.out.println("City1: " + name.get(city1));
        // System.out.println("City2: " + name.get(city2));
        // System.out.println("Weight: " + weight);
        // System.out.println(matrix[name.get(city1)][name.get(city2)]);
      }

      // System.out.println();
      
      int[] number = new int[vertecies-1];
      for (int j = 0; j < vertecies-1; j++) {
        number[j] = j+1;
      }
      Permute(number, 0, premutation);
      // System.out.println();
      
      for (int i = 0; i < vertecies; i++){
        for (int j = 0; j < vertecies; j++){
          // System.out.print(matrix[i][j] + " ");
        }
        // System.out.println();
      }

      int[][] setPath = new int[factorial(vertecies-1)][vertecies-1];
      int row = 0;
      int column = 0;

      // System.out.println(premutation.size());
      for (int i = 0; i < premutation.size(); i += vertecies-1) {
        // System.out.println(i);
        column = 0;
        for (int j  = i; j < i+(vertecies-1); j++){
          setPath[row][column] = premutation.get(j);
          // System.out.println("i: " + i);
          // System.out.println("j: " + j);
          
          // System.out.print(premutation.get(j) + " ");
          column++;
        }
        row++;
      }
      // System.out.println();

    

      int sum;
      int smallest = Integer.MAX_VALUE;
      int col;
      int[] shortPath = new int[vertecies+1];
      int[] tempPath = new int[vertecies+1];
      
      for (int i = 0; i < factorial(vertecies-1); i++){
        col = 0;
        sum = 0;
        
        for (int j = 0; j < vertecies; j++){
          // System.out.print(setPath[i][col] + " ");
          // Compute origin to first node
          // System.out.println("J: "+ j);
          // System.out.println("col: " + col);
          if (j == 0){
              // System.out.println("IN IF");
            
            if (matrix[j][setPath[i][col]] == 0){
              sum = -1;
              break;
            }
            else {
              sum += matrix[j][setPath[i][col]];
              tempPath[j] = 0;
              // col++;
            }
          }
          // Compute last node to origin
          else if (j == vertecies-1){
              // System.out.println("IN IF ELSE");
            
            if (matrix[setPath[i][col]][0] == 0){
              sum = -1;
              j++;
            }
            else{
              sum += matrix[setPath[i][col]][0];
              tempPath[j+1] = 0;
              
              if (col == vertecies-2) {
                if (matrix[setPath[i][col]][0] != 0){
                  // System.out.println("IN matrix[setPath[i][col]][0] != 0");
                  tempPath[j] = setPath[i][col]; 
                  j++;
                }
                else{
                  sum = -1;
                  j++;
                }
              }
            }
          }
          // Compute node to node
          else {
              // System.out.println("IN LAST ELSE");
              if (matrix[setPath[i][col]][setPath[i][col+1]] == 0){
                sum = -1;
                break;
              }
            
              else{
                sum += matrix[setPath[i][col]][setPath[i][col+1]];
                tempPath[j] = setPath[i][col];
                col++;
              }
          }
          
        }
        // System.out.println();
        // System.out.println("Path:" + Arrays.toString(tempPath));
        // System.out.println("Current sum: " + sum);
        // System.out.println("Current Smallest: " + smallest);
        
        // System.out.println();
        
       
        if (sum != -1){
          if (sum < smallest){
            smallest = sum;
            shortPath = tempPath.clone();
          }
          if (smallest == -1){
            smallest = sum;
            shortPath = tempPath.clone();
            break;
          }
        }
        else{
          smallest = -1;
        }
    
      }

      // System.out.println("Shortest path: " + Arrays.toString(shortPath));
      // System.out.println("Smallest: " + smallest);

      
      if (smallest != -1){
        path.append("Path:");
        for (int i = 0; i < shortPath.length; i++){
          if (i == shortPath.length-1){
            path.append(index.get(shortPath[i]) + "\n");
          }
          else{
            path.append(index.get(shortPath[i]) + "->");
          }
        }
        path.append("Cost:" + smallest);
      }
      else {
        path.append("Path:\n");
        path.append("Cost:-1");
      }
      
      System.out.println(path);
            
    }
}

