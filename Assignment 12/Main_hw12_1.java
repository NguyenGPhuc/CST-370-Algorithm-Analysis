/*
 * INSTRUCTION:
 *     This is a Java starting code for hw12_1.
 *     When you finish the development, download this file.
 *     Note that the current filename is "Main.java".
 *     But rename it to "Main_hw12_1.java".
 *     After that, upload the renamed file on Canvas.
 */

// Finish the head comment with Abstract, ID, Name, and Date.
/*
 * Title: Main_hw12_1.java
 * Abstract: Base of the coin collection puzzle. The program chooses the path that will 
 * output the maximum amount of coins. It can only go right or down, starting from top
 * left to bottom right.
 * ID: 1337
 * Name: Paul Nguyen
 * Date: 05/12/2022
 */

import java.io.*;
import java.util.*;
 
class Main 
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int row = input.nextInt();
        row++;
        int column = input.nextInt();
        column++;
        Stack<String> path = new Stack<String>();

        StringBuilder sb = new StringBuilder();

        int[][] pathGrid = new int[row][column];

        for (int i = 1; i < row; i++){
          for (int j = 1; j < column; j++){
            pathGrid[i][j] = input.nextInt();
          }
        }

        int firstRowSum = 0;
        for (int j = 0; j < column; j++){
          if (j == 0)
            firstRowSum = pathGrid[0][j];
          else{
             pathGrid[0][j] += firstRowSum;
             firstRowSum = pathGrid[0][j];
          } 
        }

        int firstColSum = 0;
        for (int i = 0; i < row; i++){
          if (i == 0)
            firstColSum = pathGrid[i][0];
          else{
            pathGrid[i][0] += firstColSum;
            firstColSum = pathGrid[i][0];
          } 
        }

        int maxSum = 0;
        for (int i = 1; i < row; i++){
          for (int j = 1; j < column; j++){
            if (pathGrid[i][j-1] > pathGrid[i-1][j]){
              pathGrid[i][j] = pathGrid[i][j-1] + pathGrid[i][j];
              maxSum = pathGrid[i][j];
            }
            else {
              pathGrid[i][j] = pathGrid[i-1][j] + pathGrid[i][j];
              maxSum = pathGrid[i][j];
            }
          }
        }

        // Print maximum matrix
        // System.out.println();
        // for (int i = 0; i < row; i++){
        //   for (int j = 0; j < column; j++){
        //     System.out.print(pathGrid[i][j] + " ");
        //     }
        //   System.out.println();
        // }

      
        int lastRow = --row;
        // System.out.println(lastRow);
        
        int lastColumn = --column;
        // System.out.println(lastColumn);
      
        int turns = lastRow + lastColumn;
        for (int i = 0; i < turns-1; i++){
          if (i == 0){
            path.push("(" + lastRow + "," + lastColumn + ")");
            // System.out.println(lastColumn);
          }

          else {
            if (pathGrid[lastRow][lastColumn-1] < pathGrid[lastRow-1][lastColumn]){
              path.push("(" + (lastRow-1) + "," + lastColumn + ")->");
              lastRow--;
              // System.out.println(lastRow);
              
            }
            else if (pathGrid[lastRow][lastColumn-1] == pathGrid[lastRow-1][lastColumn] && lastColumn == 1){
              path.push("(" + (lastRow-1) + "," + lastColumn + ")->");
              lastRow--;
              // System.out.println(lastColumn);
              
            }
            else {
              path.push("(" + lastRow + "," + (lastColumn-1) + ")->");
              lastColumn--;
              // System.out.println(lastColumn); 
            }
            
          }
        }


        System.out.println("Max coins:" + maxSum);
        System.out.print("Path:");
        while (!path.empty()){
          System.out.print(path.pop());
        }
        System.out.println();
        
    }
}

