package com.MyCode.array.ArrayRearrangement;

/**
 * Ref :- https://www.geeksforgeeks.org/maximum-product-subarray/
 *    Kadane’s algorithm
 */
public class MaxProductSubArray {

    public static void main(String[] args) {

        int arr[] = { 1, -2, -3, 0, 7, -8, -2 };
        int n=arr.length;

        System.out.println(maxProductSubArray(arr,n));
    }

    private static int maxProductSubArray(int[] arr, int n){

        int min_ending_here = 1,max_ending_here = 1,max_so_far=1,flag=0;

        for (int i = 0; i < n; i++) {

            if(arr[i]>0){
                max_ending_here = max_ending_here * arr[i];
                min_ending_here = Math.min(min_ending_here*arr[i],1);
                flag=1;
            }else if(arr[i] == 0){
                 max_ending_here=1;
                 min_ending_here=1;
            }else {
                int temp = max_ending_here;
                max_ending_here = Math.max(min_ending_here*arr[i],1);
                min_ending_here = temp * arr[i];
            }
            if(max_so_far<max_ending_here)
                max_so_far = max_ending_here;
        }

        if(flag == 0 && max_so_far == 1)
            return 0;

        return max_so_far;
    }
}
