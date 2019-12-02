package com.MyCode.array.ArrayRearrangement;

/**
 * Ref :- https://www.geeksforgeeks.org/find-a-sorted-subsequence-of-size-3-in-linear-time/
 */
public class SortestSubsequenceON {

    public static void main(String[] args) {

        int arr[] = {12, 11, 10, 5, 6, 2, 30};
        find3Numbers(arr);
    }

    private static void find3Numbers(int[] arr) {

        int n=arr.length;

        int min=0,max=n-1;

        int smaller[]=new int[n];
        smaller[0]=-1;

        for (int i = 1; i < n; i++){
            if(arr[i]<=arr[min]){
                min=i;
                smaller[i] = -1;
            }else
                smaller[i] = min;
        }

        int greater[]=new int[n];
        greater[n-1]=-1;

        for (int i = n-2; i >= 0 ; i--) {
            if(arr[i]>arr[max]){
                max=i;
                greater[i]=-1;
            }else
                greater[i]=max;
        }

        for (int i = 0; i < n; i++) {
            if(smaller[i]!=-1 && greater[i]!=-1)
                System.out.println(arr[smaller[i]] +" " +arr[i] +" " +arr[greater[i]]);
        }


    }
}
