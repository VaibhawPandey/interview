package com.competitiveCodes.VPCodingBlocks.Graph;

import java.util.Arrays;

public class DijsktraAlgoSPAlgo {

    static int V=9;
    public static void main(String[] args) {


        int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        DijsktraAlgoSPAlgo dijsktraAlgoSPAlgo=new DijsktraAlgoSPAlgo();
        dijsktraAlgoSPAlgo.shortestPath(graph,0);

    }

    private void shortestPath(int[][] graph, int src) {

        int distance[]=new int[V];
        boolean dspSet[] = new boolean[V];

        Arrays.fill(distance,Integer.MAX_VALUE);
        Arrays.fill(dspSet,false);

        distance[src] = 0;

        for (int count = 0; count < V-1; count++) {

            int u = min_Cost(distance,dspSet);
            dspSet[u] = true;

            for (int v = 0; v < V; v++) {

                if(dspSet[v] == false && graph[u][v] != 0 &&
                        distance[u] != Integer.MAX_VALUE && distance[u] + graph[u][v] < distance[v])
                    distance[v] = distance[u] + graph[u][v];
            }

        }

        for (int i = 0; i < V; i++)
            System.out.println(i +"--" +distance[i]);

    }

    private int min_Cost(int dist[], boolean[] dspSet) {

        int min_value=Integer.MAX_VALUE,min_position=-1;

        for (int v = 0; v < V; v++) {
            if (dspSet[v] == false && dist[v]<min_value){
                min_value = dist[v];
                min_position=v;
            }
        }

        return min_position;

    }
}
