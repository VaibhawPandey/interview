package com.MyCode.array.ArrayRearrangement;

public class ArrayRearrangement {

    public static void main(String[] args) {
        int arr[] = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
        int n=arr.length;

        int j=-1;
        for (int i = 0; i < n; i++) {
            if(arr[i]<0){
                j++;
               int temp=arr[j];
               arr[j]=arr[i];
               arr[i] = temp;
            }
        }

        for (int i = 0; i < n; i++)
            System.out.print(arr[i] +" ");

        System.out.println();

        int pos = j+1,neg=0;

        while (pos<n && neg<pos && arr[neg]<0){
            int temp=arr[neg];
            arr[neg] = arr[pos];
            arr[pos] = temp;
            pos++;
            neg += 2;
        }

        for (int i = 0; i < n; i++)
            System.out.print(arr[i] +" ");



    }
}
