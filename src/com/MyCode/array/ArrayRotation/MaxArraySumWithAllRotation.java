package com.MyCode.array.ArrayRotation;

import java.util.Arrays;

public class MaxArraySumWithAllRotation {

    public static void main(String[] args) {

        int arr[]={1,1,8,2,6};
        int n=arr.length;

        int maxVal=Integer.MIN_VALUE,sumArray=0,currValue=0;

        for (int i = 0; i < arr.length; i++) {
            sumArray += arr[i];
            currValue += i*arr[i];
        }

        for (int i = 1; i < arr.length; i++) {

            currValue = currValue+(sumArray-arr[i-1])+((n-1)*arr[i-1]);
            maxVal = Math.max(maxVal,currValue);
        }

        System.out.println(maxVal);
    }
}
