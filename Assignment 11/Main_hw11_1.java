/*
 * INSTRUCTION:
 *     This is a Java staring code for hw11_1.
 *     When you finish the development, download this file.
 *     Note that the current filename is "Main.java".
 *     But rename it to "Main_hw11_1.java".
 *     After that, upload the renamed file on Canvas.
 */

// Finish the head comment with Abstract, ID, Name, and Date.
/*
 * Title: Main_hw11_1.java
 * Abstract: Return sorted list of integer using Radix sort.
 * Show the sorted array after every digit iteration.
 * ID: 1337
 * Name: Paul Nguyen
 * Date: 05/05/2022
 */

/* 
Radix sort original code: https://www.geeksforgeeks.org/radix-sort/
*/

import java.io.*;
import java.util.*;
class Main 
{
    // A utility function to get maximum value in arr[]
    static int getMax(int arr[], int n)
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }
 
    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(int arr[], int n, int exp)
    {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);
 
        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;
 
        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
 
        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
 
        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current digit
        for (i = 0; i < n; i++){
          arr[i] = output[i];
        }
            
        
        print(arr, n);
        
    }
 
    // The main function to that sorts arr[] of size n using
    // Radix Sort
    static void radixsort(int arr[], int n)
    {
        // Find the maximum number to know number of digits
        int m = getMax(arr, n);
 
        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // exp is 10^i where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10){
          countSort(arr, n, exp);
        }
            
    }
 
    // A utility function to print an array
    static void print(int arr[], int n)
    {
        for (int i = 0; i < n; i++){
            if (i != n-1)
              System.out.print(arr[i] + " ");
            else
              System.out.print(arr[i]);     
        }
        System.out.println();
            
    }
 
    /*Driver Code*/
    public static void main(String[] args)
    {

        Scanner input =  new Scanner(System.in);

        int size = input.nextInt();
        int[] arr = new int[size];

        for (int i = 0; i < arr.length; i++){
          arr[i] = input.nextInt();
        }
           
          // Function Call
        radixsort(arr, arr.length);
    }
}

