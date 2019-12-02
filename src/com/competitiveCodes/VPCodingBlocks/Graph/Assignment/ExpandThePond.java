package com.competitiveCodes.VPCodingBlocks.Graph.Assignment;

import java.util.Arrays;
import java.util.Scanner;

public class ExpandThePond {

    static int max_pond_size = Integer.MIN_VALUE;
    static int temp_pond_size = 0;

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int N=scanner.nextInt(),M=scanner.nextInt();
        int graph[][] = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++)
                 graph[i][j] = scanner.nextInt();
        }

        boolean visited[][]=new boolean[N][M];
        for (int i = 0; i < N; i++)
        Arrays.fill(visited[i],false);


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                // Expanding the pond by one block
                if(graph[i][j]==0) {
                    graph[i][j] = 1;
                    expandedPondSize(graph,i,j,N,M,visited);
                    for (int k = 0; k < N; k++)
                        Arrays.fill(visited[i],false);
                    max_pond_size = Math.max(max_pond_size,temp_pond_size);
                    temp_pond_size=0;
                    graph[i][j]=0;
                }

            }
        }

        System.out.println(max_pond_size);





        }

    private static void expandedPondSize(int[][] graph, int i, int j, int n, int m, boolean[][] visited) {


        if(i>=n | i<0 | j>=m | j<0)
            return;

        if(!visited[i][j]) {

            visited[i][j] = true;
            if (graph[i][j] == 0)
                return;

            temp_pond_size++;

            expandedPondSize(graph, i + 1, j, n, m, visited);
            expandedPondSize(graph, i, j + 1, n, m, visited);
            expandedPondSize(graph, i - 1, j, n, m, visited);
            expandedPondSize(graph, i, j - 1, n, m, visited);
        }
    }
}
