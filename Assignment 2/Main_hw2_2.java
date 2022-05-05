/*
 * INSTRUCTION:
 *     This is a Java staring code for hw2_2.
 *     When you finish the development, download this file.
 *     Note that the current filename is "Main.java".
 *     But rename it to "Main_hw2_2.java".
 *     After that, upload the renamed file on Canvas.
 */

// Finish the head comment with Abstract, ID, Name, and Date.
/*
 * Title: Main_hw2_2.java
 * Abstract: With user input of number and strings, create enough index to hold binary for the number. Display strings accoding to binary.
 * ID: 1337
 * Name: Paul Nguyen
 * Date: 02/10/2022
 */

import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;

class Main 
{ 
    // StringBuilder for Binary portion.
    // From open source https://www.geeksforgeeks.org/program-decimal-binary-conversion/
    static StringBuilder toBinary(int n, int l){
      int[] binaryNum =  new int[32];
      StringBuilder binaryList = new StringBuilder();

        if (l == 0){
          binaryList.append("0");
          return binaryList;
        }

        int i = 0;
        while (l > 0){
          binaryNum[i] = n % 2;
          n = n/2;
          l = l - 1;
          i++;
        }

        for (int j = i - 1; j >= 0; j--){
          binaryList.append(binaryNum[j]);
        }
        return binaryList;
    }

    // StringBuilder for String portion
    static StringBuilder printString(String s, int n, String[] sl){
      int[] binNum = new int[n];
      char[] binChar = new char[n];
      
      StringBuilder sb = new StringBuilder();

      if (s.equals("0")){
        sb.append("EMPTY");
        return sb;
      }

      for (int i = 0; i < s.length(); i++){
        binChar[i] = s.charAt(i);
        binNum[i] = Character.getNumericValue(binChar[i]);
      }

      int sum = 0;
      for (int i = 0; i < binNum.length; i++){
        sum += binNum[i];
      }
      int counter = 0;
      for (int i = 0; i < s.length(); i++){
        
        if (binNum[i] == 1){
      
      
            if (sum == 1){
              counter++;
              sb.append(sl[i]);
            }

            else if (counter == sum-1){
              counter++;
              sb.append(sl[i]);
            }
            else {
              sb.append(sl[i] + " ");
              counter++;
            }
        }
      }

      if (sb.length() == 0){
        sb.append("EMPTY");
      }

      return sb;
    }


    public static void main(String[] args) {
      
      int numberInput = 0;

      StringBuilder answer = new StringBuilder();

      Scanner input = new Scanner(System.in);
      numberInput = input.nextInt();
      input.nextLine();

      String[] stringInput = new String[numberInput];
  
      try {
        String stringList = input.nextLine();

        stringInput = stringList.split(" ");
      }
      catch (Exception e) {
        System.out.println("Too many element");
      }
      
      // Display index, binary, and elements.
      for (int i = 0; i < Math.pow(2, numberInput); i++){
        if (i != Math.pow(2, numberInput)-1){
          answer.append(i + ":" + toBinary(i,numberInput) + ":" + printString(toBinary(i,numberInput).toString(), numberInput, stringInput) + "\n");
        }
        else {
          answer.append(i + ":" + toBinary(i, numberInput) + ":" + printString(toBinary(i,numberInput).toString(), numberInput, stringInput));
        }
      }
      System.out.println(answer);
      input.close();
    }
}

