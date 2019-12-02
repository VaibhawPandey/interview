package com.competitiveCodes.sort;

public class RadixSort {

    private void countSort(int arr[],int exp){
        
        int[] count = new int[10];
        int[] output = new int[arr.length];
        
        for(int i=0; i < arr.length; i++){
            count[(arr[i]/exp)%10]++;
        }
        
        for(int i=1; i < count.length; i++){
            count[i] += count[i-1];
        }
        
        for(int i=arr.length-1; i >= 0; i--){
            output[count[(arr[i]/exp)%10]-1] = arr[i];
            count[(arr[i]/exp)%10]--;
        }
        
        for(int i=0; i < arr.length; i++){
            arr[i] = output[i];
        }
    }
    
    private int max(int arr[]){
        int max = arr[0];
        for(int i=1; i < arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }
        return max;
    }
    
    public void radixSort(int arr[]){
        
        int max = max(arr);
        for(int exp = 1; exp <= max; exp *= 10){
            countSort(arr,exp);
        }
    }

    public void radixSortNew(int arr[])
    {
        int max = max(arr);
        int length = (int)(Math.log10(max)+1);
        for(int i=0; i < length; i++)
        {
            countSortNew(arr, i);
        }
    }

    private void countSortNew(int[] arr, int i) {
        for(int j=0; j < arr.length; j++)
        {
           // arr[j]
        }
    }

    public static void main(String args[]){
        int arr[] = {101,10,11,66,94,26,125};
        RadixSort rs = new RadixSort();
        rs.radixSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}

