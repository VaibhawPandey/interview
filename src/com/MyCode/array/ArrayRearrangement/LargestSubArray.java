package com.MyCode.array.ArrayRearrangement;

import java.util.HashMap;

/**
 * Ref :- https://www.geeksforgeeks.org/largest-subarray-with-equal-number-of-0s-and-1s/
 */
public class LargestSubArray {

    public static void main(String[] args) {

        int arr[] = {1, 0, 0, 1, 0, 1, 1};
        int n = arr.length;

        maxLen(arr,n);
    }

    private static void maxLen(int[] arr, int n) {

        HashMap<Integer,Integer> hashMap=new HashMap<>();

        for (int i = 0; i < n; i++)
            if(arr[i] == 0)arr[i] = -1;

        int sum=0,max_len = 0,ending_index = -1;

        for (int i = 0; i < n; i++) {

            sum += arr[i];
            if(sum == 0){
                max_len = i+1;
                ending_index = i;
            }

            if(hashMap.containsKey(sum+n)){
                if(max_len < i-hashMap.get(sum+n)){
                    max_len = i-hashMap.get(sum+n);
                    ending_index = i;
                }
            }else
                hashMap.put(sum+n,i);

        }

        int start_index=ending_index-max_len+1;
        System.out.println(start_index+" to " +ending_index);
    }
}
