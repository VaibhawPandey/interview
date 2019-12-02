package com.LeetCode.Problem.Graph;

import java.util.Scanner;

public class FindtheTownJudge {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int N=scanner.nextInt();
        int trust[][]={{1,3},{2,3},{3,1}};
        System.out.println(findJudge(N,trust));
    }

    public static int findJudge(int N, int[][] trust) {
        int trustCount[]=new int[N+1];
        int trustedByCount[]=new int[N+1];

        for(int i=0;i<trust.length;i++){
            trustCount[trust[i][0]]++;
            trustedByCount[trust[i][1]]++;
        }

        for(int i=1;i<=N;i++){
            if(trustCount[i] == 0 && trustedByCount[i] == N-1)
                return i;
        }

        return -1;
    }
}
