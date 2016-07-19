/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perfectnumber;

import java.util.Arrays;

/**
 *
 * @author GT
 */
public class SJFTest {
    
    public static void main(String[] args) {
        // TODO code application logic here
     
        int count = 5;
        int[] burst_times = new int[count];
        int[] waiting_time = new int[count+1];
        int[] arrival_times = new int[count];
        int[] remaining_times = new int[count];
        int[] turn_around_time = new int[count];
        String[] processes = new String[count];
        
        for(int i=0;i<count;i++){
            String p = "P"+String.valueOf(i);
            processes[i] = p;
            arrival_times[i] = 0;
            int b = (int )(Math.random() * 20 + 1);
            burst_times[i] = b;            
            
        }
        for (int i = 0; i < count; i++) {
            waiting_time[i] = 0;
            turn_around_time[i] = 0;
        }
        for(int i=0;i<count;i++){
            System.out.println("Process :"+processes[i]+" Burst Time: "+burst_times[i]+" Waiting Time: "+waiting_time[i]+" TAT: "+turn_around_time[i]);
        }
        System.out.println("**********************************************************************************************************************");
        int temp;
        String temp_proc;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count - 1; j++) {
                if (burst_times[j] > burst_times[j + 1]) {
                    temp = burst_times[j];
                    burst_times[j] = burst_times[j + 1];
                    burst_times[j + 1] = temp;
                    
                    temp_proc  = processes[j];
                    processes[j] = processes[j + 1];
                    processes[j + 1] = temp_proc;
                    
                    temp = waiting_time[j];
                    waiting_time[j] = waiting_time[j + 1];
                    waiting_time[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i <count; i++) {
            turn_around_time[i] = burst_times[i] + waiting_time[i];
            waiting_time[i+1] = turn_around_time[i];
        }

        for(int i=0;i<count;i++){
            System.out.println("Process :"+processes[i]+" Burst Time: "+burst_times[i]+" Waiting Time: "+waiting_time[i]+" TAT: "+turn_around_time[i]);
        }
        System.out.println(Arrays.toString(burst_times));
       
        
        
    }
   
    
}
