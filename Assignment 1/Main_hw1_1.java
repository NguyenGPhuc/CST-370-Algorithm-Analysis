/*
 * INSTRUCTION:
 *     This is a Java staring code for hw1_1.
 *     When you finish the development, download this file.
 *     Note that the current filename is "Main.java".
 *     But rename it to "Main_hw1_1.java".
 *     After that, upload the renamed file on Canvas.
 */

// Finish the head comment with Abstract, ID, Name, and Date.
/*
 * Title: Main_hw1_1.java
 * Abstract: Program determine the shortest distance pair(s) within a given list of integers. Print out the distance and the pair(s).
 * ID: 1337
 * Name: Paul Nguyen
 * Date: 02/03/2022
 */
 
import java.util.*;

class Main 
{
    public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);
    int size = input.nextInt();
    int min_distance = Integer.MAX_VALUE;

    // List of numbers vector
    Vector<Integer> numList = new Vector<>();
    
    for (;size > 0; size--){
      numList.add(input.nextInt());
    }

    // Sort list
    Collections.sort(numList);

    int different = 0;
   
   // Get minimum distant
    for (int i = 0; i < numList.size()-1; i++){
      different = numList.get(i+1) - numList.get(i);
      if (different < min_distance){
        min_distance = different;
       
      }
    }
    System.out.println("Min Distance:" + min_distance);

    // Get and print pair(s)
    for (int i = 0; i < numList.size()-1; i++){
      different = numList.get(i+1) - numList.get(i);
      if (different == min_distance){
        StringBuilder pairString = new StringBuilder("Pair:");

        pairString.append(numList.get(i));
        pairString.append(" " + numList.get(i+1));
        System.out.println(pairString);
      }
    }
    input.close();
  }
}

