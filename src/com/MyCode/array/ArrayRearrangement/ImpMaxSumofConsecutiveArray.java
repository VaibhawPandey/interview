package com.MyCode.array.ArrayRearrangement;

import java.util.Arrays;

/**
 * Ref:- https://www.geeksforgeeks.org/maximize-sum-consecutive-differences-circular-array/
 */
public class ImpMaxSumofConsecutiveArray {

    public static void main(String[] args) {
        int arr[] = { 4, 2, 1, 8 };
        int n = arr.length;
        System.out.println(maxSum(arr,n));
    }

    private static int maxSum(int[] arr, int n) {

        Arrays.sort(arr);
        int sum=0;

        for (int i = 0; i < n/2; i++) {
            sum += 2*arr[n-1-i];
            sum -= 2*arr[i];
        }

        return sum;
    }
}
