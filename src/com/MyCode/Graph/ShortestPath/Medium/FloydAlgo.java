package com.MyCode.Graph.ShortestPath.Medium;

import java.util.Arrays;

public class FloydAlgo {
    static int INF=Integer.MAX_VALUE;

    public static void main(String[] args) {
        int graph[][] = { {0,   5,  INF, 10},
                {INF, 0,   3, INF},
                {INF, INF, 0,   1},
                {INF, INF, INF, 0}
        };

        floydAlgo(graph);
    }

    private static void floydAlgo(int[][] graph) {
        int V=graph.length;
        int dist[][] = new int[V][V];

        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                dist[i][j] =  graph[i][j];

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if(dist[i][k] != INF && dist[k][j] != INF)
                    if(dist[i][k]+dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k]+dist[k][j];
                }
            }
        }


        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if(dist[i][j] == Integer.MAX_VALUE)
                    System.out.print("-1 ");
                else
                    System.out.print(dist[i][j] + " ");
            }

            System.out.println();
        }


    }
}
