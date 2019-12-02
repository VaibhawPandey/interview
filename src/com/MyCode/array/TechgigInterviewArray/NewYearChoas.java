package com.MyCode.array.TechgigInterviewArray;

import java.util.Arrays;
import java.util.Scanner;

public class NewYearChoas {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        int n,arr[];
        String output[]=new String[t];

        for (int i = 0; i < t; i++) {
            n=scanner.nextInt();
            arr = new int[n];
            int tempArr[]=new int[n];
            for (int j = 0; j < n; j++) {
                int k=scanner.nextInt();
                arr[j] = k;
                tempArr[j] = k;
            }

            Arrays.sort(tempArr);
            int count=0;

            for (int j = n-1; j >= 0; j--) {
                if(arr[j] != tempArr[j]){
                    if(arr[j] == tempArr[j])
                        continue;

                   if((j-1)>=0 && arr[j-1] == tempArr[j]){
                       count++;
                       arr =swap(arr,j-1,j,1);
                   }else if((j-2)>=0 && arr[j-2] == tempArr[j]){
                       count +=2;
                       arr = swap(arr,j-2,j,2);
                   }else {
                       output[i]="Too chaotic";
                       break;
                   }
                }
            }

            if(output[i] == null || !output[i].equalsIgnoreCase("Too chaotic"))
                output[i] = String.valueOf(count);

            System.out.println(output[i]);


        }
    }

    private static int[] swap(int[] arr, int src, int dest,int shiftCount) {

        for (int i = 1; i <= shiftCount ; i++) {
            int temp = arr[dest];
            arr[dest] = arr[dest-i];
            arr[dest-i] = temp;
        }

        return arr;
    }
}
