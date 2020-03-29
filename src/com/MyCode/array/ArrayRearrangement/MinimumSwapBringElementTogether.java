package com.MyCode.array.ArrayRearrangement;

//import javafx.util.Pair;

import java.util.*;

/**
 * Ref:- https://www.geeksforgeeks.org/minimum-swaps-required-bring-elements-less-equal-k-together/
 *
 *
 */

//TODO
    /**** Wrong Approach *****/

public class MinimumSwapBringElementTogether {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();

        for (int i = 0; i < t; i++) {

            int n=scanner.nextInt();
            int arr[]=new int[n];

            for (int j = 0; j < n; j++)
                arr[j] = scanner.nextInt();

            int k=scanner.nextInt();
            // minimumSwap(arr,k);

        }
    }

//    private static void minimumSwap(int[] arr, int k) {
//
//        List<Pair<Integer,Integer>> arrPos = new ArrayList<>();
//        for (int i = 0; i < arr.length; i++)
//            arrPos.add(new Pair<>(arr[i],i));
//
//        arrPos.sort(new Comparator<Pair<Integer, Integer>>() {
//            @Override
//            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
//                if(o1.getKey()<=k && o2.getKey()>k)
//                return -1;
//                else
//                    return 0;
//            }
//        });
//
//       /* for (int i = 0; i < arrPos.size(); i++)
//            System.out.println(arrPos.get(i) +" ");*/
//
//        boolean visited[]=new boolean[arrPos.size()];
//        Arrays.fill(visited,false);
//
//        int output=0;
//
//        for (int i = 0; i < arrPos.size(); i++) {
//
//            if(visited[i] || arrPos.get(i).getValue()==i || arrPos.get(i).getKey() > k)
//                continue;
//
//            int cycle_count=0;
//            int j=i;
//            while (!visited[j]){
//                visited[j] = true;
//                if(arrPos.get(j).getKey()>k)
//                    break;
//                j = arrPos.get(j).getValue();
//                cycle_count++;
//            }
//
//            if(cycle_count>0)
//                output += cycle_count;
//        }
//
//        System.out.println(output);
//    }
}
