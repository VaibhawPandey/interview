package com.competitiveCodes.techgig.Semifinal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CandidateCode {

    static long output[];


    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        output=new long[t];

        List<Integer> digitListArray[];


        for (int i = 0; i < t; i++) {


            int n=scanner.nextInt();
            int arr[]=new int[n];
            digitListArray = new ArrayList[n];

            for (int j = 0; j < n; j++) {
                arr[j] = scanner.nextInt();
                digitListArray[j] = getDigitList(arr[j]);
            }

            long max= Arrays.stream(arr).max().getAsInt();

            int memo[]=new int[1<<10];
            Arrays.fill(memo,-1);

            /*int res=0;
            for (int j = 0; j < 1<<10; j++)
                res = Math.max(res,dp(j,memo,arr));*/
            //max = calculateOutput(n,arr,max,digitListArray);
            max = calculateOutput(n,arr,max,digitListArray);
            output[i] = max;

        }

        for (int i = 0; i < t; i++)
            System.out.println(output[i]);

    }

    static int mask(int n) {
        int mask = 0;
        for (int i = 1; n>0; i*= 10) {
            int digit = n/i % 10;
            mask |= 1 << digit;
            n=n/i;
        }
        return mask;
    }

    static int dp(int set, int memo[],int[] a) {
        if (set == 0) {
            return memo[set] = 0;
        }
        if (memo[set] != -1)
            return memo[set];

        int res = 0;
        for (Integer num: a) {
            int bitmask = mask(num);
            if ((set | bitmask) == set)
                res = Math.max(dp(set ^ mask(num), memo, a) + num, res);
        }
        return memo[set] = res;
    }

    private static long calculateOutput(int n, int[] arr, long max, List<Integer>[] digitListArray) {

        for (int i = 0; i < n; i++) {
            long sum=arr[i];
            List<Integer> digitList=new ArrayList<>();
           for (Integer digit:digitListArray[i])
            digitList.add(digit);
            for (int j = 0; j < n; j++) {

                if(j==i)
                    continue;

                int temp=arr[j];
                int k;
                boolean containsDigit=false;

                List<Integer> tempDigitList=digitListArray[j];

                for (int l = 0; l < tempDigitList.size(); l++) {

                    if(digitList.contains(tempDigitList.get(l))){
                        containsDigit = true;
                        break;
                    }
                }

                /*{
                    k=temp%10;
                    temp = temp/10;

                    if(digitList.contains(k)) {
                        containsDigit = true;
                        break;
                    }
                }*/

                if(!containsDigit) {
                    for (Integer digit:digitListArray[j])
                        digitList.add(digit);
                    sum += arr[j];
                }

            }

            max = Math.max(sum,max);
        }

        return max;

    }

    private static List<Integer> getDigitList(int n) {
        List<Integer> digitList=new ArrayList<>();
        int k=0;

        while (n!=0){
            k = n%10;
            n = n/10;
            digitList.add(k);
        }

        return digitList;
    }
}
