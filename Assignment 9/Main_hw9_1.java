/*
 * INSTRUCTION:
 *     This is a Java staring code for hw9_1.
 *     When you finish the development, download this file.
 *     Note that the current filename is "Main.java".
 *     But rename it to "Main_hw9_1.java".
 *     After that, upload the renamed file on Canvas.
 */

// Finish the head comment with Abstract, ID, Name, and Date.
/*
 * Title: Main_hw9_1.java
 * Abstract: To test the performance of insertion sort, merge sort, and quick sort.
 * ID: 1337
 * Name: Paul Nguyen
 * Date: 04/15/2022
 */

import java.util.*;
import java.text.DecimalFormat;

class Main 
{
    // INSERTION SORT //
    // Original Code from https://www.geeksforgeeks.org/insertion-sort/
  
    static void InsertionSort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
 
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
    /* A utility function to print array of size n*/
    static void printArrayInsertion(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
 
        System.out.println();
    }

    static void doubleSort(double arr[])
      {
          int n = arr.length;
          for (int i = 1; i < n; ++i) {
              double key = arr[i];
              int j = i - 1;
   
              /* Move elements of arr[0..i-1], that are
                 greater than key, to one position ahead
                 of their current position */
              while (j >= 0 && arr[j] > key) {
                  arr[j + 1] = arr[j];
                  j = j - 1;
              }
              arr[j + 1] = key;
          }
      }
  
    static void printArrayInsertionD(double arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
 
        System.out.println();
    }
/*========================================================================*/

