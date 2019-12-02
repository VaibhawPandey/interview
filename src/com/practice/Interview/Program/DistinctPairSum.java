package com.practice.Interview.Program;

import java.util.ArrayList;
import java.util.List;

/*
    Program - 3
 */
public class DistinctPairSum {

    public static void main(String[] args) {
        int arr[]={1,2,4,6,8,3};
        int n=arr.length,finalSum=8,sum=0;

        List<Integer> includedIndexList=new ArrayList<>();
        printAllIndexes(arr,0,includedIndexList,sum,finalSum);

    }

    private static void printAllIndexes(int[] arr, int position, List<Integer> includedIndexList, int sum, int finalSum) {

        if(sum == finalSum){
            for (int i = 0; i < includedIndexList.size(); i++)
                System.out.print((includedIndexList.get(i)-1) +" -- " +arr[includedIndexList.get(i) - 1] + " ");
            System.out.println();
            return;
        }

        if(sum>finalSum)
            return;

        if(position>=arr.length)
            return;

        includedIndexList.add(position+1);
        sum += arr[position];
        position += 1;
        printAllIndexes(arr,position,includedIndexList,sum,finalSum);

        includedIndexList.remove(includedIndexList.size()-1);
        sum -= arr[position-1];

        printAllIndexes(arr,position,includedIndexList,sum,finalSum);

    }
}
