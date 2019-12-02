package com.MyCode.Graph.ShortestPath.Medium;

import java.util.Arrays;

public class DijskrtaAlgo {
    static int V = 9;
    static int dist[];
    static boolean visited[];

    public static void main(String[] args) {

        int graph[][] = {{0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        dijskrta(graph,0);

    }

    private static void dijskrta(int[][] graph, int src) {

        visited=new boolean[V];
        dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        Arrays.fill(visited,false);

        dist[src] = 0;
        //visited[src] = true;

        for (int count = 0; count < V-1; count++) {

            int u=getMinEdge();
            visited[u] = true;

            for (int v = 0; v < V; v++) {

                if(!visited[v] && graph[u][v]!=0 &&
                        dist[u]!= Integer.MAX_VALUE && dist[u]+graph[u][v]<dist[v])
                    dist[v] = dist[u] + graph[u][v];
            }
        }

        for (int v = 0; v < V; v++)
            System.out.print(dist[v] +" ");

    }

    /*private static void dijskrtaUtil(int[][] graph, int src) {

        int u=getMinEdge(src,graph);
        visited[src] = true;
        if (u != -1){
              //if(!visited[u]) {
                  //visited[u]=true;
                  dist[u] = dist[src]+graph[src][u];
                  dijskrtaUtil(graph, u);
              //}
        }
    }*/

    private static int getMinEdge() {

        int minPosition = -1,minValue=Integer.MAX_VALUE;

        for (int v = 0; v < V; v++) {
            if(!visited[v] && dist[v]<minValue){
                minPosition=v;
                minValue = dist[v];
            }
        }

        return minPosition;
    }
}
