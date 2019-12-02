package com.MyCode.array.ArrayRearrangement;

public class RearrangePositiveAndNegativeNumbersUsingMergeSort {

    static int arr[];
    public static void main(String[] args) {

        arr=new int[]{12, 11, -13, -5, 6, -7, 5, -3, -6};
        int n=arr.length;

        rearrange(0,n-1);

        for (int i = 0; i < n; i++)
            System.out.print(arr[i] +" ");

    }

    private static void rearrange(int l, int r) {

        if(l<r){
            int mid=(l+r)/2;
            rearrange(l,mid);
            rearrange(mid+1,r);

            merge(l,mid,r);

        }
    }

    private static void merge(int l, int mid, int r) {

        int i,j,k;
        int n1=mid-l+1;
        int n2=r-mid;

        int leftArray[]=new int[n1];
        int rightArray[]=new int[n2];

        for (i = 0; i < n1; i++)
            leftArray[i] = arr[l+i];

        for (j = 0;  j< n2; j++)
            rightArray[j] = arr[mid+j+1];

        i=0;j=0;k=l;

        while (i<n1 && leftArray[i]<0)
            arr[k++]=leftArray[i++];

        while (j<n2 && rightArray[j]<0)
            arr[k++] = rightArray[j++];

        while (i<n1)
            arr[k++] = leftArray[i++];

        while (j<n2)
            arr[k++] = rightArray[j++];

    }
}
