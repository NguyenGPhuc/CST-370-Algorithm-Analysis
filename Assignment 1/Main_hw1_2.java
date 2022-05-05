/*
 * INSTRUCTION:
 *     This is a Java staring code for hw1_2.
 *     When you finish the development, download this file.
 *     Note that the current filename is "Main.java".
 *     But rename it to "Main_hw1_2.java".
 *     After that, upload the renamed file on Canvas.
 */

// Finish the head comment with Abstract, ID, Name, and Date.
/*
 * Title: Main_hw1_2.java
 * Abstract: This program will combines two given integer lists into one, removing all duplicates.
 * The final list will be printed with ALL occurrences of duplicate remove.
 * ID: 1337
 * Name: Paul Nguyen
 * Date: 02/04/2022
 */

import java.util.*;

class Main 
{
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        Vector<Integer> combinationList = new Vector<Integer>();

        // Get size and integers for list 1
        int size1 = input.nextInt();
        Integer[] arr1 = new Integer[size1];
        for (int i = 0; i < size1; i++){
          arr1[i] = input.nextInt();
    
        }

        //  Get size and integers for list 2
        int size2 = input.nextInt();
        Integer[] arr2 = new Integer[size2];
        for (int i = 0; i < size2; i++){
          arr2[i] = input.nextInt();
        }

        // Add both list to a single list
        Collections.addAll(combinationList, arr1);
        Collections.addAll(combinationList, arr2);

        // Sort and reverse list
        Collections.sort(combinationList);
        Collections.reverse(combinationList);

        // List that track duplicate numbers
        Vector<Integer> remove_list = new Vector<Integer>();
  
        for (int i = 0; i < combinationList.size()-1; i++){
            
          if (combinationList.get(i).equals(combinationList.get(i+1))){
            remove_list.add(combinationList.get(i));
          }
        }

        // Remove duplicate from original
        combinationList.removeAll(remove_list);

        // Print answer
        StringBuilder list = new StringBuilder("Answer:");
        if (combinationList.isEmpty()){
          System.out.println("Answer:NONE");
        }
        else{
          for (int i = 0; i < combinationList.size(); i++){
            if (i == 0){
              list.append(combinationList.get(i));
            }
            else{
              list.append(" " + combinationList.get(i));
            }
          }
        System.out.println(list);
        }
    }
}

