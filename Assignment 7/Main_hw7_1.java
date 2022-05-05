/*
 * INSTRUCTION:
 *     This is a Java staring code for hw7_1.
 *     When you finish the development, download this file.
 *     Note that the current filename is "Main.java".
 *     But rename it to "Main_hw7_1.java".
 *     After that, upload the renamed file on Canvas.
 */

// Finish the head comment with Abstract, ID, Name, and Date.
/*
 * Title: Main_hw7_1.java
 * Abstract: Using divide and conquer to find the biggest number in the an array.
 * ID: 1337
 * Name: Paul Nguyen
 * Date: 03/24/2022
 */

import java.util.*;
class Main 
{

    // Sum the array A from start index to end index
    static int sum_div_N_conq(int A[], int start, int end) 
    {
      if (start == end) 
      {
          
          return A[start];
      }
      else 
      {
          int max1 = sum_div_N_conq (A, start, (start+end)/2);
          int max2 = sum_div_N_conq (A, (start+end)/2+1, end);

          if (max1 >= max2){
            return max1;
          }
          else {
            return max2;
          }
      }
    }
  
    public static void main(String[] args) {

      Scanner input = new Scanner(System.in);
      
      int numberOf =  input.nextInt();
      int[] numberList =  new int[numberOf];
      for (int i = 0; i < numberOf; i++){
        numberList[i] = input.nextInt();
      }

      int sum = sum_div_N_conq (numberList, 0, numberList.length-1);
      System.out.println(sum);
      
    }
}

