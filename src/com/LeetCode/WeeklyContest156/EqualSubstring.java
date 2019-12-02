package com.LeetCode.WeeklyContest156;

import java.util.Map;
import java.util.Scanner;

public class EqualSubstring {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.next();
        String str1=scanner.next();
        int maxCost=scanner.nextInt();

        System.out.println(equalSubstring(str,str1,maxCost));

    }

    public static int equalSubstring(String s, String t, int maxCost) {

        /*int sum=0,count=0;
        for (int i = 0; i < s.length(); i++) {
            int diff=Math.abs(s.charAt(i)-t.charAt(i));
            if((sum+diff)>maxCost)
                return count;
            sum += diff;
            count++;
            if(sum == maxCost)
                return count;
        }

        return s.length();*/
        int n=s.length();
        int diffArr[]=new int[n];
        for (int i = 0; i < n; i++)
            diffArr[i] = Math.abs(s.charAt(i)-t.charAt(i));

        int maxCount=0;
        for (int i = 0; i < n; i++) {
            int localCount=0,localSum=0;
            for (int j = i; j < n; j++) {
                localSum += diffArr[j];
                if(localSum>maxCost)
                    break;
                localCount++;
            }
            maxCount = Math.max(maxCount,localCount);
        }

        return maxCount;
    }
}