    // MERGE SORT //
    // Original code from https://www.geeksforgeeks.org/merge-sort/
  
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    static void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
  
        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];
  
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
  
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
  
    // Main function that sorts arr[l..r] using
    // merge()
    static void MergeSort(int arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;
  
            // Sort first and second halves
            MergeSort(arr, l, m);
            MergeSort(arr, m + 1, r);
  
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    static void printArrayMerge(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
  
/*========================================================================*/
  
    // QUICk SORT //
    // Original code from https://www.geeksforgeeks.org/quick-sort/
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
     
    /* This function takes last element as pivot, places
       the pivot element at its correct position in sorted
       array, and places all smaller (smaller than pivot)
       to left of pivot and all greater elements to right
       of pivot 
    */
    static int partition(int[] arr, int low, int high)
    {
         
        // pivot
        int pivot = arr[high];
         
        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);
     
        for(int j = low; j <= high - 1; j++)
        {
            // If current element is smaller
            // than the pivot
            if (arr[j] < pivot)
            {
                 
                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
     
    /* The main function that implements QuickSort
              arr[] --> Array to be sorted,
              low --> Starting index,
              high --> Ending index
     */
    static void quickSort(int[] arr, int low, int high)
    {    
        // Random random = new Random();
        if (low < high)
        {
             
            // pi is partitioning index, arr[p]
            // is now at right place
          
            int pi = partition(arr, low, high);
            // pi = random.nextInt(high - low) + low;
            // System.out.print(pi);
     
            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
 
    // Function to print an array
    static void printArrayQuick(int[] arr, int size)
    {
        for(int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
             
        System.out.println();
    }

    // Quick sort function 2
    // https://www.javatpoint.com/quick-sort
    static int partition2(int a[], int start, int end)  
    {  
        int pivot = a[end]; // pivot element  
        int i = (start - 1);  
      
        for (int j = start; j <= end - 1; j++)  
        {  
            // If current element is smaller than the pivot  
            if (a[j] < pivot)  
            {  
                i++; // increment index of smaller element  
                int t = a[i];  
                a[i] = a[j];  
                a[j] = t;  
            }  
        }  
        int t = a[i+1];  
        a[i+1] = a[end];  
        a[end] = t;  
        return (i + 1);  
    }  

    /* function to implement quick sort */  
    static void quick(int a[], int start, int end) /* a[] = array to be sorted, start = Starting index, end = Ending index */  
    {  
        if (start < end)  
        {  
            int p = partition2(a, start, end); //p is the partitioning index  
            quick(a, start, p - 1);  
            quick(a, p + 1, end);  
        }  
    } 

  
    // Quick sort function 3
    // https://www.baeldung.com/java-quicksort
    static void QuickSort(int arr[], int begin, int end) {
      if (begin < end) {
          int partitionIndex = Partition(arr, begin, end);
  
          QuickSort(arr, begin, partitionIndex-1);
          QuickSort(arr, partitionIndex+1, end);
      }
    }

    static int Partition(int arr[], int begin, int end) {
      int pivot = arr[end];
      int i = (begin-1);
  
      for (int j = begin; j < end; j++) {
          if (arr[j] <= pivot) {
              i++;
  
              int swapTemp = arr[i];
              arr[i] = arr[j];
              arr[j] = swapTemp;
          }
      }
  
      int swapTemp = arr[i+1];
      arr[i+1] = arr[end];
      arr[end] = swapTemp;
  
      return i+1;
    }


/*========================================================================*/
  
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Setting start and end time as float
        long myStart;
        long myFinish;
        double timeElapsed;
      
        Random randInt = new Random();
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(5);
        
        System.out.print("Enter input size: ");
        int size = input.nextInt();
      
        System.out.println();
      
        int[] ascending = new int[size];
        int[] descending = new int[size];
        int[] random = new int[size];

        // Generate ascending array
        for (int i  = 0; i < ascending.length-1; i++){
          ascending[i] = i;
        }

        // Generate descending array
        int j = 0;
        for (int i = descending.length-1; i >= 0; i--){
          descending[j] = i;
          j++;
        }

        int max = Integer.MAX_VALUE; 
        // Generate random array
        for (int k = 0; k < random.length-1; k++){
          random[k] = randInt.nextInt((max - 1) + 1);
        }


        System.out.println("========== Select Option for Input Numbers ===========");
        System.out.println("1. Ascending Order");
        System.out.println("2. Descending Order");
        System.out.println("3. Random order");

        System.out.print("Choose option:" );
        int choice = input.nextInt();
        System.out.println();

        double insertionTime = 0.0;
        double mergeTime = 0.0;
        double quickTime = 0.0;

        
        for (int i = 1; i <= 3; i++){
        System.out.println("======================== Run" +i+ " ========================");
      
          myStart = 0;
          myFinish = 0;
          timeElapsed = 0.0;
          
          if (choice == 1){
            // Insertion sort
            int[] ascending1 = ascending.clone();
            if (size < 50000){
              myStart = System.nanoTime();     
              InsertionSort(ascending1);
              myFinish = System.nanoTime();
              timeElapsed = (myFinish - myStart)/1000000.0;
              insertionTime += (timeElapsed);
              System.out.print("Insertion sort:    ");
              System.out.printf("%.5f", timeElapsed);
              System.out.println(" millisecond");
              // printArrayInsertion(ascending);
            }
            
  
            // Merge sort
            int[] ascending2 = ascending.clone();
            myStart = System.nanoTime();  
            MergeSort(ascending2, 0, ascending2.length-1);
            myFinish = System.nanoTime();
            timeElapsed = (myFinish - myStart)/1000000.0;
            mergeTime += (timeElapsed);
            System.out.print("Merge sort:        ");
            System.out.printf("%.5f", timeElapsed);
            System.out.println(" millisecond");
            // printArrayMerge(random);
  
            // Quick Sort
            myStart = System.nanoTime();
            int[] ascending3 = ascending.clone();
            quickSort(ascending3, 0,  ascending3.length-1);
            myFinish = System.nanoTime();
            timeElapsed = (myFinish - myStart)/1000000.0;
            quickTime += (timeElapsed);
            System.out.print("Quick sort:        ");
            System.out.printf("%.5f", timeElapsed);
            System.out.println(" millisecond");
            // System.out.printf("%.5f", (end-start));
            // System.out.println();
            // printArrayQuick(random, random.length);
          }
  
          else if (choice == 2){
            // Insertion sort
            if (size < 50000){
              int[] descending1 = descending.clone();
              myStart = System.nanoTime();
              InsertionSort(descending1);
              myFinish = System.nanoTime();
              timeElapsed = (myFinish - myStart)/1000000.0;
              insertionTime += (timeElapsed);
              System.out.print("Insertion sort:    ");
              System.out.printf("%.5f", timeElapsed);
              System.out.println(" millisecond");
            }
           
            // System.out.printf("%.5f", (end-start));
            // System.out.println();
            // printArrayInsertion(ascending);
  
            // Merge sort
            int[] descending2 = descending.clone();
            myStart = System.nanoTime();
            MergeSort(descending2, 0, descending2.length-1);
            myFinish = System.nanoTime();
            timeElapsed = (myFinish - myStart)/1000000.0;
            mergeTime += (timeElapsed);
            System.out.print("Merge sort:        ");
            System.out.printf("%.5f", timeElapsed);
            System.out.println(" millisecond");
            // System.out.printf("%.5f", (end-start));
            // System.out.println();
            // printArrayMerge(random);
  
            // Quick Sort
            int[] descending3 = descending.clone();
            myStart = System.nanoTime();
            quickSort(descending3, 0, descending3.length-1);
            myFinish = System.nanoTime();
            timeElapsed = (myFinish - myStart)/1000000.0;
            quickTime += (timeElapsed);
            System.out.print("Quick sort:        ");
            System.out.printf("%.5f", timeElapsed);
            System.out.println(" millisecond");
            // System.out.printf("%.5f", (end-start));
            // System.out.println();
            // printArrayQuick(random, random.length);
            
            
          }
  
          else {
            // Insertion sort
            if (size < 50000){
              int[] random1 = random.clone();
               myStart = System.nanoTime();
              InsertionSort(random1);
              myFinish = System.nanoTime();
              timeElapsed = (myFinish - myStart)/1000000.0;
              insertionTime += (timeElapsed);
              System.out.print("Insertion sort:    ");
              System.out.printf("%.5f", timeElapsed);
              System.out.println(" millisecond");
              // System.out.printf("%.5f", (end-start));
              // System.out.println();
              // printArrayInsertion(random);
            }
           
  
            // Merge sort
            int[] random2 = random.clone();
            myStart = System.nanoTime();
            MergeSort(random2, 0, random2.length-1);
            myFinish = System.nanoTime();
            timeElapsed = (myFinish - myStart)/1000000.0;
            mergeTime += (timeElapsed);
            System.out.print("Merge sort:        ");
            System.out.printf("%.5f", timeElapsed);
            System.out.println(" millisecond");
            // printArrayMerge(random);
  
            // Quick Sort 
            int[] random3 = random.clone();

            // for (int k = 0; k < random3.length-1; k++){
            //   System.out.print(random3[k] + " ");
            // }
            myStart = System.nanoTime();
            quickSort(random3, 0, random3.length-1);
            myFinish = System.nanoTime();
            timeElapsed = (myFinish - myStart)/1000000.0;
            quickTime += (timeElapsed);
            System.out.print("Quick sort:        ");
            System.out.printf("%.5f", timeElapsed);
            System.out.println(" millisecond");

            // Quick sort 2
            // myStart = System.nanoTime();
            // QuickSort(random3, 0, random3.length-1);
            // myFinish = System.nanoTime();
            // timeElapsed = (myFinish - myStart)/1000000.0;
            // quickTime += (timeElapsed);
            // System.out.print("Quick sort: ");
            // System.out.printf("%.5f", timeElapsed);
            // System.out.println(" millisecond");
            
            // // Quick sort 3
            // myStart = System.nanoTime();
            // quick(random3, 0, random3.length-1);
            // myFinish = System.nanoTime();
            // timeElapsed = (myFinish - myStart)/1000000.0;
            // quickTime += (timeElapsed);
            // System.out.print("Quick sort: ");
            // System.out.printf("%.5f", timeElapsed);
            // System.out.println(" millisecond");
            
            // printArrayQuick(random, random.length);       
          }
          System.out.println("====================================================== \n");
            
        }

        System.out.println("======================= Ranking =======================");
        insertionTime = (insertionTime/3.0);
        mergeTime = (mergeTime/3.0);
        quickTime = (quickTime/3.0);


        if (insertionTime <= mergeTime && insertionTime <= quickTime){
          if (size < 50000){
            System.out.println("(1) Insertion Sort");
          }
          if (mergeTime <= quickTime){
            System.out.println("(2) Merge Sort");
            System.out.println("(3) Quick Sort");
          }
          else{
            System.out.println("(2) Quick Sort");
            System.out.println("(3) Merge Sort");
          }
          
        }
          
        else if (mergeTime <= insertionTime && mergeTime <= quickTime){
          System.out.println("(1) Merge Sort");
          if (insertionTime <= quickTime){
            if (size < 50000){
              System.out.println("(2) Insertion Sort");
            }
            
            System.out.println("(3) Quick Sort");
          }
          else {
            System.out.println("(2) Quick Sort");

            if (size < 50000){
              System.out.println("(3) Insertion Sort");
            }  
          }
        }
        else {
          System.out.println("(1) Quick Sort");
          if (insertionTime <= mergeTime){
            if (size < 50000){
              System.out.println("(2) Insertion Sort");
            }
            System.out.println("(3) Merge Sort");
          }
          else{
            System.out.println("(2) Merge Sort");
            if (size < 50000){
              System.out.println("(3) Insertion Sort");
            }
          }
        }
        System.out.println("======================================================= \n");
      
       
    }
}

