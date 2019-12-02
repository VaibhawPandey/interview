package com.MyCode.array.ArrayRearrangement;

/**
 * Ref :- https://www.geeksforgeeks.org/maximum-contiguous-circular-sum/
 */
public class ImpMaxCircularSubArraySum {

    public static void main(String[] args) {

        int arr[] = {8, -8, 9, -9, 10, -11, 12};
        int n=arr.length;

        System.out.println(maxSubArraySum(arr,n));
    }

    private static int maxSubArraySum(int[] arr, int n) {

        int max_Kedana = kedana(arr);
        int max_Sum=0;

        for (int i = 0; i < n; i++) {
            max_Sum += arr[i];
            arr[i] = -arr[i];
        }

        int max_Wrap = max_Sum + kedana(arr);

        return Math.max(max_Wrap,max_Kedana);
    }

    private static int kedana(int[] arr) {

        int max_SubArray_Sum=0,max_so_far=0;


        for (int i=0;i<arr.length;i++){
            max_SubArray_Sum += arr[i];
            if(arr[i]< 0)
                max_SubArray_Sum=0;
            max_so_far=Math.max(max_so_far,max_SubArray_Sum);
        }

        return max_so_far;
    }
}
