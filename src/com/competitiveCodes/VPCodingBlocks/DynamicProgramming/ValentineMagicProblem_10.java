package com.competitiveCodes.VPCodingBlocks.DynamicProgramming;

import java.util.*;

public class ValentineMagicProblem_10 {

    static int dp[][];

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int N=scanner.nextInt(),M=scanner.nextInt();

        List<Integer> chocolate=new ArrayList<>();
        List<Integer> candies=new ArrayList<>();

        for (int i = 0; i < N; i++)
            chocolate.add(scanner.nextInt());

        for (int i = 0; i < M; i++)
            candies.add(scanner.nextInt());

        Collections.sort(chocolate);
        Collections.sort(candies);


        dp=new int[N+1][M+1];

        for (int i = 0; i <= N; i++)
            Arrays.fill(dp[i],-1);

        System.out.println(getResult(0,0,chocolate,candies,N,M));


    }

    private static int getResult(int i, int j, List<Integer> chocolate, List<Integer> candies, int N, int M) {

        if(i==N)
            return 0;
        if(j==M)
            return Integer.MAX_VALUE;

        if(dp[i][j] != -1)
            return dp[i][j];

        dp[i][j]=Math.min(Math.abs(chocolate.get(i)-candies.get(j)) + getResult(i+1,j+1,chocolate,candies,N,M),getResult(i,j+1,chocolate,candies,N,M));

        return dp[i][j];
    }
}
