package com.MyCode.array.ArrayRearrangement;

import java.util.Arrays;

public class RearrangeArrayEP {

    public static void main(String[] args) {
        int arr[] = { 1, 3, 2, 2, 5 };
        int n=arr.length;

        Arrays.sort(arr);

        int start=0,end=n-1;
        for (int i = 1; i < n; i=i+2) {

            int temp=arr[i];
            arr[i]=arr[end];
            arr[end] = temp;
            end--;
        }

        for (int i = 0; i < n; i++)
            System.out.print(arr[i] +" ");
    }
}
