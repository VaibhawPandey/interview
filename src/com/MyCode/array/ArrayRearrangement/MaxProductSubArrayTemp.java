package com.MyCode.array.ArrayRearrangement;

public class MaxProductSubArrayTemp {

    public static void main(String[] args) {

        int arr[] = { 1, -2, -3, 0, 7, -8, -2 };
        int n = arr.length;

        System.out.println(maxSubArray(arr,n));
    }

    private static int maxSubArray(int[] arr, int n) {

        int min_SubArray_Sum=1,max_subArray_Sum = 1,flag=0,max_so_far=1;

        for (int i = 0; i < n; i++) {

            if(arr[i]>0){
                max_subArray_Sum = max_subArray_Sum * arr[i];
                min_SubArray_Sum = Math.min(min_SubArray_Sum*arr[i],1);
                flag=1;
            }else if(arr[i]==0){
                 max_subArray_Sum = 1;
                 min_SubArray_Sum = 1;
            }else {
                 int temp = max_subArray_Sum;
                 max_subArray_Sum = Math.max(min_SubArray_Sum*arr[i],1);
                 min_SubArray_Sum = temp*arr[i];
            }

            if(max_so_far<max_subArray_Sum)
                max_so_far = max_subArray_Sum;
        }

        if(flag == 0 && max_so_far == 1)
            return 0;

        return max_so_far;
    }
}
