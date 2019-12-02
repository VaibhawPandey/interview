package com.MyCode.array.TechgigInterviewArray;

import javafx.util.Pair;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinimumSwap {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {

        int n=arr.length;

        List<Pair<Integer,Integer>> arrPos = new ArrayList<>();
        for (int i = 0; i < n; i++)
            arrPos.add(new Pair<>(arr[i],i));

        arrPos.sort(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {

                if(o1.getKey()<o2.getKey())
                    return -1;
                else if(o1.getKey().equals(o2.getKey()))
                    return 0;
                else return 1;
            }
        });

       /* for (int i = 0; i < n; i++)
            System.out.println(arrPos.get(i).getKey());*/

       boolean visited[]=new boolean[n];
       Arrays.fill(visited,false);

       int output_Sum = 0;

        for (int i = 0; i < n; i++) {

            if(visited[i] || arrPos.get(i).getValue() == i)
                continue;

            int count=0;
            int j=i;
            while (!visited[j]){

                visited[j]=true;
                j = arrPos.get(j).getValue();
                count++;
            }

            //Count-1 because for 3 items position change 2 swap required so its n-1.
            if(count>0)
                output_Sum += count-1;

        }

        return output_Sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        System.out.println(res);

        //bufferedWriter.write(String.valueOf(res));
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}
