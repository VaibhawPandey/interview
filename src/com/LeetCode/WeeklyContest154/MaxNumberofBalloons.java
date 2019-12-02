package com.LeetCode.WeeklyContest154;

import java.util.Scanner;

public class MaxNumberofBalloons {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.next();
        int charCount[] = new int[26];

        for (int i = 0; i < str.length(); i++)
            charCount[str.charAt(i) - 'a']++;

        String matchedChar="balloon";
        int maxCount=Integer.MAX_VALUE;

        for (int i = 0; i < matchedChar.length(); i++) {
            int charCountatI = charCount[matchedChar.charAt(i) - 'a'];
            if(matchedChar.charAt(i) == 'l' || matchedChar.charAt(i) == 'o')
                charCountatI = charCountatI/2;
            maxCount = Math.min(charCountatI, maxCount);
        }

        System.out.println(maxCount);
    }
}
