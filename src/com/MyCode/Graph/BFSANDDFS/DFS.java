package com.MyCode.Graph.BFSANDDFS;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class DFS {

    static int V;
    static LinkedList<Integer> adj[];
    static boolean visited[];

    static void Graph(int v){
        V=v;
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++)
            adj[i] = new LinkedList<>();

    }

    static void addEdge(int u,int v){
        adj[u].add(v);
        //adj[v].add(u);
    }

    public static void main(String[] args) {
        Graph(4);
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(1, 2);
        addEdge(2, 0);
        addEdge(2, 3);
        addEdge(3, 3);

        visited=new boolean[V];
        Arrays.fill(visited,false);

        DFS(0);
    }

    static void DFS(int v){

        visited[v]=true;
        System.out.print(v +" ");
        Iterator<Integer> itr=adj[v].listIterator();

        while (itr.hasNext()){
            int u=itr.next();
            if(!visited[u])
                DFS(u);
        }
    }
}
