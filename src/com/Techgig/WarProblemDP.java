package com.Techgig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class WarProblemDP {
    public static void main(String[] args) {
        //Scanner scanner=new Scanner(System.in);
        FastReader scanner=new FastReader();
        int t=scanner.nextInt();
        int R[]=new int[t];
        int P[]=new int[t];

        for (int i = 0; i < t; i++) {
            R[i]=scanner.nextInt();
            P[i]=scanner.nextInt();
        }

        for (int i = 0; i < t; i++) {
            long dpArray[][]=new long[R[i]+1][R[i]+1];
            for (int j = 0; j <= R[i]; j++)
                Arrays.fill(dpArray[j],-1);

            long result=war(P[i], 0, P[i], R[i],dpArray) ;
            System.out.println(result%1000000007);
        }
    }

    public static long war(int aryaStarkWins, int sansaStarkWins, final int p, final int r,long[][]dpArray) {

        if(dpArray[aryaStarkWins][sansaStarkWins]!=-1)
            return dpArray[aryaStarkWins][sansaStarkWins];

        if (aryaStarkWins < sansaStarkWins * p) {
            return 0;
        }

        if (aryaStarkWins + sansaStarkWins == r) {
            return 1;
        }
        dpArray[aryaStarkWins][sansaStarkWins]=(war(aryaStarkWins + 1, sansaStarkWins, p, r,dpArray) + war(aryaStarkWins, sansaStarkWins + 1, p, r,dpArray))%1000000007;

        return dpArray[aryaStarkWins][sansaStarkWins];
    }



    public static class FastReader {

        BufferedReader bufferedReader;
        StringTokenizer stringTokenizer;

        FastReader(){
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){

            while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }

    }


}
