package com.competitiveCodes.codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class ForegoneProblem {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        BigInteger nextBigInteger(){
            return new BigInteger(next());
        }
    }


    public static void main(String[] args) {

        FastReader scanner=new FastReader();
        int t=scanner.nextInt();

        BigInteger arr[]=new BigInteger[t];

        for (int i=0;i<t;i++)
            arr[i]=scanner.nextBigInteger();

        for (int i=0;i<t;i++)
        getBestSoln(arr[i],i+1);
    }

    private static void getBestSoln(BigInteger n,int testCase) {

        BigInteger firstNum=n;
        BigInteger secondNum=BigInteger.valueOf(0);
       while (n.compareTo(secondNum) == 1){
           if(contains4(firstNum) || contains4(secondNum)){
               secondNum=secondNum.add(BigInteger.valueOf(1));
               firstNum=firstNum.subtract(secondNum);
           }else
               break;
       }

        if(!firstNum.equals(n)){
            System.out.println("Case #" + testCase + ": " +firstNum + " " +secondNum);
        }

    }

    private static boolean contains4(BigInteger n) {

        while (!n.equals(BigInteger.valueOf(0))){
            if(n.remainder(BigInteger.valueOf(10)).equals(BigInteger.valueOf(4)))
                return true;
            n=n.divide(BigInteger.valueOf(10));
        }

        return false;
    }
}
