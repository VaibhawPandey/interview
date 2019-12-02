package com.competitiveCodes.VPCodingBlocks.DynamicProgramming.Assignments;

import java.util.Scanner;

public class WildCardPatternMatching {

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        String word=scanner.next();
        String pattern=scanner.next();
        if(strMatched(word,pattern))
            System.out.println("MATCHED");
        else
            System.out.println("NOT MATCHED");
    }

    private static boolean strMatched(String word, String pattern) {

        int n=word.length(),m=pattern.length();

        if(m==0)
            return (n==0);
        boolean lookup[][]=new boolean[n+1][m+1];

        //For empty string the value is false
        for (int i=1;i<=n;i++)
            lookup[i][0]=false;

        lookup[0][0]=true;

        //Only '*' can match with empty string
        for (int j = 1; j <=m; j++) {
            if(pattern.charAt(j-1) == '*')
                lookup[0][j]=lookup[0][j-1];
        }

        //Loop through patter
        for (int i=1;i<=n;i++){
            for (int j = 1; j <= m; j++) {
                // Two cases if we see a '*'
                // a) We ignore '*'' character and move
                //    to next  character in the pattern,
                //     i.e., '*' indicates an empty sequence.
                // b) '*' character matches with ith
                //     character in input
                if(pattern.charAt(j-1) == '*')
                    lookup[i][j] = lookup[i-1][j] || lookup[i][j-1];
                else if(pattern.charAt(j-1) == '?' || word.charAt(i-1) == pattern.charAt(j-1))
                    lookup[i][j] = lookup[i-1][j-1];
                else
                    lookup[i][j] = false;
            }
        }

        return lookup[n][m];
    }
}
