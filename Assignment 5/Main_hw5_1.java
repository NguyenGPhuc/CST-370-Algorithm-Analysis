/*
 * INSTRUCTION:
 *     This is a Java staring code for hw5_1.
 *     When you finish the development, download this file.
 *     Note that the current filename is "Main.java".
 *     But rename it to "Main_hw5_1.java".
 *     After that, upload the renamed file on Canvas.
 */

// Finish the head comment with Abstract, ID, Name, and Date.
/*
 * Title: Main_hw5_1.java
 * Abstract: Print the reverse sequence of an integer using recursive only.
 * ID: 1337
 * Name: Paul Nguyen
 * Date: 03/04/2022
 */

import java.util.*;
class Main 
{
    
  
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    StringBuilder revSequence = new StringBuilder();

    reverse(input.nextInt(), revSequence); 
    System.out.println(revSequence);
    }

    // Recursive function
    public static int reverse(int num, StringBuilder sb){
      if (num/10 < 1){
        sb.append(num);
        return num;
      }
      else{
        if (num%10 > 0){
          sb.append(num%10);
        }
        // Calling itself until end of last digit.
        return reverse(num/10, sb);
      }
    }
}

