package com.MyCode.array.TechgigInterviewArray;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] arr) {

        int n=arr.length;
        String output="";
        int tempArr[]=new int[n];

        for (int j = 0; j < n; j++)
            tempArr[j] = arr[j];

        Arrays.sort(tempArr);
        int count=0;

        for (int j = n-1; j >= 0; j--) {
            if(arr[j] != tempArr[j]){
                if(arr[j] == tempArr[j])
                    continue;

                if((j-1)>=0 && arr[j-1] == tempArr[j]){
                    count++;
                    arr =swap(arr,j-1,j,1);
                }else if((j-2)>=0 && arr[j-2] == tempArr[j]){
                    count +=2;
                    arr = swap(arr,j-2,j,2);
                }else {
                    output="Too chaotic";
                    break;
                }
            }
        }

        if(output.equalsIgnoreCase(""))
            output = String.valueOf(count);

        System.out.println(output);


    }

    private static int[] swap(int[] arr, int src, int dest,int shiftCount) {

        for (int i = 1; i <= shiftCount ; i++) {
            int temp = arr[dest];
            arr[dest] = arr[dest-i];
            arr[dest-i] = temp;
        }

        return arr;
    }



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}

