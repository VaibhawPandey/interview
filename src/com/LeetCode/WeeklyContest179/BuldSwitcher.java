package com.LeetCode.WeeklyContest179;

import java.util.Scanner;

public class BuldSwitcher {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int light[]=new int[n];
        for (int i = 0; i < n; i++)
            light[i] = scanner.nextInt();

        System.out.println(numTimesAllBlue(light));
    }
    public static int numTimesAllBlue(int[] light) {

        int count=0;
        int n=light.length;
        boolean isON[]=new boolean[n];
        boolean isBlue[]=new boolean[n];
        for (int i = 0; i < n; i++) {
            int k=light[i]-1;
            isON[k]=true;
            if(k == 0 || isBlue[k-1] == true) {
                isBlue[k] = true;
                //count++;
                k++;
                while (k<n){
                    if(isON[k])
                        isBlue[k] = true;
                    else
                       break;;
                    k++;
                }
                boolean isTobeAdded=true;
                for (int j = 0; j < n; j++) {
                    if(isON[j] && !isBlue[j]) {
                        isTobeAdded = false;
                        break;
                    }
                }
                if(isTobeAdded)
                    count++;
            }

        }
        return count;
    }
}
