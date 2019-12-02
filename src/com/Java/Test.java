package com.Java;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        String abc="f1c1g1";
        String result="";

        for (Character c:abc.toCharArray()){
            if(Character.isDigit(c)){
                //if(Integer.valueOf(c)!=1) {
                    int value= c - '0' - 1;
                    for (int i = 0; i < value; i++) {
                        int len=result.length();
                        result += result.substring(len-1,len);
                    }

                //}
            }else
                result += c;
        }

        System.out.println(result);
    }
}
