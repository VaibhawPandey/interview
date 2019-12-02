package com.practice;

public class TrapingWaterProblem {

    public static void main(String[] args) {
        int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int n=arr.length;

        System.out.println(trappingWater(arr,n));
    }

    private static int trappingWater(int[] arr, int n) {

        int result=0;
        int left_max=0,right_max=0,lo=0,hi=n-1;

        while (lo<=hi){

            if(arr[lo]<arr[hi]){
                if(arr[lo]>left_max)
                    left_max=arr[lo];
                else
                    result += left_max-arr[lo];
                lo++;
            }else {

                if(arr[hi]>right_max)
                    right_max=arr[hi];
                else
                    result += right_max-arr[hi];

                hi--;
            }
        }

        return result;
    }
}
