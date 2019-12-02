package com.competitiveCodes.VPCodingBlocks.Graph;

import java.util.Iterator;
import java.util.LinkedList;

public class DFS {

    static int v;
    static LinkedList<Integer> adj[];

    void Graph(int V){
        this.v=V;
        adj = new LinkedList[V];

        for (int i = 0; i < V; i++)
            adj[i]=new LinkedList<>();
    }

    void addEdge(int v,int w){
        adj[v].add(w);
    }

    public static void main(String[] args) {

        DFS dfs=new DFS();
        dfs.Graph(4);

        dfs.addEdge(0, 1);
        dfs.addEdge(0, 2);
        dfs.addEdge(1, 2);
        dfs.addEdge(2, 0);
        dfs.addEdge(2, 3);
        dfs.addEdge(3, 3);

        DFS.dFS(2);
    }

    private static void dFS(int s) {

        boolean visited[]=new boolean[v];
        visited[s] = true;
        DFSUtil(s,visited);
    }

    private static void DFSUtil(int s, boolean[] visited) {
        System.out.print(s +"-->");
        Iterator<Integer> itr=adj[s].listIterator();
        while (itr.hasNext()){
            int k=itr.next();

            if(!visited[k]){
                visited[k]=true;
                DFSUtil(k,visited);
            }
        }


    }
}
