package com.competitiveCodes.VPCodingBlocks.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

/*
  * @Question :- https://hack.codingblocks.com/contests/c/204/814
 */

public class DiwaliPuzzleProblem_6 {

    final static int mod=1000003;

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();

        int noofElements[]=new int[t];
        int k[]=new int[t];

        for (int i=0;i<t;i++){
            noofElements[i]=scanner.nextInt();
            k[i]=scanner.nextInt();
        }

        for (int i = 0; i < t; i++) {
            long dp[][][]=new long[noofElements[i]][2][noofElements[i]];
            for (int j = 0; j < noofElements[i]; j++) {
                for (int l = 0; l < 2; l++) {
                    Arrays.fill(dp[j][l],-1L);
                }
            }
            //Arrays.fill(dp,-1L);
            System.out.println(getPuzzleProblemResult(dp,noofElements[i],k[i],0,0,0));
        }
    }

    private static long getPuzzleProblemResult(long[][][] dp, int noofElement, int k,int position,int prevElement,int count) {

        if(position == noofElement){
            if(count == k)
                return 1;
            return 0;
        }

        long ans=0;

        if(dp[position][prevElement][count] != -1)
            return dp[position][prevElement][count];

        //If last prevElement is 0
        if(prevElement == 1){
             // If present prevElement is 1,so 1*1=1 i.e., increment in count
             ans += getPuzzleProblemResult(dp,noofElement,k,position+1,1,count+1);
        }else {
             // If last prevElement is 0,so 0*1=0 i.e., no increment in count
             ans += getPuzzleProblemResult(dp,noofElement,k,position+1,1,count);
        }

        ans %= mod;

        //If present prevElement is 0 then 0*0=0 or 1*0=0 so no increment in count
        ans += getPuzzleProblemResult(dp,noofElement,k,position+1,0,count);

        ans %= mod;

        return dp[position][prevElement][count] = ans;

    }
}
