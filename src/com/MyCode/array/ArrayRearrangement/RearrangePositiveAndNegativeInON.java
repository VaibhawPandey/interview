package com.MyCode.array.ArrayRearrangement;

/**
 * Ref :- https://www.geeksforgeeks.org/rearrange-positive-negative-numbers-using-inbuilt-sort-function/
 */

public class RearrangePositiveAndNegativeInON {

    static int arr[];
    public static void main(String[] args) {
        arr=new int[]{-12, 11, 0, -5, 6, -7, 5, -3, -6};
        int n=arr.length;
        int negativeCount=0;

        for (int i = 0; i < n; i++)
            if(arr[i]<0)
                negativeCount++;

        printArray(arr);
        rearrange(0,arr.length-1);

        reverse(negativeCount,arr.length-1);

        System.out.println();

        printArray(arr);
    }

    private static void rearrange(int start, int end) {

        if(start == end)
            return;

        rearrange(start+1,end);

        if(arr[start]>=0){
            reverse(start+1,end);
            reverse(start,end);
        }
    }

    private static void reverse(int start, int end) {

        while (start<end){
            int temp = arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }

    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] +" ");
    }
}
