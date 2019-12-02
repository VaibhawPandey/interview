package com.MyCode.array.ArrayRotation;

import java.util.Arrays;

/*
  * Ref :- https://www.geeksforgeeks.org/find-maximum-value-of-sum-iarri-with-only-rotations-on-given-array-allowed/
 */

public class MaxArraySumWithOneRotation {

    public static void main(String[] args) {

        int arr[]={10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int n=arr.length;

        int maxVal=Integer.MIN_VALUE,sumArray=0,currValue=0;

        for (int i = 0; i < arr.length; i++) {
            sumArray += arr[i];
            currValue += arr[i] * i;
        }

        for (int i = 1; i < arr.length; i++) {
            currValue = currValue + sumArray - n*arr[n-i];
            maxVal = Math.max(currValue,maxVal);
        }

        System.out.println(maxVal);
    }
}
