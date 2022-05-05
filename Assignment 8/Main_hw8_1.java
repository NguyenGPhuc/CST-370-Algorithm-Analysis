/*
 * INSTRUCTION:
 *     This is a Java staring code for hw8_1.
 *     When you finish the development, download this file.
 *     Note that the current filename is "Main.java".
 *     But rename it to "Main_hw8_1.java".
 *     After that, upload the renamed file on Canvas.
 */

// Finish the head comment with Abstract, ID, Name, and Date.
/*
 * Title: Main_hw8_1.java
 * Abstract: Given an array of negative and positive integers, place all negative in font, and positive in the back.
 * ID: 1337
 * Name: Paul Nguyen
 * Date: 04/06/2022
 */

import java.util.*;
class Main 
{
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      Vector<Integer> intVec = new Vector<Integer>();
      Vector<Integer> intVec2 = new Vector<Integer>();
  
      int num = input.nextInt();

      for (int i = 0; i < num; i++){
        intVec.add(input.nextInt());
        intVec2.add(intVec.get(i));
      }
      
      int i = 0;
      int j = intVec.size()-1;

      while (j > i){
        while (intVec.get(i) < 0 && i < intVec2.size()-1 && j > 0){
          i++;
        }
        while (intVec.get(j) > 0 && j > 0){
          j--;
        }
        if (j > i){
          if (intVec.get(i) > 0 && intVec.get(j) < 0){
          int temp;
          temp = intVec.get(i);
          intVec.set(i, intVec.get(j));
          intVec.set(j, temp);
          }
        }

      }
      
      for (Integer k: intVec){
        if (k == intVec.lastElement()){
          System.out.println(k);
        }
        else{
          System.out.print(k + " ");
        }
      }

      i = 0;
      j = 0;

      while (j < intVec2.size()-1 && i < intVec2.size()-1){
       
        while (intVec2.get(i) < 0 && j < intVec2.size()-1 && i < intVec2.size()-1){
          i++;
          j = i;
        }
        while (intVec2.get(j) > 0 && j < intVec2.size()-1 && i < intVec2.size()-1){
          j++;
        }
        

        if (intVec2.get(i) > 0 && intVec2.get(j) < 0){
          int temp;
          temp = intVec2.get(i);
          intVec2.set(i, intVec2.get(j));
          intVec2.set(j, temp);
        }
        
      }
      
      for (Integer k: intVec2){
        if (k == intVec2.lastElement()){
          System.out.println(k);
        }
        else{
          System.out.print(k + " ");
        }
      }  
    }
}

