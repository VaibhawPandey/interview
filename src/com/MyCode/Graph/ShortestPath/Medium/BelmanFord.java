package com.MyCode.Graph.ShortestPath.Medium;
import com.MyCode.Graph.ShortestPath.Graph;
import org.omg.CORBA.INTERNAL;

import java.util.Arrays;

public class BelmanFord {

    public static void main(String[] args) {
        int V = 5; // Number of vertices in graph
        int E = 8; // Number of edges in graph
        Graph graph = new Graph(V,E);

        // add edge 0-1 (or A-B in above figure)
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = -1;

        // add edge 0-2 (or A-C in above figure)
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 4;

        // add edge 1-2 (or B-C in above figure)
        graph.edge[2].src = 1;
        graph.edge[2].dest = 2;
        graph.edge[2].weight = 3;

        // add edge 1-3 (or B-D in above figure)
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 2;

        // add edge 1-4 (or A-E in above figure)
        graph.edge[4].src = 1;
        graph.edge[4].dest = 4;
        graph.edge[4].weight = 2;

        // add edge 3-2 (or D-C in above figure)
        graph.edge[5].src = 3;
        graph.edge[5].dest = 2;
        graph.edge[5].weight = 5;

        // add edge 3-1 (or D-B in above figure)
        graph.edge[6].src = 3;
        graph.edge[6].dest = 1;
        graph.edge[6].weight = 1;

        // add edge 4-3 (or E-D in above figure)
        graph.edge[7].src = 4;
        graph.edge[7].dest = 3;
        graph.edge[7].weight = -3;

        belmanFord(graph,0);
    }

    private static void belmanFord(Graph graph, int src) {

        boolean visited[]=new boolean[graph.V];
        int dist[] = new int[graph.V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        Arrays.fill(visited,false);

        visited[0]=true;
        dist[0] = 0;

        for (int i = 1; i < graph.V; i++) {
            for (int e = 0; e < graph.E; e++) {
                int u=graph.edge[e].src;
                int v=graph.edge[e].dest;
                int weight=graph.edge[e].weight;

                if(dist[u] != Integer.MAX_VALUE && dist[u]+weight < dist[v])
                    dist[v] = dist[u] + weight;
            }
        }

        for (int e = 0; e < graph.E; e++) {
            int u=graph.edge[e].src;
            int v=graph.edge[e].dest;
            int weight=graph.edge[e].weight;

            if(dist[u] != Integer.MAX_VALUE && dist[u]+weight < dist[v]) {
                System.out.println("Negative cycle Exists");
                return;
            }
        }

        for (int i = 0; i < graph.V; i++)
            System.out.println(i +"\t" +dist[i]);


    }

}
