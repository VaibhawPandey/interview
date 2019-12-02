package com.MyCode.Graph.BFSANDDFS.Medium;

import com.MyCode.Graph.BFSANDDFS.Graph;

import java.util.Iterator;

public class MaxEdgestobeAddedBipartite {

    static long count_Count[];
    public static void main(String[] args) {
        int n=5;
        Graph graph=new Graph(n);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,3);
        graph.addEdge(2,4);

        count_Count=new long[2];

        System.out.println(getMaxEdges(graph,n));
    }

    private static int getMaxEdges(Graph graph, int n) {

        dfsUtil(graph,0,0,0);

        return (int) (count_Count[0] * count_Count[1] - (n-1));
    }

    private static void dfsUtil(Graph graph, int node, int parent, int color) {

        count_Count[color]++;

        Iterator<Integer> itr=graph.adj[node].listIterator();
        if(color ==0)
            color = 1;
        else color = 0;
        for (int i = 0; i < graph.adj[node].size(); i++) {
            if(graph.adj[node].get(i) != parent)
                dfsUtil(graph,graph.adj[node].get(i),node,color);
        }
    }
}
