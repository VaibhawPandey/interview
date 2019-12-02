package com.MyCode.array.ArrayRearrangement;

public class ReplaceWithMaxElement {

    public static void main(String[] args) {
        int arr[]={16, 17, 4, 3, 5, 2};
        int n=arr.length;

        int output[]=new int[n];
        int max_element=arr[n-1];
        output[n-1]=-1;
        for (int i = n-2; i >= 0; i--) {
            output[i] = max_element;

            if(max_element<arr[i])
                max_element = arr[i];
        }

        for (int i = 0; i < n; i++)
            System.out.print(output[i] +" ");


    }
}
