package com.MyCode.array.ArrayRearrangement;

public class ImpMaxConsecutiveOnesSW {

    public static void main(String[] args) {
        int arr[]={1,1,1,0,0,0,1,1,1,1,0};
        int K=2;

        System.out.println(maxOnes(arr,K));
    }

    private static int maxOnes(int[] arr, int k) {

        int max_length=Integer.MIN_VALUE;
        int start=0;

        for (int position = 0; position < arr.length; position++) {
            if(arr[position] == 0) k--;

            while (k<0){
                if(arr[start] == 0)k++;
                start++;
            }

            max_length=Math.max(max_length,position-start+1);
        }

        return max_length;
    }
}
