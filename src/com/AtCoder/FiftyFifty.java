package com.AtCoder;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FiftyFifty {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s= scanner.next();

        char charString[] = s.toCharArray();
        Set<Character> hashSet=new HashSet<Character>();
        for (int i = 0; i < 4; i++) {
            hashSet.add(charString[i]);
        }

        if(hashSet.size()==2)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
