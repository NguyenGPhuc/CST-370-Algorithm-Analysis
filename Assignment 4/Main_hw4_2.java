/*
 * INSTRUCTION:
 *     This is a Java staring code for hw4_2.
 *     When you finish the development, download this file.
 *     Note that the current filename is "Main.java".
 *     But rename it to "Main_hw4_2.java".
 *     After that, upload the renamed file on Canvas.
 */

// Finish the head comment with Abstract, ID, Name, and Date.
/*
 * Title: Main_hw4_2.java
 * Abstract: Given a set of integers, find the two subsets that are evenly divided. Display the subset with the lowest integer.
 * ID: 1337
 * Name: Paul Nguyen
 * Date: 02/24/2022
 */

import java.util.*;
class Main 
{
    // From open source https://www.geeksforgeeks.org/program-decimal-binary-conversion/
    static int[] toBinary(int n, int l){
      int[] binaryNum =  new int[l];
      int[] binaryReverse = new int[l];
     
      int j = l;
      int m = j;
  
      int i = 0;
      while (l > 0){
        binaryNum[i] = n % 2;
        n = n/2;
        l = l - 1;
        i++;
      }
      
      for (int k = 0; k < m; k++) {
        binaryReverse[j - 1] = binaryNum[k];
        j = j - 1;
      }

      return binaryNum;    
    }

  
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      ArrayList<Integer> userSet = new ArrayList<>();
      StringBuilder subSet = new StringBuilder();
      subSet.append("Equal Set: ");

      int number = input.nextInt();
      int sum = 0;

      for (int i = 0; i < number; i++){
        userSet.add(input.nextInt());
        sum += userSet.get(i);   
      }    
 
      Collections.sort(userSet); 

      int[] set1 = new int[number];
      int[] set2 = new int[number];
      int[] answer1 = new int[number];
      int[] answer2 = new int[number];
      int[] finalAnswer = new int[number];
      int[] finalSet = new int[number];
        
      boolean equal = false;
      
      for (int i = 0; i < set1.length; i++){
        set1[i] = userSet.get(i);
        set2[i] = userSet.get(i);
      }

      
      for (int i = (int)(Math.pow(2, number)-1); i >= 0; i--){
 
        int subSum1 = 0;
        int subSum2 = 0;
        int finalCounter = 0;

        for (int j = 0; j < set1.length; j++){
          if (toBinary(i, number)[j] == 1){
            subSum1 += set1[j];
          }
          else if (toBinary(i, number)[j] == 0){
            subSum2 += set2[j];
          }
        }

        if (subSum1 == subSum2){
          answer1 = toBinary(i, number);
          for (int k = 0; k < answer1.length; k++){
            if (answer1[k] == 1){
              answer2[k] = 0;
            }
            else{
              answer2[k] = 1;
            }
            
          }

          if (answer1[0] > answer2[0]){
            finalAnswer = answer1;
          }
          else{
            finalAnswer = answer2;
          }

          for (int k = 0; k < finalSet.length; k++){
            if (finalAnswer[k] == 1){
              finalSet[k] = set1[k];
              finalCounter++;
            }
          }
         
          for (int j = 0; j < finalAnswer.length; j++){
            if (finalAnswer[j] == 1){
              if (finalCounter-1 == 0){
                subSet.append(finalSet[j]);
              }
              else{
                subSet.append(finalSet[j] + " ");
                finalCounter--;
              }
            }
          }
          equal = true;
          break;
        }

      }

      if (equal == true){
        System.out.println(subSet);
      }
      else {
        subSet.append(0);
        System.out.println(subSet);
      }
      
    }
}

