package com.MyCode.HackerRankInterview.Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FraudulentActivityProblem {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt(),d= scanner.nextInt();

        int expenditure[] = new int[n];
        for (int i = 0; i < n; i++)
            expenditure[i] = scanner.nextInt();

        System.out.println(activityNotifications(expenditure,d));
    }

    static int activityNotifications(int[] expenditure, int d) {

        int i=d,n=expenditure.length,output=0;
        int temp[]=new int[201];
        while (i<n){

            if(i==d) {
                for (int j = i - d; j < i; j++)
                    temp[expenditure[j]]++;
            }else {
                temp[expenditure[i-d-1]]--;
                temp[expenditure[i-1]]++;
            }

            int pos = 0;
            List<Integer> tempValue=new ArrayList<>();
            for (int j = 1; j < temp.length; j++) {
                for (int k = 0; k < temp[j]; k++)
                    tempValue.add(j);

                //if(tempValue.size()>(d/2+1))
                    //break;
            }

            int mid=0;
            if(d%2 == 0)
                mid = tempValue.get(d/2)+tempValue.get(d/2+1);
            else
               mid = tempValue.get(d/2)*2;

            if(mid<=expenditure[i])
                output++;

            i++;
        }

        return output;

    }
}
