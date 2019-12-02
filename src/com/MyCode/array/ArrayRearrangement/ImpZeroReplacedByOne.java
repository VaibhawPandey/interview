package com.MyCode.array.ArrayRearrangement;

/**
 * Ref:- https://www.geeksforgeeks.org/find-index-0-replaced-1-get-longest-continuous-sequence-1s-binary-array/
 */
public class ImpZeroReplacedByOne {

    public static void main(String[] args) {
        int  arr[] =  {1, 1, 1, 1, 0};
        //int n=arr.length;

        System.out.println(maxOnesIndex(arr));
    }

    private static int maxOnesIndex(int[] arr) {

        int n=arr.length;
        int last_zero=-1,last_last_zero=-1,max_length=0;
        int temp_last_zero=0;

        for (int position = 0; position < n; position++) {
            if(arr[position] == 0){
                if(last_last_zero != -1 || last_zero != -1){
                    temp_last_zero = position-last_last_zero-2+1;
                    max_length = Math.max(max_length,temp_last_zero);
                }
                last_last_zero=last_zero;
                last_zero=position;
            }
        }

        temp_last_zero = n-last_last_zero-2;
        max_length = Math.max(max_length,temp_last_zero);


        return max_length;

    }
}
