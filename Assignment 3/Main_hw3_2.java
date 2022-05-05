/*
 * INSTRUCTION:
 *     This is a Java staring code for hw3_2.
 *     When you finish the development, download this file.
 *     Note that the current filename is "Main.java".
 *     But rename it to "Main_hw3_2.java".
 *     After that, upload the renamed file on Canvas.
 */

// Finish the head comment with Abstract, ID, Name, and Date.
/*
 * Title: Main_hw3_2.java
 * Abstract: Checks if two words are anagram of each other. If they are,
 * prints out the letter and the number of times they overlap. If not, print "NO ANAGRAM".
 * ID: 1337
 * Name: Paul Nguyen
 * Date: 02/17/2022
 */

import java.util.*;


class Main 
{
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in).useDelimiter("\\s");
        char[] alpha = new char[26];
        int[] occur = new int[26];
        boolean anagram = true;

        StringBuilder printOut = new StringBuilder();
        
        char[] letter1 = input.next().toUpperCase().toCharArray();
        char[] letter2 = input.next().toUpperCase().toCharArray();

        for (int i = 0; i < letter1.length; i++){
          alpha[letter1[i]  - 65] = letter1[i];
          occur[letter1[i]  - 65] += 1;
        }

        for (int i = 0; i < occur.length; i++){
          if (occur[i] > 0) {
            printOut.append(alpha[i] + ":" + occur[i] + "\n");
          }
        }

        for (int i = 0; i < letter2.length; i++){
            occur[letter2[i] - 65] -= 1;
        }

        for (int i = 0; i < occur.length-1; i++){
          if (occur[i] != 0){
            System.out.println("NO ANAGRAM");
            anagram = false;
            break;
          }
        }

        if (anagram == true){
          System.out.println("ANAGRAM");
          System.out.print(printOut);
        }
        
    }
}

