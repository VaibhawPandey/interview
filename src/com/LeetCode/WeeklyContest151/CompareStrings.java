package com.LeetCode.WeeklyContest151;

public class CompareStrings {

    public static void main(String[] args) {
        String queries[]={"bba","abaaaaaa","aaaaaa","bbabbabaab","aba","aa","baab","bbbbbb","aab","bbabbaabb"};
        String words[]={"aaabbb","aab","babbab","babbbb","b","bbbbbbbbab","a","bbbbbbbbbb","baaabbaab","aa"};

        int out[]=numSmallerByFrequency(queries,words);
        for (int i = 0; i < out.length; i++)
            System.out.print(out[i] +" ");




    }

    public static int[] numSmallerByFrequency(String[] queries, String[] words) {

        int output[]=new int[queries.length];
        int funQueries[]=getFunValue(queries);
        int funWords[]=getFunValue(words);

        for (int i = 0; i < funQueries.length; i++) {
            int outputSub = 0;
            for (int j = 0; j < funWords.length; j++) {
                if(funQueries[i]<funWords[j])
                    outputSub++;
            }
            output[i]=outputSub;
        }

        return output;
    }

    private static int[] getFunValue(String[] input) {
        int result[]=new int[input.length];


        for (int i = 0; i < input.length; i++) {
            int alp[]=new int[26];
            String in=input[i];
            int maxValue=0;
            for (int j = 0; j < in.length(); j++) {
                alp[in.charAt(j) - 'a']++;
            }

            for (int j = 0; j < 26; j++) {
                if(alp[j] != 0) {
                    maxValue = alp[j];
                    break;
                }
            }

            result[i] = maxValue;
        }

        return result;
    }
}
