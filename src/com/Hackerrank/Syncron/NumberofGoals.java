package com.Hackerrank.Syncron;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class NumberofGoals {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int na=scanner.nextInt();
        List<Integer> teamA=new ArrayList<>();
        List<Integer> teamB=new ArrayList<>();
        for (int i = 0; i < na; i++)
            teamA.add(scanner.nextInt());

        int nb=scanner.nextInt();
        for (int i = 0; i < nb; i++)
            teamB.add(scanner.nextInt());

        List<Integer> output=counts(teamA,teamB);

        for (Integer count:output) {
            System.out.print(count +" ");
        }
    }

    public static List<Integer> counts(List<Integer> teamA, List<Integer> teamB) {
        // Write your code here

        List<Integer> outputList=new ArrayList<>();
        int max= Collections.max(teamA);
        int arr[]=new int[max+1];

        for (int i = 0; i < teamA.size(); i++) {
            arr[teamA.get(i)]++;
        }


        for (int i = 0; i < teamB.size(); i++) {
            if(max<=teamB.get(i))
               outputList.add(teamA.size());
            else
                outputList.add(arr[teamB.get(i)]);
        }

        return outputList;
    }
}
