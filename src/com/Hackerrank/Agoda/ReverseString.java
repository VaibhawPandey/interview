package com.Hackerrank.Agoda;

public class ReverseString {

    public static void main(String[] args) {
        String inputWords="Agoda best apps";
        System.out.println(reverseWords(inputWords));
    }

    private static String reverseWords(String inputWords) {
        String reverseWords="";
        String words[]=inputWords.split(" ");
        for (int i = words.length-1; i > 0; i--) {
            reverseWords += words[i] +" ";
        }
        reverseWords += words[0];

        return reverseWords;
    }
}
