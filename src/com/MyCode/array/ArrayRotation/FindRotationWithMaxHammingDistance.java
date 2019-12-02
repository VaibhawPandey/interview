package com.MyCode.array.ArrayRotation;

public class FindRotationWithMaxHammingDistance {

    public static void main(String[] args) {

        int arr[] = {2, 4, 6, 8};
        int n = arr.length;
        System.out.println(maxHamming(arr,n));
    }

    private static int maxHamming(int[] arr, int n) {

        int brr[]=new int[2*n];

        for (int i = 0; i < n; i++)
            brr[i] = brr[n+i] = arr[i];

        int maxHam = 0;

        for (int i=0;i<n;i++){

            int currHam = 0;
            for (int j = i,k=0; j < (i+n); j++,k++) {

                if(brr[j] != brr[k])
                    currHam++;

                if(currHam == n)
                    return n;

                maxHam = Math.max(currHam,maxHam);

            }
        }

        return maxHam;

    }
}
