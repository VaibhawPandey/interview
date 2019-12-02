package com.competitiveCodes.VPCodingBlocks.Graph;

import java.util.Arrays;

/*
   * Negative cycle detection
 */
public class BellmanFordAlgo {

    static int V;
    static int E;
    static Edge edge[];

    class Edge{
        int src,dest,weight;

        Edge(){
            src=dest=weight=0;
        }
    }

    void Graph(int v,int e){
        this.V = v;
        this.E = e;
        edge = new Edge[E];

        for (int i = 0; i < E; i++)
            edge[i] = new Edge();
    }

    public static void main(String[] args) {

        BellmanFordAlgo bellmanFordAlgo=new BellmanFordAlgo();
        bellmanFordAlgo.Graph(5,8);

        // add edge 0-1 (or A-B in above figure)
        bellmanFordAlgo.edge[0].src = 0;
        bellmanFordAlgo.edge[0].dest = 1;
        bellmanFordAlgo.edge[0].weight = -1;

        // add edge 0-2 (or A-C in above figure)
        bellmanFordAlgo.edge[1].src = 0;
        bellmanFordAlgo.edge[1].dest = 2;
        bellmanFordAlgo.edge[1].weight = 4;

        // add edge 1-2 (or B-C in above figure)
        bellmanFordAlgo.edge[2].src = 1;
        bellmanFordAlgo.edge[2].dest = 2;
        bellmanFordAlgo.edge[2].weight = 3;

        // add edge 1-3 (or B-D in above figure)
        bellmanFordAlgo.edge[3].src = 1;
        bellmanFordAlgo.edge[3].dest = 3;
        bellmanFordAlgo.edge[3].weight = 2;

        // add edge 1-4 (or A-E in above figure)
        bellmanFordAlgo.edge[4].src = 1;
        bellmanFordAlgo.edge[4].dest = 4;
        bellmanFordAlgo.edge[4].weight = 2;

        // add edge 3-2 (or D-C in above figure)
        bellmanFordAlgo.edge[5].src = 3;
        bellmanFordAlgo.edge[5].dest = 2;
        bellmanFordAlgo.edge[5].weight = 5;

        // add edge 3-1 (or D-B in above figure)
        bellmanFordAlgo.edge[6].src = 3;
        bellmanFordAlgo.edge[6].dest = 1;
        bellmanFordAlgo.edge[6].weight = 1;

        // add edge 4-3 (or E-D in above figure)
        bellmanFordAlgo.edge[7].src = 4;
        bellmanFordAlgo.edge[7].dest = 3;
        bellmanFordAlgo.edge[7].weight = -3;

        bellmonFord(0);
    }

    private static void bellmonFord(int src) {

        int dist[]=new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);

        dist[src]=0;

        for (int i = 1; i < V; i++) {
            for (int j = 0; j < E; j++) {

                int egSrc=edge[j].src;
                int egDest = edge[j].dest;
                int weight = edge[j].weight;

                if(dist[egSrc] != Integer.MAX_VALUE && dist[egSrc] + weight < dist[egDest])
                    dist[egDest] = dist[egSrc] + weight;
            }
        }

        for (int j = 0; j < E; j++) {

            int egSrc=edge[j].src;
            int egDest = edge[j].dest;
            int weight = edge[j].weight;

            if(dist[egSrc] != Integer.MAX_VALUE && dist[egSrc] + weight < dist[egDest]) {
                System.out.println("Negative cycle exists");
                return;
            }

        }

        System.out.println("Negative cycle does not exists");

        for (int i = 0; i < dist.length; i++)
            System.out.println(i +": " +dist[i]);

    }
}
