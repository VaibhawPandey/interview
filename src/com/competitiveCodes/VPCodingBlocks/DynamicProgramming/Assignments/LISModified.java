package com.competitiveCodes.VPCodingBlocks.DynamicProgramming.Assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LISModified {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        List<int[]> arrList=new ArrayList<>();
        List<int[]> valueList=new ArrayList<>();

        for (int i = 0; i < t; i++) {
            int n=scanner.nextInt();
            int arr[]=new int[n];
            int value[]=new int[n];

            for (int j = 0; j < n; j++)
                arr[j]=scanner.nextInt();

            arrList.add(arr);

            for (int j = 0; j < n; j++)
                value[j] =scanner.nextInt();

            valueList.add(value);
        }

        for (int i = 0; i < t; i++)
            System.out.println(getMaxValue(arrList.get(i),valueList.get(i)));

    }

    private static long getMaxValue(int[] arr, int[] value) {

        long ans=0;
        long dp[]=new long[arr.length];

        for (int i = 0; i < arr.length; i++)
            dp[i] = value[i];

        for (int i = 0; i <arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[i]){
                    long updatedValue = value[j+1] +dp[j];
                    dp[i]=Math.max(updatedValue,updatedValue);
                }
            }
            ans=Math.max(ans,dp[i]);
        }

        /*for (int i = 0; i < arr.length; i++) {
            System.out.println(dp[i]);
        }*/

        return ans;
    }

}
