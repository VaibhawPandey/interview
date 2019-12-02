package com.competitiveCodes.VPCodingBlocks.Graph;

import java.util.*;

public class CheckCyclicUndirectedGraphBFS {

    public static void main(String[] args) {

        int V = 4;
        ArrayList<Integer> adj[] = new ArrayList[V];
        for(int i = 0; i < 4; i++)
            adj[i] = new ArrayList<Integer>();

        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 0);
        addEdge(adj, 2, 3);

        if(isCyclicDisconnected(adj,V))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    private static boolean isCyclicDisconnected(ArrayList<Integer>[] adj, int v) {

        boolean visited[]=new boolean[v];
        Arrays.fill(visited,false);

        for (int i = 0; i < v; i++) {
           if(!visited[i] && isCyclicConnected(adj,0,v,visited))
               return true;
        }

        return false;
    }

    private static boolean isCyclicConnected(ArrayList<Integer>[] adj, int s, int v, boolean[] visited) {

        int parent[]=new int[v];
        Arrays.fill(parent,-1);

        Queue<Integer> queue=new LinkedList<>();
        queue.add(s);
        visited[s] = true;

        while (!queue.isEmpty()){

            int r=queue.poll();
            Iterator<Integer> itr=adj[r].listIterator();

            while (itr.hasNext()){
                int k=itr.next();
                if(!visited[k]){
                    visited[k] = true;
                    queue.add(k);
                    parent[k]=r;
                }else {
                    if(parent[r] != k)
                        return true;
                }
            }
        }

        return false;

    }


    private static void addEdge(ArrayList<Integer>[] adj, int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }


}
