package com.MyCode.array.ArrayRearrangement;

public class DoubleFirstNumAndMove {

    public static void main(String[] args) {

        int arr[] = {0, 2, 2, 2, 0, 6, 6, 0, 0, 8};
        int n=arr.length;

        for (int i = 1; i < n; i++) {
            if(arr[i]==arr[i-1]){
                arr[i-1] *= 2;
                arr[i] = 0;
            }
        }

//        for (int i = 0; i < n; i++)
//            System.out.print(arr[i] +" ");

        int j=0;

        for (int i = 0; i < n; i++) {
            if(arr[i]!=0){
               int temp=arr[i];
               arr[i]=arr[j];
               arr[j]=temp;
               j++;
            }
        }

        for (int i = 0; i < n; i++)
            System.out.print(arr[i] +" ");

    }
}
