/*
 * INSTRUCTION:
 *     This is a Java staring code for hw10_2.
 *     When you finish the development, download this file.
 *     Note that the current filename is "Main.java".
 *     But rename it to "Main_hw10_2.java".
 *     After that, upload the renamed file on Canvas.
 */

// Finish the head comment with Abstract, ID, Name, and Date.
/*
 * Title: Main_hw10_2.java
 * Abstract: Given a set of strings, find the order in that letters is sorted.
 * Keep in mind the order doesn't follow our alphabet convention. 
 * ID: 1337
 * Name: Paul Nguyen
 * Date: 04/22/22
 */

import java.util.*;
class Main 
{
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);

      LinkedHashSet<Character> linkedset = new LinkedHashSet<Character>();

      int rows = input.nextInt();
      int columns = 0;

      // String vector to record each word
      Vector<String> string_list = new Vector<>();
      
      for (int i = 0; i < rows+1; i++){
        string_list.add(input.nextLine());
        
        if (columns <= string_list.get(i).length()){
          columns = string_list.get(i).length();
        }    
      }

      // Matrix of characters from given words.
      char[][] letter_matrix = new char[rows][columns];
      for (int i = 0; i < rows; i++){
        // Fill up matrix with arbitary character that's not part of the aphabet.
        for (int j = 0; j < columns; j++){
          letter_matrix[i][j] = '.';
        }
        // Fill matrix with actual characters from given word.
        for (int k = 0; k < string_list.get(i+1).length(); k++){
          letter_matrix[i][k] = string_list.get(i+1).charAt(k);
        }
      }

      //
      for (int i = 0; i < columns; i++){
        for (int j = 0; j < rows; j++){
         if (letter_matrix[j][i] != '.')
           linkedset.add(letter_matrix[j][i]);
        }
      }

      // Keep place of the last element in the LinkedHashSet
      Character lastEle = '?';
      for (Character last : linkedset)
      {
        lastEle = last;
      }

      // Print out LinkedHashSet
      for (Character c : linkedset){
        if (c == lastEle){
          System.out.print(c);
        }
        else {
          System.out.print(c + "->");
        }
      }
      System.out.println();
      
    }
}