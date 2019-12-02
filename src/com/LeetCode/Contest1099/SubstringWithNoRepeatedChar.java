package com.LeetCode.Contest1099;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SubstringWithNoRepeatedChar {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.next();

        int K=scanner.nextInt();

        System.out.println(numKLenSubstrNoRepeats(s,K));


    }

    public static int numKLenSubstrNoRepeats(String S, int K) {

        if(S.length()<K)
            return 0;

        int output=0;

        for (int i = 0; i < S.length(); i++) {
            if(i+K > S.length())
                break;
            Set<Character> hashSetChar=new HashSet<Character>();

            for (int j = i; j < i+K; j++)
                hashSetChar.add(S.charAt(j));


            if(hashSetChar.size() == K)
                output++;
        }

        return output;
    }
}
