package com.MyCode.array.ArrayRearrangement;

public class AllNNEndinOrder {

    public static void main(String[] args) {

        int arr[]={1, -1, 3, 2, -7, -5, 11, 6 };
        int n=arr.length;
        int j=0;
        for (int i = 0; i <n; i++) {
            if(arr[i]<0){
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
                j++;
            }
        }

        for (int i = 0; i < n; i++)
            System.out.print(arr[i] +" ");

    }
}
