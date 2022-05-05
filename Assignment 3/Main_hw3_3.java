/*
 * INSTRUCTION:
 *     This is a Java staring code for hw3_3.
 *     When you finish the development, download this file.
 *     Note that the current filename is "Main.java".
 *     But rename it to "Main_hw3_3.java".
 *     After that, upload the renamed file on Canvas.
 */

// Finish the head comment with Abstract, ID, Name, and Date.
/*
 * Title: Main_hw3_3.java
 * Abstract: Assuming the 2nd timestamp will always be ahead of the first. Find the range between two different timestamps.
 * ID: 1337
 * Name: Paul Nguyen
 * Date: 02/17/2022
 */
 
import java.util.*;

class Main 
{
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        int[] time1 = new int[3];
        int[] time2 = new int[3];
        int[] timeRange = new int[3];
        StringBuilder timeAnswer = new StringBuilder();

        String sTime1 = input.nextLine();
        String[] splitTime1 = sTime1.split(":");
        for (int i = 0; i < time1.length; i++){
                 time1[i] = Integer.parseInt(splitTime1[i]);
        }

        String sTime2 = input.nextLine();
        String[] splitTime2 = sTime2.split(":");
        for (int i = 0; i < time2.length; i++){
          time2[i] = Integer.parseInt(splitTime2[i]);
        }

        for (int i = timeRange.length-1; i >= 0; i--){
          if (i == 2){
            if (time2[i] >= time1[i]){
              timeRange[i] = time2[i] - time1[i];
            }
            else {
              timeRange[i] = (time2[i] - time1[i]) + 60;
              time1[i-1] += 1;
            }
            timeAnswer.append(String.format("%02d", timeRange[i]));
          }
          else if (i == 1) {
            if (time2[i] >= time1[i]){
              timeRange[i] = time2[i] - time1[i];
            }
            else {
              timeRange[i] = (time2[i] - time1[i]) + 60;
              time1[i-1] += 1;
            }
            timeAnswer.insert(0, String.format("%02d", timeRange[i]) + ":");
          }
          else{
            if (time2[i] >= time1[i]){
              timeRange[i] = time2[i] - time1[i];
            }
            else {
              timeRange[i] = (time2[i] - time1[i]) + 24;
            }
            timeAnswer.insert(0, String.format("%02d", timeRange[i]) + ":");
          }
        }
        System.out.println(timeAnswer);
        
    }
}

