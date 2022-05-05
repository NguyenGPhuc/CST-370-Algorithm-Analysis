/*
 * INSTRUCTION:
 *     This is a Java staring code for hw2_1.
 *     When you finish the development, download this file.
 *     Note that the current filename is "Main.java".
 *     But rename it to "Main_hw2_1.java".
 *     After that, upload the renamed file on Canvas.
 */

// Finish the head comment with Abstract, ID, Name, and Date.
/*
 * Title: Main_hw2_1.java
 * Abstract: Find overlaping of given number ranges. Display pairs of numbers that overlap all given range.
 * ID: 1337
 * Name: Paul Nguyen
 * Date: 02/10/2022
 */

import java.util.Scanner;
import java.util.Arrays;
import java.util.Vector;
 
class Main 
{
    public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);
    int lowerBound = Integer.MIN_VALUE;
    int higherBound = Integer.MAX_VALUE;
    int[] pair = new int[2];
    int[] tempPair = new int[2];
  
    int lines = input.nextInt();
    input.nextLine();

    for (int i = 0; i < lines; i++){
      String sPair = input.nextLine();

      String[] number = sPair.split(" ");
      tempPair[0] = Integer.parseInt(number[0]);
      tempPair[1] = Integer.parseInt(number[1]);

      if (tempPair[0] > tempPair[1]){
          int temp = 0;
          temp = tempPair[1];
          tempPair[1] = tempPair[0];
          tempPair[0] = temp;
      }
      
      if (number.length >= 2){
        if (lowerBound <= tempPair[0]){
          lowerBound = tempPair[0];
        }
        if (higherBound >= tempPair[1]){
          higherBound = tempPair[1];
        }
        
        pair[0] = lowerBound;
        pair[1] = higherBound;
      }
      else if (number.length == 1){
        lowerBound = tempPair[0];
        higherBound = tempPair[0];
      }     
      else {
        lowerBound = -1;
        higherBound = -1;
      }
    }
    if (pair[0] <= pair[1]){
      System.out.println(pair[0] + " " + pair[1]);
    }
    else {
      System.out.println(-1);
    }
  }
}

