/*
 * INSTRUCTION:
 *     This is a Java staring code for hw11_2.
 *     When you finish the development, download this file.
 *     Note that the current filename is "Main.java".
 *     But rename it to "Main_hw11_2.java".
 *     After that, upload the renamed file on Canvas.
 */

// Finish the head comment with Abstract, ID, Name, and Date.
/*
 * Title: Main_hw11_2.java
 * Abstract: Create a hash table that's able to insert, display status, return table size, search, delete, and rehash.
 * ID: 1337
 * Name: Paul Nguyehn
 * Date: 05/06/2022
 */

import java.util.*;
class Main 
{
    // Create a larger table, size is double to the nearest larger prime.
    // All values are rehashed into the new table. 
    // Function returns Object array of new table array and state array.
    public static Object[] rehash(int[] prime, int[] table, String[] state, int num, StringBuilder sb, int slot){

       int newSize = 0;
       for (int i = 0; i < prime.length; i++){
         if (table.length * 2 < prime[i]){
           newSize = prime[i];
           break;
         }
       }

      int newHashKey = 0;
      int[] newTable = new int[newSize];
      String[] newState = new String[newSize];
      Arrays.fill(newState, "Empty");

      for (int i = 0; i < table.length; i++){
        if (table[i] > 0){
          newHashKey = hash(table[i], newTable.length);
          if (newState[newHashKey] != "Active"){
            newTable[newHashKey] = table[i];
            newState[newHashKey] = "Active";
          }
          else{
            while (state[newHashKey] == "Active"){
              if (newHashKey != state.length-1)
                newHashKey++;
              else 
                newHashKey = 0;
              }
            table[newHashKey] = num;
            state[newHashKey] = "Active";
          }
        }
      }
      
      newHashKey = hash(num, newTable.length);
      if (newState[newHashKey] != "Active"){
        newTable[newHashKey] = num;
        newState[newHashKey] = "Active";
      }
      else {
        newTable[newHashKey+1] = num;
        newState[newHashKey+1] = "Active";
      }

      return new Object[]{newTable,newState};
    }

    // Hash a given put.
    public static int hash(int num, int inital){
      int hashKey = num % inital;

      return hashKey;
    }
  
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int primeNum[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211};

        int inital = input.nextInt();

        // Load factor for linear probing.
        final double LOAD_FACTOR = .5;

        // Keep count of elements in the table.
        int slot = 0;

        // Creates table and status array. Status is initialize with "Empty".
        int[] table = new int[inital];
        String[] state = new String[inital];
        Arrays.fill(state, "Empty");

        int number;

        int actions = input.nextInt();
        input.nextLine();

        // Number of commands.
        for (int i = 0; i < actions; i++){
          String read = input.nextLine();
  
          // Insert value into hash table.
          if (read.contains("insert")){
            slot++;
            number = Integer.parseInt(read.replaceAll("[\\D]", ""));
            if (slot < inital*LOAD_FACTOR){
              int hashKey = hash(number, inital);
              if (state[hash(number, inital)] != "Active"){
                table[hashKey] = number;
                state[hashKey] = "Active";
              }
              else{
                while (state[hashKey] == "Active"){
                  if (hashKey != state.length-1)
                    hashKey++;
                  else 
                    hashKey = 0;
                  }
                table[hashKey] = number;
                state[hashKey] = "Active";
              }
            }
            // If number of value above load factor of 0.5, rehash the table.
            else{
              Object[] newObj = rehash(primeNum, table, state, number, sb, slot);
      
              table = (int[])newObj[0];
              state = (String[])newObj[1];
              inital = table.length;
            }     
          }
  
          // Display status of input value.
          else if (read.contains("displayStatus")){
            number = Integer.parseInt(read.replaceAll("[\\D]", ""));
          
            if (state[number] == "Empty"){
              sb.append("Empty\n");
            }    
            else
              sb.append(table[number] + " " + state[number] + "\n");
          }

          // Search for value in table.
          else if (read.contains("search")){
            number = Integer.parseInt(read.replaceAll("[\\D]", ""));
            int tempHash = hash(number, inital);
            
            if (table[tempHash] == number){
              while (table[tempHash] != number){
                if (tempHash != table.length-1){
                  tempHash++;
                }
                else {
                  tempHash = 0;
                }
              }
              if (table[tempHash] == number && state[tempHash] != "Deleted")
                sb.append(table[tempHash] + " Found\n");
              else 
                sb.append(number + " Not found\n");
                
                
            }
            else {
                sb.append(number + " Not found\n");
            }
          }

          // Delete input value form table.
          else if (read.contains("delete")){
            number = Integer.parseInt(read.replaceAll("[\\D]", ""));
              int temphash = hash(number, inital);
              if (table[temphash] == number && state[temphash] == "Active"){
                state[temphash] = "Deleted";
                slot--;
              }
              else{
                while (table[temphash] != number){
                  if (temphash != table.length-1)
                    temphash++;
                  else 
                    temphash = 0;
                  }
                if (table[temphash] == number && state[temphash] == "Active"){
                  state[temphash] = "Deleted";
                  slot--;
                }  
              }
          }
          else{
            sb.append(table.length + "\n");
          }
      }

      // Print out result
      System.out.print(sb);

        
    }
}

