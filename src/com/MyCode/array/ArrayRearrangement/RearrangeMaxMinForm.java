package com.MyCode.array.ArrayRearrangement;

/**
 * Imp
 * Ref:- https://www.geeksforgeeks.org/rearrange-array-maximum-minimum-form-set-2-o1-extra-space/
 */
public class RearrangeMaxMinForm {

    public static void main(String[] args) {

        int arr[]={1, 2, 3, 4, 5, 6, 7};
        int n=arr.length;

        int max_idx=n-1,min_idx=0;
        int max_Element= arr[max_idx]+1;

        for (int i = 0; i < arr.length; i++) {

            if(i%2 == 0){
                arr[i] += (arr[max_idx]%max_Element)*max_Element;
                max_idx--;
            }else {
               arr[i] += (arr[min_idx]%max_Element)*max_Element;
               min_idx++;
            }
        }

        for (int i = 0; i < n; i++)
            System.out.print(arr[i]/max_Element +" ");

    }
}
