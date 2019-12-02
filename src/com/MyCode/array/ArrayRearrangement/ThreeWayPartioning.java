package com.MyCode.array.ArrayRearrangement;

/**
 * Ref:- https://www.geeksforgeeks.org/three-way-partitioning-of-an-array-around-a-given-range/
 */
public class ThreeWayPartioning {

    public static void main(String[] args) {
        int arr[] = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32};
        int lowVal = 14, highVal = 20;

        threeWayPartioning(arr,lowVal,highVal);
    }

    private static void threeWayPartioning(int[] arr, int lowVal, int highVal) {

        int n=arr.length-1;
        int start=0,end=n-1;

        for (int i = 0; i < end;) {

            if(arr[i]<lowVal){
                int temp=arr[i];
                arr[i]=arr[start];
                arr[start]=temp;
                start++;
                i++;
            }else if(arr[i]>highVal){
                int temp=arr[i];
                arr[i]=arr[end];
                arr[end]=temp;
                end--;
            }else i++;
        }

        for (int i = 0; i < n; i++)
            System.out.print(arr[i] +" ");
    }
}
