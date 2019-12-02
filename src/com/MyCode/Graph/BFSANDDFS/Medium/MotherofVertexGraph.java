package com.MyCode.Graph.BFSANDDFS.Medium;


import com.MyCode.Graph.BFSANDDFS.Graph;

import java.util.Arrays;
import java.util.Iterator;

public class MotherofVertexGraph {

    static boolean visited[];
    public static void main(String[] args) {

        Graph graph=new Graph(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(4, 1);
        graph.addEdge(6, 4);
        graph.addEdge(5, 6);
        graph.addEdge(5, 2);
        graph.addEdge(6, 0);

        int v=-1;
        visited=new boolean[graph.V];
        Arrays.fill(visited,false);

        for (int i = 0; i < graph.V; i++) {
            if(!visited[i]) {
                DFSUtil(i,graph);
                v = i;
            }
        }

        Arrays.fill(visited,false);
        if(v == -1)
            System.out.println(v);

        DFSUtil(v,graph);
        for (int i = 0; i < graph.V; i++) {
            if(!visited[i])
                System.out.println(-1);
        }

        System.out.println(v);
    }

    private static void DFSUtil(int src, Graph graph) {

        visited[src] = true;

        Iterator<Integer> itr=graph.adj[src].listIterator();
        while (itr.hasNext()){
            int u=itr.next();
            if(!visited[u])
                DFSUtil(u,graph);
        }

    }
}
