package com.competitiveCodes.VPCodingBlocks.Graph;

public class FloydWarshallAlgo {

    static int INF=9999,V=4;

    public static void main(String[] args) {

        int graph[][] = { {0,   5,  INF, 10},
                {INF, 0,   3, INF},
                {INF, INF, 0,   1},
                {INF, INF, INF, 0}
        };

        FloydWarshallAlgo floydWarshallAlgo=new FloydWarshallAlgo();
        floydWarshallAlgo.floydWarshall(graph);

    }

    private void floydWarshall(int[][] graph) {

        for (int k=0;k<V;k++){
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {

                    if(graph[i][k] + graph[k][j] < graph[i][j])
                        graph[i][j] = graph[i][k] + graph[k][j];

                }
            }
        }

        printSolution(graph);
    }

    private void printSolution(int[][] graph) {

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++)
                System.out.print(graph[i][j] +" ");
            System.out.println();
        }
    }
}
