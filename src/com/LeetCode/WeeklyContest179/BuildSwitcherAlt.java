package com.LeetCode.WeeklyContest179;

import java.util.Scanner;


public class BuildSwitcherAlt {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int light[] = new int[n];
        for (int i = 0; i < n; i++)
            light[i] = scanner.nextInt();

        System.out.println(numTimesAllBlue(light));
    }

    private static int numTimesAllBlue(int[] light) {

        int sum = 0,n=light.length,count=0;

        for (int i = 0; i < n; i++) {
            sum += light[i];

            if(sum == ((i+1)*(i+2))/2)
                count++;
        }

        return count;
    }
}
