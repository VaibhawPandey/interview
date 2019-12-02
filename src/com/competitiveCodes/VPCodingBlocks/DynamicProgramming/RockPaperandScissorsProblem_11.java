package com.competitiveCodes.VPCodingBlocks.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class RockPaperandScissorsProblem_11 {

    static Double dp[][][];

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int r=scanner.nextInt(),s=scanner.nextInt(),p=scanner.nextInt();
        dp = new Double[r+1][s+1][p+1];
        dp = updateDPValue(dp,r,s,p);
        //In case rock have won
        Double f1=getResultF1(r,s,p);
        dp = updateDPValue(dp,r,s,p);
        //In case of scissor have won
        Double f2=getResultF2(r,s,p);
        dp = updateDPValue(dp,r,s,p);
        //In case of paper have won
        Double f3=getResultF3(r,s,p);

        System.out.println(f1 +" " +f2 +" " +f3);

    }



    private static Double[][][] updateDPValue(Double[][][] dp, int r, int s, int p) {

        for (int i = 0; i <= r; i++) {
            for (int j = 0; j <= s; j++) {
                Arrays.fill(dp[i][j],-1.0);
            }
        }

        return dp;
    }

    private static Double getResultF1(int r, int s, int p) {
        if(r==0||s==0)
            return 0.0;

        if(p==0)
            return 1.0;

        if(dp[r][s][p] != -1)
            return dp[r][s][p];

        int total=r*s + s*p + p*r;
        Double res=0.0;

        //P vs R = P wins so R = R-1 and probability of win is (r*p)/total
        res += getResultF1(r-1,s,p) * (r*p)/total;
        //R vs S = R wins so S = S-1 and probability of win is (r*s)/total
        res += getResultF1(r,s-1,p) * (r*s)/total;
        //S vs P = S wins so P = P-1 and probability of win is (s*p)/total
        res += getResultF1(r,s,p-1) * (s*p)/total;

        return dp[r][s][p] = res;
    }

    private static Double getResultF2(int r, int s, int p) {
        if(p==0||s==0)
            return 0.0;

        if(r==0)
            return 1.0;

        if(dp[r][s][p] != -1)
            return dp[r][s][p];

        int total=r*s + s*p + p*r;
        Double res=0.0;

        //P vs R = P wins so R = R-1 and probability of win is (r*p)/total
        res += getResultF2(r-1,s,p) * (r*p)/total;
        //R vs S = R wins so S = S-1 and probability of win is (r*s)/total
        res += getResultF2(r,s-1,p) * (r*s)/total;
        //S vs P = S wins so P = P-1 and probability of win is (s*p)/total
        res += getResultF2(r,s,p-1) * (s*p)/total;

        return dp[r][s][p] = res;
    }

    private static Double getResultF3(int r, int s, int p) {

        if(p==0||r==0)
            return 0.0;

        if(s==0)
            return 1.0;

        if(dp[r][s][p] != -1)
            return dp[r][s][p];

        int total=r*s + s*p + p*r;
        Double res=0.0;

        //P vs R = P wins so R = R-1 and probability of win is (r*p)/total
        res += getResultF3(r-1,s,p) * (r*p)/total;
        //R vs S = R wins so S = S-1 and probability of win is (r*s)/total
        res += getResultF3(r,s-1,p) * (r*s)/total;
        //S vs P = S wins so P = P-1 and probability of win is (s*p)/total
        res += getResultF3(r,s,p-1) * (s*p)/total;

        return dp[r][s][p] = res;
    }
}
