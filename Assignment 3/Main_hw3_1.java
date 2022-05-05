/*
 * INSTRUCTION:
 *     This is a Java staring code for hw3_1.
 *     When you finish the development, download this file.
 *     Note that the current filename is "Main.java".
 *     But rename it to "Main_hw3_1.java".
 *     After that, upload the renamed file on Canvas.
 */

// Finish the head comment with Abstract, ID, Name, and Date.
/*
 * Title: Main_hw3_1.java
 * Abstract: Check is a string input a palindrome or not. Display "TRUE" for yes and "FALSE" for no.
 * ID: 1337
 * Name: Paul Nguyen
 * Date: 02/17/2022
 */

import java.util.*;
class Main 
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String flag = "TRUE";

        String word = input.nextLine();
        char[] letter = word.toUpperCase().toCharArray();

   
        for (int i = 0, j = letter.length-1; (i != j); i++, j--){
          if (letter[i] != letter[j]){
            flag = "FALSE";
            break;
          }
        }
        System.out.println(flag);
    }
}

