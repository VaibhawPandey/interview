package com.MyCode.Graph.BFSANDDFS;

import java.util.*;


public class BFS {

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

        Queue<Integer> queue = new ArrayDeque<>();

        //queue.add(0);


        //for (int i = 0; i < V; i++) {
            //if(!visited[i]) {
                queue.add(2);
                visited[2] = true;
                BFSCheck(queue);
            //}
        //}



    }

    private static void BFSCheck(Queue<Integer> queue) {


        while (!queue.isEmpty()) {
            int pos=queue.peek();
            Iterator<Integer> itr = adj[pos].listIterator();
            while (itr.hasNext()) {
                int v = itr.next();
                if(!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                }
            }
            System.out.println(queue.poll());
        }
    }
}
