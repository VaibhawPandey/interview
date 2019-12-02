package com.LeetCode.WeeklyContest154;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.stream.Stream;

public class KConcMaxSum {

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        Properties properties=new Properties();
        try {
            properties.load(new FileInputStream("data.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String propString = properties.getProperty("data");
        propString.toCharArray();
        int[] arr = Stream.of(propString.split(",")).mapToInt(Integer::parseInt).toArray();
        int k=36263;
        System.out.println(kConcatenationMaxSum(arr,k));
    }
    public static int kConcatenationMaxSum(int[] arr, int k) {

        int n=arr.length;
        int max_so_far=Integer.MIN_VALUE,max_ending_here = 0;
        int last_ending_point = 0,last_loop_point = 0;

        for (int i = 0; i < n*k; i++) {


            if(i/n != last_loop_point){
                 if(max_so_far<0)
                     return 0;
                 if(last_ending_point == max_so_far)
                     return max_so_far;
                 /*if(i/n > 1 && max_so_far == 2*last_ending_point){
                     return k*last_ending_point;
                 }*/
                 last_ending_point = max_so_far;
                 last_loop_point = i/n;
            }
            max_ending_here = (max_ending_here+arr[i%n])%1000000007;
            if(max_ending_here>max_so_far)
                max_so_far = max_ending_here;

            if(max_ending_here<0)
                max_ending_here = 0;


        }

        return max_so_far;
    }
}
