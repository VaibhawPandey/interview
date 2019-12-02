package com.MyCode.Graph.BFSANDDFS.Medium;

import com.MyCode.Graph.BFSANDDFS.Graph;

import java.util.Arrays;
import java.util.Iterator;

public class TransativeClosureGraph {

    static int t[][];
    static boolean visited[];

    public static void main(String[] args) {
        Graph g =new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        t=new int[4][4];
        visited=new boolean[t.length];
        for (int i = 0; i < t.length; i++) {
            if(!visited[i])
                DFSUtil(i,g,i);
            Arrays.fill(visited,false);
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(t[i][j] +" ");
            }
            System.out.println();
        }
    }

    private static void DFSUtil(int v, Graph graph,int src) {

        Iterator<Integer> itr=graph.adj[v].listIterator();

        while (itr.hasNext()){
            int u=itr.next();
            if(!visited[u]) {
                visited[u] = true;
                t[src][u] = 1;
                DFSUtil(u,graph,src);
            }
        }
    }
}
