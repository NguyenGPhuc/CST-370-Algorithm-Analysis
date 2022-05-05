/*
 * INSTRUCTION:
 *     This is a Java staring code for hw8_2.
 *     When you finish the development, download this file.
 *     Note that the current filename is "Main.java".
 *     But rename it to "Main_hw8_2.java".
 *     After that, upload the renamed file on Canvas.
 */

// Finish the head comment with Abstract, ID, Name, and Date.
/*
 * Title: Main_hw8_2.java
 * Abstract: Knapsack problem with limitation. Find max combination, while following the rule that it must skip at least 1 box.
 * ID: 1337
 * Name: Paul Nguyen
 * Date: 04/08/2022
 */


// Original code: https://www.geeksforgeeks.org/power-set/
// Modify by Paul Nguyen for CST 370's assignment.

import java.util.*;

class Main 
{
    static void printPowerSet(int[] set, int set_size, StringBuilder sb)
    { 
        /*set_size of power set of a set
        with set_size n is (2**n -1)*/
        long pow_set_size = (long)Math.pow(2, set_size);
        int counter, j;
        

        int[] binary = new int[set_size];
        int[] combination = new int[set_size];
        int max = 0;
        int temp;
        int binaryFlag;
        int boxes = 0;

      
        /*Run from counter 000..0 to
        111..1*/
        sb.append("Boxes:");
        for(counter = 0; counter < pow_set_size; counter++)
        {  
            binaryFlag = 0;
            temp = 0;

            for(j = set_size-1; j >= 0; j--){
               
                /* Check if jth bit in the
                counter is set If set then
                print jth element from set */
                if((counter & (1 << j)) > 0){
                  binary[j] = 1;
                  binaryFlag++;
                }
                else{
                  binary[j] = 0;
                }
            }

            if (binaryFlag >= 1){
              for (int i  = binary.length-1; i >= 0; i--){
                if (binary[i] == 1){
                  /* 
                    If there's a consecutive combination, it will add -1000 to max apple, 
                    effectively making it fails the test for max apple.
                  */
                 if (i != 0 && binary[i-1] == 1){
                  temp += -1000;
                }
                  else {
                    temp += set[i];
                  }
                }
               
              }

              // Hold number max apples with the limited combination.
              if (max < temp){
                max = temp;
                for (int k = binary.length-1; k >= 0; k--){
                  combination[k] = binary[k];
                }
              }
            }
          }
  
      for (int i = 0; i < combination.length; i++){
        boxes += 1;
      }
      // StringBuilder for the limited combination, with number of max appple.
      for (int k = 0; k < combination.length; k++){
        if (combination[k] == 1 && boxes == 1){
          sb.append(k + "\n");
        }
        else if (combination[k] == 1){
          sb.append(k + " ");
        }
        boxes -= 1;
      }
      
      sb.append("Max Apples:" + max);
    }
   

  
    public static void main(String[] args) {

      Scanner input = new Scanner(System.in);
      StringBuilder sb =  new StringBuilder();

      int number = input.nextInt();
      
      int[] set = new int[number];

      for (int i = 0; i < set.length; i++){
        set[i] = input.nextInt();
      }
      
      printPowerSet(set, set.length, sb);

      System.out.println(sb);
    }
}

