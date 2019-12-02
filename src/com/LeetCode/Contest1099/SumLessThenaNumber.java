package com.LeetCode.Contest1099;

import java.util.Scanner;

public class SumLessThenaNumber {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int arr[]=new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();

        int k=scanner.nextInt();
        System.out.println(twoSumLessThanK(arr,k));
    }

    private static int twoSumLessThanK(int[] A, int K) {

        int max_Sum = Integer.MIN_VALUE;

        for (int i = 0; i < A.length-1; i++) {
            for (int j = i+1; j < A.length; j++) {

                if(A[i]+A[j]<K)
                    max_Sum = Math.max(A[i]+A[j],max_Sum);
            }
        }

        if(max_Sum == Integer.MIN_VALUE)
            return -1;

        return max_Sum;

    }
}
