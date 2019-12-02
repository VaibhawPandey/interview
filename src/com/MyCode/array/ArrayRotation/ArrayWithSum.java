package com.MyCode.array.ArrayRotation;

/*
 **
 * Ref :- https://www.geeksforgeeks.org/given-a-sorted-and-rotated-array-find-if-there-is-a-pair-with-a-given-sum/
 */
public class ArrayWithSum {

    public static void main(String[] args) {
        int arr[] = {11, 15, 6, 8, 9, 10};
        int sum = 16;
        int n = arr.length;

        if(pairInSortedArray(arr,sum,n))
            System.out.println("Has pair");
        else
            System.out.println("Do not have pair");
    }

    private static boolean pairInSortedArray(int[] arr, int sum, int n) {

        int l,r;
        for (r = 0; r < n-1; r++) {
            if(arr[r]>arr[r+1])
                break;
        }

        l=(r+1)%n;

        while (l != r){

            if(arr[l]+arr[r] == sum) {
                System.out.println(arr[l] +"--" +arr[r]);
                return true;
            }

            if(arr[l]+arr[r] > sum)
                r = (n+r-1)%n;
            else
                l = (l+1)%n;
        }


        return false;
    }
}
