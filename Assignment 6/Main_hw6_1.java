/*
 * INSTRUCTION:
 *     This is a Java staring code for hw6_1.
 *     When you finish the development, download this file.
 *     Note that the current filename is "Main.java".
 *     But rename it to "Main_hw6_1.java".
 *     After that, upload the renamed file on Canvas.
 */

// Finish the head comment with Abstract, ID, Name, and Date.
/*
 * Title: Main_hw6_1.java
 * Abstract: Take a set of integers and print it out in a formate with a dash, if they are consecutive.
 * ID: 1337
 * Name: Paul Nguyen
 * Date: 03/11/2022
 */

import java.util.*;
class Main 
{
    public static void main(String[] args) {

      Scanner input = new Scanner(System.in);
      StringBuilder sb = new StringBuilder();
      int number = input.nextInt();
      int[] numSet = new int[number];

      for (int i  = 0; i < number; i++){
        numSet[i] = input.nextInt();
      }

      Arrays.sort(numSet);
      
      for (int i = 0; i < numSet.length; i++){
        if (i != numSet.length-1){
          // If consecutive, set another pointer that calculate ahead to get to the end of consecutive.
          if (numSet[i]+1 == numSet[i+1] ){
              if (i == 0){
                sb.append(numSet[i]);
              }
              else {
                sb.append(" " + numSet[i]);
              }
              
              int j = i+1;
              while (j != numSet.length-1  && numSet[j]+1 == numSet[j+1]){
                j++;
              }
              i = j;
              
              sb.append("-" + numSet[i]);
              
          }
          // If not consecutive, add to string normally.
          else{
            if (i == 0){
              sb.append(numSet[i]);
            }
            else{
              sb.append(" " + numSet[i]);
            }
          }
        }
        else {
          sb.append(" " + numSet[i]);
        }
      }

      System.out.println(sb);
    }
    
}

