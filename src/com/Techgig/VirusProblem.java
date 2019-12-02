package com.Techgig;

import java.util.Scanner;

public class VirusProblem {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        String arr[]=new String[t];

        for (int i = 0; i < t; i++)
            arr[i]=scanner.next();

        for (int i = 0; i < t; i++) {
            int maxCount=0;
            char outChar = 0;
            int words[]=new int[26];

            for (Character ch:arr[i].toCharArray()){
                int charPosition=ch - 'a';
                words[charPosition]++;
                if(words[charPosition]>maxCount){
                    maxCount=words[charPosition];
                    outChar=ch;
                }else if(words[charPosition]==maxCount){
                      if(outChar>ch)
                          outChar=ch;
                }
            }

            System.out.println(outChar);
        }


    }
}
