package com.MyCode.Graph.BFSANDDFS;

import java.util.LinkedList;

public class Graph {

    public static int V;
    public static LinkedList<Integer> adj[];

    public Graph(int v){
        V=v;
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++)
            adj[i] = new LinkedList<>();
    }

    public static void addEdge(int u,int v){
        adj[u].add(v);
    }

    public static void bidirectionalAddEdge(int u,int v){
        adj[u].add(v);
        adj[v].add(u);
    }
}
