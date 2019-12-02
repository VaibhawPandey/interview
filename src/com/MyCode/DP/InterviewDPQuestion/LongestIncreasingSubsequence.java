package com.MyCode.DP.InterviewDPQuestion;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int arr[] = {10, 22, 9, 33, 21, 50, 41, 60};

        int n=arr.length;
        int lis[]=new int[n];

        Arrays.fill(lis,1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++){
                if(arr[j]<arr[i] && lis[i] < lis[j]+1)
                    lis[i] = lis[j]+1;
            }
        }

        System.out.println(lis[n-1]);

    }
}
